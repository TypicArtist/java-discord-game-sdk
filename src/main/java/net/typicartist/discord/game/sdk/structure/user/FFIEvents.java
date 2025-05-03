package net.typicartist.discord.game.sdk.structure.user;

import com.sun.jna.Pointer;

public class FFIEvents {
    public interface CurrentUserUpdateHandler {
        void invoke(Pointer ptr);
    }

    public CurrentUserUpdateHandler onCurrentUserUpdate;
}
