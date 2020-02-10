package com.gocamargo;


import com.gocamargo.model.RedditThread;
import com.gocamargo.service.RedditConnectionService;
import com.gocamargo.util.FileUtil;

import java.util.List;
import java.util.Scanner;

public class RedditCrawlerApplication {

    public static void main(String[] args) {
        RedditConnectionService service = new RedditConnectionService();

        Scanner scanner = new Scanner(System.in);
        String path, fileName;
        System.out.println("Insira o caminho do arquivo");
        path = scanner.nextLine();

        System.out.println("Insira o nome do arquivo");
        fileName = scanner.nextLine();

        List<RedditThread> topThreads = service.getTopThreadsFromCsv(path, fileName);

        topThreads.forEach(System.out::println);
    }
}