package nlu.fit.web.souvenirecommerce.util;

import nlu.fit.web.souvenirecommerce.model.entity.UserCredential;
import org.mindrot.jbcrypt.BCrypt;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.time.Instant;
import java.time.chrono.ChronoLocalDateTime;
import java.util.HexFormat;

public class PasswordUtil {

    public static String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }

    public String generateSecureToken() {
        byte[] bytes = new byte[32]; // 32 bytes = 64 ký tự hex
        new SecureRandom().nextBytes(bytes);
        return HexFormat.of().formatHex(bytes);
    }

    // Khi verify reset token — so sánh bằng constant-time để tránh timing attack
    public boolean isResetTokenValid(UserCredential cred, String token) {
        if (cred.getResetToken() == null || cred.getResetExpiresAt() == null) return false;
        boolean tokenMatch = MessageDigest.isEqual(
                cred.getResetToken().getBytes(),
                token.getBytes()
        );
        boolean notExpired = cred.getResetExpiresAt().isAfter(ChronoLocalDateTime.from(Instant.now()));
        return tokenMatch && notExpired;
    }
}