package net.typicartist.discord.game.sdk;

import com.sun.jna.Library;
import com.sun.jna.Native;

public class DiscordGameSDK implements Library {
    DiscordGameSDK INSTANCE = Native.load("discord_game_sdk", DiscordGameSDK.class);

    
}
