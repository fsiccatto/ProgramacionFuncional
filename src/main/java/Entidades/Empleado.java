package Entidades;
import lombok.*;

@Getter
@Setter
@ToString
public class Empleado {
    private String nombre;
    private String departamento;
    private double salario;
    private int edad;

    public Empleado(String nombre, String departamento, double salario, int edad) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.salario = salario;
        this.edad = edad;
    }

}
