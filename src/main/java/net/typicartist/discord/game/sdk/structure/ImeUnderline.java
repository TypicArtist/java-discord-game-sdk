package net.typicartist.discord.game.sdk.structure;

import java.util.List;
import com.sun.jna.Structure;

public class ImeUnderline extends Structure {
    public long from;
    public long to;
    public long color;
    public long background_color;
    public boolean thick;

    @Override
    protected List<String> getFieldOrder() {
        return List.of("from", "to", "color", "background_color", "thick");
    }
}
