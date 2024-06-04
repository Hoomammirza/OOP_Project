package UserManagement;

public class TimerException extends Exception{
    public int time;
    public TimerException(int time){
        this.time = time;
    }
}
