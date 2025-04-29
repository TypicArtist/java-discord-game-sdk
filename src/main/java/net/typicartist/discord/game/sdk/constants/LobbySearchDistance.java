package net.typicartist.discord.game.sdk.constants;

public enum LobbySearchDistance {
    Local(0),
    Default(1),
    Extended(2),
    Global(3);

    private final int code;

    LobbySearchDistance(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}