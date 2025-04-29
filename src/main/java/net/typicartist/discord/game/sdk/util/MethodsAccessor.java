package net.typicartist.discord.game.sdk.util;

import java.lang.reflect.InvocationTargetException;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

public class MethodsAccessor <T extends Structure> {
    private final Pointer methodsPtr;
    private final Class<T> methodsType;
    private T methodsStructure;

    public MethodsAccessor(Pointer methodsPtr, Class<T> methodsType) {
        this.methodsPtr = methodsPtr;
        this.methodsType = methodsType;
    }

    public T getMethods() {
        if (methodsStructure == null) {
            try {
                methodsStructure = methodsType.getConstructor(Pointer.class).newInstance(methodsPtr);
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException("Failed to create structure instance", e);
            }
        }

        return methodsStructure;
    }
}