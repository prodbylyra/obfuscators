package us.prodbylyra.obfuscators;

import us.prodbylyra.obfuscators.benchmark.Benchmark;
import us.prodbylyra.obfuscators.validator.Validator;

public class Application {
    public static void main(String[] args) {
        Validator.validate();
        Benchmark.benchmark();
    }
}
