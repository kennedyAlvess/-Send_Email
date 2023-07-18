import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.util.Properties;


public class JavaMail {
    public static void sendMail(String recepient)  {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String meuEmail = "seu_email";
        String minhaSenha = "sua_senha";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(meuEmail, minhaSenha);
            }
        });
        Message mensagem = prepareMessage(session, meuEmail, recepient);
        try {
            Transport.send(mensagem);
            JOptionPane.showMessageDialog(null,"MENSAGEM ENVIADA COM SUCESSO PARA");
        }catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }

    private static Message prepareMessage(Session session, String meuEmail, String recepient)  {
        try {
            Message mensagem = new MimeMessage(session);
            mensagem.setFrom(new InternetAddress(meuEmail));
            mensagem.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            mensagem.setSubject(String.valueOf(JOptionPane.showInputDialog("QUAL TITULO DO E-MAIL")));
            mensagem.setText("ENVIANDO EMAIL COM UMA APLICAÇÃO JAVA SIMPLES");
            return mensagem;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
