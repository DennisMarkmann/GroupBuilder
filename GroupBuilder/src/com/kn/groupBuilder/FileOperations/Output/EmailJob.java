package com.kn.groupBuilder.FileOperations.Output;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Member;
import com.kn.groupBuilder.Storage.Pojo;

public class EmailJob {

	public void initializeEmailSending(Pojo pojo) {

		String username = "GroupBuilder@gmx.de";
		String password = "buildGroups";
		String senderAddress = "GroupBuilder@gmx.de";
		String subject = "GroupBuilder";
		String smtpHost = "smtp.gmx.net";

		new EmailJob().sendMail(smtpHost, username, password, senderAddress,
				subject, pojo);
	}

	public void sendMail(String smtpHost, String username, String password,
			String senderAddress, String subject, Pojo pojo) {

		Properties properties = new Properties();
		properties.put("mail.smtp.host", smtpHost);
		properties.setProperty("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");

		MailAuthenticator auth = new MailAuthenticator(username, password);
		Session session = Session.getDefaultInstance(properties, auth);

		try {
			Message msg = new MimeMessage(session);

			msg.setFrom(new InternetAddress(senderAddress));

			msg.setSubject(subject);
			msg.setHeader("GroupBuilder", "GroupBuilder");
			msg.setSentDate(new Date());
			MimeMultipart mailContent;
			ArrayList<Group> groupList = pojo.getGroupList();
			for (Group group : groupList) {

				mailContent = this.generateMailContent(group,
						pojo.getDefaultPath());

				msg.setContent(mailContent);

				for (Member member : group.getMemberList()) {
					String emailAdress = member.getEMailAdress();
					if (emailAdress != null && !emailAdress.equals("")) {
						msg.setRecipients(Message.RecipientType.TO,
								InternetAddress.parse(emailAdress, false));
						Transport.send(msg);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	class MailAuthenticator extends Authenticator {
		private final String user;
		private final String password;

		public MailAuthenticator(String user, String password) {
			this.user = user;
			this.password = password;
		}

		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(this.user, this.password);
		}
	}

	private MimeMultipart generateMailContent(Group group, String defaultPath)
			throws MessagingException {
		String emailText = "Hello! "
				+ "\r\n"
				+ "This is an autmatic generated mail by the groupBuilder of Dennis Markmann."
				+ "\r\n" + "\r\n" + "GroupName: " + group.getName() + "\r\n"
				+ "GroupSize: " + group.getMemberList().size() + "\r\n"
				+ "Decription: " + group.getDescription() + "\r\n" + "\r\n"
				+ "Member:" + "\r\n";

		for (Member member : group.getMemberList()) {
			String memberInfo = member.getLastName() + ", "
					+ member.getFirstName() + " : " + member.getEMailAdress()
					+ "\r\n";
			emailText = emailText + memberInfo;
		}

		MimeMultipart mailContent = new MimeMultipart();
		MimeBodyPart text = new MimeBodyPart();
		text.setText(emailText);
		text.setDisposition(MimeBodyPart.INLINE);

		File file = new File(defaultPath + "//Groups//" + group.getName()
				+ ".xml");

		MimeBodyPart attachement = new MimeBodyPart();
		attachement.setDataHandler(new DataHandler(new FileDataSource(file)));
		attachement.setFileName(file.getName());
		attachement.setDisposition(MimeBodyPart.ATTACHMENT);
		mailContent.addBodyPart(text);
		mailContent.addBodyPart(attachement);

		return mailContent;
	}
}