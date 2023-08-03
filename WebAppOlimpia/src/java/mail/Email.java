/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mail;

import java.io.Serializable;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author santi
 */
public class Email implements Serializable {

    public void enviarCorreo(String fromMail, String username, String receptor, String clave, String mensaje, String asunto) throws AddressException, MessagingException{

        
            Properties pro = System.getProperties();
            pro.put("mail.smtp.host", "smtp.gmail.com");
            pro.put("mail.smtp.auth", "true");
            pro.put("mail.smtp.port", "465");
           
            //  pro.put("mail.smtp.user", fromMail);
           // pro.put("mail.smtp.clave", "miClaveDeGMail");
            
            pro.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            pro.put("mail.smtp.socketFactory.port", "465");
            pro.put("mail.smtp.socketFactory.fallback", "false");


            Session sesion = Session.getDefaultInstance(pro, null);
            sesion.setDebug(true);

            Message message = new MimeMessage(sesion);

            message.setFrom(new InternetAddress(fromMail));

            message.setRecipient(Message.RecipientType.TO, new InternetAddress(receptor));
            message.setContent(mensaje, "text/html");
            message.setSubject(asunto);

            //Variable de envio para los correos electronicos
            Transport transport = sesion.getTransport("smtp");
            transport.connect("smtp.gmail.com", username, clave);
            transport.sendMessage(message, message.getAllRecipients());





        

    }
}
