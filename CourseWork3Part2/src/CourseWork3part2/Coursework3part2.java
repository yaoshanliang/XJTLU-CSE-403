

package CourseWork3part2;

import java.time.Clock;
import java.time.Duration;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.Timer;


public class Coursework3part2 {
    static DateDisplay DateDisplay;
            
    public static void main(String[] args) {
//        Stockclass stock = new Stockclass("");
        Clock clock= Clock.system(ZoneId.of("GB"));
        Clock tickClock=Clock.tick(clock, Duration.ofDays(1));
        Date date = new Date();
       DateDisplay clockD = new DateDisplay (0,0,800,300, date);
       JFrame f = new JFrame();
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       f.setSize(1000,400);
       f.setVisible(true);
       f.add(clockD);
    //    Timer t = new Timer(1000, clockD);
    //    t.start();

        
    }
    
}
