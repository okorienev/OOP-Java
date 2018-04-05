package labs.lab4;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static String path = "example.txt";

    private static StringBuffer getString(String path){
        // reads text from given file, returns StringBuffer object
        Scanner in;
        StringBuffer string;
        try {
            in = new Scanner(new File(path));
            string = new StringBuffer();
            while (in.hasNext()){
                string.append(in.nextLine()).append(' ');
            }
            return string;
        } catch (FileNotFoundException e) {
            return new StringBuffer();
        }
    }

    private static Sentence findUniqueWords(Sentence sentence, Text text) throws Exception{
        int occurencteCounter;
        Word[] uniqueWords = {new Word(" "), new Word(" ")};
        Sentence result = new Sentence(uniqueWords);
        for (Word word: sentence.sentence) {
            occurencteCounter = 0;
            if (word.wordIsSeparator){
                continue;
            }
            for (int i =1; i < text.text.length; i++) {
                for(Word word1: text.text[i].sentence){
                    if(word1.toString().toLowerCase().equals(word.toString().toLowerCase())){
                        occurencteCounter +=1;
                    }
                }
            }
            if(occurencteCounter == 0){
                result.addWord(word);
                result.addWord(new Word(" "));
            }
        }
        Word [] newResult = new Word[result.sentence.length - 2];
        System.arraycopy(result.sentence, 2, newResult, 0, newResult.length);
        return new Sentence(newResult);
    }

    public static void main(String[] args) throws Exception{
        Text text = Text.textParser(getString(path));
        System.out.println(findUniqueWords(text.text[0], text));
        }
    }
