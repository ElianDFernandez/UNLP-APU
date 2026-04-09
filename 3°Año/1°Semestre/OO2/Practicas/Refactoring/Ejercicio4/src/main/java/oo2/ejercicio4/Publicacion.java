package oo2.ejercicio4;

/**
 *
 * @author Elian
 */
public class Publicacion {
   private String texto;
   private int likes;
   
   public Publicacion(String texto) {
      this.texto = texto;
      this.likes = 0;
   }
   
   public void darLike() { likes++; }
   
   public void darDislike() { likes--; }
   
   private int impacto() {
       return likes * 3;
   }
   
   public int alcance() {
       return impacto() * 10;
   }
}

/*
1. Rename method Procesar -> Impacto
    1. Linea 20 procesar -> impacto
    2. Linea 25 procesar -> impacto

2. Rename method Calcular -> alcance
    1. Linea 24
    2. Clase Perfil linea 23

3. Rename method Calular clase Perfil  -> alcance
    1. Clase Perfil linea 26

4. Rename parametro "p" del metodo agregarPublicacion de Clase Perfil -> publicacion
    1. Clase Perfil linea 18, firma y cuerpo
*/