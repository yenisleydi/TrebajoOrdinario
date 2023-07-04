package Ventanas;

import Pojo.Estudiante;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Registro extends JFrame{
    private static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JButton registrarButton;
    private JButton regresarButton;
    private JTextField textField12;
    private JTextField textField13;
    private JTextField textField14;
    private JButton mostrarButton;
    private int band=-1;
    double extra1=0;
    private int asistencias=85;

    //String usuario = CrearCredencial.generarUsuario();
    //String contra = CrearCredencial.generarContrasena();

    public Registro(){
        setupFrame();
        init();
    }
    private void setupFrame() {
        setTitle("Ingresar usuarios");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(490, 460);
        add(panel1);
        textField10.setEditable(false);
        textField11.setEditable(false);
    }
    public void init(){
       registrarButton.addActionListener(e -> {
           registro();
       });
       regresarButton.addActionListener(e -> {
           this.setVisible(false);
           new Login().setVisible(true);
       });
       mostrarButton.addActionListener(e -> {
           this.setVisible(false);
           new Mostrar().setVisible(true);
       });
    }
    private void registro(){
        String carrera = textField1.getText();
        String semestre = textField2.getText();
        String alumno = textField3.getText();
        String profesor = textField4.getText();
        String materia = textField5.getText();
        double parcial1;
        double parcial2;
        double parcial3;
        double ordinario;
        double asistenciaParcial1;
        double asistenciaParcial2;
        double asistenciaParcial3;
        String usuario = CrearCredencial.generarUsuario();
        String contra = CrearCredencial.generarContrasena();
        // Validar que nombre no contenga números
        if (!validarTextoSinNumeros(carrera)) {
            JOptionPane.showMessageDialog(null, "El nombre de la carrera no debe contener números.");
            return;
        }

        // Validar que apellidoP no contenga números
        if (!validarTextoSinNumeros(semestre)) {
            JOptionPane.showMessageDialog(null, "El semestre no debe de contener numeros");
            return;
        }

        // Validar que apellidoM no contenga números
        if (!validarTextoSinNumeros(alumno)) {
            JOptionPane.showMessageDialog(null, "El nombre del alumno no debe de contener numeros ");
            return;
        }

        // Validar que direccion no contenga números
        if (!validarTextoSinNumeros(profesor)) {
            JOptionPane.showMessageDialog(null, "El nombre del profesor no debe de contener numeros");
            return;
        }
        if (!validarTextoSinNumeros(materia)){
            JOptionPane.showMessageDialog(null, "El nombre de la materia no debe de contener numeros");
            return;
        }
        try {
            parcial1 = Double.parseDouble(textField6.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ingrese un número válido en el campo del parcial 1.");
            return;
        }
        try {
            parcial2 = Double.parseDouble(textField7.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ingrese un número válido en el campo del parcial 2.");
            return;
        }
        try {
            parcial3 = Double.parseDouble(textField8.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ingrese un número válido en el campo del parcial 3.");
            return;
        }

        // Validar ordinario
        try {
            ordinario = Double.parseDouble(textField9.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ingrese un número válido en el campo del ordinario.");
            return;
        }

        try {
            asistenciaParcial1 = Double.parseDouble(textField12.getText());
            if (asistenciaParcial1 < asistencias) {
                parcial1 = 0.0;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ingrese un número válido en el campo de asistencia del parcial 1.");
            return;
        }

        try {
            asistenciaParcial2 = Double.parseDouble(textField13.getText());
            if (asistenciaParcial2 < asistencias) {
                parcial2 = 0.0;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ingrese un número válido en el campo de asistencia del parcial 2.");
            return;
        }

        try {
            asistenciaParcial3 = Double.parseDouble(textField14.getText());
            if (asistenciaParcial3 < asistencias) {
                parcial3 = 0.0;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ingrese un número válido en el campo de asistencia del parcial 3.");
            return;
        }

        if(band!=-1){
            System.out.println("gola");
            switch (band){
                case 1 -> extra1(carrera,semestre,alumno,profesor,materia,parcial1,parcial2,parcial3,ordinario,usuario,contra);
                case 2 -> extra2(carrera,semestre,alumno,profesor,materia,parcial1,parcial2,parcial3,ordinario,extra1,usuario,contra);
            }
        } else {
            if (calcularCalificacion(parcial1, parcial2, parcial3, ordinario)) {
                registrarAlumno(carrera,semestre,alumno,profesor,materia,parcial1,parcial2,parcial3,ordinario,extra1,0.0,usuario,contra);
            } else {
                textField1.setEditable(false);
                textField2.setEditable(false);
                textField3.setEditable(false);
                textField4.setEditable(false);
                textField5.setEditable(false);
                textField6.setEditable(false);
                textField7.setEditable(false);
                textField8.setEditable(false);
                textField9.setEditable(false);
                textField12.setEditable(false);
                textField13.setEditable(false);
                textField14.setEditable(false);


                JOptionPane.showMessageDialog(this, "Ingresa calificacion de extra 1");
                textField10.setEditable(true);
                band = 1;
            }
        }
    }
    private void registrarAlumno(String carrera,String semestre,String alumno, String profesor, String materia,double parcial1, double parcial2,double parcial3, double ordinario,double extra1, double extra2,String usuario, String contra){
        estudiantes.add(new Estudiante(carrera, semestre, alumno, profesor, materia, parcial1, parcial2, parcial3, ordinario,extra1,extra2,usuario,contra));
        JOptionPane.showMessageDialog(this, "Alumno Registrado");
        textField1.setText(" ");
        textField2.setText(" ");
        textField3.setText(" ");
        textField4.setText(" ");
        textField5.setText(" ");
        textField6.setText(" ");
        textField7.setText(" ");
        textField8.setText(" ");
        textField9.setText(" ");
        textField10.setText(" ");
        textField11.setText(" ");
        textField12.setText(" ");
        textField13.setText(" ");
        textField14.setText(" ");
        band=-1;
    }
    private void extra1(String carrera,String semestre,String alumno, String profesor, String materia,double parcial1, double parcial2,double parcial3, double ordinario,String usuario, String contra){
        extra1 = Double.parseDouble(textField10.getText());
        System.out.println(extra1);
        if (extra1 < 6){
            band=2;
            JOptionPane.showMessageDialog(this, "Ingresa calificacion de extra 2");
            textField10.setEditable(false);
            textField11.setEditable(true);
        }else {
            registrarAlumno(carrera,semestre,alumno,profesor,materia,parcial1,parcial2,parcial3,ordinario,extra1,0.0,usuario,contra);
            System.out.println("dhols");
        }
    }
    private void extra2(String carrera,String semestre,String alumno, String profesor, String materia,double parcial1, double parcial2,double parcial3, double ordinario,double extra1,String usuario,String contra){
        double extra2 = Double.parseDouble(textField11.getText());
        registrarAlumno(carrera,semestre,alumno,profesor,materia,parcial1,parcial2,parcial3,ordinario,extra1,extra2,usuario,contra);
    }
    public boolean calcularCalificacion(double parcial1, double parcial2, double parcial3, double ordinario){
        double calificacion = (((parcial1+parcial2+parcial3)/3)+ordinario)/2;
        if (calificacion>6){
            return true;
        }else {
            return false;
        }
    }
    private boolean validarTextoSinNumeros(String texto) {
        // Expresión regular para validar que el texto no contenga números
        String patron = "^[^0-9]+$";
        return Pattern.matches(patron, texto);
    }
    public static ArrayList<Estudiante> getElemento() {
        return estudiantes;
    }


}
