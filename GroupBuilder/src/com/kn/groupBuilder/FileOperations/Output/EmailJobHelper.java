package com.kn.groupBuilder.FileOperations.Output;

import java.io.File;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import com.kn.groupBuilder.Storage.Group;
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

    final MimeMultipart generateMailContent(final Group group, final String path) throws MessagingException {

        final StringBuilder sb = new StringBuilder();

        sb.append("Hello! ");
        sb.append(System.lineSeparator());
        sb.append("This is an autmatic generated mail by the groupBuilder of Dennis Markmann.");
        sb.append(System.lineSeparator());
        sb.append(System.lineSeparator());
        sb.append(new TextCreator().createText(group));

        final MimeBodyPart text = new MimeBodyPart();
        text.setText(sb.toString());
        text.setDisposition(MimeBodyPart.INLINE);

        final File file = new File(path + "Groups//" + group.getName() + ".xml");
        final MimeBodyPart attachement = new MimeBodyPart();
        attachement.setDataHandler(new DataHandler(new FileDataSource(file)));
        attachement.setFileName(file.getName());
        attachement.setDisposition(MimeBodyPart.ATTACHMENT);

        final MimeMultipart mailContent = new MimeMultipart();
        mailContent.addBodyPart(text);
        mailContent.addBodyPart(attachement);

        return mailContent;
    }
}
