package net.typicartist.discord.game.sdk.structure;

import java.util.List;
import com.sun.jna.Structure;
import net.typicartist.discord.game.sdk.enums.LobbyType;

public class Lobby extends Structure {
    public long id;
    public LobbyType type;
    public long owner_id;
    public byte[] secret = new byte[128];
    public long capacity;
    public boolean locked;

    @Override
    protected List<String> getFieldOrder() {
        return List.of("id", "type", "owner_id", "secret", "capacity", "locked");
    }
}
