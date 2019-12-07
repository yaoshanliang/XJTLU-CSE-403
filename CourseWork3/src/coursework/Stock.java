package coursework;

import coursework.StockItem;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Stock extends JPanel implements ActionListener, Displayable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static ArrayList<StockItem> myQuotes = new ArrayList<>();
    private ArrayList<StockItem> tickerData = new ArrayList<>();
    private String ticker;
    private int year;
    private static long maxVolume = 0;
    private static double highest = 0;
    private static double lowest = 100000;
    private static int totalNumber = 0;

    private final int priceHeight = 200;
    private final int volumeHeight = 80;

    public Stock(String ticker, int year) {
        this.ticker = ticker;
        this.year = year;

        try {
            BufferedReader in = new BufferedReader(new FileReader("priceData.txt"));
            String line;
            while ((line = in.readLine()) != null) {
                String[] array = line.split(",");
                String[] date = array[1].split("/");
                int year1 = Integer.parseInt("20" + date[2]);
                int month = Integer.parseInt(date[1]);
                int day = Integer.parseInt(date[0]);

                StockItem stockItem = new StockItem(array[0], LocalDate.of(year1, month, day), Double.valueOf(array[2]),
                        Double.valueOf(array[3]), Double.valueOf(array[4]), Double.valueOf(array[5]),
                        Long.valueOf(array[6]));

                myQuotes.add(stockItem);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // getVolumesByTicker("XOM", 2009);
    }

    public static void main(String[] args) throws Exception {

    }

    // public static void printVolumesOnDate(LocalDate date) {
    // // for (StockPrice sp : myQuotes) {
    // // if (sp.getDate().equals(date)) {
    // // System.out.println(sp.getTicker() + " volume on " + date + " = " +
    // // sp.getVolume());
    // // }
    // // }
    // myQuotes.stream().filter(sp -> sp.getDate().equals(date))
    // .forEach(sp -> System.out.println(sp.getTicker() + " volume on " + date + " =
    // " + sp.getVolume()));
    // }

    // public static void printTotalVolumesForMonth(YearMonth month) {
    // long volume = 0;

    // volume = myQuotes.stream().filter(sp ->
    // YearMonth.from(sp.getDate()).equals(month))
    // .mapToLong(sp -> sp.getVolume()).sum();

    // System.out.println("Stream volume for " + month + " = " + volume);
    // }

    public void drawVolumesByTicker(Graphics g) {
        myQuotes.stream().filter(si -> (si.getTicker().equals(this.ticker)) && (si.getDate().getYear() == this.year))
                .forEach(si -> {
                    tickerData.add(si);
                    if (si.getVolume() > maxVolume) {
                        maxVolume = si.getVolume();
                    }
                    if (si.getHigh() > highest) {
                        highest = si.getHigh();
                    }
                    if (si.getLow() < lowest) {
                        lowest = si.getLow();
                    }
                    totalNumber++;
                });

        int height = 1;
        int width = 5;
        int initTop = 50;
        int top = 0;
        Color color;
        int lastCloseLeft = 0;
        int lastCloseTop = 0;

        // System.out.println(tickerData);
        int interval = (800 - tickerData.size() * width) / tickerData.size();
        int left = (1000 - ((interval + width) * tickerData.size())) / 2;
        double heightStep = 200 / (highest - lowest);
        System.out.println(heightStep);

        System.out.println("interval" + interval);
        for (int i = 0; i < tickerData.size(); i++) {
            StockItem si = tickerData.get(i);

            if (si.getOpen() > si.getClose()) {
                color = new Color(255, 1, 3);
            } else {
                color = new Color(0, 128, 0);
            }
            top = (int) (initTop + (highest - si.getHigh()) * heightStep);
            height = (int) ((si.getHigh() - si.getLow()) * heightStep);
            g.setColor(color);
            g.drawRect(left, top, width, height);
            g.fillRect(left, top, width, height);

            double volumeInterval = (double) 80 / maxVolume;
            System.out.println("volumeInterval" + volumeInterval);

            double volumeHeight = volumeInterval * si.getVolume();
            System.out.println("volumeHeight" + volumeHeight);

            int volumeTop = (int) (400 - volumeHeight);
            System.out.println("volumeTop" + volumeTop);

            g.drawRect(left, volumeTop, width, (int) volumeHeight);
            g.fillRect(left, volumeTop, width, (int) volumeHeight);


            if (lastCloseLeft > 0) {
                g.setColor(new Color(9, 35, 122));
                g.drawLine(lastCloseLeft, lastCloseTop, left, top);
            }
            
            lastCloseLeft = left + 2;

            lastCloseTop = (int) (initTop + (highest - si.getClose()) * heightStep);

            left += interval + width;
        }
        System.out.println(this.ticker);
        System.out.println(this.year);

        System.out.println(maxVolume);
        System.out.println(highest);
        System.out.println(lowest);
        System.out.println(totalNumber);

        g.drawString(ticker + " " + year, 780, 80);
        g.drawString("Price", 20, 180);
        g.drawString("Volume", 20, 370);

    }

    @Override
    public void getDisplayable(Graphics g) {
        drawVolumesByTicker(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // repaint();
    }
}