public class Customer  extends User {

    private int id;
    private String name;
    private String role;
    private String email;
    private String password;
    public Customer() {
        super();
    }

    public Customer(String id, String name, String email, String password, String role) {
        super(name, email, password, role);
        this.id =Integer.parseInt(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String toString() {
        return id + "," + name + "," +password + "," + email + "," + role;
    }
   // @Override
//    public String toString() {
//        return "Customer{" +
//                "customerId='" + getCustomerId() + '\'' +
//                ", firstName='" + getFirstName() + '\'' +
//                ", lastName='" + getLastName() + '\'' +
//                ", email='" + getEmail() + '\'' +
//                ", phoneNumber='" + getPhoneNumber() + '\'' +
//                ", id=" + getId() +
//                ", name='" + getName() + '\'' +
//                ", role='" + getRole() + '\'' +
//                '}';
//    }

}