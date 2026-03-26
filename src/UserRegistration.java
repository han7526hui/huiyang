import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class UserRegistration {
   private static final double VIP_DISCOUNT_UNDER_18_BIRTHDAY = 25.0;
   private static final double VIP_DISCOUNT_UNDER_18 = 20.0;
   private static final double VIP_BASE_FEE = 100.0;
   String fullName;
   String emailAddress;
   String dateOfBirth;
   long cardNumber;
   String cardProvider;
   String cardExpiryDate;
   double feeToCharge;
   int cvv;
   String userType;
   boolean emailValid;
   boolean minorAndBirthday;
   boolean minor;
   boolean ageValid;
   boolean cardNumberValid;
   boolean cardStillValid;
   boolean validCVV;
   Scanner scanner;
   LocalDate dob;

   public UserRegistration() {
        scanner = new Scanner(System.in);
    }

public void registration(){
    System.out.println("Welcome to the ERyder Registration.");
    System.out.println("Here are your two options:");
    System.out.println("1. Register as a Regular User");
    System.out.println("2. Register as a VIP User");
    System.out.println("Please enter your choice (1 or 2):");

     String choice = scanner.nextLine().trim();
    
    if (choice.equals("1")) {
        userType = "Regular User";
    } else {
        userType = "VIP User";
  }

  
  System.out.print("Please enter your full name:");
        this.fullName = scanner.nextLine().trim();

        System.out.print("Please enter ypur email address:");
        emailAddress = scanner.nextLine().trim();
        emailValid = analyzeEmail(emailAddress);

        System.out.print("Please enter your date of birth:YYYY-MM-DD");
        dateOfBirth = scanner.nextLine().trim();
        LocalDate dob = LocalDate.parse(dateOfBirth); 
       

        System.out.println("Please enter your credit card number.（Only Visa、MasterCard、American Express is accepted):");
      
        while (!scanner.hasNextLong()) {
            System.out.print("The card number must be digits only. Please re-enter：");
            scanner.next();
        }

        this.cardNumber = scanner.nextLong();
        scanner.nextLine(); 
        this.cardNumberValid = analyzeCardNumber(this.cardNumber);
    }

    private boolean analyzeEmail(String email) {
        if (email.contains("@") && email.contains(".") 
                && !email.startsWith("@") && !email.endsWith(".")
                && email.indexOf("@") < email.lastIndexOf(".")) {
            return true;
        } else {
            System.out.println("Invalid email format.");
            return false;
        }
    }

    private boolean analyzeAge(LocalDate dob) {
        
        long age = java.time.temporal.ChronoUnit.YEARS.between(dob, LocalDate.now());
        LocalDate today = LocalDate.now();
        boolean isBirthday = (dob.getMonth() == today.getMonth() && dob.getDayOfMonth() == today.getDayOfMonth());
        if (age > 12 && age <= 120) {
          
            this.minor = age < 18;
            this.minorAndBirthday = this.minor && isBirthday(dob);
            return true;
        } else {
            System.out.println("Age must be greater than 12 and less than or equal to 120.");
            return false;
        }

    }

     private boolean analyseCVV() {
            return true;
        }

        private boolean analyseCVV(int cvv){
        String cvvStr = Integer.toString(cvv);
        if(cardProvider.equals("American Express")&&cvvStr.length()==4||cardProvider.equals("VISA")&&cvvStr.length()==3||cardProvider.equals("MasterCard")&&cvvStr.length()==3){
            System.out.println("Card CVV is valid.");
            validCVV=true;
        }else {
            System.out.println("Invalid CVV for the given card. Going back to the start of the registration process.");
            validCVV=false;
        }
        registration();
        return validCVV;
    }

    private boolean isBirthday(LocalDate dob) {
        LocalDate today = LocalDate.now();
        return dob.getMonth() == today.getMonth() && dob.getDayOfMonth() == today.getDayOfMonth();
    }

    private boolean analyzeCardNumber(long cardNum) {
        String cardStr = String.valueOf(cardNum);
      
        if (cardStr.length() == 16 && cardStr.startsWith("4")) {
            this.cardProvider = "Visa";
            return true;
        }
       
        else if (cardStr.length() == 16 && cardStr.startsWith("5") 
                && Integer.parseInt(cardStr.substring(1,2)) >=1 && Integer.parseInt(cardStr.substring(1,2)) <=5) {
            this.cardProvider = "MasterCard";
            return true;
        }
       
        else if (cardStr.length() == 15 && (cardStr.startsWith("34") || cardStr.startsWith("37"))) {
            this.cardProvider = "American Express";
            return true;
        } else {
            System.out.println("Invalid card number.Only Visa、MasterCard、American Express is accepted");
            return false;
        }
    }

      private boolean analyseCardExpiryDate() {
        int month = Integer.parseInt(cardExpiryDate.substring(0, 2));
        int year = 2000 + Integer.parseInt(cardExpiryDate.substring(3, 5));

        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int currentMonth = currentDate.getMonthValue();

        if (year > currentYear || (year == currentYear && month >= currentMonth)) {
            System.out.println("The card is still valid.");
            return true;
        } else {
            System.out.println("Sorry, your card has expired. Please use a different card. Going back to the start of the registration process...");
            registration();
            return false;
        }
    }

}

