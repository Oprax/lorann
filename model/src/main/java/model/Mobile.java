package model;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Yog on 13/06/2016.
 */
public class Mobile extends Element {
    private int x;
    private int y;
    private int dx = 0;
    private int dy = 0;

    public Mobile(String imagePath, int x, int y, final boolean permeability) {
        super(x, y, imagePath, permeability);
        this.x = x;
        this.y = y;
    }

    public void move()
    {
        this.x += this.dx;
        this.y += this.dy;
    }
}
