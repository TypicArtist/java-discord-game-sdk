package net.typicartist.discord.game.sdk.structure;

import java.util.List;

import com.sun.jna.Structure;

public class FFIEvents extends Structure {
    public static class ByReference extends FFIEvents implements Structure.ByReference {}

    public byte dummy;

    @Override
    protected List<String> getFieldOrder() {
        return List.of("dummy");
    }    
}
