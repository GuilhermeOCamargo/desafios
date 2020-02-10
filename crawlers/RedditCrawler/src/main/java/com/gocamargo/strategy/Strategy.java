package com.gocamargo.strategy;

import java.util.List;

public interface Strategy {
    List<String> createResponse(String message);
}