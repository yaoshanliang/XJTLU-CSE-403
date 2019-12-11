
package CourseWork3part2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;


public class readstock {
    private static ArrayList<StockPrice> myQuotes = new ArrayList();
    
    public readstock() {
        try {
            BufferedReader in = new BufferedReader(new FileReader("priceData.txt"));
            String str;
            while ((str = in.readLine()) != null) {
                String[] array = str.split(",");
                String[] date = array[1].split("/");
 
                if (array[0].equals("AAPL") && date[2].equals("10")) {
                    StockPrice stockprice = new StockPrice(array[0], LocalDate.of(Integer.parseInt("20" + date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0])), Double.valueOf(array[2]),
                    Double.valueOf(array[3]), Double.valueOf(array[4]), Double.valueOf(array[5]),
                    Long.valueOf(array[6]));
                    myQuotes.add(stockprice);
                }
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int[][] getClose() {
        int data[][] = new int [myQuotes.size()][2];
        int interval = 10;
        System.out.println(myQuotes.size());
        for (int i = 0; i < myQuotes.size(); i++) {
            data[i][0] = 200 + (interval * i);
            data[i][1] =(int)((300 - (int) myQuotes.get(i).getClose()) * 1.7);
        }

        return data;
    }    

    public int[][] getOpen() {
        int data[][] = new int [myQuotes.size()][2];
        int interval = 10;
        System.out.println(myQuotes.size());
        for (int i = 0; i < myQuotes.size(); i++) {
            data[i][0] = 200 + (interval * i);
            data[i][1] = (int)((300 - (int) myQuotes.get(i).getOpen()) * 1.7);
        }

        return data;
    }   
    
}
