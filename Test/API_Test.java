import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class API_Test {
    // getting track info from Spotify

    public static void main(String[] args) {
        // TODO: Automate generating tokens
        String accessToken =
                "BQAAoneljqiWK9FayvPiVJ6KhJTBb6zq50ChzCftdXaW5dd2r5DlH5HDL8Dxfi8qBCP6qXWclm40Y7LGqSGyV4Rh8A_1e36_vn_75q90QSF4puBEk5Q"; // token
        String trackId = "2IjyFRCRn8x1bEquOM3vxg"; // id of the song in Spotify
        String apiUrl = "https://api.spotify.com/v1/tracks/" + trackId;

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Bearer " + accessToken);

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                System.out.println(response.toString()); // print track info

            } else {
                System.out.println("GET request failed. Response Code: " + responseCode); // print error message
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
