package us.prodbylyra.obfuscators.validator;

import us.prodbylyra.obfuscators.validator.test.Test;
import us.prodbylyra.obfuscators.validator.test.impl.annotation.AnnotationTest;
import us.prodbylyra.obfuscators.validator.test.impl.enumeration.EnumerationTest;
import us.prodbylyra.obfuscators.validator.test.impl.reflection.ReflectionTest;

import java.util.Arrays;
import java.util.List;

public class Validator {
    public static void validate() {
        List<Test> testList = Arrays.asList(
                new AnnotationTest(),
                new EnumerationTest(),
                new ReflectionTest()
        );

        for (Test test : testList) {
            String result = "ERROR";
            try {
                if (test.test()) {
                    result = "OK";
                } else {
                    result = "FAIL";
                }
            } catch (Throwable t) {
                t.printStackTrace(System.err);
            }
            System.out.printf("%s... %s%n", test.type(), result);
        }
    }
}
