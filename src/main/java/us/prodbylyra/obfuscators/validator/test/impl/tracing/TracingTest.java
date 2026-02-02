package us.prodbylyra.obfuscators.validator.test.impl.tracing;

import us.prodbylyra.obfuscators.validator.test.Test;

public class TracingTest implements Test {
    @Override
    public String type() {
        return "Tracing";
    }

    @Override
    public boolean test() {
        try {
            retrace(5);
        } catch (Throwable e) {
            throw new IllegalStateException("Failed tracing", e);
        }

        return traces == 5;
    }

    public int traces = 0;

    private void trace(int i) throws Throwable {
        traces++;

        StackTraceElement element = new Throwable().getStackTrace()[1];

        TracingTest.class
                .getDeclaredMethod(element.getMethodName(), int.class)
                .invoke(this, i - 1);
    }

    @SuppressWarnings("SameParameterValue")
    private void retrace(int i) throws Throwable {
        if (i == 0) {
            return;
        }

        trace(i);
    }
}
