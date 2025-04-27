package net.typicartist.discord.game.sdk.enums;

public enum LobbySearchCast {
    String(1),
    Number(2);

    private final int code;

    LobbySearchCast(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}