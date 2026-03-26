import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminPanel {
    List<RegisteredUsers> registeredUsersList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    RegisteredUsers newUser = new RegisteredUsers();
     StringBuilder stringBuilder = new StringBuilder();
    public void userManagementOptions() {
       System.out.println("Welcome to E-Ryder Admininstrator Panel.\r\n" + //
                      "What doyouwant to do?\r\n" + //
                      "1.Add New Users\r\n"+
                      "2.View Registered Users\r\n" +
                      "3.Remove Registered Users\r\n" +
                      "4.Update Registered Users\r\n" +
                      "5.EXIT");
                      
        while (true) {
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    addNewUsers();
                    break;
                case 2:
                    viewRegisteredUsers();
                    break;
                case 3:
                    removeRegisteredUsers();
                    break;
                case 4:
                    updateRegisteredUsers();
                    break;
                case 5:
                    System.out.println("Exiting");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private void addNewUsers() {
        System.out.print("How many users would you like to add? ");
        int number = scanner.nextInt();
        scanner.nextLine(); 
        for (int i = 0; i < number; i++) {
            System.out.println("Enter details for user " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Email Address: ");
            String emailAddress = scanner.nextLine();

            System.out.print("Date of Birth (YYYY-MM-DD): ");
            String dateOfBirth = scanner.nextLine();

            System.out.print("Card Number: ");
            String cardNumber = scanner.nextLine();

            System.out.print("Card Provider: ");
            String cardProvider = scanner.nextLine();

            System.out.print("Card Expiry Date (MM/YY): ");
            String cardExpiryDate = scanner.nextLine();

            System.out.print("CVV: ");
            String cvv = scanner.nextLine();

            System.out.print("User Type: ");
            String userType = scanner.nextLine();

            
            for (int j = 0; j < 3; j++) {
                System.out.println("Enter details for trip #" + (j + 1) + ":");
                System.out.print("Trip Date (YYYY-MM-DD): ");
                String tripDate = scanner.nextLine();

                System.out.print("Source: ");
                String source = scanner.nextLine();

                System.out.print("Destination: ");
                String destination = scanner.nextLine();
            System.out.print("Fare: ");
            String fare = scanner.nextLine();

            System.out.print("Feedback: ");
            String feedback = scanner.nextLine();

            StringBuilder stringBuilder = new StringBuilder();
            
            stringBuilder.append(tripDate).append(source).append(destination).append(fare).append(feedback);          
            newUser.lastThreeTripStrings[j]=stringBuilder.toString();
            }
            
            RegisteredUsers newUser = new RegisteredUsers(name,emailAddress,dateOfBirth,cardNumber,cardProvider,cardExpiryDate,cvv,userType);
            registeredUsersList.add(newUser);
        }
    }
        private void viewRegisteredUsers() {
            if (registeredUsersList.isEmpty()) {
                System.out.println("No registered users found.");
            }else{
               for(RegisteredUsers users: registeredUsersList){
                System.out.println(users.getFullName());
                System.out.println(users.getEmailAddress());
                System.out.println(users.getDateOfBirth());
                System.out.println(users.getCardNumber());
                System.out.println(users.getCardExpiryDate());
                System.out.println(users.getFeeToCharge());
                System.out.println(users.getCvv());
                System.out.println(users.getUserType());
                System.out.println(users.lastThreeTripStrings[0]);
                System.out.println(users.lastThreeTripStrings[1]);
                System.out.println(users.lastThreeTripStrings[2]);
               }
            }
        }
        private void removeRegisteredUsers() {
            if (registeredUsersList.isEmpty()) {
                System.out.println("No registered users found.");
            } else {
                System.out.print("Enter the email address of the user to remove: ");
                String emailToRemove = scanner.nextLine();
                boolean removed = registeredUsersList.removeIf(user -> user.getEmailAddress().equalsIgnoreCase(emailToRemove));
                if (removed) {
                    System.out.println("User removed successfully.");
                    for(RegisteredUsers registeredUsers:registeredUsersList){
                        System.out.println(registeredUsers.getFullName());
                        System.out.println(registeredUsers.getEmailAddress());
                        System.out.println(registeredUsers.getDateOfBirth());
                        System.out.println(registeredUsers.getCardNumber());
                        System.out.println(registeredUsers.getCardExpiryDate());
                        System.out.println(registeredUsers.getFeeToCharge());
                        System.out.println(registeredUsers.getCvv());
                        System.out.println(registeredUsers.getUserType());
                        System.out.println(registeredUsers.lastThreeTripStrings[0]);
                        System.out.println(registeredUsers.lastThreeTripStrings[1]);
                        System.out.println(registeredUsers.lastThreeTripStrings[2]);
                    if (registeredUsers.equals(emailToRemove)) {
                        registeredUsersList.remove(registeredUsers);
  
                        
                    }
                    }
                } else {
                    System.out.println("User not found.");
                }
                
            }
            
        }
            private void updateRegisteredUsers(){
                if (registeredUsersList.isEmpty()) {
                    System.out.println("No registered users to remove");

                    
                }else{
                    System.out.println("Enter the email address of the user to update: ");
                    String emailToUpdate = scanner.nextLine();
                    boolean updated = false;
                    for (RegisteredUsers user : registeredUsersList) {
                        if (user.getEmailAddress().equalsIgnoreCase(emailToUpdate)) {
                            System.out.println("Enter new details for the user:");
                            System.out.print("Name: ");
                            String name = scanner.nextLine();

                            System.out.print("Email Address: ");
                            String emailAddress = scanner.nextLine();

                            System.out.print("Date of Birth (YYYY-MM-DD): ");
                            String dateOfBirth = scanner.nextLine();

                            System.out.print("Card Number: ");
                            String cardNumber = scanner.nextLine();

                            System.out.print("Card Provider: ");
                            String cardProvider = scanner.nextLine();

                            System.out.print("Card Expiry Date (MM/YY): ");
                            String cardExpiryDate = scanner.nextLine();

                            System.out.print("CVV: ");
                            String cvv = scanner.nextLine();

                            System.out.print("User Type: ");
                            String userType = scanner.nextLine();
                            
                        }else{
                            System.out.println("Users not found");

                        }

                }
            }
    }
}
