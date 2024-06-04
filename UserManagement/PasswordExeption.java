package UserManagement;

public class PasswordExeption extends Exception {
    public PasswordExeption(){};
    public PasswordExeption(String message){
        super(message);
    }
}
