package gui;

import dato.DatosEstudiantes;
import modelo.CursoICC264;
import modelo.Estudiante;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana_AgregarEstudianteICC264 extends Ventana implements ActionListener {
    CursoICC264 curso;

    private JButton agregarBtn;
    private JButton cancelarBtn;

    private JTextField nombreField;
    private JTextField emailField;
    private JTextField rutField;

    public Ventana_AgregarEstudianteICC264(CursoICC264 curso) {
        this.curso = curso;

        this.setTitle("Agregar Estudiante ICC264");

        JLabel rutLabel = this.generarEtiqueta("Rut: ", 50, 50, 100, 20);
        JLabel nombreLabel = this.generarEtiqueta("Nombre: ", 50, 100, 100, 20);
        JLabel emailLabel = this.generarEtiqueta("Email: ", 50, 150, 100, 20);

        agregarBtn = this.generarBoton("Agregar", 50, 200, 125, 30);
        cancelarBtn = this.generarBoton("Cancelar", 225, 200, 125, 30);

        agregarBtn.addActionListener(this);
        cancelarBtn.addActionListener(this);

        rutField = this.generarCampoDeTexto(150, 50, 200, 20);
        nombreField = this.generarCampoDeTexto(150, 100, 200, 20);
        emailField = this.generarCampoDeTexto(150, 150, 200, 20);
    }

    public void agregarEstudiante() {
        if(!camposVacios()) {
            Estudiante estudiante = new Estudiante(rutField.getText(), nombreField.getText(), emailField.getText());
            curso.agregarEstudiante(estudiante);
            DatosEstudiantes.registrarDatos(estudiante, "ICC264.txt");

            JOptionPane.showMessageDialog(this, "¡El ha sido registrado exitósamente!",
                    "Vehiculos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "El estudiante no se ha podido registrar",
                    "Vehiculos", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public boolean camposVacios() {
        return rutField.getText().equals("") || nombreField.getText().equals("") ||
                emailField.getText().equals("");
    }

    public void limpiarTextField() {
        nombreField.setText("");
        rutField.setText("");
        emailField.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cancelarBtn) {
            new Ventana_CursoICC264(this.curso);
            this.dispose();
        } else if(e.getSource() == agregarBtn) {
            agregarEstudiante();
            limpiarTextField();
        }
    }
}
