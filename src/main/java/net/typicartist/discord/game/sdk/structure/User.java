package net.typicartist.discord.game.sdk.structure;

import java.util.List;
import com.sun.jna.Structure;

public class User extends Structure {
    public long id;
    public byte[] username = new byte[256];
    public byte[] discriminator = new byte[8];
    public byte[] avatar = new byte[128];
    public boolean bot;

    @Override
    protected List<String> getFieldOrder() {
        return List.of("id", "username", "discriminator", "avatar", "bot");
    }
}