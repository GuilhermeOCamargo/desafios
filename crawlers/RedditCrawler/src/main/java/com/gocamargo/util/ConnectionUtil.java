package com.gocamargo.util;

import com.gocamargo.exception.ConnectionException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ConnectionUtil {

    Document document;

    public Document getConnection(String url){
        try{
            return document = createConnection(url).get();
        }catch (Exception e){
            throw new ConnectionException(e);
        }
    }

    private Connection createConnection(String url){
        return Jsoup.connect(url)
//                .userAgent(this.userAgent)
                .followRedirects(true);
    }
}
