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
import java.util.Date;
import java.util.List;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import coursework.DisplayHost;

public class DateDispaly extends JPanel implements ActionListener, DisplayHost {

    private static final long serialVersionUID = 1L;

    private Clock clock;
    private final int x, y;
    private final int width, height;
    private static int displayStatus = 0;

    private List<Displayable> myDisplayables = new ArrayList<>();

    public DateDispaly(int x, int y, int w, int h) {
        super();
        this.setLocation(x, y);
        this.setSize(w, h);
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }

    public void actionPerformed(ActionEvent e) {
        repaint(0, 0, 1000, 100);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(new Color(200, 100, 100));
        Font ClockFont = new Font("SANS-SERIF", Font.BOLD, 20);
        g.setFont(ClockFont);
        Date date = new Date();
        String dateString = date.toString();
        FontMetrics fm = g.getFontMetrics();
        int stringWidth = fm.stringWidth(dateString);
        g.drawString(dateString, this.getWidth() / 2 - stringWidth / 2 - 100, 30);
    
        for (Displayable disp : myDisplayables) {
            disp.getDisplayable(g);
        }
    }

    @Override
    public List<Displayable> getListOfDisplayables() {
        return myDisplayables;
    }
    

}