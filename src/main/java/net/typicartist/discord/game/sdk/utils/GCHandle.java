package net.typicartist.discord.game.sdk.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import com.sun.jna.Pointer;

public final class GCHandle {
    private static final Map<Long, Object> store = new ConcurrentHashMap<>();
    private static final AtomicLong nextId = new AtomicLong(1);

    private final long handle;

    private GCHandle(long handle) {
        this.handle = handle;
    }

    public void free() {
        store.remove(handle);
    } 

    public static GCHandle alloc(Object obj) {
        long id = nextId.getAndIncrement();
        store.put(id, obj);
        return new GCHandle(id);
    }

    public static GCHandle fromPtr(Pointer ptr) {
        long handle = Pointer.nativeValue(ptr);
        return new GCHandle(handle);
    }

    public static Pointer toPtr(GCHandle gcHandle) {
        return Pointer.createConstant(gcHandle.handle);
    }
}
