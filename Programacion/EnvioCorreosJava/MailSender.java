import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {

    public static void main(String[] args) {
        // Configuración del servidor SMTP de Mailrelay
        String host = ""; // Reemplaza con el servidor SMTP de Mailrelay
        int puerto = 587; // Puerto para envío de correo (puede variar, consulta la documentación de Mailrelay)
        final String usuario = ""; // Reemplaza con tu nombre de usuario de Mailrelay
        final String contraseña = ""; // Reemplaza con tu contraseña de Mailrelay

        // Propiedades de conexión
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", puerto);

        // Autenticación
        Authenticator autenticador = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usuario, contraseña);
            }
        };

        // Creación de la sesión
        Session session = Session.getInstance(props, autenticador);

        try {
            // Creación del mensaje
            Message mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress("")); // Reemplaza con tu dirección de correo electrónico
            mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse("javierpuertas2004@gmail.com")); // Reemplaza con la dirección de correo del destinatario
            mensaje.setSubject("Perro metete al discord");
            mensaje.setText("Esto es una pruba desde java");

            // Envío del mensaje
            Transport.send(mensaje);

            System.out.println("¡El correo ha sido enviado exitosamente! al correo ");

        } catch (MessagingException e) {
            System.err.println("Error al enviar el correo: " + e.getMessage());
        }
    }
}