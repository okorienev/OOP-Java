package labs.lab4;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence {
    public Word[] sentence;
    public boolean sentenceEndedFlag;


    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        for (Word word : sentence) {
            result.append(word.toString());
        }
        return result.toString();
    }

    public boolean isSentenceEnded() throws Exception{
        //DEPRECATED
//        String[] endingConstructions ={".", "?", "!", "?!", "...", ". ", "? ", "! ", "?! ", "... "};
//        for (String s:endingConstructions) {
//            if(sentence[sentence.length - 1].toString().equals(s))
//                return true;
//        }
//        return false;
        return sentence[sentence.length - 1].toString().matches("(\\.|\\?|!|...|\\?!)\\s");
    }

    public Sentence(Word[] words) throws Exception{
        sentence = words.clone();
        sentenceEndedFlag = isSentenceEnded();
    }

    public boolean addWord(Word word) throws Exception{
        if (sentenceEndedFlag){
            return false;
        }else {
            Word[] newSentence = new Word[sentence.length + 1];
            System.arraycopy(sentence, 0, newSentence, 0, sentence.length);
            newSentence[newSentence.length - 1] = word;
            sentence = newSentence;
            sentenceEndedFlag = isSentenceEnded();
            return true;
        }
    }
}


