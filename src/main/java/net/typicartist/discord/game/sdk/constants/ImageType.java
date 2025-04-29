package net.typicartist.discord.game.sdk.constants;

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
