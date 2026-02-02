package us.prodbylyra.obfuscators.validator.test.impl.annotation;

import us.prodbylyra.obfuscators.validator.test.Test;

@Annotation(
        stringValue = "string",
        intValue = 1_000_000_000,
        floatValue = 40.393837363534333231302928272625242322212019181716151413121110987654321F,
        longValue = 1_000_000_000_000_000_000L,
        doubleValue = 123.45678910111213141516171819202122232425262728293031323334353637383940D,
        booleanValue = true
)
public class AnnotationTest implements Test {
    @Override
    public String type() {
        return "Annotation";
    }

    @Override
    public boolean test() {
        Class<? extends AnnotationTest> annotationTest = AnnotationTest.class;

        if (annotationTest.isAnnotationPresent(Annotation.class)) {
            Annotation annotation = annotationTest.getAnnotation(Annotation.class);

            if (!annotation.stringValue().equals("string")) {
                throw new IllegalStateException("Mismatched annotation string type");
            }

            if (annotation.intValue() != 1_000_000_000) {
                throw new IllegalStateException("Mismatched annotation int type");
            }

            if (annotation.floatValue() != 40.393837363534333231302928272625242322212019181716151413121110987654321F) {
                throw new IllegalStateException("Mismatched annotation float type");
            }

            if (annotation.longValue() != 1_000_000_000_000_000_000L) {
                throw new IllegalStateException("Mismatched annotation long type");
            }

            if (annotation.doubleValue() != 123.45678910111213141516171819202122232425262728293031323334353637383940D) {
                throw new IllegalStateException("Mismatched annotation double type");
            }

            if (!annotation.booleanValue()) {
                throw new IllegalStateException("Mismatched annotation boolean type");
            }
        } else {
            throw new IllegalStateException("Annotation not present");
        }

        return true;
    }
}
