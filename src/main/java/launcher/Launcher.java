package launcher;

import dato.DatosEstudiantes;
import gui.Ventana_CursoICC264;
import modelo.CursoICC264;

public class Launcher {
    public static void main(String [] args) {
        CursoICC264 cursoICC264 = new CursoICC264();
        DatosEstudiantes.leerArchivoEstudiantes(cursoICC264, "ICC264.txt");

        new Ventana_CursoICC264(cursoICC264);
    }
}
