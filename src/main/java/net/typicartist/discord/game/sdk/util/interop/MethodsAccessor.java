package net.typicartist.discord.game.sdk.util.interop;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

public class MethodsAccessor {
    private static final Map<Pointer, Structure> methodsCache = new ConcurrentHashMap<>();
    
    private MethodsAccessor() {};

    @SuppressWarnings("unchecked")
    public static <T extends Structure> T getMethods(Pointer methodsPtr, Class<T> clazz) {
        if (methodsPtr ==  Pointer.NULL) {
            throw new IllegalArgumentException("Pointer is null.");
        }
        
        return (T) methodsCache.computeIfAbsent(methodsPtr, p -> {   
            try {
                T instance = clazz.getDeclaredConstructor(Pointer.class).newInstance(p);
                instance.read(); 
                return instance;
            } catch (Exception e) {
                throw new RuntimeException("Failed to instantiate structure: " + clazz.getName(), e);
            }
        });
    
    }
}
