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

    final MimeMultipart generateMailContent(final Group group, final String path) throws MessagingException {

        final StringBuilder sb = new StringBuilder();

        sb.append("Hello! ");
        sb.append(System.lineSeparator());
        sb.append("This is an autmatic generated mail by the groupBuilder of Dennis Markmann.");
        sb.append(System.lineSeparator());
        sb.append(System.lineSeparator());
        sb.append("GroupName: ");
        sb.append(group.getName());
        sb.append(System.lineSeparator());
        sb.append("GroupSize: ");
        sb.append(group.getMemberList().size());
        sb.append(System.lineSeparator());
        sb.append("Decription: ");
        sb.append(group.getDescription());
        sb.append(System.lineSeparator());
        sb.append(System.lineSeparator());
        sb.append("Member: ");
        sb.append(System.lineSeparator());

        for (final Member member : group.getMemberList()) {

            sb.append(member.getLastName());
            sb.append(", ");
            sb.append(member.getFirstName());
            sb.append(" : ");
            sb.append(member.getEMailAdress());
            sb.append(System.lineSeparator());

        }

        final MimeMultipart mailContent = new MimeMultipart();
        final MimeBodyPart text = new MimeBodyPart();
        text.setText(sb.toString());
        text.setDisposition(MimeBodyPart.INLINE);

        final File file = new File(path + "Groups//" + group.getName() + ".xml");

        final MimeBodyPart attachement = new MimeBodyPart();
        attachement.setDataHandler(new DataHandler(new FileDataSource(file)));
        attachement.setFileName(file.getName());
        attachement.setDisposition(MimeBodyPart.ATTACHMENT);
        mailContent.addBodyPart(text);
        mailContent.addBodyPart(attachement);

        return mailContent;
    }
}
