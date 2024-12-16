public class User {
    private String name;
    private String id;
    private String email;
    private String password;

    public User(String name, String id, String email, String password) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public String getUserID() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void logIn(String email, String password) {
        if (this.email.equals(email) && this.password.equals(password)) {
            System.out.println("User logged in successfully!");
        } else {
            System.out.println("Invalid credentials.");
        }
    }

    public void signOut() {
        System.out.println("User signed out.");
    }
}

