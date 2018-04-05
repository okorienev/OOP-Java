package labs.lab4;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Oleksandr Korienev
 * class for storing text. Text is represented as Sentence[] array
 * can be constructed from Sentence[] array or parsed from StringBuffer using Text.textParser() method (returns Text object)
 * @see Sentence
 */
public class Text {
    private static Pattern alphaWordPattern = Pattern.compile("[a-zA-Z]+");
    private static Pattern separatorWordPattern = Pattern.compile("[.,?!:;' -]+");
    public Sentence[] text;

    /**
     *
     * @param sentences Sentence[] array
     */
    public Text(Sentence[] sentences) {
        text = sentences;
    }

    public void addSentence(Sentence sentence) {
        Sentence[] newText = new Sentence[text.length + 1];
        System.arraycopy(text, 0, newText, 0, text.length);
        newText[newText.length - 1] = sentence;
        text = newText;
    }

    @Override
    public String toString(){
        StringBuilder stringBuffer = new StringBuilder();
        for (Sentence s: text) {
            stringBuffer.append(s.toString());
        }
        return stringBuffer.toString();
    }

    /**
     * method to created new Text object from given StringBuffer
     * @param stringBuffer StringBuffer with text to parse
     * @return new Text object
     * @throws Exception if  text  contains non-resolved symbols
     * @// TODO: 18.03.2018 overload method for String and StringBuilder(optionally)
     * @// TODO: 18.03.2018 test parsing with JUnit(optionally)
     */
    public static Text textParser(StringBuffer stringBuffer) throws Exception {
        Matcher matcherAlpha = alphaWordPattern.matcher(stringBuffer.toString());
        Matcher matcherSeparator = separatorWordPattern.matcher(stringBuffer.toString());
        Word[] sentenceStartStub = {new Word(" "), new Word(" ")};
        Sentence[] textStartStub = {new Sentence(sentenceStartStub), new Sentence(sentenceStartStub)};
        Text text = new Text(textStartStub);
        Sentence sentence = new Sentence(sentenceStartStub);
        boolean textEndedFlag = false;
        while (!textEndedFlag){
            if(matcherAlpha.find()){
                sentence.addWord(new Word(matcherAlpha.group()));
                //System.out.println(matcherAlpha.group());
            }
            if(matcherSeparator.find()){
                sentence.addWord(new Word(matcherSeparator.group()));
                //System.out.println(matcherSeparator.group());
                if(sentence.sentenceEndedFlag){
                    Word[] newSentence = new Word[sentence.sentence.length - 2];
                    System.arraycopy(sentence.sentence, 2, newSentence, 0, newSentence.length);
                    text.addSentence(new Sentence(newSentence));
                    sentence = new Sentence(sentenceStartStub);
                }
            }else textEndedFlag = true;
        }
        Sentence[] newText = new Sentence[text.text.length -2];
        System.arraycopy(text.text, 2, newText, 0, newText.length);
        return new Text(newText);
    }
}
