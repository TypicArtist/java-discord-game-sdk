package net.typicartist.discord.game.sdk.structure;

import java.util.List;

import com.sun.jna.Structure;

public class OAuth2Token extends Structure {
    public static class ByReference extends OAuth2Token implements Structure.ByReference {}

    public byte[] accessToken = new byte[128];
    public byte[] scopes = new byte[1024];
    public long expires;

    @Override
    protected List<String> getFieldOrder() {
        return List.of(
            "accessToken", 
            "scopes", 
            "expires"
        );
    }  
}
