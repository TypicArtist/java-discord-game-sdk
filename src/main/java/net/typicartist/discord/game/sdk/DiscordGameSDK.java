package net.typicartist.discord.game.sdk;

import java.util.List;

import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.PointerByReference;

import net.typicartist.discord.game.sdk.constants.LogLevel;
import net.typicartist.discord.game.sdk.constants.Result;
import net.typicartist.discord.game.sdk.exception.ResultException;
import net.typicartist.discord.game.sdk.structure.FFICreateParams;
import net.typicartist.discord.game.sdk.structure.FFIEvents;
import net.typicartist.discord.game.sdk.structure.FFIMethods;
import net.typicartist.discord.game.sdk.util.MethodsAccessor;

public class DiscordGameSDK {
    public static String DLL_NAME = "\"C:\\\\Users\\\\PC_USER\\\\Desktop\\\\java-discord-game-sdk\\\\src\\\\main\\\\resources\\\\discord_game_sdk\"";

    private interface DiscordGameSDKLibrary extends Library {
        DiscordGameSDKLibrary INSTANCE = Native.load(DLL_NAME, DiscordGameSDKLibrary.class);
        
        int DiscordCreate(int version, FFICreateParams.ByReference createParams, PointerByReference manager);
    }

    private Pointer methodPtr;
    private FFIMethods.Core methods;

    public DiscordGameSDK(long clientId, long flags) {
        FFICreateParams.ByReference createParams = new FFICreateParams.ByReference();
        createParams.clientId = clientId;
        createParams.flags = flags;

        FFIEvents.ByReference events = new FFIEvents.ByReference();
        Pointer eventsPtr = new Memory(events.size());
        createParams.events = eventsPtr;
        
        PointerByReference managerRef = new PointerByReference();

        Result result = Result.fromCode(DiscordGameSDKLibrary.INSTANCE.DiscordCreate(3, createParams, managerRef));

        if (result != Result.Ok) {
            this.dispose();
            throw new ResultException(result);
        }

        methodPtr = managerRef.getValue();
        MethodsAccessor<FFIMethods.Core> accessor = new MethodsAccessor<>(eventsPtr, FFIMethods.Core.class);
        methods = accessor.getMethods();
    }

    public void dispose() {
        if (methodPtr != Pointer.NULL) {
            methods.destroy(methodPtr);
        }
    }
}
