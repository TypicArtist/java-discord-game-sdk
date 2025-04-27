package net.typicartist.discord.game.sdk.structure;

import com.sun.jna.Structure;
import java.util.List;

public class User extends Structure {
    public long id;
    public byte[] username = new byte[256];
    public byte[] discriminator = new byte[8];
    public byte[] avatar = new byte[128];
    public int flags;

    @Override
    protected List<String> getFieldOrder() {
        return List.of("id", "username", "discriminator", "avatar", "flags");
    }
}
