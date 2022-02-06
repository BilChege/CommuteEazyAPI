/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commuteeazy.commuteeazy.Service;

import com.africastalking.AfricasTalking;
import com.africastalking.Logger;
import com.africastalking.SmsService;
import com.africastalking.sms.Recipient;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;

/**
 *
 * @author BilChege
 */
@Service
public class VerificationServices {
    
   public String verifyPhone(String phoneNumber) throws IOException{
       System.out.println(phoneNumber);
       int code = (new Random().nextInt(1000000-100000))+100000;
       String username = "BilChege";
       String apiKey = "cb5152df2490741f26324d0ed4f986989b5483540ea4b7159acbc5b8017a74d7";
//       String from = "Commuteeazy";       
       AfricasTalking.initialize(username, apiKey);
       SmsService smsService = AfricasTalking.getService(AfricasTalking.SERVICE_SMS);
       AfricasTalking.setLogger(new Logger(){
           @Override
           public void log(String string, Object... os) {
               System.out.println(string);
           }
       });
       String message = String.valueOf(code);
       int removeZero = Integer.parseInt(phoneNumber);
       String phoneNum = String.valueOf(removeZero);
       System.out.println(phoneNum);
       String [] recipients = new String[] {"+254"+phoneNum};
       List<Recipient> recipientsObjs = smsService.send(message, recipients, true);
       String verificationCode;
       if (recipientsObjs != null) {           
           verificationCode = message;
       } else {
           verificationCode = "0";
       }
       return verificationCode;
   }         
    
   public String sendEmail(String username,String emailAddress) throws AddressException, MessagingException{
      String to = emailAddress;//change accordingly  
      String from = "bildadchege2@gmail.com";  
      String host = "smtp.gmail.com";//or IP address
      
      Properties properties = System.getProperties();  
      properties.setProperty("mail.smtp.host", host);  
      properties.setProperty("mail.smtp.port", "465");
      properties.setProperty("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
      properties.setProperty("mail.smtp.socketFactory.port", "465");
      Session session = Session.getDefaultInstance(properties);
      String msgBody = "<html>\n" +
"	<body>\n" +
"		<h1>Hi "+username+"</h1>\n" +
"		<p>This is to notify you that you have successfully created a CommuteEazy mobile App Account. We appreciate you joining us and hope you have the best experience connecting with public transportation operators.</p>\n" +
"	</body>\n" +
"</html>";
      
       MimeMessage message = new MimeMessage(session);  
       message.setFrom(new InternetAddress(from));  
       message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
       message.setSubject("CommuteEazy Account created");  
       message.setContent(msgBody,"text/html; charset=utf-8");
  
         // Send message  
       Transport.send(message);  
       System.out.println("message sent successfully....");
       return "email sent";
   }
}
