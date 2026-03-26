public class Main {
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

    
    }
}    