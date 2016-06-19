package model.mobile;

import contract.*;

import java.awt.*;
import java.util.ArrayList;

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
/*
        Point pos = this.getPos().getLocation();
        Point curPos = pos.getLocation();

        ArrayList<IElement> open = new ArrayList<IElement>();
        open.add(tileMap[curPos.x][curPos.y]);

        ArrayList<IElement> close = new ArrayList<IElement>();

        while(!open.isEmpty()) {
        }
*/
        return MobileOrder.random();
    }
}
