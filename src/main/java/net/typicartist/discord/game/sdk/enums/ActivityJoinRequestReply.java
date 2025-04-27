package net.typicartist.discord.game.sdk.enums;

public enum ActivityJoinRequestReply {
    No(0),
    Yes(1),
    Ignore(2);

    private final int code;

    ActivityJoinRequestReply(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
