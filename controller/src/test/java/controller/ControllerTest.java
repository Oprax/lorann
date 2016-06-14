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
        this.view.setController(controller);
    }
    
    @Test
    public void TestParserTestMap() throws Exception {
        String[][] map = this.controller.parser("BVHPL\n" +
                "1234 \n" +
                "CO   ");

        String[][] expectedMap = {
                {"bone.png", "vertical_bone.png", "horizontal_bone.png", "purse.png", "lorann_b.png"},
                {"monster_1.png", "monster_2.png", "monster_3.png", "monster_4.png", ""},
                {"gate_closed.png", "gate_open.png", "", "", ""}
        };
        assertArrayEquals(map, expectedMap);
    }

    @Test
    public void TestParserLoadMap() throws Exception {
        this.model.loadMap("TEST");
        String[][] map = this.controller.parser(
                this.model.getMap()
        );
        String[][] expectedMap = {
                {"bone.png", "vertical_bone.png", "horizontal_bone.png", "purse.png", "lorann_b.png"},
                {"monster_1.png", "monster_2.png", "monster_3.png", "monster_4.png", ""},
                {"gate_closed.png", "gate_open.png", "", "", ""}
        };
        assertArrayEquals(map, expectedMap);
    }
}