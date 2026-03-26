public class Main1{
    public static void main(String[] args) {
     Feedback feedback = new Feedback("Alexa", "Arya", "2933809204@qq.com");
     String sentence1 = "I was very satisfied with the service."; 
     String sentence2 = "The e-Bike is quite comfortable to ride."; 
     String sentence3 = "The battery life of the e-Bike is impressive.";
     String sentence4 = "The customer support was helpful and responsive.";
     String sentence5 = "I would recommend this e-Bike to my friends and family."; 
     feedback.assembleFeedback(sentence1, sentence2, sentence3, sentence4, sentence5);
     feedback.printFeedbackInfo();
     System.out.println(feedback);
 }
}