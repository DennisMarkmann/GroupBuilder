package markmann.dennis.groupBuilder.fileOperations.output;

import java.io.File;
import java.util.ArrayList;

import markmann.dennis.groupBuilder.exceptions.NothingToDoExeption;
import markmann.dennis.groupBuilder.logging.LogHandler;
import markmann.dennis.groupBuilder.storage.Group;
import markmann.dennis.groupBuilder.storage.Member;
import markmann.dennis.groupBuilder.storage.Pojo;

import org.apache.log4j.Logger;

import dennis.markmann.MyLibraries.DefaultJobs.Email.EmailContentCreator;
import dennis.markmann.MyLibraries.DefaultJobs.Email.EmailJob;
import dennis.markmann.MyLibraries.DefaultJobs.Email.EmailObject;
import dennis.markmann.MyLibraries.DefaultJobs.Email.EmailSettings;

/**
 * Helper class used to initialize the emailSending and to create the emails to send.
 * 
 * @author dennis.markmann
 * @version 1.0
 */

public class EmailJobHelper {

    private static final Logger LOGGER = LogHandler.getLogger("./logs/Output.log");

    private EmailSettings setEmailSettings() {
        return new EmailSettings(
                "GroupBuilder@gmx.de",
                "buildGroups",
                "GroupBuilder@gmx.de",
                "GroupBuilder",
                "smtp.gmx.net",
                "587",
                true);
    }

    public final void sendMailToGroups(final Pojo pojo, final ArrayList<Group> groupList) {

        LOGGER.info("Sending eMails to groups.");

        if (groupList.size() == 0) {
            new NothingToDoExeption(pojo.getTranslation("Send")).showDialog();
            return;
        }

        final ArrayList<EmailObject> emailList = this.createEmailObjects(pojo, groupList);
        // try {

        final Thread emailThread = new Thread(new EmailJob(this.setEmailSettings(), emailList));
        emailThread.run();

        //
        // } catch (final EmailSendingException e) {
        // new markmann.dennis.groupBuilder.exceptions.EmailSendingException(e);
        // } catch (final EmailAddressException e) {
        // new markmann.dennis.groupBuilder.exceptions.EmailAddressException(e);
        // }
    }

    //
    // public final void sendSingleMail(final Pojo pojo, final Member member) {
    // final ArrayList<EmailObject> emailList = new ArrayList<EmailObject>();
    // emailList.add(this.createSingleEmailObject(pojo, member));
    // new EmailJob().sendMail(this.setEmailSettings(), emailList);
    // }

    private ArrayList<EmailObject> createEmailObjects(final Pojo pojo, final ArrayList<Group> groupList) {

        final ArrayList<EmailObject> emailList = new ArrayList<EmailObject>();
        final String path = pojo.getSettings().getPath();

        for (final Group group : groupList) {

            final EmailObject emailObject = new EmailObject();
            emailList.add(emailObject);

            final ArrayList<String> emailAddresList = emailObject.getEmailAddressList();
            final String emailText = new TextCreator().generateMailText(group, path);
            final File file = new File(path + "Groups//" + group.getName() + ".xml");

            new EmailContentCreator().createMailContent(emailText, file, emailObject);

            for (final Member member : group.getMemberList()) {
                emailAddresList.add(member.getEMailAdress());
            }
        }
        return emailList;
    }

    // private EmailObject createSingleEmailObject(final Pojo pojo,
    // final Member member) {
    //
    // final ArrayList<EmailObject> emailList = new ArrayList<EmailObject>();
    // final String path = pojo.getSettings().getPath();
    //
    // final EmailObject emailObject = new EmailObject();
    // emailList.add(emailObject);
    //
    // final ArrayList<String> emailAddresList = emailObject
    // .getEmailAddressList();
    // emailAddresList.add(member.getEMailAdress());
    //
    // final Group group = member.getGroup();
    //
    // final String emailText = this.generateMailText(group, path);
    // final File file = new File(path + "Groups//" + group.getName() + ".xml");
    //
    // new EmailContentCreator().createMailContent(emailText, file,
    // emailObject);
    //
    // return emailObject;
    // }
}
