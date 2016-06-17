package model.mobile;

import contract.IElement;
import contract.IMonster;
import contract.MobileOrder;

import java.awt.*;

/**
 * Created by Yog on 14/06/2016.
 */
public class Monster1 extends Mobile implements IMonster {
    public Monster1(Point pos)
    {
        super("monster_1.png", true, pos);
    }

    @Override
    public MobileOrder getDirection(Point heroPos, IElement[][] tileMap) {
        Point pos = this.getPos().getLocation();

        System.out.printf("Hero : %s%n", heroPos);
        System.out.printf("Monster : %s%n", pos);

        MobileOrder direction = MobileOrder.random();

        if(pos.x == heroPos.x) {
            if(pos.y > heroPos.y) {
                direction = MobileOrder.Left;
            } else if (pos.y < heroPos.y) {
                direction = MobileOrder.Right;
            }
        } else if(pos.y == heroPos.y) {
            if(pos.x > heroPos.x) {
                direction = MobileOrder.Up;
            } else if (pos.x < heroPos.x) {
                direction = MobileOrder.Down;
            }
        } else if (pos.x < heroPos.x) {
            if(pos.y > heroPos.y) {
                direction = MobileOrder.Down;
            } else if (pos.y < heroPos.y) {
                direction = MobileOrder.Left;
            }
        }

        System.out.printf("Dir : %s%n", direction);

        return direction;
    }
}
