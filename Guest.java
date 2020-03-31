import java.util.Objects;

public class Guest {


   private String lastName;
   private String firstName;
   private String email;
   private String phoneNumber;

   public Guest(String lastName,String firstName,String email,String phoneNumber){
      this.lastName=lastName;
      this.firstName=firstName;
      this.email=email;
      this.phoneNumber=phoneNumber;
   }
   public Guest(){

   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   public String getLastName() {
      return lastName;
   }

   public String getFirstName() {
      return firstName;
   }

   public String getEmail() {
      return email;
   }

   public String getPhoneNumber() {
      return phoneNumber;
   }

   @Override
   public String toString() {
      return "Nume:"+this.lastName+" "+this.firstName+",Email:"+this.email+",PhoneNumber:"+this.phoneNumber;
   }

}
