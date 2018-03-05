package labs.lab4;

public class NotEndedSentenceException extends Exception{
    public NotEndedSentenceException(){

    }
    public NotEndedSentenceException(String message){
        super(message);
    }
}
