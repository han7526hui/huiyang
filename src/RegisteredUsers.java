public class RegisteredUsers {
    private String fullName;
    private String emailAddress;
    private String dateOfBirth;
    private String cardNumber;
    private String cardExpiryDate;
    private String feeToCharge;
    private String cvv;
    private String userType;
   String[] lastThreeTripStrings =new String[3];
    public RegisteredUsers(String fullName,String emailAddress,String dateOfBirth,String cardNumber,String cardExpiryDate,String feeToCharge,String cvv,String userTyper){
    this.fullName=fullName;
    this.emailAddress=emailAddress;
    this.dateOfBirth = dateOfBirth;
    this.cardNumber = cardNumber;
    this.cardExpiryDate = cardExpiryDate;
    this.feeToCharge = feeToCharge;
    this.cvv = cvv;
    this.userType =userTyper;
    }
    public RegisteredUsers(){}
    public String getFullName(){
        return fullName;
    }
    public void setFullName(String fullName){
        this.fullName = fullName;
    }
    public String getEmailAddress(){
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }
    public String getDateOfBirth(){
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth=dateOfBirth;
    }
    public String getCardNumber(){
        return cardNumber;
    }
    public void setCardNumber(String cardNNumber){
        this.cardNumber = cardNNumber;
    }
    public String getCardExpiryDate(){
        return cardExpiryDate;
    }
    public void setCardExpiryDate(String cardExpiryDate){
        this.cardExpiryDate=cardExpiryDate;
    }
    public String getFeeToCharge(){
        return feeToCharge;

    }
    public void setFeeToCharge(String feeToCharge){
        this.feeToCharge=feeToCharge;
    }
    public String getCvv(){
        return cvv;

    }
    public void setCvv(String cvv){
        this.cvv=cvv;
    }
    public String getUserType(){
        return userType;
    }
    public void setUserType(String userType){
        this.userType = userType;
    }
    public String toString(){
        return fullName+emailAddress+dateOfBirth+cardNumber+cardExpiryDate+feeToCharge+cvv+userType;
    }
}
