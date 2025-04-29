package net.typicartist.discord.game.sdk.constants;

public enum MouseButton {
    Left(0),
    Middle(1),
    Right(2);

    private final int code;

    MouseButton(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}