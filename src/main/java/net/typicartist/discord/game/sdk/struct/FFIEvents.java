package net.typicartist.discord.game.sdk.struct;

import java.util.List;

import com.sun.jna.Structure;

public class FFIEvents extends Structure {
    @Override
    protected List<String> getFieldOrder() {
        return List.of();
    }    
}
