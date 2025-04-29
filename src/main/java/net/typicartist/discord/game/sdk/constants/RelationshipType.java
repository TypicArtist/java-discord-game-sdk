package net.typicartist.discord.game.sdk.constants;

public enum RelationshipType {
    None(0),
    Friend(1),
    Blocked(2),
    PendingIncoming(3),
    PendingOutgoing(4),
    Implicit(5);

    private final int code;

    RelationshipType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}