/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author cdkhu
 */
public class SendProject {
    public boolean sendEmail(String email) {
        boolean test = false;

        String toEmail = email;
        String fromEmail = "duycuonghdc2802@gmail.com";
        String password = "ucsi pdqw slzn bbam";

        try {

            // your host email smtp server details
            Properties pr = new Properties();
            pr.put("mail.smtp.auth", "true");
            pr.put("mail.smtp.starttls.enable", "true");
            pr.put("mail.smtp.ssl.trust", "smtp.gmail.com"); //linha adicionada para antivirus não dar problema
            pr.put("mail.smtp.host", "smtp.gmail.com");
            pr.put("mail.smtp.port", "587");

            //get session to authenticate the host email address and password
            Session session = Session.getInstance(pr, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });

            //set email message details
            Message mess = new MimeMessage(session);

            //set from email address
            mess.setFrom(new InternetAddress(fromEmail));
            //set to email address or destination email address
            mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

            //set email subject
            mess.setSubject("Inquiry Project Report Notification");

            //set message text
            mess.setText("Your Inquiry Project is finished and ready to be viewed! \n For the security reason please login to our system and to see the report details"
                    + "\n Thanks for your cooperation! \n Furniture Staff");
            //send the message
            Transport.send(mess);

            test = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return test;
    }
}
