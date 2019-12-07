package coursework;

import java.time.LocalDate;


public class StockItem {
    private final String ticker;
    private final LocalDate date;
    private final double open;
    private final double high;
    private final double low;
    private final double close;
    private final long volume;

    public StockItem(String ticker, LocalDate date, double open, double high, double low, double close, long volume) {
        this.ticker = ticker;
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public long getVolume() {
        return this.volume;
    }

    public String getTicker() {
        return this.ticker;
    }

    public double getHigh() {
        return this.high;
    }

    public double getLow() {
        return this.low;
    }

    public double getOpen() {
        return this.open;
    }

    public double getClose() {
        return this.close;
    }
}