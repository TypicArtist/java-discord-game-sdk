package net.typicartist.discord.game.sdk.structure;

import java.util.List;
import com.sun.jna.Structure;
import net.typicartist.discord.game.sdk.enums.ActivityType;

public class Activity extends Structure {
    public ActivityType type;
    public long application_id;
    public byte[] name = new byte[128];
    public byte[] state = new byte[128];
    public byte[] details = new byte[128];
    public ActivityTimestamps timestamps;
    public ActivityAssets assets;
    public ActivityParty party;
    public ActivitySecrets secrets;
    public boolean instance;
    public long supported_platforms;

    @Override
    protected List<String> getFieldOrder() {
        return List.of("type", "application_id", "name", "state", "details", "timestamps", "assets", "party", "secrets", "instance", "supported_platforms");
    }
}
