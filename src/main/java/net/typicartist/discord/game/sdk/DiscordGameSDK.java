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

        



        
        PointerByReference managerRef = new PointerByReference();

        Result result = EnumUtil.fromCode(Result.class, DiscordGameSDKLibrary.INSTANCE.DiscordCreate(3, createParams, managerRef));

        if (result != Result.Ok) {
            this.dispose();
            throw new ResultException(result);
        }

        methodsPtr = managerRef.getValue();
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
    }

    public static void main(String[] args) {
        DiscordGameSDK discord = new DiscordGameSDK(7L, CreateFlags.Default);
        discord.dispose();
    }
}
