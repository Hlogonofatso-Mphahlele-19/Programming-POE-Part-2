package chatapp;


import java.util.Scanner;

public class Chatapp { 
    
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        
        System.out.println("Register ur account: ");
        
        System.out.print("Enter your first name: ");
        String firstName = kb.nextLine();
        
        System.out.print("Enter your last name: ");
        String lastName = kb.nextLine();
        
        System.out.print("Enter your username: ");
        String username = kb.nextLine();
        
        System.out.print("Enter your password name: ");
        String password = kb.nextLine();
        
        System.out.print("Enter a South African cellphone number (begins with +27 and followed by 9 numbers): ");
        String cell = kb.nextLine();
        
        Login user = new Login(username, password, cell);
        String regResult = user.registerUser();
        System.out.println(regResult);
        
        if (regResult.equals("User registered successfully!")) {
            System.out.println("\n=== Login ===");
            System.out.print("Ener username: ");
            String loginUser = kb.nextLine();
            
            System.out.print("Enter passwword: ");
            String loginPass = kb.nextLine();
            
            boolean success = user.loginUser(loginUser, loginPass);
            System.out.println(user.returnLoginStatus(success, firstName, lastName));
        }
        
        kb.close();
        
    }

    
    


}        