package labs.lab4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @author Oleksandr Korienev
 * Class for punctuation symbols
 * set debug to true to see the log, default = false
 */
public class PunctuationSymbol {
    public char character;
    private Matcher matcher;
    private boolean debug = false;
    private Pattern pattern = Pattern.compile("[.,?!:;\"\' -]");
    /**
     *
     * @param c character
     * @throws NonResolvedSymbolException if character is not resolved
     */
    public PunctuationSymbol(char c) throws NonResolvedSymbolException{
        matcher = pattern.matcher(""+c);
        if (matcher.find()){
            character = c;
            if(debug){
                System.out.printf("Constructed PunctuationSymbol object with character '%s'", character);
            }
        }else{
            throw new  NonResolvedSymbolException();
        }
    }

    /**
     *
     * @param s String
     * @throws IllegalArgumentException if string is more than 1 character length
     * @throws NonResolvedSymbolException if symbol is not resolved
     */
    public PunctuationSymbol(String s) throws Exception{
        matcher = pattern.matcher(s);
        if (s.length()!= 1){
            throw new IllegalArgumentException();
        }else{
            if(matcher.find()){
                character = s.charAt(0);
                if(debug){
                    System.out.printf("Constructed PunctuationSymbol object with character '%s'", character);
                }
            }else{
                throw new NonResolvedSymbolException();
            }
        }
    }
}
