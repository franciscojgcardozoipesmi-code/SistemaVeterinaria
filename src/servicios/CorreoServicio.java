package servicios;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class CorreoServicio {

    private static final String CORREO_SISTEMA =
            System.getenv("HENRY_CORREO");

    private static final String CLAVE_CORREO =
            System.getenv("HENRY_CORREO_CLAVE");

    public static void enviarCodigoRecuperacion(
            String destinatario,
            String codigo
    ) throws Exception {

        if (CORREO_SISTEMA == null
                || CORREO_SISTEMA.isBlank()
                || CLAVE_CORREO == null
                || CLAVE_CORREO.isBlank()) {

            throw new IllegalStateException(
                    "No se configuraron los datos del correo"
            );
        }

        Properties propiedades =
                new Properties();

        propiedades.put(
                "mail.smtp.auth",
                "true"
        );

        propiedades.put(
                "mail.smtp.starttls.enable",
                "true"
        );

        propiedades.put(
                "mail.smtp.starttls.required",
                "true"
        );

        propiedades.put(
                "mail.smtp.host",
                "smtp.gmail.com"
        );

        propiedades.put(
                "mail.smtp.port",
                "587"
        );

        propiedades.put(
                "mail.smtp.ssl.trust",
                "smtp.gmail.com"
        );

        Session sesion =
                Session.getInstance(
                        propiedades,
                        new Authenticator() {

                    @Override
                    protected PasswordAuthentication
                            getPasswordAuthentication() {

                        return new PasswordAuthentication(
                                CORREO_SISTEMA,
                                CLAVE_CORREO
                        );
                    }
                });

        MimeMessage mensaje =
                new MimeMessage(
                        sesion
                );

        mensaje.setFrom(
                new InternetAddress(
                        CORREO_SISTEMA,
                        "Henry System Vet",
                        StandardCharsets.UTF_8.name()
                )
        );

        mensaje.setRecipient(
                Message.RecipientType.TO,
                new InternetAddress(
                        destinatario
                )
        );

        mensaje.setSubject(
                "Código de recuperación",
                StandardCharsets.UTF_8.name()
        );

        mensaje.setText(
                "Recibimos una solicitud para cambiar "
                + "la contraseña de tu cuenta.\n\n"
                + "Tu código de recuperación es: "
                + codigo
                + "\n\nEl código vence en 10 minutos."
                + "\n\nSi no solicitaste el cambio, "
                + "podés ignorar este correo.",
                StandardCharsets.UTF_8.name()
        );

        Transport.send(
                mensaje
        );
    }
}