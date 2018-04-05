package labs.lab4.test;

import labs.lab4.AlphabetSymbol;
import labs.lab4.NonResolvedSymbolException;
import labs.lab4.PunctuationSymbol;
import labs.lab4.Word;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordTest {

    @Test
    void WordFromAlphabetSymbolArray() throws Exception{
        char[] charset = {'w', 'o', 'r', 'd'};
        AlphabetSymbol[] alphabetSymbols = new AlphabetSymbol[charset.length];
        for (int i = 0; i < charset.length; i++) {
            alphabetSymbols[i] = new AlphabetSymbol(charset[i]);
        }
        Word word = new Word(alphabetSymbols);
        assertEquals(word.letterWord, alphabetSymbols);
        assertFalse(word.wordIsSeparator);
    }

    @Test
    void WordFromPunctuationSymbolArray() throws Exception{
        char[] charset = {'!', '?', ' '};
        PunctuationSymbol[] punctuationSymbols = new PunctuationSymbol[charset.length];
        for (int i = 0; i < charset.length; i++) {
            punctuationSymbols[i] = new PunctuationSymbol(charset[i]);
        }
        Word word = new Word(punctuationSymbols);
        assertEquals(word.separatorWord, punctuationSymbols);
        assertEquals(word.toString(), "!? ");
        assertTrue(word.wordIsSeparator);
    }

    @Test
    void addAlphaCharSuccess() throws Exception{
        char[] charset = {'w', 'o', 'r', 'd'};
        AlphabetSymbol[] alphabetSymbols = new AlphabetSymbol[charset.length];
        for (int i = 0; i < charset.length; i++) {
            alphabetSymbols[i] = new AlphabetSymbol(charset[i]);
        }
        Word word = new Word(alphabetSymbols);
        assertTrue(word.addAlphaChar(new AlphabetSymbol('s')));
        assertEquals(word.letterWord[word.letterWord.length - 1].character, 's');
        assertEquals(word.toString(), "words");
    }

    @Test
    void  addAlphaCharToSeparatorWord() throws Exception{
        char[] charset = {'!', '?', ' '};
        PunctuationSymbol[] punctuationSymbols = new PunctuationSymbol[charset.length];
        for (int i = 0; i < charset.length; i++) {
            punctuationSymbols[i] = new PunctuationSymbol(charset[i]);
        }
        Word word = new Word(punctuationSymbols);
        assertFalse(word.addAlphaChar(new AlphabetSymbol('c')));
    }


    @Test
    void addPunctCharSuccess() throws NonResolvedSymbolException{
        char [] charset = {'!', '?', ' '};
        PunctuationSymbol[] punctuationSymbols = new PunctuationSymbol[charset.length];
        for (int i = 0; i < charset.length; i++) {
            punctuationSymbols[i] = new PunctuationSymbol(charset[i]);
        }
        Word word = new Word(punctuationSymbols);
        assertTrue(word.addPunctChar(new PunctuationSymbol('?')));
        assertFalse(word.addAlphaChar(new AlphabetSymbol('c')));
        assertEquals("!? ?", word.toString());
    }

    @Test
    void wordFromStringTest() throws NonResolvedSymbolException{
    String alphaString = "word";
    String sepString = "!? ";
    assertEquals(new Word(alphaString).toString() ,"word");
    assertFalse(new Word(alphaString).wordIsSeparator);
    assertEquals(new Word(sepString).toString(), "!? ");
    assertTrue(new Word(sepString).wordIsSeparator);
    }
}