package us.prodbylyra.obfuscators.validator.test.impl.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Annotation {
    String stringValue();
    int intValue();
    float floatValue();
    long longValue();
    double doubleValue();
    boolean booleanValue();
}
