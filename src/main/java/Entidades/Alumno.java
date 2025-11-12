package Entidades;
import lombok.*;

@Builder
@Getter
@Setter
@ToString

public class Alumno {
    private String nombre;
    private int nota;
    private String curso;
    public Alumno(String nombre, int nota, String curso){
        this.nombre = nombre;
        this.curso = curso;
        this.nota = nota;
    }

}
