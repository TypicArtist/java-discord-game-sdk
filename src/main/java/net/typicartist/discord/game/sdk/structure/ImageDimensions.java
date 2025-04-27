package net.typicartist.discord.game.sdk.structure;

import java.util.List;

import com.sun.jna.Structure;

public class ImageDimensions extends Structure {
    public long Width;
    public long Height;

    @Override
    protected List<String> getFieldOrder() {
        return List.of("Width", "Height");
    }
}
