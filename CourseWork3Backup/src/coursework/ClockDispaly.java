package coursework;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Clock;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import coursework.DisplayHost;

public class ClockDispaly extends JPanel implements ActionListener, DisplayHost {

    private static final long serialVersionUID = 1L;

    private Clock clock;
    private final int x, y;
    private final int width, height;
    // private final Image myImage;
    private String city;

    private List<Displayable> myDisplayables = new ArrayList<>();

    public ClockDispaly(int x, int y, int w, int h, Clock clock, String city) {
        super();
        this.clock = clock;
        this.setLocation(x, y);
        this.setSize(w, h);
        this.setBackground(Color.BLACK);
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.city = city;
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;

    }

    public void paint(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(200, 100, 100));
        Font font = new Font("SANS-SERIF", Font.BOLD, 50);
        g.setFont(font);
        g.drawString(this.city, 200, 80);

        Font ClockFont = new Font("SANS-SERIF", Font.BOLD, 100);
        g.setFont(ClockFont);
        FontMetrics fm = g.getFontMetrics();
        String str = "00:00:00";
        int stringWidth = fm.stringWidth(str);
        g.drawString(LocalTime.now(clock).toString(), this.getWidth() / 2 - stringWidth / 2, 200);
    
        int x = 0, y = 0;
        System.out.print(myDisplayables);
        for (Displayable disp : myDisplayables) {
            BufferedImage image = disp.getDisplayable();
            g.drawImage(image, x, y, null);
            y = y + image.getHeight();
        }
    }

    public static BufferedImage readImage(String filename) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(filename));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    @Override
    public List<Displayable> getListOfDisplayables() {

        System.out.println(myDisplayables);
        return myDisplayables;
    }
    

}