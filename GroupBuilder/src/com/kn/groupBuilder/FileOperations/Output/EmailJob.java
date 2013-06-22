package com.kn.groupBuilder.FileOperations.Output;

import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Member;
import com.kn.groupBuilder.Storage.Pojo;

class EmailJob {

    final void sendMail(
            final String smtpHost,
            final String username,
            final String password,
            final String senderAddress,
            final String subject,
            final Pojo pojo) {

        final Properties properties = new Properties();
        properties.put("mail.smtp.host", smtpHost);
        properties.setProperty("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

        final MailAuthenticator auth = new MailAuthenticator(username, password);
        final Session session = Session.getDefaultInstance(properties, auth);

        try {
            final Message msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress(senderAddress));

            msg.setSubject(subject);
            msg.setHeader(subject, subject);
            msg.setSentDate(new Date());
            MimeMultipart mailContent;
            final ArrayList<Group> groupList = pojo.getGroupList();
            for (final Group group : groupList) {

                mailContent = new EmailJobHelper().generateMailContent(group, pojo.getSettings().getPath());
                msg.setContent(mailContent);

                for (final Member member : group.getMemberList()) {
                    final String emailAdress = member.getEMailAdress();
                    if (emailAdress != null && !emailAdress.equals("")) {
                        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailAdress, false));
                        Transport.send(msg);
                    }
                }
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    private final class MailAuthenticator extends Authenticator {

        private final String user;
        private final String password;

        private MailAuthenticator(final String user, final String password) {
            this.user = user;
            this.password = password;
        }

        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(this.user, this.password);
        }
    }

}
