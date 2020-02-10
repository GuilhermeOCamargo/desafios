package com.gocamargo.service;

import com.gocamargo.model.RedditThread;
import com.gocamargo.util.ConnectionUtil;
import com.gocamargo.util.FileUtil;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RedditConnectionService {

    private ConnectionUtil connectionUtil;
    private final String REDDIT_URL = "https://old.reddit.com";

    public RedditConnectionService() {
        this.connectionUtil = new ConnectionUtil();
    }

    public List<RedditThread> getTopThreadsFromCsv(String path, String fileName){
        List<String> subredditsToSearch = FileUtil.readFile(path, fileName);
        List<RedditThread> topThreads = new ArrayList<>();
        for (String subreddit:subredditsToSearch) {
            getThreads(subreddit)
                    .forEach(element -> {
                        RedditThread thread = this.createSubreddit(element);
                        if(validateThread(thread))
                            topThreads.add(this.createSubreddit(element));
                    });
        }
        return topThreads;
    }

    private boolean validateThread(RedditThread thread){
        return Objects.nonNull(thread) && thread.getScore() >= 5000;
    }

    private Elements getThreads(String subreddit){
        return this.connectionUtil.getConnection(this.REDDIT_URL.concat("/r/").concat(subreddit))
                .getElementsByClass("thing");
    }

    private RedditThread createSubreddit(Element element){
        if(element.hasAttr("data-score")){
            String title, commentsLink, subreddit;
            Integer score;
            subreddit = element.attr("data-subreddit");
            commentsLink = this.REDDIT_URL.concat(element.attr("data-permalink"));
            score = Integer.parseInt(element.attr("data-score"));
            title = element.select("div.entry div.top-matter p a").eachText().get(0);
            return new RedditThread(title, commentsLink, score, subreddit);
        }
        return null;
    }
}