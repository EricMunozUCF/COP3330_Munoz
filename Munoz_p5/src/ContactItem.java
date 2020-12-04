public class ContactItem {

    private String firstName, lastName, phoneNumber, emailAddress;

    public ContactItem(String firstName, String lastName, String phoneNumber, String emailAddress) throws Exception {
        if (firstName.isBlank() && lastName.isBlank() && phoneNumber.isBlank() && emailAddress.isBlank())
            throw new Exception("WARNING: Contact needs at least 1 field filled out.");

        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String toString() {
        return this.getFirstName() + " " + this.getLastName() + " " + this.getPhoneNumber() + " " + this.getEmailAddress();
    }
}
