package coursework;

import coursework.ClockDispaly;
import java.time.Clock;
import java.time.Duration;
import java.time.ZoneId;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Main {
    static ClockDispaly clockDispaly;

    protected static int width = 1000;
    protected static int height = 400;
    private static Locale locale = Locale.getDefault();
    protected static String ticker = "XOM";
    protected static int year = 2010;

    public static void main(String[] args) throws Exception {
        System.out.println(locale);

        Clock clock = Clock.system(ZoneId.of("Asia/Shanghai"));// Set timezone to Shanghai
        Clock ticClock = Clock.tick(clock, Duration.ofSeconds(1));

        // Display the clock
        clockDispaly = new ClockDispaly(0, 0, width, height, ticClock);

        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(width, height);
        f.setVisible(true);
        // f.setResizable(false);
        f.add(clockDispaly);

        // Add a timer 
        // Timer timer = new Timer(1000, clockDispaly);
        // timer.start();

        Stock stock = new Stock(ticker, year);// Get ticker

        clockDispaly.getListOfDisplayables().add(stock);
    }
}