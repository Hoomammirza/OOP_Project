package Game;

public class AddCardException extends Exception{
    public String message;
    public AddCardException(String message){
        this.message = message;
    }
}
