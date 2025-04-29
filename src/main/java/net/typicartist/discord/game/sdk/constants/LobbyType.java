package net.typicartist.discord.game.sdk.constants;

public enum LobbyType {
    Private(1),
    Public(2);

    private final int code;

    LobbyType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
