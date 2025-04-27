package net.typicartist.discord.game.sdk.structure;

import java.util.List;
import com.sun.jna.Structure;

public class OAuth2Token extends Structure {
    public byte[] access_token = new byte[128];
    public byte[] scopes = new byte[1024];
    public long expires;

    @Override
    protected List<String> getFieldOrder() {
        return List.of("access_token", "scopes", "expires");
    }
}
