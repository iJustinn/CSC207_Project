package spotify.services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AccessTokenService {
    private static final String grantType = "client_credentials";
    private static final String clientId = "82901fa01a524c9b837890faaa3c4b69";
    private static final String clientSecret = "4f7a940b3d7648e691e4c475c550d0fc";

    private static final String targetURI = String.format(
            "https://accounts.spotify.com/api/token/?grant_type=%s&client_id=%s&client_secret=%s",
            grantType,
            clientId,
            clientSecret
    );

    public static String requestAccessToken() {
        HttpClient httpClient = HttpClient.newHttpClient();
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(targetURI))
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body().substring(17, 17 + 115);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
