package model.mobile;

import contract.IElement;
import contract.IHero;
import contract.IView;
import contract.MobileOrder;

import java.awt.*;

/**
 * Created by Yog on 14/06/2016.
 */
public class Hero extends Mobile implements IHero {
    public Hero(Point pos) {
        super("lorann_b.png", true, pos);
    }

    public void move(MobileOrder order, IElement[][] tileMap, IView view)
    {
        switch (order) {
            case Left:
                if(this.direction == MobileOrder.Left &&
                        this.pos.y > 0 &&
                        tileMap[this.pos.x][this.pos.y - 1].getPermeability())
                {
                    this.pos.setLocation(
                            this.pos.getX(),
                            this.pos.getY() - 1);
                } else {
                    this.loadSprite("sprite\\lorann_l.png");
                }
                break;
            case Right:
                if(this.direction == MobileOrder.Right &&
                        this.pos.y < view.getWidth() / 32 - 1 &&
                        tileMap[this.pos.x][this.pos.y + 1].getPermeability())
                {
                    this.pos.setLocation(
                            this.pos.getX(),
                            this.pos.getY() + 1);
                } else {
                    this.loadSprite("sprite\\lorann_r.png");
                }
                break;
            case Up:
                if(this.direction == MobileOrder.Up &&
                        this.pos.x > 0 &&
                        tileMap[this.pos.x - 1][this.pos.y].getPermeability()) {
                    this.pos.setLocation(
                            this.pos.getX() - 1,
                            this.pos.getY());
                } else {
                    this.loadSprite("sprite\\lorann_u.png");
                }
                break;
            case Down:
                if(this.direction == MobileOrder.Down &&
                        this.pos.x < view.getHeight() / 32 - 1 &&
                        tileMap[this.pos.x + 1][this.pos.y].getPermeability()) {
                    this.pos.setLocation(
                            this.pos.getX() + 1,
                            this.pos.getY());
                } else {
                    this.loadSprite("sprite\\lorann_b.png");
                }
                break;
        }
        this.direction = order;
    }
}
