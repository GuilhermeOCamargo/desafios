package com.gocamargo.util;

import com.gocamargo.exception.ConnectionException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ConnectionUtil {

    Document document;
    private String userAgent = "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.5; en-US; rv:1.9.1b3) Gecko/20090305 Firefox/3.1b3 GTB5";

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
