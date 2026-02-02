package us.prodbylyra.obfuscators.validator.test.impl.enumeration;

import us.prodbylyra.obfuscators.validator.test.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EnumerationTest implements Test {
    @Override
    public String type() {
        return "Enumeration";
    }

    @Override
    public boolean test() {
        List<String> resolved = new ArrayList<>();

        for (Enumeration value : Enumeration.values()) {
            resolved.add(value.name());
        }

        List<String> expected = Arrays.asList(
                "FIZZ", "BUZZ", "FIZZ_BUZZ"
        );

        boolean result = true;
        for (String value : resolved) {
            if (!expected.contains(value)) {
                result = false;
                break;
            }
        }

        return result;
    }
}
