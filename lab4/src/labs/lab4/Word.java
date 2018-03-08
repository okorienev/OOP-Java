package labs.lab4;

/**
 * @author Oleksandr Korienev
 * Class for words. Word can be separator or common word.
 * Common word is @see AlphabetSymbol array, separatpor word is @see PunctuationSymbol array
 */
public class Word {
    public AlphabetSymbol[] letterWord;
    public PunctuationSymbol[] separatorWord;
    public boolean wordIsSeparator;

    public Word(AlphabetSymbol[] alphabetSymbols){
        letterWord = new AlphabetSymbol[alphabetSymbols.length];
        letterWord = alphabetSymbols;
        wordIsSeparator = false;
    }

    public Word(PunctuationSymbol[] punctuationSymbols){
        separatorWord = new PunctuationSymbol[punctuationSymbols.length];
        separatorWord = punctuationSymbols;
        wordIsSeparator = true;
    }
    public Word(String s)throws NonResolvedSymbolException{
        try{
            new AlphabetSymbol(s.charAt(0));
            letterWord = new AlphabetSymbol[s.length()];
            for (int i = 0; i < s.length(); i++) {
                letterWord[i] = new AlphabetSymbol(s.charAt(i));
            }
        }catch (NonResolvedSymbolException e){
            new PunctuationSymbol(s.charAt(0));
        }
    }
    public boolean addAlphaChar(AlphabetSymbol alphabetSymbol){
        if (wordIsSeparator){
            return false;
        }else {
            AlphabetSymbol[] word = new AlphabetSymbol[letterWord.length + 1];
            for (int i = 0; i < letterWord.length; i++) {
                word[i] = letterWord[i];
            }
            word[word.length - 1] = alphabetSymbol;
            return true;
        }
    }
    public boolean addPunctChar(PunctuationSymbol punctuationSymbol){
        if (!wordIsSeparator){
            return false;
        }else {
            PunctuationSymbol[] word = new PunctuationSymbol[letterWord.length + 1];
            for (int i = 0; i < letterWord.length; i++) {
                word[i] = separatorWord[i];
            }
            word[word.length - 1] = punctuationSymbol;
            return true;
        }
    }

    @Override
    public String toString() {
        StringBuffer string = new StringBuffer();
        if (wordIsSeparator){
            for (int i = 0; i < separatorWord.length; i++) {
                string.append(separatorWord[i].character);
            }
        }else {
            for (int i = 0; i < letterWord.length; i++) {
                string.append(letterWord[i].character);
            }
        }
        return string.toString();
    }
}
