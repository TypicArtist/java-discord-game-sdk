package net.typicartist.discord.game.sdk.enums;

public enum LogLevel {
    Error(1),
    Warn(2),
    Info(3),
    Debug(4);

    private final int code;

    LogLevel(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
