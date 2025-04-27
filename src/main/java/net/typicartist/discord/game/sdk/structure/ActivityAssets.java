package net.typicartist.discord.game.sdk.structure;

import java.util.List;

import com.sun.jna.Structure;

public class ActivityAssets extends Structure {
    public byte[] LargeImage = new byte[128];
    public byte[] LargeText = new byte[128];
    public byte[] SmallImage = new byte[128];
    public byte[] SmallText = new byte[128];

    @Override
    protected List<String> getFieldOrder() {
        return List.of("LargeImage", "LargeText", "SmallImage", "SmallText");
    }
}
