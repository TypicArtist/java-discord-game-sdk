package net.typicartist.discord.game.sdk.structure;

import java.util.List;
import com.sun.jna.Structure;
import net.typicartist.discord.game.sdk.enums.ActivityPartyPrivacy;

public class ActivityParty extends Structure {
    public byte[] id = new byte[128];
    public PartySize size;
    public ActivityPartyPrivacy privacy;

    @Override
    protected List<String> getFieldOrder() {
        return List.of("id", "size", "privacy");
    }
}
