package net.typicartist.discord.game.sdk.enums;

public enum LobbySearchComparison {
    LessThanOrEqual(-2),
    LessThan(-1),
    Equal(0),
    GreaterThan(1),
    GreaterThanOrEqual(2),
    NotEqual(3);

    private final int code;

    LobbySearchComparison(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
