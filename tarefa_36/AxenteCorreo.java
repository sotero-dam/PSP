package tarefa_36;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

public class AxenteCorreo {

    private static final String CORREO_ORIXE = "hello@sofiakindom.com";
    private static final String CORREO_DESTINO = "kitty@sofiakindom.com";

    public static void main(String[] args) {
        AxenteCorreo axente = new AxenteCorreo();
        ConfiguracionCorreo configuracion = new ConfiguracionCorreo();
        Session sesion = configuracion.obterSesion();

        axente.enviarNotificacion(sesion);
        axente.lerCorreos(sesion, configuracion.obterNomeUsuario(), configuracion.obterContrasinal());
    }

    public void enviarNotificacion(Session sesion) {
        try {
            MimeMessage mensaxe = new MimeMessage(sesion);
            mensaxe.setFrom(new InternetAddress(CORREO_ORIXE));
            mensaxe.setRecipients(Message.RecipientType.TO, InternetAddress.parse(CORREO_DESTINO));
            mensaxe.setSubject("Proba de Axente [Sofia DAM :)]");
            mensaxe.setText("O sistema de notificacións ta ready");
            Transport.send(mensaxe);
            System.out.println("Correo enviado, tudo bemmmm.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void lerCorreos(Session sesion, String nomeUsuario, String contrasinal) {
        Store almacen = null;
        Folder caixaEntrada = null;
        try {
            almacen = sesion.getStore("pop3s");
            almacen.connect(nomeUsuario, contrasinal);

            caixaEntrada = almacen.getFolder("INBOX");
            caixaEntrada.open(Folder.READ_ONLY);

            Message[] mensaxes = caixaEntrada.getMessages();

            System.out.println("O que che enviaron: " + mensaxes.length);
            int contador = 0;
            for (int i = mensaxes.length - 1; i >= 0 && contador < 5; i--) {
                Message mensaxe = mensaxes[i];
                Address[] remitentes = mensaxe.getFrom();
                String remitenteStr = remitentes.length > 0 ? remitentes[0].toString() : "Non me sona de nada";
                System.out.println("Asunto: " + mensaxe.getSubject());
                System.out.println("Remitente: " + remitenteStr);
                contador++;
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        } finally {
            try {
                if (caixaEntrada != null && caixaEntrada.isOpen()) {
                    caixaEntrada.close(false);
                }
                if (almacen != null) {
                    almacen.close();
                }
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }
}