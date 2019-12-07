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

public class ClockFace  {

    private Clock myClcok;

    public ClockFace(Clock aClock) {
        this.myClcok = aClock;
    }
}