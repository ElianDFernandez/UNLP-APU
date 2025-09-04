package ar.edu.unlp.oo1.ejercicio1;

/**
 * Completar esta clase de acuerdo a lo especificado
 */
public class WallPost  {
    
                        private String texto;
                        private int meGustas;
                        private boolean destacado;

                        public WallPost() {
                            this.texto = "Undefined post";
                            this.meGustas = 0;
                            this.destacado = false;
                        }
                        
	/**
	 * Retorna el texto descriptivo de la publicación
	 * 
	 * @return
	 */
	String getText() {
                            return this.texto;
	};

	/**
	 * Setea el texto descriptivo de la publicación
	 * @param text
	 */
	void setText(String text) {
                            this.texto = text;
	};

	/**
	 * Retorna la cantidad de “me gusta”
	 * 
	 * @return
	 */
	int getLikes() {
                             return this.meGustas;
	};

	/**
	 * Incrementa la cantidad de likes en uno
	 */
	void like() {
                            this.meGustas++;
	};

	/**
	 * Decrementa la cantidad de likes en uno. Si ya es 0, no hace nada
	 */
	void dislike() {
                            if (meGustas != 0) {
                                this.meGustas --;
                            }
	};

	/**
	 * Retorna true si el post está marcado como destacado, false en caso contrario
	 * 
	 * @return
	 */
	boolean isFeatured() {
                            return this.destacado;
	};

	/**
	 * Cambia el post del estado destacado a no destacado y viceversa
	 */
	void toggleFeatured() {
                            this.destacado = !this.destacado;
	};

	/*
	 * Este mensaje se utiliza para que una instancia de Wallpost se muestre de forma adecuada
	 */
	@Override
	public String toString() {
		return "WallPost {" +
			"text: " + getText() +
			", likes: '" + getLikes() + "'" +
			", featured: '" + isFeatured() + "'" +
			"}";
	}

}