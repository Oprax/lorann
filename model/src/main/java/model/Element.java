package model;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Yog on 13/06/2016.
 */
public abstract class Element {
    private int         x;
    private int         y;
    private Image       image = null;
    private ImageIcon   imageIcon = null;
    private boolean     permeability;

    public Element(String path, final boolean permeability)
    {
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


}
