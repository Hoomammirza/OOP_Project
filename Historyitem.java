import UserManagement.User;
import com.mysql.cj.conf.HostInfo;

import java.sql.Date;
import java.sql.Time;

public class Historyitem {
    User Host;
    User Guest;
    boolean Hostwin;
    Date date;
    Time time;
    int Hostlevel;
    int Guestlevel;
    int HostCoin;
    int HostXP;
    int GuestCoin;
    int GuestXP;

    public Historyitem(User Host,User Guest,boolean Hostwin,Date date,Time time,int Hostlevel,int Guestlevel,int HostCoin,int HostXP,int GuestCoin,int GuestXP) {
        this.Host = Host;
        this.Guest = Guest;
        this.date = date;
        this.time = time;
        this.Hostlevel = Hostlevel;
        this.Guestlevel = Guestlevel;
        this.Hostwin = Hostwin;
        this.HostCoin = HostCoin;
        this.HostXP = HostXP;
        this.GuestCoin = GuestCoin;
        this.GuestXP = GuestXP;
    }

    public String print(User user) {
        if (user.Username.equals(Host.Username)){

        }else {

        }
    }
}
