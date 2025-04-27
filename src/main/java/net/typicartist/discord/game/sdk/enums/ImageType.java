package net.typicartist.discord.game.sdk.enums;

public enum ImageType {
    User(0);

    private final int code;

    ImageType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
