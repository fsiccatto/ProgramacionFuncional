package Entidades;
import lombok.*;

@Builder
@Getter
@Setter
@ToString

public class Producto {
    private String nombre;
    private String categoria;
    private double precio;
    private int stock;
    public Producto(String nombre, String categoria, double precio, int stock){
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

}
