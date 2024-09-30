package org.example.interfaces;

import org.example.entities.Persona;

public interface Usuario {
  org.example.entities.Persona getIdPersona();
   void setIdPersona(Persona IdPersona);

   String getRol();
   void setRol(String rol);

}
