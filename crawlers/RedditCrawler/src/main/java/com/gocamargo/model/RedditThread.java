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
        sb.append("RedditThread{").append("\n")
                .append("title: ").append(title).append("\n")
                .append("commentsLink: ").append(commentsLink).append("\n")
                .append("score: ").append(score).append("\n")
                .append("subreddit: ").append(subreddit).append("\n")
                .append('}');
        return sb.toString();
    }
}