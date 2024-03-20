package app;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SeleccionPartidoUI extends JFrame implements ActionListener {
    private JComboBox<String> partidosComboBox;
    private JButton seleccionarButton;

    public SeleccionPartidoUI() {
        setTitle("Seleccionar Partido");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // ComboBox para mostrar los partidos disponibles
        partidosComboBox = new JComboBox<>();
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(partidosComboBox, gbc);

        // Botón para seleccionar el partido
        seleccionarButton = new JButton("Seleccionar");
        seleccionarButton.addActionListener(this);
        gbc.gridy = 1;
        panel.add(seleccionarButton, gbc);

        add(panel);
        setVisible(true);
    }

    public void cargarPartidos(Connection connection) {
        try {
            String query = "SELECT id_partido, fecha FROM Partidos WHERE fecha > CURDATE() AND resultado IS NULL";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idPartido = resultSet.getInt("id_partido");
                String fecha = resultSet.getString("fecha");
                partidosComboBox.addItem(idPartido + " - " + fecha);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == seleccionarButton) {
            // Obtener el id del partido seleccionado
            String selectedPartido = (String) partidosComboBox.getSelectedItem();
            int idPartido = Integer.parseInt(selectedPartido.split(" - ")[0]);

            // Pasar el id del partido a otra clase (puedes hacer lo que necesites aquí)
            // Por ejemplo, puedes llamar a otro método para manejar la selección del partido
            manejarSeleccionPartido(idPartido);
        }
    }

    // Método para manejar la selección del partido
    private void manejarSeleccionPartido(int idPartido) {
        // Aquí puedes implementar la lógica para manejar la selección del partido
        // Por ejemplo, puedes pasar el id del partido a otra clase o realizar alguna acción en función de él
        // En este ejemplo, simplemente mostraremos un mensaje con el id del partido seleccionado
        JOptionPane.showMessageDialog(this, "Has seleccionado el partido con ID: " + idPartido);
    }
}
