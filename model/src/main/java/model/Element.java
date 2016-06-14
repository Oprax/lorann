package model;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Yog on 13/06/2016.
 */
public abstract class Element {
    private int         x = 5;
    private int         y = 5;
    private Image       image = null;
    private ImageIcon   imageIcon = null;
    private boolean     permeability;

    public Element(int x, int y, String path, final boolean permeability)
    {
        this.x = x;
        this.y = y;
        if (path == null) {
            System.out.println("/!\\ERROR/!\\SPRITE PATH FOR " + x + y + " IMAGE IS NULL/!\\ERROR/!\\");
        }
        this.imageIcon = new ImageIcon(path);
        this.image = this.imageIcon.getImage();
        this.permeability = permeability;
    }

    public Image getImage()
    {
        return this.image;
    }

    public boolean getPermeability()
    {
        return permeability;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }
}
