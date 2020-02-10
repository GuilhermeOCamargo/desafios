package com.gocamargo.model;

public class RedditThread {

    private String title;
    private String commentsLink;
    private Integer score;
    private String subreddit;

    public RedditThread(String title, String commentsLink, Integer score, String subreddit) {
        this.title = title;
        this.commentsLink = commentsLink;
        this.score = score;
        this.subreddit = subreddit;
    }

    public String getTitle() {
        return title;
    }

    public String getCommentsLink() {
        return commentsLink;
    }

    public Integer getScore() {
        return score;
    }

    public String getSubreddit() {
        return subreddit;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("TITLE: ").append(title).append("\n")
                .append("LINK: ").append(commentsLink).append("\n")
                .append("SCORE: ").append(score).append("\n")
                .append("SUBREDDIT: ").append(subreddit).append("\n");
        return sb.toString();
    }
}