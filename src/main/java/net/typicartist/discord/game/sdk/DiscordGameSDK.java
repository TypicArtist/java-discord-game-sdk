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
    private Pointer eventsPtr;

    private Pointer methodsPtr;
    private Object methodsStructure;
    private FFIMethods methods;

    public DiscordGameSDK(long clientId, CreateFlags flags) {
        FFICreateParams.ByReference createParams = new FFICreateParams.ByReference();
        createParams.clientId = clientId;
        createParams.flags = flags.getCode();

        selfHandle = GCHandle.alloc(this);
        createParams.eventData = GCHandle.toPtr(selfHandle);

        FFIEvents.ByReference events = new FFIEvents.ByReference();
        eventsPtr = new Memory(events.size());
        createParams.events = eventsPtr;
        
        PointerByReference managerRef = new PointerByReference();

        Result result = EnumUtil.fromCode(Result.class, DiscordGameSDKLibrary.INSTANCE.DiscordCreate(3, createParams, managerRef));

        if (result != Result.Ok) {
            this.dispose();
            throw new ResultException(result);
        }

        methodsPtr = managerRef.getValue();
        methods = getMethods();
    }

    private FFIMethods getMethods() {
        if (methodsStructure == null) {
            methodsStructure = new FFIMethods(methodsPtr);
        }

        return (FFIMethods) methodsStructure;
    }

    public void dispose() {
        if (methodsPtr != Pointer.NULL) {
            methods.destroy.invoke(methodsPtr);
        }
        selfHandle.free();

        Native.free(Pointer.nativeValue(eventsPtr));
    }

    public static void main(String[] args) {
        DiscordGameSDK discord = new DiscordGameSDK(7L, CreateFlags.Default);
        discord.dispose();
    }
}
