package com.gocamargo.model;

import com.gocamargo.strategy.Strategy;
import com.gocamargo.strategy.RedditCrawlerStrategy;
import com.gocamargo.strategy.StartStrategy;

import java.util.Arrays;

public enum CommandsEnum {
    REDDIT_CRAWLER("/NadaPraFazer", new RedditCrawlerStrategy()), START("/start", new StartStrategy());

    private String description;
    private Strategy strategy;

    CommandsEnum(String description, Strategy strategy) {
        this.description = description;
        this.strategy = strategy;
    }

    public String getDescription() {
        return description;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public static CommandsEnum fromValue(String value) {
        return Arrays.stream(values())
                .filter(v -> v.description.equals(value)).findFirst()
                .orElseThrow(() -> new RuntimeException("Comando invalido!"));
    }
}
