package user;

public class UserResponse {
    private String success;
    private User user;
    private String accessToken;
    private String refreshToken;
    private String message;

    // Конструктор без параметров
    public UserResponse() { }

    // Конструктор с параметрами
    public UserResponse(String success, User user, String accessToken, String refreshToken) {
        this.success = success;
        this.user = user;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    // Конструктор с двумя параметрами
    public UserResponse(String success, String message) {
        this.success = success;
        this.message = message;
    }

    // Геттер для success
    public String getSuccess() {
        return success;
    }

    // Сеттер для success
    public void setSuccess(String success) {
        this.success = success;
    }

    // Геттер для user
    public User getUser () {
        return user;
    }

    // Сеттер для user
    public void setUser (User user) {
        this.user = user;
    }

    // Геттер для accessToken
    public String getAccessToken() {
        return accessToken;
    }

    // Сеттер для accessToken
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    // Геттер для refreshToken
    public String getRefreshToken() {
        return refreshToken;
    }

    // Сеттер для refreshToken
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    // Геттер для message
    public String getMessage() {
        return message;
    }

    // Сеттер для message
    public void setMessage(String message) {
        this.message = message;
    }
}
