package Entidades;

import lombok.*;

@Getter
@Setter
@ToString
public class Libro {
    private String titulo;
    private String autor;
    private int paginas;
    private double precio;

    public Libro(String titulo, String autor, int paginas, double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.precio = precio;
    }

}
