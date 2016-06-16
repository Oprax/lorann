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
        return MobileOrder.random();
    }
}
