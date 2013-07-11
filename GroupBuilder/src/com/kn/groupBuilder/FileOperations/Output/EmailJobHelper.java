package com.kn.groupBuilder.FileOperations.Output;

import java.io.File;
import java.util.ArrayList;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Member;
import com.kn.groupBuilder.Storage.Pojo;

import dennis.markmann.MyLibraries.DefaultJobs.EmailJob;
import dennis.markmann.MyLibraries.MyObjects.EmailObject;

public class EmailJobHelper {

    public final void initializeEmailSending(final Pojo pojo) {

        final String username = "GroupBuilder@gmx.de";
        final String password = "buildGroups";
        final String senderAddress = "GroupBuilder@gmx.de";
        final String subject = "GroupBuilder";
        final String smtpHost = "smtp.gmx.net";

        final ArrayList<EmailObject> emailList = this.createEmailObjects(pojo);
        new EmailJob().sendMail(smtpHost, username, password, senderAddress, subject, emailList);
    }

    private final MimeMultipart generateMailContent(final Group group, final String path) throws MessagingException {

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

    private final ArrayList<EmailObject> createEmailObjects(final Pojo pojo) {

        final ArrayList<EmailObject> emailList = new ArrayList<EmailObject>();

        for (final Group group : pojo.getGroupList()) {

            final EmailObject emailObject = new EmailObject();
            emailList.add(emailObject);
            final ArrayList<String> emailAddresList = emailObject.getEmailAddressList();
            try {
                emailObject.setMailContent(this.generateMailContent(group, pojo.getSettings().getPath()));
            } catch (final MessagingException e) {
                // TODO
                e.printStackTrace();
            }

            for (final Member member : group.getMemberList()) {
                emailAddresList.add(member.getEMailAdress());
            }
        }
        return emailList;
    }
}
