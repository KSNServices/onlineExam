package com.onlineexam.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailUtil {

	private static Session session = null;

	private static Properties props = new Properties();

	private static Properties configFile = new Properties();

	private static String fromEmail = "";
	private static String password = "";

	static {
		try {
			configFile.load(EmailUtil.class.getClassLoader().getResourceAsStream("mailConfig.properties"));
			fromEmail = configFile.getProperty("in.school.erp.mail.userName");
			password = configFile.getProperty("in.school.erp.mail.password");

			props.put("mail.smtp.host", configFile.getProperty("mail.host")); // SMTP
																				// Host
			props.put("mail.smtp.socketFactory.port", configFile.getProperty("mail.smtp.socketFactory.port")); // SSL
																												// Port
			props.put("mail.smtp.socketFactory.class", configFile.getProperty("mail.smtp.socketFactory.class")); // SSL
																													// Factory
																													// Class
			props.put("mail.smtp.auth", configFile.getProperty("mail.smtp.auth")); // Enabling
																					// SMTP
																					// Authentication
			props.put("mail.smtp.port", configFile.getProperty("mail.smtp.port")); // SMTP
																					// Port
			props.put("mail.smtp.EnableSSL.enable", "true");
			Authenticator auth = new Authenticator() {
				// override the getPasswordAuthentication method
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				}
			};
			session = Session.getDefaultInstance(props, auth);
			System.out.println("Session created");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Utility method to send simple HTML email
	 * 
	 * @param session
	 * @param toEmail
	 * @param subject
	 * @param body
	 */
	public void sendEmail(String toEmail, String subject, String body) {
		try {
			MimeMessage msg = new MimeMessage(session);
			// set message headers
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress(fromEmail, "NoReply-AethonTech"));

			msg.setReplyTo(InternetAddress.parse(fromEmail, false));

			msg.setSubject(subject, "UTF-8");

			msg.setText(body, "UTF-8");

			msg.setSentDate(new Date());

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
			System.out.println("Message is ready");
			Transport.send(msg);

			System.out.println("EMail Sent Successfully!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendAttachmentEmail(String toEmail, String subject, String body, String fileFullPath) {
		try {
			MimeMessage msg = new MimeMessage(session);
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress(fromEmail, "NoReply-JD"));

			msg.setReplyTo(InternetAddress.parse(fromEmail, false));

			msg.setSubject(subject, "UTF-8");

			msg.setSentDate(new Date());

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));

			// Create the message body part
			BodyPart messageBodyPart = new MimeBodyPart();

			// Fill the message
			messageBodyPart.setText(body);

			// Create a multipart message for attachment
			Multipart multipart = new MimeMultipart();

			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			// Second part is attachment
			messageBodyPart = new MimeBodyPart();
			String filename = fileFullPath;
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			msg.setContent(multipart);

			// Send message
			Transport.send(msg);
			System.out.println("EMail Sent Successfully with attachment!!");
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public void sendImageEmail(Session session, String toEmail, String subject, String body, String imageFileName) {
		try {
			MimeMessage msg = new MimeMessage(session);
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress(fromEmail, "NoReply-JD"));

			msg.setReplyTo(InternetAddress.parse(fromEmail, false));

			msg.setSubject(subject, "UTF-8");

			msg.setSentDate(new Date());

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));

			// Create the message body part
			BodyPart messageBodyPart = new MimeBodyPart();

			messageBodyPart.setText(body);

			// Create a multipart message for attachment
			Multipart multipart = new MimeMultipart();

			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			// Second part is image attachment
			messageBodyPart = new MimeBodyPart();
			String filename = imageFileName;
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			// Trick is to add the content-id header here
			messageBodyPart.setHeader("Content-ID", "image_id");
			multipart.addBodyPart(messageBodyPart);

			// third part for displaying image in the email body
			messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent("<h1>Attached Image</h1>" + "<img src='cid:image_id'>", "text/html");
			multipart.addBodyPart(messageBodyPart);

			// Set the multipart message to the email message
			msg.setContent(multipart);

			// Send message
			Transport.send(msg);
			System.out.println("EMail Sent Successfully with image!!");
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		EmailUtil emailUtil = new EmailUtil();
		String messageBody = "Hi," + "\n\n" + " Your password of Betcha app is " + new Integer(1234) + "." + "\n\n\n\n"
				+ "Regards,\nBetcha Team";

		emailUtil.sendEmail("shailesh.atn@outlook.com", "Password Recovery", messageBody);

		// EmailUtil.sendAttachmentEmail(session, toEmail,"SSLEmail Testing
		// Subject with Attachment", "SSLEmail Testing Body with Attachment");

		// EmailUtil.sendImageEmail(session, toEmail,"SSLEmail Testing Subject
		// with Image", "SSLEmail Testing Body with Image");

	}

}
