package com.gocamargo.service;

import com.gocamargo.model.CommandsEnum;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Arrays;
import java.util.List;

public class TelegramBotService extends TelegramLongPollingBot {

    private final String TOKEN;
    private final String USERNAME;
    private RedditConnectionService redditConnectionService;

    public TelegramBotService() {
        this.TOKEN = System.getenv("TELEGRAM_REDDIT_BOT");
        this.USERNAME = System.getenv("TELEGRAM_REDDIT_USERNAME");
        this.redditConnectionService = new RedditConnectionService();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()){
            SendMessage response = new SendMessage()
                    .setChatId(update.getMessage().getChatId());
            for (String responseMessage:getReponseMessage(update.getMessage().getText())) {
                response.setText(responseMessage);
                try{
                    execute(response);
                }catch (TelegramApiException e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        return USERNAME;
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }


    private List<String> getReponseMessage(String message){
        String parsedCommand = message.contains(" ")?message.substring(0, message.indexOf(" ")):message;
        try{
            CommandsEnum commandsEnum = CommandsEnum.fromValue(parsedCommand);
            return commandsEnum.getStrategy().createResponse(message);
        }catch (RuntimeException e){
            return Arrays.asList(e.getMessage());
        }

    }

}
