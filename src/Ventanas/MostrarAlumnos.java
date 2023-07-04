package Ventanas;

import Pojo.Estudiante;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MostrarAlumnos extends JFrame {
    private static ArrayList<Estudiante> estudiantes;
    private JList<Estudiante> jLista;
    private JButton btnMostrar, btnRegresar;
    private DefaultListModel<Estudiante> elementosModel;

    // CONTENEDORES
    private JPanel panelList, panelButton, panelContainer;

    public MostrarAlumnos(String usuario, String contraseña) {
        estudiantes = Registro.getElemento();
        initControl();
        setControl();
        configPanel();
        setupFrame();

        mostrarEstudiante(usuario, contraseña);
        regresar();
    }

    private void mostrarEstudiante(String usuario, String contraseña) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getUsuario().equals(usuario) && estudiante.getContra().equals(contraseña)) {
                String mensaje = "Carrera: " + estudiante.getCarrera() + "\n" +
                        "Semestre: " + estudiante.getSemestre() + "\n" +
                        "Alumno: " + estudiante.getAlumno() + "\n" +
                        "Profesor: " + estudiante.getProfesor() + "\n" +
                        "Materia: " + estudiante.getMateria() + "\n" +
                        "Parcial 1: " + estudiante.getParcial1() + "\n" +
                        "Parcial 2: " + estudiante.getParcial2() + "\n" +
                        "Parcial 3: " + estudiante.getParcial3() + "\n" +
                        "Ordinario: " + estudiante.getOrdinario() + "\n" +
                        "Extra 1: " + estudiante.getExtra1() + "\n" +
                        "Extra 2: " + estudiante.getExtra2();
                JOptionPane.showMessageDialog(this, mensaje, "Información del Estudiante", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Estudiante no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void regresar() {
        btnRegresar.addActionListener(e -> {
            this.setVisible(false);
            new Login().setVisible(true);
        });
    }

    private void initControl() {
        jLista = new JList<>();
        panelButton = new JPanel();
        panelList = new JPanel();
        panelContainer = new JPanel();
        btnMostrar = new JButton();
        btnRegresar = new JButton();
    }

    private void setupFrame() {
        setTitle("Mostrar");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(350, 230);
        add(panelContainer);

    }

    private void setControl() {
        btnMostrar.setText("Mostrar");
        btnRegresar.setText("Regresar");
    }

    private void configPanel() {
        panelList.setLayout(new GridLayout(1, 0));
        panelList.add(jLista);
        panelList.setPreferredSize(new Dimension(100, 100));

        panelButton.setLayout(new FlowLayout());
        panelButton.setPreferredSize(new Dimension(300, 100));
        panelButton.add(btnMostrar);
        panelButton.add(btnRegresar);

        panelContainer.setLayout(new GridLayout(2, 0));
        panelContainer.add(panelList);
        panelContainer.add(panelButton);
    }

}
