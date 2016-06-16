package model.mobile;

import contract.*;

import java.awt.*;

/**
 * Created by Yog on 14/06/2016.
 */
public class Monster2 extends Mobile implements IMonster {
    public Monster2(Point pos)
    {
        super("monster_2.png", true, pos);
    }

    @Override
    public MobileOrder getDirection(Point heroPos, IElement[][] tileMap) {
        return MobileOrder.random();
    }
}
