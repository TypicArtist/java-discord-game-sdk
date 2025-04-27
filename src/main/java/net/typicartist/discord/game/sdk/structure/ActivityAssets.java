package net.typicartist.discord.game.sdk.structure;

import java.util.List;
import com.sun.jna.Structure;

public class ActivityAssets extends Structure {
    public byte[] large_image = new byte[128];
    public byte[] large_text = new byte[128];
    public byte[] small_image = new byte[128];
    public byte[] small_text= new byte[128];

    @Override
    protected List<String> getFieldOrder() {
        return List.of("large_image", "large_text", "small_image", "small_text");
    }
}
