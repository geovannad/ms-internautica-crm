package com.example.msinternauticacrm.models;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Getter
@Setter
@Document(collection = "boats")
public class Boat {
   @Id
   private String id;
   private String teste;

   public Boat(String id, String teste) {
      this.id = id;
      this.teste = teste;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getTeste() {
      return teste;
   }

   public void setTeste(String teste) {
      this.teste = teste;
   }
}
