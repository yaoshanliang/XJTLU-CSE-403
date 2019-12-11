package coursework;

import coursework.StockItem;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;

public class Stock extends JPanel implements ActionListener, Displayable {

    private static final long serialVersionUID = 1L;
    private static ArrayList<StockItem> myQuotes = new ArrayList<>();
    private ArrayList<StockItem> tickerData = new ArrayList<>();
    private Locale locale;
    private String ticker;
    private int year;
    private JFrame jFrame;
    private static long maxVolume = 0;
    private static double highest = 0;
    private static double lowest = 100000;
    private static int totalNumber = 0;
    private static int currentNumber = 0;

    public Stock(String ticker, int year, Locale locale, JFrame j) {
        System.out.println(ticker + year);
        this.ticker = ticker;
        this.year = year;
        this.locale = locale;
        this.jFrame = j;

        try {
            // Read data from price file
            BufferedReader in = new BufferedReader(new FileReader("priceData.txt"));
            String line;
            while ((line = in.readLine()) != null) {

                // Process the string to get each variables
                String[] array = line.split(",");
                String[] date = array[1].split("/");
                int year1 = Integer.parseInt("20" + date[2]);
                int month = Integer.parseInt(date[1]);
                int day = Integer.parseInt(date[0]);

                // New a stock object and then push it into the arraylist
                StockItem stockItem = new StockItem(array[0], LocalDate.of(year1, month, day), Double.valueOf(array[2]),
                        Double.valueOf(array[3]), Double.valueOf(array[4]), Double.valueOf(array[5]),
                        Long.valueOf(array[6]));

                myQuotes.add(stockItem);

            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Draw graphics to show the change in values
    public void drawGraphics(Graphics g2) {
        maxVolume = 0;
        highest = 0;
        lowest = 100000;
        totalNumber = 0;
        tickerData = new ArrayList<>();
        myQuotes.stream().filter(si -> (si.getTicker().equals(this.ticker)) && (si.getDate().getYear() == this.year))
                .forEach(si -> {
                    tickerData.add(si);

                    // Get the max volume and highest price for later calculation to fit the screen
                    if (si.getVolume() > maxVolume) {
                        maxVolume = si.getVolume();
                    }
                    if (si.getHigh() > highest) {
                        highest = si.getHigh();
                    }
                    if (si.getLow() < lowest) {
                        lowest = si.getLow();
                    }

                    // Get the total number of the given ticker for later calculation to get the interval of each bar
                    totalNumber++;
                });

        // Calculate position of each data to fit the screen of 1000x400
        int height = 1;
        int width = 5;
        int initTop = 100;
        int top = 0;
        Color color;
        int lastCloseLeft = 0;
        int lastCloseTop = 0;

        int interval = (800 - tickerData.size() * width) / tickerData.size();
        int left = (1000 - ((interval + width) * tickerData.size())) / 2;
        double heightStep = 200 / (highest - lowest);

        // Get the root panel and then draw bars and lines
        Graphics g = this.jFrame.getRootPane().getGraphics();
        for (int i = 0; i < tickerData.size(); i++) {
            if (i < currentNumber) {
                StockItem si = tickerData.get(i);

                // Get correct color of up and down according to the current locate
                if (si.getOpen() > si.getClose()) {
                    color = this.getDownColorByLocale();
                } else {
                    color = this.getUpColorByLocale();
                }

                // Calculate the position of high and low price and draw bars
                top = (int) (initTop + (highest - si.getHigh()) * heightStep);
                height = (int) ((si.getHigh() - si.getLow()) * heightStep);
                g.setColor(color);
                g.drawRect(left, top, width, height);
                g.fillRect(left, top, width, height);

                // Calculate the position of volume and draw bars
                double volumeInterval = (double) 80 / maxVolume;
                double volumeHeight = volumeInterval * si.getVolume();
                int volumeTop = (int) (400 - volumeHeight); 
                g.drawRect(left, volumeTop, width, (int) volumeHeight);
                g.fillRect(left, volumeTop, width, (int) volumeHeight);

                // Draw lines of the price between dates
                if (lastCloseLeft > 0) {
                    g.setColor(new Color(9, 35, 122));
                    g.drawLine(lastCloseLeft, lastCloseTop, left, top);
                }

                // Calculate the interval of each data
                lastCloseLeft = left + 2;
                lastCloseTop = (int) (initTop + (highest - si.getClose()) * heightStep);
                left += interval + width - 2;
            }

        }

        // System.out.println(maxVolume);
        // System.out.println(highest);
        // System.out.println(lowest);
        // System.out.println(totalNumber);

        Font font = new Font("SANS-SERIF", Font.BOLD, 15);
        g2.setFont(font);
        g2.setColor(new Color(9, 35, 122));

        // Show Current tiker info
        StockItem sc = tickerData.get(currentNumber);
        System.out.println("Current Date: " + sc.getDate().getYear() + " "  + sc.getDate().getMonth() + " " + sc.getDate().getDayOfMonth());
        g2.drawString("Year: " + sc.getDate().getYear(), 800, 30);
        g2.drawString("Month: " + sc.getDate().getMonth(), 800, 55);
        g2.drawString("Day: " + sc.getDate().getDayOfMonth(), 800, 80);
        g2.drawString("Ticker: " + this.ticker, 800, 110);
        g2.drawString("Locale: " + this.locale, 800, 135);

        // Show price and volume
        font = new Font("SANS-SERIF", Font.BOLD, 20);
        g2.setFont(font);
        g2.drawString("Price", 20, 180);
        g2.drawString("Volume", 20, 370);

        if (currentNumber < tickerData.size() - 1) {
            currentNumber++;
        }
    }

    // Get the color of the upward trend by the default locale
    public Color getUpColorByLocale() {
        if (this.locale.toString().equals("zh_CN_#Hans")) {
            return new Color(255, 1, 3);
        } else {
            return new Color(0, 128, 0);
        }
    }

    // Get the color of the down trend by the default locale
    public Color getDownColorByLocale() {
        if (this.locale.toString().equals("zh_CN_#Hans")) {
            return new Color(0, 128, 0);
        } else {
            return new Color(255, 1, 3);
        }
    }

    @Override
    public void getDisplayable(Graphics g) {
        drawGraphics(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}