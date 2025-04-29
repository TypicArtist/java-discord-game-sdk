package net.typicartist.discord.game.sdk.constants;

public enum ActivityPartyPrivacy {
    Private(0),
    Public(1);

    private final int code;

    ActivityPartyPrivacy(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}