package net.typicartist.discord.game.sdk;

import com.sun.jna.Library;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;

import net.typicartist.discord.game.sdk.constants.CreateFlags;
import net.typicartist.discord.game.sdk.constants.Result;
import net.typicartist.discord.game.sdk.exception.ResultException;
import net.typicartist.discord.game.sdk.structure.FFICreateParams;
import net.typicartist.discord.game.sdk.structure.application.FFIEvents;
import net.typicartist.discord.game.sdk.structure.core.FFIMethods;
import net.typicartist.discord.game.sdk.utils.EnumUtil;
import net.typicartist.discord.game.sdk.utils.GCHandle;

public class DiscordGameSDK {
    private interface DiscordGameSDKLibrary extends Library {
        DiscordGameSDKLibrary INSTANCE = Native.load("discord_game_sdk", DiscordGameSDKLibrary.class);
        
        int DiscordCreate(int version, FFICreateParams.ByReference createParams, PointerByReference manager);
    }

    private GCHandle selfHandle;

    private FFIEvents.ByReference events;
    private Pointer eventsPtr;

    private FFIEvents.ByReference applicationEvents;
    private Pointer applicationEventsPtr;

    private FFIEvents.ByReference userEvents;
    private Pointer userEventsPtr;
    
    private FFIEvents.ByReference imageEvents;
    private Pointer imageEventsPtr;

    private FFIEvents.ByReference activityEvents;
    private Pointer activityEventsPtr;

    private FFIEvents.ByReference relationshipEvents;
    private Pointer relationshipEventsPtr;

    private FFIEvents.ByReference lobbyEvents;
    private Pointer lobbyEventsPtr;

    private FFIEvents.ByReference networkEvents;
    private Pointer networkEventsPtr;

    private FFIEvents.ByReference overlayEvents;
    private Pointer overlayEventsPtr;

    private FFIEvents.ByReference storageEvents;
    private Pointer storageEventsPtr;

    private FFIEvents.ByReference storeEvents;
    private Pointer storeEventsPtr;

    private FFIEvents.ByReference voiceEvents;
    private Pointer voiceEventsPtr;

    private FFIEvents.ByReference achievementEvents;
    private Pointer achievementEventsPtr;

    private Pointer methodsPtr;
    private Object methodsStructure;

    public DiscordGameSDK(long clientId, CreateFlags flags) {
        FFICreateParams.ByReference createParams = new FFICreateParams.ByReference();
        createParams.clientId = clientId;
        createParams.flags = flags.getCode();

        selfHandle = GCHandle.alloc(this);
        createParams.eventData = selfHandle.toPtr();

        events = new FFIEvents.ByReference();
        eventsPtr = new Memory(events.size());
        createParams.events = eventsPtr;

        applicationEvents = new FFIEvents.ByReference();
        applicationEventsPtr = new Memory(applicationEvents.size());
        createParams.applicationEvents = applicationEventsPtr;
        createParams.applicationVersion = 1;

        userEvents = new FFIEvents.ByReference();
        userEventsPtr = new Memory(userEvents.size());
        createParams.userEvents = userEventsPtr;
        createParams.userVersion = 1;

        imageEvents = new FFIEvents.ByReference();
        imageEventsPtr = new Memory(imageEvents.size());
        createParams.imageEvents = imageEventsPtr;
        createParams.imageVersion = 1;

        activityEvents = new FFIEvents.ByReference();
        activityEventsPtr = new Memory(activityEvents.size());
        createParams.imageEvents = activityEventsPtr;
        createParams.imageVersion = 1;

        relationshipEvents = new FFIEvents.ByReference();
        relationshipEventsPtr = new Memory(relationshipEvents.size());
        createParams.relationshipEvents = relationshipEventsPtr;
        createParams.relationshipVersion = 1;

        lobbyEvents = new FFIEvents.ByReference();
        lobbyEventsPtr = new Memory(lobbyEvents.size());
        createParams.lobbyEvents = lobbyEventsPtr;
        createParams.lobbyVersion = 1;

        networkEvents = new FFIEvents.ByReference();
        networkEventsPtr = new Memory(networkEvents.size());
        createParams.networkEvents = networkEventsPtr;
        createParams.networkVersion = 1;

        overlayEvents = new FFIEvents.ByReference();
        overlayEventsPtr = new Memory(overlayEvents.size());
        createParams.overlayEvents = overlayEventsPtr;
        createParams.overlayVersion = 2;

        storageEvents = new FFIEvents.ByReference();
        storageEventsPtr = new Memory(storageEvents.size());
        createParams.storageEvents = storageEventsPtr;
        createParams.storageVersion = 1;

        storeEvents = new FFIEvents.ByReference();
        storeEventsPtr = new Memory(storeEvents.size());
        createParams.storeEvents = storeEventsPtr;
        createParams.storageVersion = 1;

        voiceEvents = new FFIEvents.ByReference();
        voiceEventsPtr = new Memory(voiceEvents.size());
        createParams.voiceEvents = voiceEventsPtr;
        createParams.voiceVersion = 1;

        achievementEvents = new FFIEvents.ByReference();
        achievementEventsPtr = new Memory(achievementEvents.size());
        createParams.achievementEvents = achievementEventsPtr;
        createParams.achievementVersion = 1;

        initEvents(eventsPtr, events);

        PointerByReference managerRef = new PointerByReference();
        int result = DiscordGameSDKLibrary.INSTANCE.DiscordCreate(3, createParams, managerRef);

        if (result != Result.Ok.getCode()) {
            this.dispose();
            throw new ResultException(result);
        }

        methodsPtr = managerRef.getValue();
    }

    private void initEvents(Pointer eventsPtr, FFIEvents events) {
        events.write();
        events.getPointer().write(0, events.getPointer().getByteArray(0, events.size()), 0, events.size());
        eventsPtr.write(0, events.getPointer().getByteArray(0, events.size()), 0, events.size());
    }

    private FFIMethods getMethods() {
        if (methodsStructure == null) {
            methodsStructure = new FFIMethods(methodsPtr);
        }

        return (FFIMethods) methodsStructure;
    }

    public void dispose() {
        if (methodsPtr != Pointer.NULL) {
            getMethods().destroy.invoke(methodsPtr);
        }
        selfHandle.free();
        Native.free(Pointer.nativeValue(eventsPtr));
        Native.free(Pointer.nativeValue(applicationEventsPtr));
        Native.free(Pointer.nativeValue(userEventsPtr));
        Native.free(Pointer.nativeValue(imageEventsPtr));
        Native.free(Pointer.nativeValue(activityEventsPtr));
        Native.free(Pointer.nativeValue(relationshipEventsPtr));
        Native.free(Pointer.nativeValue(lobbyEventsPtr));
        Native.free(Pointer.nativeValue(networkEventsPtr));
        Native.free(Pointer.nativeValue(overlayEventsPtr));
        Native.free(Pointer.nativeValue(storageEventsPtr));
        Native.free(Pointer.nativeValue(storeEventsPtr));
        Native.free(Pointer.nativeValue(voiceEventsPtr));
        Native.free(Pointer.nativeValue(achievementEventsPtr));
    }

    public void runCallbacks() {
        var res = getMethods().runCallbacks.invoke(methodsPtr);
        if (res != Result.Ok.getCode()) {
            throw new ResultException(res);
        }
    }

    public static void main(String[] args) {
        DiscordGameSDK discord = new DiscordGameSDK(7L, CreateFlags.Default);
        discord.dispose();
    }
}
