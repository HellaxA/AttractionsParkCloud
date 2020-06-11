package attractions.hash;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class HashString {
    public static String hashString(String originalString) {
        return Hashing.sha256()
                .hashString(originalString, StandardCharsets.UTF_8)
                .toString();
    }

    public static String hashIt(String originalString) {
        String password = HashString.hashString(originalString);
        String hashed = HashString.hashString(password);
        return hashed;
    }
}
