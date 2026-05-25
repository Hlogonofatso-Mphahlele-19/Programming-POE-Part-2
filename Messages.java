
package quickchat;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Messages {
    private static int totalMessages = 0;
    private static List<String> sentMessages = new ArrayList<>();
    
    private String messageID;
    private String recipient;
    private String messageText;
    private String messageHash;
    
    public Messages(String recipient, String messageText) {
        this.messageID = generateMessageID();
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageHash = createMessageHash();
    }
    
    private String generateMessageID() {
        Random random = new Random();
        long id = (long)(random.nextDouble()* 1000_000_0000L);
        return String.format("%010d", id);
    }
    
    public String checkRecipientCell() {
        if (recipient.startsWith("+27") && recipient.length() <= 12) {
            return "Cellphone number successfully captured.";
        }
        return "Cellphone number incorrectly formatted or does'nt vontain the international code";
    }
    
    public String validateMessageLength() {
        if(messageText.length() > 250) {
            int excess = messageText.length() - 250;
            return "The message exceed 250 charecters by " + ", please reduce the message size";
        }
        return "Message ready to send";
    }
    
    public String createMessageHash() {
        String[] text = messageText.split(" ");
        String firstWord = text[0];
        String lastWord = text[text.length -1];
        return messageID.substring(0, 2) + ":" + totalMessages + ":" + (firstWord + lastWord).toUpperCase();
    }
    
    public String sendMessage(int optionChoice) {
        switch(optionChoice) {
            case 1:
                totalMessages++;
                sentMessages.add(this.toString());
                return "MEssage syccessfully send";
            case 2:
                return "Press 0 to delete the message";
            case 3:
                return "Message successfully stored";
            default: 
                return "Invalid option";
        }
    }
    
    public static String printMessages() {
        return String.join("\n", sentMessages);
    }
    
    public static int returnTotalMessages() {
        return totalMessages;
    }
    
    public String toString() {
        return "Message ID: " + messageID + "\nMessage Hash: " + messageHash + "\nRecipient: " + recipient + "\nMessage: " + messageText;
    }    
    
}
