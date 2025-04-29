package net.typicartist.discord.game.sdk.constants;

public enum KeyVariant {
    Normal(0),
    Right(1),
    Left(2);

    private final int code;

    KeyVariant(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}