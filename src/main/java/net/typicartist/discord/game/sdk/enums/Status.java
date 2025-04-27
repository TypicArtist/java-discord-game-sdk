package net.typicartist.discord.game.sdk.enums;

public enum Status {
    Offline(0),
    Online(1),
    Idle(2),
    DoNotDisturb(3);

    private final int code;

    Status(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}