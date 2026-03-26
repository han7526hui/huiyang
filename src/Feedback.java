public class Feedback {
    private String firstName;
    private String lastName;
    private String email;
    private String completeFeedback;
    private String reviewID;
    private boolean longFeedback;

    public Feedback(String firstName,String lastName,String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.completeFeedback = "";
        this.reviewID = "";
        this.longFeedback = false;
    }

     public void assembleFeedback(String sentence1, String sentence2, String sentence3, String sentence4, String sentence5) {
        this.completeFeedback = sentence1 + sentence2 + sentence3 + sentence4 + sentence5;
        this.longFeedback = isFeedbackLong(this.completeFeedback);
        createReviewID();
    }

    private boolean isFeedbackLong(String feedback){
        if (feedback == null) {
            return false;
        }
        return feedback.length() > 500;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCompleteFeedback() {
        return completeFeedback;
    }

    public String getReviewID() {
        return reviewID;
    }

    public boolean isLongFeedback() {
        return longFeedback;
    }

     private void createReviewID() {
        String namePart = (this.firstName + this.lastName).toUpperCase();
        String feedbackPart = "";
        if (this.completeFeedback.length() >= 15) {
            feedbackPart = this.completeFeedback.substring(10, 15).toLowerCase();
        } else {
            feedbackPart = "abcde";
        }
        long time = System.currentTimeMillis();
        this.reviewID = namePart + "_" + feedbackPart + "_" + time;
    }

     public void printFeedbackInfo() {
        System.out.println("FirstName:" + firstName + " " );
        System.out.println("LastName:" + lastName + "");
        System.out.println("Email" + email);
        System.out.println("CompleteFeedBack：" + completeFeedback);
        System.out.println("ReviewID：" + reviewID);
        System.out.println("LongFeedBack：" + longFeedback);
    }

    public String toString() {
        return "Feedback{" +
                "firstName=" + firstName + "," +
                "lastName='" + lastName + "," +
                "email='" + email + "," +
                "completeFeedback='" + completeFeedback + "," +
                "reviewID=" + reviewID + "," +
                "longFeedback=" + longFeedback +
                "}";
    }
}


