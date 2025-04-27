package net.typicartist.discord.game.sdk.structure;

import java.util.List;
import com.sun.jna.Structure;
import net.typicartist.discord.game.sdk.enums.Status;

public class Presence extends Structure {
    public Status status;
    public Activity activity;

    @Override
    protected List<String> getFieldOrder() {
        return List.of("status", "activity");
    }
}
