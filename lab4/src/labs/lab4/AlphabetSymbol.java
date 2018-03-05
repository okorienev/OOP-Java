package labs.lab4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @author Oleksandr Korienev
 * Class for alphabet symbol
 * set debug to true to see the creation log, default = false
*/
public class AlphabetSymbol {
    public char character;
    Pattern pattern = Pattern.compile("[a-zA-Z]");
    private Matcher matcher;
    private static boolean debug = false;
    /**
     *
     * @param c character
     * @throws NonResolvedSymbolException if character is not resolved
     */
    public AlphabetSymbol(char c) throws NonResolvedSymbolException{
        matcher = pattern.matcher(""+c);
        if (matcher.find()){
            character = c;
            if(debug){
                System.out.printf("Constructed AlphabetSymbol object with character '%c'", character);
            }
        }else{
            throw new  NonResolvedSymbolException();
        }
    }
    /**
     *
     * @param s String
     * @throws Exception if string is more than 1 character length or if symbol is not resolved
     */
    public AlphabetSymbol(String s) throws Exception{
        matcher = pattern.matcher(s);
        if (s.length()!= 1){
            throw new IllegalAccessException();
        }else{
            if(matcher.find()){
                character = s.charAt(0);
                if(debug){
                    System.out.printf("Constructed AlphabetSymbol object with character '%c'", character);
                }
            }else{
                throw new NonResolvedSymbolException();
            }
        }
    }
}
