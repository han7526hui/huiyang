public class Main3 {
    public static void main(String[] args) {
        eRyder bike = new eRyder("12345678",80,true,15.5);
         bike.printBikeDetails();
        bike.ride(80, true);
        bike.printRideDetails(3);
        eRyder bike2 = new eRyder("87654321",80,false,15.5,"KIKI","1234567890");
        bike2.printBikeDetails();
        bike2.ride(80, false);
        bike2.printRideDetails(20);
        double totalFare=bike2.totalFare(20);
        String str1 = "I am very satisfied with the service.";
        String str2 = "This electric bike rides really comfortably.";
        String str3 ="The battery life of this electric bicycle is impressive."; 
        String str4 = "Customer support is helpful and responsive.";
        String str5 ="I will recommend this electric bicycle to my friends and family.";
        Feedback feedback =new Feedback("Han", "Huiyang", "2933809204@qq.com");
        feedback.assembleFeedback( str1, str2, str3, str4, str5);
        System.out.println(feedback.toString());
        UserRegistration userRegistration = new UserRegistration();
        userRegistration.registration();
        System.out.println(userRegistration);
        AdminPanel adminPanel = new AdminPanel();
        adminPanel.userManagementOptions();
    }
}
