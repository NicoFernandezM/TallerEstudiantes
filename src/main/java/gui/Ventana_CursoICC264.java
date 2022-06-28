package gui;

import modelo.CursoICC264;
import modelo.Estudiante;
import modelo.EstudianteNoEncontradoException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana_CursoICC264 extends Ventana implements ActionListener {
    private CursoICC264 curso;

    private JButton nuevoEstudianteBtn;
    private JButton buscarBtn;
    private JComboBox rutEstudiante;

    private JLabel nombreLabel;
    private JLabel emailLabel;

    private JLabel nombre;
    private JLabel email;

    public Ventana_CursoICC264(CursoICC264 curso) {
        this.curso = curso;

        this.setTitle("Curso ICC264");

        JLabel nombreLabel = this.generarEtiqueta("Nombre: ", 20, 100, 80, 20);
        JLabel emailLabel = this.generarEtiqueta("Email: ", 20, 150, 80, 20);

        nuevoEstudianteBtn = this.generarBoton("Nuevo estudiante", 200, 200, 150, 30);
        nuevoEstudianteBtn.addActionListener(this);

        buscarBtn = this.generarBoton("Buscar estudiante", 20, 200, 150, 30);
        buscarBtn.addActionListener(this);

        nombre = this.generarEtiqueta("", 100, 100, 300, 20);
        email = this.generarEtiqueta("", 100, 150, 300, 20);

        rutEstudiante = this.generarComboBox(curso.getEstudiantes(), 20, 50, 200, 20);
    }

    public void mostrarDatosEstudiante() throws EstudianteNoEncontradoException {
        Estudiante e = curso.buscarEstudiantePorRut(rutEstudiante.getSelectedItem().toString());
        nombre.setText(e.getNombre());
        email.setText(e.getEmail());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == nuevoEstudianteBtn) {
            new Ventana_AgregarEstudianteICC264(this.curso);
            this.dispose();
        } else if(e.getSource() == buscarBtn) {
            try {
                mostrarDatosEstudiante();
            } catch (EstudianteNoEncontradoException ex) {
                ex.printStackTrace();
            }
        }
    }

}
