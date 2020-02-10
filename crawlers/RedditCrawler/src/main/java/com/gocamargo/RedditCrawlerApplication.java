package com.gocamargo;


import com.gocamargo.service.TelegramBotService;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class RedditCrawlerApplication {

    public static void main(String[] args) {
//        RedditConnectionService service = new RedditConnectionService();
//
//        Scanner scanner = new Scanner(System.in);
//        String path, fileName;
//        System.out.println("Insira o caminho do arquivo");
//        path = scanner.nextLine();
//
//        System.out.println("Insira o nome do arquivo");
//        fileName = scanner.nextLine();
//
//        List<RedditThread> topThreads = service.getTopThreadsFromCsv(path, fileName);
//
//        topThreads.forEach(System.out::println);

        ApiContextInitializer.init();

        TelegramBotsApi botsApi = new TelegramBotsApi();

        try{
            botsApi.registerBot(new TelegramBotService());
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
}