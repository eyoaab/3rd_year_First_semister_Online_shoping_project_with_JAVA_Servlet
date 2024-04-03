package One;

import java.sql.Timestamp;

public class Customer {
    private int customerId;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private byte[] customerPassword; // Use appropriate data type for password storage
    private String gender;
    private Timestamp registrationDate;

    // Constructors
    public Customer() {
    }

    public Customer(String firstName, String lastName, int age, String email, byte[] customerPassword,
                    String gender, Timestamp registrationDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.customerPassword = customerPassword;
        this.gender = gender;
        this.registrationDate = registrationDate;
    }

    // Getter and Setter methods
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(byte[] customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }
}
