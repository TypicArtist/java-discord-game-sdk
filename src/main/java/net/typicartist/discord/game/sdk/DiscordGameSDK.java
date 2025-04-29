package net.typicartist.discord.game.sdk;

import com.sun.jna.Library;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

import net.typicartist.discord.game.sdk.struct.FFICreateParams;
import net.typicartist.discord.game.sdk.struct.FFIEvents;

import java.math.BigInteger;

public class DiscordGameSDK {
    private interface DiscordGameSDKLibrary extends Library {
        DiscordGameSDKLibrary INSTANCE = Native.load("C:\\Users\\PC_USER\\Desktop\\java-discord-game-sdk\\src\\main\\resources\\discord_game_sdk", DiscordGameSDKLibrary.class);
        int DiscordCreate();
    } 

    public DiscordGameSDK(long clientId, long flags) {
        FFICreateParams createParams = new FFICreateParams();
        createParams.clientId = clientId;
        createParams.flags = flags;

        FFIEvents events = new FFIEvents();
        Pointer eventsPtr = new Memory(events.size());
        createParams.events = eventsPtr;

                
    }

    public static void main(String[] args) {
        new DiscordGameSDK(7L, new BigInteger("12"));
    }
}
