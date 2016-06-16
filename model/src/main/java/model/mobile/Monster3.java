package model.mobile;

import contract.IElement;
import contract.IMonster;
import contract.MobileOrder;

import java.awt.Point;

/**
 * Created by Yog on 14/06/2016.
 */
public class Monster3 extends Mobile implements IMonster {
    public Monster3(Point pos)
    {
        super("monster_3.png", true, pos);
    }

    @Override
    public MobileOrder getDirection(Point heroPos, IElement[][] tileMap) {
        return MobileOrder.random();
    }
}
