package idwall.desafio.string;
/**
 * Created by Rodrigo Catão Araujo on 06/02/2018.
 */
public class IdwallFormatter extends StringFormatter {

    @Override
    public String format(String text) {
        return handleFormat(text, getDefaultLimit());
    }

    @Override
    public String format(String text, Integer limit){
        return handleFormat(text, getApplicableLimit(limit));
    }

    private String handleFormat(String text, Integer limit){
        validateText(text);
        boolean hasNext = true;
        String textSubstring;
        while (hasNext){
            if(text.length() >= limit){
                textSubstring = text.substring(0, limit);
                if(text.substring(0, limit+1).endsWith(" ") || text.substring(0, limit+1).endsWith("\n")){
                    textSubstring = textSubstring.trim();
                    text = text.substring(limit, text.length()).trim();
                } else{
                    if(textSubstring.lastIndexOf(" ") > textSubstring.lastIndexOf("\n"))
                        textSubstring = textSubstring.substring(0, textSubstring.lastIndexOf(" "));
                    else
                        textSubstring = textSubstring.substring(0, textSubstring.lastIndexOf("\n"));

                    text = text.substring(textSubstring.length(), text.length()).trim();
                }
                getBuilder().append(textSubstring)
                        .append("\n");
                hasNext = text.length() > 0;
            }else{
                getBuilder().append(text);
                hasNext = false;
            }
        }
        return getFormatedText();
    }
}
