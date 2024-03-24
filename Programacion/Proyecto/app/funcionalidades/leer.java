public class leer {
    public static void main(String[] args) {
        // Cadena de ejemplo a encriptar
        String contraseña = "12345";

        // Encriptar la contraseña utilizando MD5
        String contraseñaEncriptada = Encriptador.encrypt(contraseña);

        // Imprimir la contraseña original y la encriptada
        System.out.println("Contraseña original: " + contraseña);
        System.out.println("Contraseña encriptada: " + contraseñaEncriptada);
        System.out.println("Otra forma encriptar : "+Encriptador.getMD5(contraseña));

    }
}
