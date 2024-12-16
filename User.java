public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean logIn(String inputUser, String inputPass) {
        return username.equals(inputUser) && password.equals(inputPass);
    }

    public void signOut() {
        System.out.println("User signed out successfully.");
    }
}

