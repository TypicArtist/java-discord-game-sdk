package net.typicartist.discord.game.sdk.structure;

import java.util.List;
import com.sun.jna.Structure;

public class PartySize extends Structure {
    public long current_size;
    public long max_size;

    @Override
    protected List<String> getFieldOrder() {
        return List.of("current_size", "max_size");
    }
}
