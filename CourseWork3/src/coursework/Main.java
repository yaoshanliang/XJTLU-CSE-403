package coursework;

import coursework.DateDispaly;
import java.time.Clock;
import java.time.Duration;
import java.time.ZoneId;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Main {
    static DateDispaly dateDispaly;

    protected static int width = 1000;
    protected static int height = 400;
    private static Locale locale = Locale.getDefault();
    protected static String ticker = "XOM";
    protected static int year = 2010;

    public static void main(String[] args) throws Exception {
        System.out.println(locale);

        // Display the date
        dateDispaly = new DateDispaly(0, 0, width, height);

        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(width, height);
        f.setVisible(true);
        f.add(dateDispaly);

        Stock stock = new Stock(ticker, year, locale);// Get ticker

        dateDispaly.getListOfDisplayables().add(stock);

        // Add a timer 
        Timer timer = new Timer(1000, dateDispaly);
        timer.start();
    }
}