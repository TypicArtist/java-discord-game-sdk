package net.typicartist.discord.game.sdk.enums;

public enum ActivitySupportedPlatformFlags {
    Desktop(1),
    Android(2),
    iOS(4);

    private final int code;

    ActivitySupportedPlatformFlags(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
