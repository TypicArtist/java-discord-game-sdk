package net.typicartist.discord.game.sdk.util.interop;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

public class EventInitializer {
    private EventInitializer() {};

    public static <T extends Structure> void initEvents(Pointer eventsPtr, T events) {
        events.write();
        byte[] structBytes = events.getPointer().getByteArray(0, events.size());
        eventsPtr.write(0, structBytes, 0, structBytes.length);
    }
}
