package net.typicartist.discord.game.sdk.struct;

import java.util.List;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

public class FFICreateParams extends Structure {
    public long clientId;
    public long flags;
    public Pointer events;
    public Pointer eventData;
    public Pointer applicationEvents;
    public int applicationVersion;
    public Pointer userEvents;
    public int userVersion;
    public Pointer imageEvents;
    public int imageVersion;
    public Pointer activityEvents;
    public int activityVersion;
    public Pointer relationshipEvents;
    public int relationshipVersion;
    public Pointer lobbyEvents;
    public int lobbyVersion;
    public Pointer networkEvents;
    public int networkVersion;
    public Pointer overlayEvents;
    public int overlayVersion;
    public Pointer storageEvents;
    public int storageVersion;
    public Pointer storeEvents;
    public int storeVersion;
    public Pointer voiceEvents;
    public int voiceVersion;
    public Pointer achievementEvents;
    public int achievementVersion;

    @Override
    protected List<String> getFieldOrder() {
        return List.of(
            "clientId", 
            "flags", 
            "events", 
            "eventData",
            "applicationEvents",
            "applicationVersion",
            "userEvents",
            "userVersion",
            "imageEvents",
            "imageVersion",
            "activityEvents",
            "activityVersion",
            "relationshipEvents",
            "relationshipVersion",
            "lobbyEvents",
            "lobbyVersion",
            "networkEvents",
            "networkVersion", 
            "overlayEvents", 
            "overlayVersion", 
            "storageEvents", 
            "storageVersion", 
            "storeEvents", 
            "storeVersion", 
            "voiceEvents", 
            "voiceVersion",
            "achievementEvents", 
            "achievementVersion"
        );
    }
}
