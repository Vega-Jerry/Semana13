/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aplicaciongui;

/**
 *
 * @author Jerry Vega
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AplicacionGUI extends JFrame {

    private JTextField campoTexto;
    private DefaultListModel<String> modeloLista;
    private JList<String> lista;

    public AplicacionGUI() {
        // Configuración de la ventana
        setTitle("Aplicación GUI");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Creación de componentes
        campoTexto = new JTextField(20);
        JButton botonAgregar = new JButton("Agregar");
        JButton botonLimpiar = new JButton("Limpiar");
        modeloLista = new DefaultListModel<>();
        lista = new JList<>(modeloLista);

        // Configuración del layout
        JPanel panelNorte = new JPanel();
        panelNorte.add(new JLabel("Ingrese texto:"));
        panelNorte.add(campoTexto);
        panelNorte.add(botonAgregar);
        panelNorte.add(botonLimpiar);

        // Agregar componentes a la ventana
        add(panelNorte, BorderLayout.NORTH);
        add(new JScrollPane(lista), BorderLayout.CENTER);

        // Manejo de eventos
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarTexto();
            }
        });

        botonLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
            }
        });
    }

    private void agregarTexto() {
        String texto = campoTexto.getText();
        if (!texto.isEmpty()) {
            modeloLista.addElement(texto);
            campoTexto.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "No se puede agregar texto vacío");
        }
    }

    private void limpiar() {
        campoTexto.setText("");
        modeloLista.clear();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AplicacionGUI aplicacion = new AplicacionGUI();
                aplicacion.setVisible(true);
            }
        });
    }
}

