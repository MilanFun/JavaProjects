package mipt.highload.queue.entity;

import java.time.LocalDateTime;

public class Token {
    private String token;
    private LocalDateTime expire;

    public Token(String token, LocalDateTime expire) {
        this.token = token;
        this.expire = expire;
    }

    public String getToken() {
        return this.token;
    }

    public Token() {}
    @Override
    public String toString() {
        return "{ Token: token=" + this.token + ", expire-in=" + this.expire + "}";
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getExpire() {
        return expire;
    }

    public void setExpire(LocalDateTime expire) {
        this.expire = expire;
    }
}
