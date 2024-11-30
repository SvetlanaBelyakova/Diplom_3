package pages;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class UserService {
    private static final String BASE_API_URL = "https://stellarburgers.nomoreparties.site/api/users"; // Замените на ваш базовый URL API

    public static void deleteUser (String email) {
            String urlString = BASE_API_URL + "/" + email;

        HttpURLConnection connection = null;

        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");
            connection.setRequestProperty("Content-Type", "application/json");

            // Если требуется аутентификация, добавьте заголовок авторизации
            // connection.setRequestProperty("Authorization", "Bearer " + yourAuthToken);

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Пользователь с email " + email + " успешно удален.");
            } else {
                System.err.println("Ошибка при удалении пользователя: " + responseCode);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при удалении пользователя: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
