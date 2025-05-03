package net.typicartist.discord.game.sdk.structure.user;

import java.util.List;
import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

public class FFIEvents extends Structure {
    public interface CurrentUserUpdateHandler extends Callback {
        void invoke(Pointer ptr);
    }

    public CurrentUserUpdateHandler onCurrentUserUpdate;

    @Override
    protected List<String> getFieldOrder() {
        return List.of(
            "onCurrentUserUpdate"
        );
    } 
}
