public class UserData {
    private int id;
    private String name;
    private String email;
    private String password;
    private String role;

    public UserData(String id, String name, String email, String password, String role) {
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

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }
}