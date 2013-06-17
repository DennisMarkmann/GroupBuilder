package com.kn.groupBuilder.FileOperations.Output;

import java.io.File;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Member;
import com.kn.groupBuilder.Storage.Pojo;

public class EmailJobHelper {

    public final void initializeEmailSending(final Pojo pojo) {

        final String username = "GroupBuilder@gmx.de";
        final String password = "buildGroups";
        final String senderAddress = "GroupBuilder@gmx.de";
        final String subject = "GroupBuilder";
        final String smtpHost = "smtp.gmx.net";

        new EmailJob().sendMail(smtpHost, username, password, senderAddress, subject, pojo);
    }

    final MimeMultipart generateMailContent(final Group group, final String defaultPath) throws MessagingException {
        String emailText = "Hello! " + "\r\n" + "This is an autmatic generated mail by the groupBuilder of Dennis Markmann."
                + "\r\n" + "\r\n" + "GroupName: " + group.getName() + "\r\n" + "GroupSize: " + group.getMemberList().size()
                + "\r\n" + "Decription: " + group.getDescription() + "\r\n" + "\r\n" + "Member:" + "\r\n";

        for (final Member member : group.getMemberList()) {
            final String memberInfo = member.getLastName() + ", " + member.getFirstName() + " : " + member.getEMailAdress()
                    + "\r\n";
            emailText = emailText + memberInfo;
        }

        final MimeMultipart mailContent = new MimeMultipart();
        final MimeBodyPart text = new MimeBodyPart();
        text.setText(emailText);
        text.setDisposition(MimeBodyPart.INLINE);

        final File file = new File(defaultPath + "//Groups//" + group.getName() + ".xml");

        final MimeBodyPart attachement = new MimeBodyPart();
        attachement.setDataHandler(new DataHandler(new FileDataSource(file)));
        attachement.setFileName(file.getName());
        attachement.setDisposition(MimeBodyPart.ATTACHMENT);
        mailContent.addBodyPart(text);
        mailContent.addBodyPart(attachement);

        return mailContent;
    }
}
