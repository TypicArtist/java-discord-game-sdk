package net.typicartist.discord.game.sdk.util.common;

public class EnumUtil {
    private EnumUtil() {};
    
    public static <E extends Enum<E>> E fromCode(Class<E> enumClass, int code) {
        for (E e : enumClass.getEnumConstants()) {
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
