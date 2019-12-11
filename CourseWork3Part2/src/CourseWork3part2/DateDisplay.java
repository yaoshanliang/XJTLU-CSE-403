/*
 */
package CourseWork3part2;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JPanel;

public class DateDisplay extends JPanel implements ActionListener{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final int myX, myY;
    private final int myWidth,myHeight;
    
    Date dateD;

    public DateDisplay (int myX, int myY, int myWidth, int myHeight, Date date){
        super();
        this.myX = myX;
        this.myY = myY;
        this.myWidth = myWidth;
        this.myHeight = myHeight;
        this.dateD = date;
        this.setLocation(myX, myY);
        this.setSize(myWidth, myHeight);
    }
        @Override   
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(200, 100, 100));
        Font font = new Font("SANS-SERIF", Font.BOLD, 30);
        
        g.setFont(font);
        FontMetrics fm = g.getFontMetrics();
        String str = "dd-mm-yyyy";
        int stringWidth = fm.stringWidth(str);
        int stringDescent = fm.getMaxDescent();
        g.drawString(dateD.toString(), this.getWidth() / 2 - stringWidth / 2, 50);

        g.setColor(new Color(100, 100, 100));

        g.drawString("APPL", 480, 300);
        readstock read = new readstock();
        int data[][] = read.getClose();
        for(int i = 1; i < data.length; i++) {
            g.setColor(new Color(90, 35, 122));
            g.drawLine(data[i-1][0], data[i-1][1], data[i][0], data[i][1]);
        }

        int data2[][] = read.getOpen();
        for(int i = 1; i < data2.length; i++) {
            g.setColor(new Color(90, 85, 22));
            g.drawLine(data2[i-1][0], data2[i-1][1], data2[i][0], data2[i][1]);
        }

    }
    
    @Override
    public int getX(){
        return myX;
    }
    
    @Override
    public int getY(){
        return myY;
    }
    
    @Override
    public int getWidth(){
        return myWidth;
    }
    
    @Override
    public int getHeight(){
        return myHeight;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
    
    
}
