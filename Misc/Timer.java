package Misc;

public class Timer {
    long targettime;
    public Timer(double duration){
        targettime = System.currentTimeMillis() + targettime;
    }
    public boolean running(){
        return System.currentTimeMillis() >= targettime;
    }
    public long getTimeRemaining(){
        return targettime - System.currentTimeMillis();
    }
}
