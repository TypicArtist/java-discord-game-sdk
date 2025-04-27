package net.typicartist.discord.game.sdk.enums;

public enum ActivityType {
    Playing(0),
    Streaming(1),
    Listening(2),
    Watching(3);

    private final int code;

    ActivityType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
