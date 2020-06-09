package attractions.email;

public class EmailExecuter {
    public void sendEmail(String email, String key){
        SendEmail.SMTP_SERVER = "smtp.gmail.com";
        SendEmail.SMTP_Port = "465";
        SendEmail.EMAIL_FROM = "AttractionsProject@gmail.com";
        SendEmail.SMTP_AUTH_USER = "AttractionsProject";
        SendEmail.SMTP_AUTH_PWD = "stZ2B6t4k7e3zZ7V";
        SendEmail.REPLY_TO = "AttractionsProject@gmail.com";

        //SendEmail.FILE_PATH      = PROPS_FILE;
        String emailTo = email;
        String thema = "";
        String text = "" + key;
        SendEmail se = new SendEmail(emailTo, thema);
        se.sendMessage(text);
    }
}
