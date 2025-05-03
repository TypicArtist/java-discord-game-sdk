package net.typicartist.discord.game.sdk.util.interop;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import com.sun.jna.Pointer;

public final class GCHandle {
    private static final ConcurrentHashMap<Long, Object> objectMap = new ConcurrentHashMap<>();
    private static final AtomicLong idGenerator = new AtomicLong(1);
    
    private final long id;
    private final Object target;
    private boolean allocated;

    private GCHandle(Object obj) {
        this.target = obj;
        this.id = idGenerator.getAndDecrement();
        this.allocated = true;
        objectMap.put(id, obj);
    }

    public static GCHandle alloc(Object target ) {
        return new GCHandle(target);
    }

    public void free() {
        if (allocated) {
            objectMap.remove(id);
            allocated = false;
        }
    }

    public boolean isAllocated() {
        return allocated;
    }

    public Object getTarget() {
        if (!allocated) {
            throw new IllegalStateException("GCHandle is no longer allocated");
        }

        return target;
    }

    public Pointer toPtr() {
        if (!allocated) {
            throw new IllegalStateException("GCHandle is no longer allocated");
        }

        return new Pointer(id);
    }

    public static GCHandle fromPtr(Pointer ptr) {
        long id = ptr.getLong(0);
        Object target = objectMap.get(id);
        if (target == null) {
            throw new IllegalArgumentException("Invalid pointer, object not found.");
        }

        return new GCHandle(target);
    }
}
