package com.nist.kidwatcher;

import android.os.AsyncTask;
import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail extends AsyncTask
{
    private static String TAG = "Mail";

    final String emailPort = "587";
    final String smtpAuth = "true";
    final String starttls = "true";
    final String emailHost = "smtp.gmail.com";

    String fromEmail;
    String fromPassword;
    List toEmailList;
    String emailSubject;
    String emailBody;

    Properties emailProperties;
    Session mailSession;
    MimeMessage emailMessage;

    public Mail(List toEmailList, String emailBody) {
        this.fromEmail = "Nicklassej@gmail.com";
        this.fromPassword = "bright222";
        this.toEmailList = toEmailList;
        this.emailSubject = "Kidwatcher har opdaget fy-ord";
        this.emailBody = emailBody;

        emailProperties = System.getProperties();
        emailProperties.put("mail.smtp.port", emailPort);
        emailProperties.put("mail.smtp.auth", smtpAuth);
        emailProperties.put("mail.smtp.starttls.enable", starttls);
        Log.i(TAG, "Mail server properties set.");
    }

    public MimeMessage createEmailMessage() throws AddressException, MessagingException, UnsupportedEncodingException
    {
        mailSession = Session.getDefaultInstance(emailProperties, null);
        emailMessage = new MimeMessage(mailSession);

        emailMessage.setFrom(new InternetAddress(fromEmail, fromEmail));
        for (Object toEmail : toEmailList) {
            Log.i(TAG, "toEmail: "+toEmail);
            emailMessage.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(toEmail.toString()));
        }

        emailMessage.setSubject(emailSubject);
        emailMessage.setContent(emailBody, "text/html");// for a html email
        // emailMessage.setText(emailBody);// for a text email
        Log.i(TAG, "Email Message created.");
        return emailMessage;
    }

    public void sendEmail() throws AddressException, MessagingException
    {
        Transport transport = mailSession.getTransport("smtp");
        transport.connect(emailHost, fromEmail, fromPassword);
        //Log.i(TAG, "allrecipients: " + emailMessage.getAllRecipients());
        transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
        transport.close();
        Log.i(TAG, "Email sent successfully.");
    }

    @Override
    protected Object doInBackground(Object[] params)
    {
        try
        {
            Log.d(TAG, "Fy-ord fundet!!!");
            createEmailMessage();
            sendEmail();
        }
        catch (Exception ex)
        {
            Log.d(TAG, "Error");
        }
        return null;
    }
}
