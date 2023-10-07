package mipt.highload.queue.entity;

public class User {
    private String email;
    private Token token;

    public User(String email, Token token) {
        this.email = email;
        this.token = token;
    }

    public User() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "{ User: email=" + this.email + ", token=" + this.token.toString() + "}";
    }
}
