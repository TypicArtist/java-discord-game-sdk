package net.typicartist.discord.game.sdk.structure;

import java.util.List;

import com.sun.jna.Structure;
import net.typicartist.discord.game.sdk.enums.ImageType;

public class ImageHandle extends Structure {
    public ImageType Type;
    public long Id;
    public long Size;

    @Override
    protected List<String> getFieldOrder() {
        return List.of("Type", "Id", "Size");
    }
}
