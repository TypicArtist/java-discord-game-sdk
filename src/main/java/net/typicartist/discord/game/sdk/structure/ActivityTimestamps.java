package net.typicartist.discord.game.sdk.structure;

import java.util.List;

import com.sun.jna.Structure;

public class ActivityTimestamps extends Structure {
    public long start;
    public long end;

    @Override
    protected List<String> getFieldOrder() {
        return List.of("start", "end");
    }
}
