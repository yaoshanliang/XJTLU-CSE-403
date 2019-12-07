package coursework;

import coursework.JsonParse;
import coursework.ClockDispaly;
import coursework.Displayable;
import coursework.Writeable;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import java.awt.event.*;


public class Weather implements ActionListener, Displayable, Writeable {
    private static final String urlString = "https://api.openweathermap.org/data/2.5/weather?q=";
    private final String city;    //or London,uk
    private static final String id = "&appid=d4a29f09eb32e4e29bfca09e1e3b65d1";
    // private static final double K = 273.15; //kelvin to celsius

    public Weather(String city){
        this.city = city;
    }

    public void actionPerformed(ActionEvent e) {
        getDisplayable();
    }
    
    public BufferedImage getDisplayable() {
        String report = getReport();
        String iconId = parseWeather(report);
        BufferedImage icon = downloadIcon(iconId);
        System.out.println(icon);
        return icon;
    }
    
    public BufferedImage downloadIcon(String id){
        String iconUrl = 
        "http://openweathermap.org/img/wn/"+id+"@2x.png";
        System.out.println(iconUrl);
        BufferedImage icon = null;
        try {
            icon = ImageIO.read(new URL(iconUrl));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return icon;
    }
    
    public String parseWeather(String report){
        /*
        Use Json function from CW1
        */
        JsonParse json = new JsonParse(report);
        String string = json.getJsonInsideString("icon");

        return string;
    }
    
    public String getReport(){
        String queryString = urlString + city + id;
        System.out.println(queryString);
        URLConnection conn = null;
        try{
            URL url = new URL(queryString);
            conn = url.openConnection();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        String report = null;
        try(InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader rd = new BufferedReader(isr);){
            String line;
            while ((line = rd.readLine()) != null) {
                System.out.println("Reading: "+line);
                report = line;     //its JSON, so only one line
            }
            rd.close();       
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return report;
    }

    @Override
    public void saveToDisk() {
        // TODO Auto-generated method stub

    }
}