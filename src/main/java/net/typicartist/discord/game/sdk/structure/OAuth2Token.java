package net.typicartist.discord.game.sdk.structure;

import java.util.List;
import com.sun.jna.Structure;

public class OAuth2Token extends Structure {
    public byte[] AccessToken = new byte[128];
    public byte[] Scopes = new byte[1024];
    public long Expires;

    @Override
    protected List<String> getFieldOrder() {
        return List.of("AccessToken", "Scopes", "Expires");
    }
}
