
package quickchat;

import java.util.Scanner;

public class QuickChat {

    
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        
        System.out.println("Welcome to QuickChat");
        
        System.out.print("How many ,essages would u like to send?");
        int numOfMessages = kb.nextInt();
        kb.nextLine();
        
        int count = 0;
        while(true) {
            System.out.println("QuickChat Menu:");
            System.out.println("1) Send Message");
            System.out.println("2) Show recently send messages");
            System.out.println("3) Quit");
            System.out.print("Choose an option from the menu: ");
            int optionChoice = kb.nextInt();
            kb.nextLine();
            
            if(optionChoice == 1) {
                if (count < numOfMessages) {
                    System.out.print("Enter recipient number: ");
                    String recipient = kb.nextLine();
                    
                    System.out.print("Enter message: ");
                    String messageText = kb.nextLine();
                    
                    Messages msg = new Messages(recipient, messageText);
                    
                    System.out.println(msg.checkRecipientCell());
                    System.out.println(msg.validateMessageLength());
                    
                    System.out.println("Choose one option from the following: ");
                    System.out.println("1) Send Message");
                    System.out.println("2) Discard Message");
                    System.out.println("3) Store Message");
                    int action = kb.nextInt();
                    kb.nextLine();
                    
                    System.out.println(msg.sendMessage(action));
                    
                    if (action ==1) {
                        System.out.println(msg.toString());
                    }
                    count++;
                } else {
                    System.out.println("You've reacjed the maximum limit of message charecters you can use");
                }
            } else if (optionChoice == 2) {
                System.out.println(Messages.printMessages());
            } else if (optionChoice == 3) {
                System.out.println("Total messages sent = ", + Messages.returnTotalMessages());
                break;
            } else {
                System.out.println("Invalid option. Try agin.");
            }
        }
        kb.close();
        
    }
    
}
