package labs.lab3;

        import java.io.File;
        import java.io.FileNotFoundException;
        import java.util.Scanner;
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
                string.append(in.nextLine()).append(' ');
            }
            return string;
        } catch (FileNotFoundException e) {
            return new StringBuffer();
        }
    }

    private static StringBuffer findFirstSentence(StringBuffer text){
        Pattern pattern = Pattern.compile("([a-z]((\\.{3})|(\\?!))( )+)|([a-z][.?!]( )+)"); //regex for sentence ending
        Matcher matcher = pattern.matcher(text.toString());
        if (matcher.find()){
            return new StringBuffer(text.substring(0, matcher.end()));
        }else{
            return new StringBuffer();
        }
    }
    private static StringBuffer[] splitIntoWords(StringBuffer sentence){
        StringBuffer[] words = new StringBuffer[sentence.toString().split("\\s").length];
        int i = 0;

        for (String s : sentence.toString().split("\\s")) {
            words[i] = new StringBuffer(s.replaceAll("[.,]", ""));
            i++;
        }
        return words;
    }
    public static void main(String[] args) {
        Pattern pattern;
        Matcher matcher;

        StringBuffer text = getString(path);
        StringBuffer[] words = splitIntoWords(findFirstSentence(text));
        for (StringBuffer word : words) {
            pattern = Pattern.compile(word.toString().toLowerCase());
            matcher = pattern.matcher(text.toString().toLowerCase());
            int counter = 0;
            while (matcher.find()){
                counter ++;
                if (counter > 1 ) {
                    break;
                }
            }
            if (counter == 1){
                System.out.println(word.toString());
            }
        }
    }
}
