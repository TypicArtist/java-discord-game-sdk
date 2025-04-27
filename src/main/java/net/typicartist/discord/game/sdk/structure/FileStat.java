package net.typicartist.discord.game.sdk.structure;

import java.util.List;
import com.sun.jna.Structure;

public class FileStat extends Structure {
    public byte[] filename = new byte[128];
    public long size;
    public long last_modified;

    @Override
    protected List<String> getFieldOrder() {
        return List.of("filename", "size", "last_modified");
    }
}
