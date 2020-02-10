package com.gocamargo.strategy;
import java.util.Arrays;
import java.util.List;

public class StartStrategy implements Strategy {
    @Override
    public List<String> createResponse(String message) {
        return Arrays.asList("Ola humano! :)");
    }
}
