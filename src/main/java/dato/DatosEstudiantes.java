package dato;

import modelo.CursoICC264;
import modelo.Estudiante;

import java.io.*;

public class DatosEstudiantes {
    public static void leerArchivoEstudiantes(CursoICC264 curso, String direccionArchivo) {
        String textoArchivo = "";
        try {
            File archivo = new File(direccionArchivo);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            while((textoArchivo = br.readLine()) != null){
                String[] data = textoArchivo.split(";");
                curso.getEstudiantes().add(new Estudiante(data[0], data[1], data[2]));
            }
        } catch (Exception e) {
            System.out.println("Documento no disponible");
        }
    }

    public static boolean registrarDatos(Object objeto, String direccionArchivo) {
        boolean lineaVacia=false;
        try {
            File file = new File(direccionArchivo);
            if (!file.exists()) {
                file.createNewFile();
                lineaVacia=true;
            }
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);

            if(!lineaVacia){
                bw.newLine();
            }
            bw.write(objeto.toString());
            bw.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error al ingresar datos de estudiante");
            return false;
        }
    }
}
