package com.gocamargo.service;

import com.gocamargo.model.Subreddit;
import com.gocamargo.util.ConnectionUtil;
import org.jsoup.nodes.Element;

import java.util.Objects;

public class RedditConnectionService {

    private ConnectionUtil connectionUtil;
    private final String REDDIT_URL = "https://old.reddit.com";

    public RedditConnectionService() {
        this.connectionUtil = new ConnectionUtil();
    }

    public void print(String subreddit){
        this.connectionUtil.getConnection(this.REDDIT_URL.concat("/r/").concat(subreddit))
                .getElementsByClass("thing")
                .forEach(element -> {
                    Subreddit entity = this.createSubreddit(element);
                    if(Objects.nonNull(entity) && entity.getScore() >= 5000)
                        System.out.println(entity);
                });
    }

    private Subreddit createSubreddit(Element element){
        if(element.hasAttr("data-score")){
            String title, commentsLink, subreddit;
            Integer score;
            subreddit = element.attr("data-subreddit");
            commentsLink = this.REDDIT_URL.concat(element.attr("data-permalink"));
            score = Integer.parseInt(element.attr("data-score"));
            title = element.select("div.entry div.top-matter p a").eachText().get(0);
            return new Subreddit(title, commentsLink, score, subreddit);
        }
        return null;
    }
}