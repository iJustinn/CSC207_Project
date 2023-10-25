package spotify.services;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AccessTokenServiceTest {
    @Test
    void testRequestAccessToken() {
        String accessToken = AccessTokenService.requestAccessToken();
        System.out.println(accessToken);
        assertEquals(115, accessToken.length());  // tokens should be 115 chars
    }
}