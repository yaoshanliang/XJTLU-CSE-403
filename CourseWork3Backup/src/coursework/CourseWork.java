package coursework;

import coursework.Weather;
import coursework.ClockDispaly;
import java.time.Clock;
import java.time.Duration;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.Timer;

public class CourseWork {
    static ClockDispaly clockDispaly;
    static List<Writeable> myWidgets = new ArrayList<>();
    public static void main(String[] args) throws Exception {

        // New a weather object, and then get the json string 
        String city = "Suzhou";
        Weather weather = new Weather(city);// Get Suzhou weather

        Clock clock = Clock.system(ZoneId.of("Asia/Shanghai"));// Set timezone to Shanghai
        Clock ticClock = Clock.tick(clock, Duration.ofSeconds(1));

        // Display the clock
        clockDispaly = new ClockDispaly(0, 0, 600, 300, ticClock, city);

        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 300);
        f.setVisible(true);
        f.add(clockDispaly);

        // Add a timer 
        Timer timer = new Timer(1000, clockDispaly);
        timer.start();

        // Timer weatherTimer = new Timer(1000 * 60 * 60 * 2, weather);
        // weatherTimer.start();

        clockDispaly.getListOfDisplayables().add(weather);
    }

    public static void saveWidgets() {
        for (Writeable w : myWidgets) {
            w.saveToDisk();
        }
    }
}