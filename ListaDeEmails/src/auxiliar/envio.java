package auxiliar;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;




public class envio {
	
	
	
	public boolean listaDeEnvio(String email, String assunto, String mensagem, Integer q, String emailLogin, String senha, String remetente) throws IOException {
		
		boolean status;
        Properties props = new Properties();
        /** Parâmetros de conexão com servidor Gmail */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                         protected PasswordAuthentication getPasswordAuthentication() 
                         {
                               //return new PasswordAuthentication("seuemail@deautenticação.com", "suaSenhaDeEmail"); //colocar seu email e senha de autenticação
                               return new PasswordAuthentication(emailLogin, senha); //colocar seu email e senha de autenticação
                         }
                    });

        /** Ativa Debug para sessão */
        session.setDebug(true);

        try {
for(int i=0;i<q;i++){
              Message message = new MimeMessage(session);
              message.setFrom(new InternetAddress(remetente)); //Remetente

              Address[] toUser = InternetAddress //Destinatário(s)
                         .parse(email);  //parâmetro email

              message.setRecipients(Message.RecipientType.TO, toUser);
              message.setSubject(assunto+i);// parâmetro Assunto
              message.setText(mensagem); // parâmetro mensagem
              
             

             // System.out.println("Mensagens enviadas com sucesso!!!");
              
             
              
              
               
                  /*Método para enviar a mensagem criada*/
                  Transport.send(message);
                  
                 
                           
              
              status = true;
}
               return true;
         } catch (MessagingException e) {
              throw new RuntimeException(e);
              //return false;
        }
        
  }

//http://www.devmedia.com.br/enviando-email-com-javamail-utilizando-gmail/18034
	
	

}
