package com.example.msinternauticacrm.filter;

import com.example.msinternauticacrm.services.CustomAdmDetailService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);
    private static final List<String> PUBLIC_ROUTES = List.of("/bergaminboats/login", "/bergaminboats/adm/api", "/bergaminboats/boat/get-by-id/**");

    private final CustomAdmDetailService admDetailService;
    private final SecretKey secretKey;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String requestURI = request.getRequestURI();

        // Ignora rotas públicas
        if (PUBLIC_ROUTES.stream().anyMatch(route -> {
            boolean matches = requestURI.startsWith(route.replace("/**", ""));
            logger.debug("Verificando rota pública: {} -> {}", route, matches);
            return matches;
        })) {
            logger.debug("Ignorando rota pública: {}", requestURI);
            filterChain.doFilter(request, response);
            return;
        }

        String authorizationHeader = request.getHeader("Authorization");

        // Verifica se o cabeçalho Authorization está presente e começa com "Bearer "
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            logger.warn("Cabeçalho Authorization ausente ou inválido para a requisição: {}", requestURI);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write("{\"error\": \"Token JWT ausente ou inválido\"}");
            response.getWriter().flush();
            return;
        }

        // Extrai o token (remove o prefixo "Bearer ")
        String token = authorizationHeader.substring(7);

        try {
            // Valida o token JWT
            Claims claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            // Obtém o email do usuário a partir do token
            String email = claims.getSubject();
            if (email != null) {
                // Carrega os detalhes do usuário
                UserDetails userDetails = admDetailService.loadUserByUsername(email);
                if (userDetails != null) {
                    // Configura o contexto de segurança
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, Collections.emptyList());
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }

            // Passa a requisição para o próximo filtro
            filterChain.doFilter(request, response);
        } catch (SignatureException se) {
            logger.error("Token JWT inválido: {}", se.getMessage());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write("{\"error\": \"Token JWT inválido\"}");
            response.getWriter().flush();
        } catch (Exception e) {
            logger.error("Erro ao processar o token JWT: {}", e.getMessage());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.setContentType("application/json");
            response.getWriter().write("{\"error\": \"Erro ao processar o token JWT\"}");
            response.getWriter().flush();
        }
    }
}