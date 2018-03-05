package labs.lab4;

public class Sentence {
    public Word[] sentence;

    Sentence(Word[] words) throws Exception{
        if (!words[words.length - 1].wordIsSeparator){
            throw new NotEndedSentenceException();
        }else {
            sentence = words;
        }
    }
}
