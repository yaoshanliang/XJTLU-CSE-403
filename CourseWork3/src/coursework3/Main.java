package coursework3;

import coursework3.DateDispaly;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Main {
    static DateDispaly dateDispaly;
    protected static int width = 1000;
    protected static int height = 400;
    private static Locale locale = Locale.getDefault();// get current locale
    protected static String ticker = "XOM";// default ticker number
    protected static int year = 2010;// default year

    public static void main(String[] args) throws Exception {
        System.out.println(locale);

        // Init the JFrame
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(width, height);

        // Display the date
        dateDispaly = new DateDispaly(0, 0, width, height);

        // Add stock to the display
        Stock stock = new Stock(ticker, year, locale, f);
        dateDispaly.getListOfDisplayables().add(stock);
        f.add(dateDispaly);

        // Add a timer 
        Timer timer = new Timer(1000, dateDispaly);
        timer.start();

        f.setVisible(true);
    }
}