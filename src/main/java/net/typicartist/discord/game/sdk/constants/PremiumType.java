package net.typicartist.discord.game.sdk.constants;

public enum PremiumType {
    None(0),
    Tier1(1),
    Tier2(2);

    private final int code;

    PremiumType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
