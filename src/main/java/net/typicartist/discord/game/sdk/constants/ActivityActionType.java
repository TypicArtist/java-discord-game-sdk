package net.typicartist.discord.game.sdk.constants;

public enum ActivityActionType {
    Join(1),
    Spectate(2);

    private final int code;

    ActivityActionType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}