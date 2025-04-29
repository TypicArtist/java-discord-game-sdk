package net.typicartist.discord.game.sdk.utils;

public class EnumUtil {
    public static <E extends Enum<E>> E fromCode(Class<E> enumClass, int code) {
        for (E e : enumClass.getEnumConstants()) {
            /*
                if (e.getCode() == code) {
                    return e.name();
                }
             */
            try {
                var field = enumClass.getDeclaredField("code");
                field.setAccessible(true);
                int value = field.getInt(e);

                if (value == code) {
                    return e;
                }
            } catch (NoSuchFieldException | IllegalAccessException exception) {
                exception.printStackTrace();
            }
        }

        return null;
    }
}
