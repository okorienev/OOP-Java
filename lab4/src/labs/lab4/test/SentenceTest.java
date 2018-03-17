package labs.lab4.test;

import labs.lab4.Sentence;
import labs.lab4.Word;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SentenceTest {

    @Test
    public void SentenceTest1() throws Exception {
        String[] strings = {"In", " ", "a", " ", "hole", " ", "in", " ", "the", " ", "ground", " ", "there", " ",
                "lived", " ", "a", " ", "hobbit", "."};
        Word[] words = new Word[strings.length];
        for(int i = 0; i < strings.length; i++){
            words[i] = new Word(strings[i]);
        }
        Sentence sentence = new Sentence(words);
        assertEquals("In a hole in the ground there lived a hobbit.", sentence.toString());
        assertTrue(sentence.sentenceEndedFlag);
        assertFalse(sentence.addWord(new Word("abba")));
    }

    @Test
    public void SentenceTest2() throws Exception{
        String[] strings = {"In", " ", "a", " ", "hole", " ", "in", " ", "the", " ", "ground", " ", "there", " ",
                "lived", " ", "a", " ", "hobbit",};
        Word[] words = new Word[strings.length];
        for(int i = 0; i < strings.length; i++){
            words[i] = new Word(strings[i]);
        }
        Sentence sentence = new Sentence(words);
        assertEquals("In a hole in the ground there lived a hobbit", sentence.toString());
        assertFalse(sentence.sentenceEndedFlag);
        sentence.addWord(new Word("."));
        assertEquals("In a hole in the ground there lived a hobbit.", sentence.toString());
        assertTrue(sentence.sentenceEndedFlag);
    }
}