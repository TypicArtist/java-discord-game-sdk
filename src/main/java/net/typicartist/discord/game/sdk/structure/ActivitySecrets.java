package net.typicartist.discord.game.sdk.structure;

import java.util.List;
import com.sun.jna.Structure;

public class ActivitySecrets extends Structure {
    public byte[] match = new byte[128];
    public byte[] join = new byte[128];
    public byte[] spectate = new byte[128];

    @Override
    protected List<String> getFieldOrder() {
        return List.of("match", "join", "spectate");
    }
}
