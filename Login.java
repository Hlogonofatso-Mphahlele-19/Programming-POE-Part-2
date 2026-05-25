package chatapp;

public class Login {
    private String username;
    private String password;
    private String cellNumber;
    private boolean registrationSuccess = false;
    
    public Login(String username, String password, String cellNumber) {
        this.username = username;
        this.password = password;
        this.cellNumber = cellNumber;
    }
    
    public boolean checkUserName() {
        boolean hasUnderscore = username.contains("_");
        boolean longEnough = username.length() <= 5;
        
        if (hasUnderscore) {
            if (longEnough) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkPasswordComplexity() {
        boolean hasLength = password.length() >= 8;
        boolean hasCapital = password.matches(".*[A-Z].*"); 
        boolean hasNumber = password.matches(".*[0-9].*");
        boolean hasSpecial = password.matches(".*[~!@#$%^&*()_{}|?><].*");
        
        if (hasLength) {
            if (hasCapital) {
                if (hasSpecial) {
                    return true;
                }
            }
        }
        return false;
    
    }
    
    public boolean checkCellphoneNumber() {
        boolean correctStart = cellNumber.startsWith("+27");
        boolean correctLength = cellNumber.length() == 12;
        
        if (correctStart) {
            if (correctLength){
                return true;
            }
        }
        return false;
    }
    
    public String registerUser() {
        if (!checkUserName()) {
            registrationSuccess = false;
            return "Username incorectly formatted, please ensure that it has an underscore and is less than 5 charecters in length";
        }
        if (!checkPasswordComplexity()) {
            registrationSuccess = false;
            return "Password incorrectly formated, please ensure that it has atleast 8 charecters, a capital letter, a number, and a special charecter.";
        }
        if (!checkCellphoneNumber()) {
            registrationSuccess = false;
            return "Cellphone number incorreclty formatted or doesn't contain the international code.";
        }
        registrationSuccess = true;
        return "User registered successfully.";
        
    }
    
    public boolean loginUser(String inputUser, String inputPass) {
        boolean userMatch = inputUser.equals(username);
        boolean passMatch = inputPass.equals(password);
        
        if (userMatch) {
            if (passMatch) {
                return true;
            }
        }
        return false;
        
    }
    
    public String returnLoginStatus(boolean loginSuccess, String firstName, String lastName) {
        if (loginSuccess) {
            return "Welcome " + firstName + " " + lastName + ", its great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
    
    public boolean getRegistrationStatus(boolean loginSuccess, String firstName, String lastName) {
        return registrationSuccess;
    }


}