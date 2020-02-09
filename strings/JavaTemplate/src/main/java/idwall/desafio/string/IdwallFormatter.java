package idwall.desafio.string;
/**
 * Created by Rodrigo Catão Araujo on 06/02/2018.
 */
public class IdwallFormatter extends StringFormatter {

    @Override
    public String format(String text, Integer limit, boolean mustJustify){
        return handleFormat(text, getApplicableLimit(limit), mustJustify);
    }

    private String handleFormat(String text, Integer limit, boolean mustJustifyText){
        validateText(text);
        boolean hasNext = true;
        String line;
        while (hasNext){
            if(text.length() >= limit){
                line = text.substring(0, limit);
                if(hasEndedBlank(text, limit)){
                    line = line.trim();
                    text = text.substring(limit).trim();
                } else{
                    if(isSpaceLatest(line))
                        line = line.substring(0, line.lastIndexOf(" "));
                    else
                        line = line.substring(0, line.lastIndexOf("\n"));

                    text = text.substring(line.length()).trim();
                }
                if(mustJustifyText)
                    line = justifyLine(line, limit);

                getBuilder().append(line)
                        .append("\n");
                hasNext = text.length() > 0;
            }else{
                if(mustJustifyText)
                    text = justifyLine(text, limit);

                getBuilder().append(text);
                hasNext = false;
            }

        }
        return getFormatedText();
    }

    private boolean hasEndedBlank(String text, int limit){
        return text.substring(0, limit+1).endsWith(" ") ||
                text.substring(0, limit+1).endsWith("\n");
    }

    private boolean isSpaceLatest(String line){
        return line.lastIndexOf(" ") > line.lastIndexOf("\n");
    }

    private String justifyLine(String line, int limit){
        if(line.length() < limit){
            Integer spacesToAdd, gaps, spacesToAddInEachGap, extraSpaces;
            spacesToAdd = limit - line.length();
            gaps = getGapsInString(line);
            spacesToAddInEachGap = spacesToAdd/gaps;
            extraSpaces = spacesToAdd % gaps;
            return  createJustifiedText(line.trim(), spacesToAddInEachGap, extraSpaces, line.endsWith("\n"));
        }
        return line;
    }

    private int getGapsInString(String text){
        char[] splitedLine = text.toCharArray();
        int gaps=0;
        for(int i=0; i<splitedLine.length; i++){
            if(splitedLine[i] == ' ')
                gaps++;
        }
        return gaps;
    }

    private String createStringOfSpaces(int numberOfGaps){
        String gaps ="";
        for(int i=0; i<=numberOfGaps; i++){
            gaps +=" ";
        }
        return gaps;
    }

    private String createJustifiedText(String text, Integer spacesToAddInEachGap, Integer extraSpaces, boolean hasBreakLine){
        String[] splitedLine = text.split(" ");
        StringBuilder justifiedText = new StringBuilder();
        String stringOfSpaces = createStringOfSpaces(spacesToAddInEachGap);
        for(int i=0; i < splitedLine.length; i++){
            justifiedText.append(splitedLine[i]);
            if(i < splitedLine.length -1)
                justifiedText.append(stringOfSpaces);
            if(extraSpaces > 0){
                justifiedText.append(" ");
                extraSpaces--;
            }
        }
        if(hasBreakLine)
            justifiedText.append("\n");
        return justifiedText.toString();
    }
}
