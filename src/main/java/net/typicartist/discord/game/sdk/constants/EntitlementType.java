package net.typicartist.discord.game.sdk.constants;

public enum EntitlementType {
    Purchase(1),
    PremiumSubscription(2),
    DeveloperGift(3),
    TestModePurchase(4),
    FreePurchase(5),
    UserGift(6),
    PremiumPurchase(7);

    private final int code;

    EntitlementType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}