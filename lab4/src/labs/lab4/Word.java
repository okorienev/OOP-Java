package labs.lab4;

/**
 * @author Oleksandr Korienev
 * Class for words. Word can be separator or common word.
 * Common word is AlphabetSymbol array, separator word is PunctuationSymbol array
 * @see AlphabetSymbol
 * @see PunctuationSymbol
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

    /**
     *
     * @param s String
     * @throws NonResolvedSymbolException if word has nor alphabet or punctuation characters or is mix of both
     */
    public Word(String s)throws NonResolvedSymbolException{
        try{
            letterWord = new AlphabetSymbol[s.length()];
            for (int i = 0; i < s.length(); i++) {
                letterWord[i] = new AlphabetSymbol(s.charAt(i));
                wordIsSeparator = false;
            }
        }catch (NonResolvedSymbolException e){
            separatorWord = new PunctuationSymbol[s.length()];
            for (int i = 0; i < s.length(); i++) {
                separatorWord[i] = new PunctuationSymbol(s.charAt(i));
                wordIsSeparator = true;
            }

        }
    }
    public boolean addAlphaChar(AlphabetSymbol alphabetSymbol){
        if (wordIsSeparator){
            return false;
        }else {
            AlphabetSymbol[] word = new AlphabetSymbol[letterWord.length + 1];
            System.arraycopy(letterWord, 0, word, 0, letterWord.length);
            word[word.length - 1] = alphabetSymbol;
            letterWord = word;
            return true;
        }
    }
    public boolean addPunctChar(PunctuationSymbol punctuationSymbol){
        if (!wordIsSeparator){
            return false;
        }else {
            PunctuationSymbol[] word = new PunctuationSymbol[separatorWord.length + 1];
            System.arraycopy(separatorWord, 0, word, 0, separatorWord.length);
            word[word.length - 1] = punctuationSymbol;
            separatorWord = word;
            return true;
        }
    }

    @Override
    public String toString() {
        StringBuffer string = new StringBuffer();
        if (wordIsSeparator){
            for (PunctuationSymbol aSeparatorWord : separatorWord) {
                string.append(aSeparatorWord.character);
            }
        }else {
            for (AlphabetSymbol aLetterWord : letterWord) {
                string.append(aLetterWord.character);
            }
        }
        return string.toString();
    }
}
