package idwall.desafio.string;

import com.google.common.base.Strings;

import java.util.Objects;

/**
 * Created by Rodrigo Catão Araujo on 06/02/2018.
 */
public abstract class StringFormatter {

    private int defaultLimit;
    private StringBuilder builder;
    private String formatedText;

    public StringFormatter() {
        this.defaultLimit = 40;
        builder = new StringBuilder();
    }

    /**
     * It receives a text and should return it formatted
     *
     * @param text
     * @return
     */
    public abstract String format(String text, boolean mustJustify);
    /**
     * It receives a text and should return it formatted
     *
     * @param text
     * @param limit
     * @return
     */
    public abstract String format(String text, Integer limit, boolean mustJustify);

    protected Integer getDefaultLimit() {
        return defaultLimit;
    }

    protected StringBuilder getBuilder() {
        return builder;
    }

    protected Integer getApplicableLimit(Integer limit){
        if(Objects.isNull(limit) || limit <= 0)
            return defaultLimit;
        return limit;
    }

    protected String getFormatedText() {
        formatedText = builder.toString();
        builder = new StringBuilder();
        return formatedText;
    }
    protected void validateText(String text){
        if(Strings.isNullOrEmpty(text))
            throw new IllegalArgumentException("O texto nao pode ser vazio ou nulo");
    }

}
