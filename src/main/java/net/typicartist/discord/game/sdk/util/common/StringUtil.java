package net.typicartist.discord.game.sdk.util.common;

import java.nio.charset.StandardCharsets;

public class StringUtil {
    private StringUtil() {};

    public static void writeStringToBuffer(String str, byte[] buffer) {
        if (str == null || buffer == null) return;

        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        int len = Math.min(bytes.length, buffer.length - 1);

        System.arraycopy(bytes, 0, str, 0, len);
        buffer[len] = 0;
    }
    
    public static String readStringFromBuffer(byte[] buffer) {
        if (buffer == null) return null;

        return new String(buffer, 0, indexOfNull(buffer), StandardCharsets.UTF_8);
    }

    private static int indexOfNull(byte[] buffer) {
        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i] == 0) return i;
        }

        return buffer.length;
    }
}
