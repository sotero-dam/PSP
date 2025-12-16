package tarefa_36;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import java.util.Properties;

public class ConfiguracionCorreo {

    private static final String ENDEREZO_HOST_MAILTRAP = "sandbox.smtp.mailtrap.io";
    private static final String NOME_USUARIO = "3eb17612509e45";
    private static final String CONTRASINAL = "654848ae97656d";
    private static final String PORTO_SMTP = "587";
    private static final String PORTO_POP3 = "995";

    public Session obterSesion() {
        Properties propiedades = new Properties();

        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.starttls.enable", "true");
        propiedades.put("mail.smtp.host", ENDEREZO_HOST_MAILTRAP);
        propiedades.put("mail.smtp.port", PORTO_SMTP);

        propiedades.put("mail.pop3s.host", ENDEREZO_HOST_MAILTRAP);
        propiedades.put("mail.pop3s.port", PORTO_POP3);
        propiedades.put("mail.pop3s.ssl.enable", "true");

        Session sesion = Session.getInstance(propiedades, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(NOME_USUARIO, CONTRASINAL);
            }
        });
        return sesion;
    }

    public String obterNomeUsuario() {
        return NOME_USUARIO;
    }

    public String obterContrasinal() {
        return CONTRASINAL;
    }
}