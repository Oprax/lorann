package controller;

import contract.IController;
import contract.IModel;
import model.Model;
import view.View;
import contract.IView;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Hashtable;

import static org.junit.Assert.*;

public class ControllerTest {

    private IModel model;
    private IView view;
    private IController controller;

    /**
     * Sets the up.
     *
     * @throws Exception
     *           the exception
     */
    @Before
    public void setUp() throws Exception {
        this.model = new Model();
        this.view = new View(this.model);
        this.controller = new Controller(this.view, this.model);
    }
    
    @Test
    public void TestControl() throws Exception {

    }

    @Test
    public void TestOrderPerform() throws Exception {

    }
    
    @Test
    public void TestParser() throws Exception {
        String[][] map = this.controller.parser("B V H P L\n" +
                "1 2 3 4  \n" +
                "C O      ");

        String[][] expectedMap = {
                {"bone.png", "", "vertical_bone.png", "", "horizontal_bone.png", "", "purse.png", "", "lorann_b.png"},
                {"monster_1.png", "", "monster_2.png", "", "monster_3.png", "", "monster_4.png", "", ""},
                {"gate_closed.png", "", "gate_open.png", "", "", "", "", "", ""}
        };

        assertArrayEquals(map, expectedMap);
    }
}