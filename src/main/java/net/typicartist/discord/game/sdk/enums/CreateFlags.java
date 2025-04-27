package net.typicartist.discord.game.sdk.enums;

public enum CreateFlags {
    Default(0),
    NoRequireDiscord(1);

    private final int code;

    CreateFlags(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
