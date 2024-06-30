package UserManagement;

public class WeakPasswordException extends Exception{
    public String message;
    public WeakPasswordException(String message){
        this.message = message;
    }
}
