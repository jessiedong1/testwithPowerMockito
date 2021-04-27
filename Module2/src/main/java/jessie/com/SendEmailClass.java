package jessie.com;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmailClass {

    public static void sendEmail(String to, String from) {
        String host = "localhost";//or IP address

        //Get the session object
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host", host);
        String value = properties.getProperty("mail.smtp.host");
        Session session = Session.getDefaultInstance(properties);

        //compose the message
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject("Ping");
            message.setText("Hello, this is example of sending email  ");

            // Send message
            Transport.send(message);
            System.out.println("message sent successfully....");
            System.out.println(value);

        }catch (MessagingException mex) {mex.printStackTrace();}
    }
}
