package net.typicartist.discord.game.sdk.structure.core;

import java.util.List;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import net.typicartist.discord.game.sdk.constants.LogLevel;

public class FFIMethods extends Structure {
    public static class ByReference extends FFIMethods implements Structure.ByReference {}

    public interface DestroyHandler extends Callback {
        void invoke(Pointer methodsPtr);
    }

    public interface RunCallbacksMethod extends Callback {
        int invoke(Pointer methodPtr);
    }

    public interface SetLogHookCallback extends Callback {
        void invoke(Pointer ptr, int level, String message);
    }

    public interface SetLogHookMethod extends Callback {
        void invoke(Pointer methodsPtr, LogLevel minLevel, Pointer callbackData, SetLogHookCallback callback);
    }

    public interface GetManagerMethod extends Callback {
        Pointer invoke(Pointer discordPtr);
    }

    public DestroyHandler destroy;
    public RunCallbacksMethod runCallbacks;
    public SetLogHookMethod setLogHook;
    public GetManagerMethod getApplicationManager;
    public GetManagerMethod getUserManager;
    public GetManagerMethod getImageManager;
    public GetManagerMethod getActivityManager;
    public GetManagerMethod getRelationshipManager;
    public GetManagerMethod getLobbyManager;
    public GetManagerMethod getNetworkManager;
    public GetManagerMethod getOverlayManager;
    public GetManagerMethod getStorageManager;
    public GetManagerMethod getStoreManager;
    public GetManagerMethod getVoiceManager;
    public GetManagerMethod getAchievementManager;

    public FFIMethods() {

    }

    public FFIMethods(Pointer methodPtr) {
        super(methodPtr);
        
        read();
    }

    @Override
    protected List<String> getFieldOrder() {
        return List.of(
            "destroy", 
            "runCallbacks", 
            "setLogHook", 
            "getApplicationManager", 
            "getUserManager", 
            "getImageManager", 
            "getActivityManager", 
            "getRelationshipManager",
            "getLobbyManager", 
            "getNetworkManager", 
            "getOverlayManager", 
            "getStorageManager", 
            "getStoreManager", 
            "getVoiceManager", 
            "getAchievementManager"
        );
    }
}
