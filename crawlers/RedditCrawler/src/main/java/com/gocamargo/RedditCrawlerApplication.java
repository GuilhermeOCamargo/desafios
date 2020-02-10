package com.gocamargo;


import com.gocamargo.service.RedditConnectionService;

public class RedditCrawlerApplication {

    public static void main(String[] args) {
        RedditConnectionService service = new RedditConnectionService();
        service.print("worldnews");
    }
}