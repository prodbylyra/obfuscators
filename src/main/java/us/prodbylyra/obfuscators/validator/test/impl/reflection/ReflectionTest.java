package us.prodbylyra.obfuscators.validator.test.impl.reflection;

import us.prodbylyra.obfuscators.validator.test.Test;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class ReflectionTest implements Test {
    @Override
    public String type() {
        return "Reflection";
    }

    @Override
    public boolean test() {
        long result;

        try {
            MethodHandle methodHandle = MethodHandles.publicLookup()
                    .findStatic(
                            Class.forName("us.prodbylyra.obfuscators.validator.reflection.Reflection"),
                            "get",
                            MethodType.methodType(long.class, long.class)
                    );

            result = (long) methodHandle.invokeExact(1337L);
        } catch (Throwable t) {
            throw new IllegalStateException("Failed reflection method invocation", t);
        }

        if (result != 100_001_337L) {
            throw new IllegalStateException("Mismatched reflection result value");
        }

        return true;
    }
}
