package net.typicartist.discord.game.sdk;

import com.sun.jna.Library;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;

import net.typicartist.discord.game.sdk.constants.Result;
import net.typicartist.discord.game.sdk.exception.ResultException;
import net.typicartist.discord.game.sdk.structure.FFICreateParams;
import net.typicartist.discord.game.sdk.structure.FFIEvents;
import net.typicartist.discord.game.sdk.structure.FFIMethods;

public class DiscordGameSDK {
    private interface DiscordGameSDKLibrary extends Library {
        DiscordGameSDKLibrary INSTANCE = Native.load("discord_game_sdk", DiscordGameSDKLibrary.class);
        
        int DiscordCreate(int version, FFICreateParams.ByReference createParams, PointerByReference manager);
    }

    private Pointer eventsPtr;

    private Pointer methodsPtr;
    private Object methodsStructure;
    private FFIMethods.Core methods;

    public DiscordGameSDK(long clientId, long flags) {
        FFICreateParams.ByReference createParams = new FFICreateParams.ByReference();
        createParams.clientId = clientId;
        createParams.flags = flags;

        FFIEvents.ByReference events = new FFIEvents.ByReference();
        eventsPtr = new Memory(events.size());
        createParams.events = eventsPtr;
        
        PointerByReference managerRef = new PointerByReference();

        Result result = Result.fromCode(DiscordGameSDKLibrary.INSTANCE.DiscordCreate(3, createParams, managerRef));
  
        if (result != Result.Ok) {
            this.dispose();
            throw new ResultException(result);
        }

        methodsPtr = managerRef.getValue();
        methods = getMethods();
    }

    private FFIMethods.Core getMethods() {
        if (methodsStructure == null) {
            methodsStructure = new FFIMethods.Core(methodsPtr);
        }

        return (FFIMethods.Core) methodsStructure;
    }

    public void dispose() {
        if (methodsPtr != Pointer.NULL) {
            methods.destroy.invoke(methodsPtr);
        }

        Native.free(Pointer.nativeValue(eventsPtr));
    }

    public static void main(String[] args) {
        DiscordGameSDK discord = new DiscordGameSDK(7L, 0L);
        discord.dispose();
    }
}
