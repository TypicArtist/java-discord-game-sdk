package net.typicartist.discord.game.sdk.enums;

public enum UserFlag {
    Partner(2),
    HypeSquadEvents(4),
    HypeSquadHouse1(64),
    HypeSquadHouse2(128),
    HypeSquadHouse3(256);

    private final int code;

    UserFlag(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
