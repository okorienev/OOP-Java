package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static String path = "example.txt";

    private static StringBuffer getString(String path){
        // reads text from given file, returns StringBuffer object
        Scanner in;
        StringBuffer string;
        try {
            in = new Scanner(new File(path));
            string = new StringBuffer();
            while (in.hasNext()){
                string.append(in.nextLine() + ' ');

            }
            return string;
        } catch (FileNotFoundException e) {
            return new StringBuffer();
        }
    }

    private static LinkedList splitIntoSentences(StringBuffer text){
        Pattern pattern = Pattern.compile("([a-z]((\\.{3})|(\\?!))( )+)|([a-z][.?!]( )+)"); //regex for sentence ending
        LinkedList<StringBuffer> sentenceList = new LinkedList<>(); //LinkedList to store sentences
            StringBuffer sentence = new StringBuffer(); // current sentence
            for (int i =0; i < text.length(); i++){ //Loop iterating StringBuffer object
                sentence.append(text.charAt(i)); // appending characters to sentence
                Matcher matcher = pattern.matcher(sentence.toString()); //re-initialising Matcher for regex
                if (matcher.find()){
                    sentenceList.add(sentence); //adding sentence to the list
                    sentence = new StringBuffer(); // re-initialising buffer
                }

            }
        return sentenceList;
    }

    private static LinkedList<StringBuffer> splitIntoWords(StringBuffer sentence){
        LinkedList<StringBuffer> wordsList = new LinkedList<>();
        StringBuffer word = new StringBuffer();
        String symbols[] = {" ", ",",".", "?", "!", "\'","\""}; //symbols to split sentence into words
        HashSet<String> nonResolvedSymbols = new HashSet<>(Arrays.asList(symbols));
        for (int i = 0; i< sentence.length(); i++){
            if(!nonResolvedSymbols.contains("" + sentence.charAt(i))){
                word.append(sentence.charAt(i));
            }else{
                if(word.length()!=0){
                    wordsList.add(new StringBuffer(word.toString().toLowerCase()));
                    word = new StringBuffer();
                }
            }
        }
        return wordsList;
    }

    public static void main(String[] args) {
        StringBuffer string = new StringBuffer(getString(path));
        LinkedList<StringBuffer> sentenceList = splitIntoSentences(string);
        LinkedList<StringBuffer> firstSentenceWords = splitIntoWords(sentenceList.getFirst());
        sentenceList.removeFirst();
        for(int i = 0; i < firstSentenceWords.size(); i++){
            StringBuffer operator = firstSentenceWords.get(i);
            boolean flag = true;
            for(int j = 0; j < sentenceList.size(); j++){
                if (sentenceList.get(j).indexOf(operator.toString()) != -1){
                    flag = false;
                    break;
                }
            }
            if(flag) System.out.println(operator);
        }
    }

}
