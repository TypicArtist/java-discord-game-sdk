package net.typicartist.discord.game.sdk.constants;

public enum SkuType {
    Application(1),
    DLC(2),
    Consumable(3),
    Bundle(4);

    private final int code;

    SkuType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}