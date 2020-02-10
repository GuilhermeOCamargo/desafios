package com.gocamargo.strategy;

import com.gocamargo.model.RedditThread;
import com.gocamargo.service.RedditConnectionService;

import java.util.ArrayList;
import java.util.List;

public class RedditCrawlerStrategy implements Strategy {
    private RedditConnectionService redditConnectionService;

    public RedditCrawlerStrategy() {
        this.redditConnectionService = new RedditConnectionService();
    }

    @Override
    public List<String> createResponse(String message) {
        List<String> response = new ArrayList<>();
        try{
            String params = getParamsWithoutCommand(message);
            List<String> parsedParams = parseMessageReddit(params);
            List<RedditThread> threads = redditConnectionService.createListOfThreads(parsedParams);
            validateThreadList(threads);
            response.add("Aqui esta o que eu encontrei sobre: "+params);
            for (RedditThread thread:threads) {
                response.add(thread.toString());
            }
        }catch (RuntimeException e){
            response.add(e.getMessage());
        }
        return response;
    }
    private String getParamsWithoutCommand(String message){
        return message.substring(message.indexOf(" "));
    }

    private List<String> parseMessageReddit(String params){
        List<String> listOfSubreddits = new ArrayList<>();
        for (String param:params.split(";")) {
            listOfSubreddits.add(param.trim());
        }
        return listOfSubreddits;
    }

    private void validateThreadList(List<RedditThread> threads){
        if(threads.isEmpty())
            throw new RuntimeException("Nenhuma thread encontrada :(");
    }
}
