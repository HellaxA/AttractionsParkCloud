package attractions.email;

import attractions.entity.Attraction;
import attractions.entity.Ticket;

import java.util.HashMap;
import java.util.Map;

public class EmailExecuter {
    public void sendEmail(String email, HashMap<Attraction, Integer> attractions, Ticket ticket){
        SendEmail.SMTP_SERVER = "smtp.gmail.com";
        SendEmail.SMTP_Port = "465";
        SendEmail.EMAIL_FROM = "AttractionsProject@gmail.com";
        SendEmail.SMTP_AUTH_USER = "AttractionsProject";
        SendEmail.SMTP_AUTH_PWD = "stZ2B6t4k7e3zZ7V";
        SendEmail.REPLY_TO = "AttractionsProject@gmail.com";

        //SendEmail.FILE_PATH      = PROPS_FILE;
        String emailTo = email;
        String thema = "Ticket by Attraction Park";

        StringBuilder attractionTimes = new StringBuilder();
        for(Map.Entry<Attraction, Integer> pair : attractions.entrySet()) {
            attractionTimes.append(pair.getKey().getNameOfAttraction() + ":\t" + pair.getValue() + " times\n");
        }
        StringBuilder result = new StringBuilder();
        result.append("Do not show this key to anybody! Save it, so that you can visit our attractions!\n");
        result.append(attractionTimes);
        result.append("Total price:\t");
        result.append(ticket.getTicketPrice() + "$\n");
        result.append("Date and time buy:\t");
        result.append(ticket.getDateOfIssuance() + "\n");
        result.append("Ticket unique key:\t");
        result.append(ticket.getAccessKey());




        SendEmail se = new SendEmail(emailTo, thema);
        se.sendMessage(result.toString());
    }
}
