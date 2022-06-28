package modelo;

public class Estudiante {
    private String rut;
    private String nombre;
    private String email;

    public Estudiante(String rut, String nombre, String email) {
        this.rut = rut;
        this.nombre = nombre;
        this.email = email;
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return (this.rut + ";" + this.nombre + ";" + this.email);
    }
}
