package app;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;


public class EntradasRealMadrid extends JFrame implements ActionListener {

    private JButton entradasButton;
    private JButton miCuentaButton;
    private JButton salirButton;

    public EntradasRealMadrid() {
        setTitle("Entradas Bernabeu");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Fondo de pantalla
        ImageIcon fondoIcono = new ImageIcon("./img/Fondo.jpeg");

        JPanel panel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(fondoIcono.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        GridBagConstraints gbc = new GridBagConstraints();

        // Configuración del logo
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 20, 0);
        // Escalando el logo para que sea de un tamaño más apropiado
        ImageIcon logoIcon = new ImageIcon(new ImageIcon("./img/LOGO.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
        JLabel logoLabel = new JLabel(logoIcon);
        panel.add(logoLabel, gbc);

        // Botón "Entradas"
        gbc.gridy++;
        gbc.insets = new Insets(10, 0, 10, 0);
        entradasButton = new JButton("Entradas");
        entradasButton.addActionListener(this);
        panel.add(entradasButton, gbc);

        // Botón "Mi Cuenta"
        gbc.gridy++;
        miCuentaButton = new JButton("Mi Cuenta");
        miCuentaButton.addActionListener(this);
        panel.add(miCuentaButton, gbc);

        // Botón "Salir"
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.PAGE_END;
        salirButton = new JButton("Salir");
        salirButton.addActionListener(this);
        panel.add(salirButton, gbc);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == salirButton) {
            System.exit(0);
        } else if (e.getSource() == entradasButton) {
            // Cuando se hace clic en el botón "Entradas", mostrar la interfaz de selección de partido
            Connection connection = Conexion.getConnection();
            SeleccionPartidoUI seleccionPartidoUI = new SeleccionPartidoUI();
            seleccionPartidoUI.cargarPartidos(connection);
        } else if (e.getSource() == miCuentaButton) {
            // Lógica para manejar el botón "Mi Cuenta"
            JOptionPane.showMessageDialog(this, "Opción de Mi Cuenta seleccionada");
        }
    }

}
