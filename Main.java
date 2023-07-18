import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JavaMail.sendMail(String.valueOf(JOptionPane.showInputDialog("INFORME O E-MAIL PARA ONDE DESEJA ENVIAR UMA MENSAGEM")));
    }
}