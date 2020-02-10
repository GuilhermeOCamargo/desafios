package idwall.desafio;

import com.google.common.base.Strings;
import idwall.desafio.string.IdwallFormatter;
import idwall.desafio.string.StringFormatter;

import java.util.InputMismatchException;
import static java.util.Objects.*;
import java.util.Scanner;

/**
 * Created by Rodrigo Catão Araujo on 06/02/2018.
 */
public class Main {

    private static final String DEFAULT_INPUT_TEXT = "In the beginning God created the heavens and the earth. Now the earth was formless and empty, darkness was over the surface of the deep, and the Spirit of God was hovering over the waters.\n" +
            "\n" +
            "And God said, \"Let there be light,\" and there was light. God saw that the light was good, and he separated the light from the darkness. God called the light \"day,\" and the darkness he called \"night.\" And there was evening, and there was morning - the first day.";
    private static final Integer DEFAULT_LIMIT = 40;

    private static String getText(Scanner scanner){
        
        String text;
        System.out.println("Insira o texto a ser formatado:\nCaso nenhum texto seja inserido, será utilizado um texto padrão");
        text = scanner.nextLine();
        if(Strings.isNullOrEmpty(text))
            text = DEFAULT_INPUT_TEXT;
        return text;
    }

    private static Integer getLimit(Scanner scanner){
        Integer limit = null;
        System.out.println("Insira a quantidade de caracteres que cada linha deverá ter:\nValor padrão "+DEFAULT_LIMIT+")");
        try {
            limit = Integer.parseInt(scanner.nextLine());
        } catch (Exception e){
            System.out.println("Valor inválido. Utilizando o valor padrão");
        }
        if(isNull(limit) || limit == 0)
            limit = DEFAULT_LIMIT;
        return limit;
    }

    private static boolean mustJustifyText(Scanner scanner){
        String mustJustify = null;
        System.out.println("O texto deverá estar justificado? Por padrão, o texto não será justificado.\n 1- Sim | 2- Nao");
        mustJustify = scanner.nextLine();
        if(Strings.isNullOrEmpty(mustJustify) && !mustJustify.equals("1") && !mustJustify.equals("2")){
            System.out.println("Valor inválido. Utilizando o valor padrão");
            return false;
        }
        return true;
  
    }

    public static void main(String[] args) {
        String text;
        Integer limit;
        boolean mustJustify;
        Scanner scanner = new Scanner(System.in);

        text = getText(scanner);
        limit = getLimit(scanner);
        mustJustify = mustJustifyText(scanner);


        // Print input data
        System.out.println("Inputs: ");
        System.out.println("Text: " + text);
        System.out.println("Limit: " + limit);
        System.out.println("Should justify: " + mustJustify);
        System.out.println("=========================");

        // Run IdwallFormatter
        final StringFormatter sf = new IdwallFormatter();
        String outputText = sf.format(text, limit, mustJustify);

        // Print output text
        System.out.println("Output: ");
        System.out.println(outputText);
    }
}
