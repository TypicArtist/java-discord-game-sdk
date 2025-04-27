package net.typicartist.discord.game.sdk.structure;

import java.util.List;
import com.sun.jna.Structure;

public class Rect extends Structure {
    public long left;
    public long top;
    public long right;
    public long bottom;

    @Override
    protected List<String> getFieldOrder() {
        return List.of("left", "top", "right", "bottom");
    }
}
