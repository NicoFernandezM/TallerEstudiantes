package modelo;

import utils.DigitoVerificador;

import java.util.ArrayList;
import java.util.List;

public class CursoICC264 {
    private List<Estudiante> estudiantes;

    public CursoICC264 () {
        this.estudiantes = new ArrayList<>();
    }

    public boolean agregarEstudiante(Estudiante estudiante) {
        String rut = estudiante.getRut();

        if(!estudianteExiste(rut) && DigitoVerificador.validarRut(rut)) {
            estudiantes.add(estudiante);
            return true;
        }

        return false;
    }

    public boolean estudianteExiste(String rut) {
        for (Estudiante e: this.estudiantes) {
            if(e.getRut().equals(rut)) {
                return true;
            }
        }

        return false;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public Estudiante buscarEstudiantePorRut(String rut) throws EstudianteNoEncontradoException{
        for (Estudiante e: this.estudiantes) {
            if(e.getRut().equals(rut)) {
                return e;
            }
        }

        throw new EstudianteNoEncontradoException();
    }
}
