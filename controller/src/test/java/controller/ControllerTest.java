package controller;

import contract.IController;
import contract.IElement;
import contract.IModel;
import model.Model;
import model.mobile.*;
import model.motionless.*;
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
    private IElement[][] expectedMap;

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
        this.view.setController(controller);/*
        this.expectedMap = new IElement[][]{
                {assocSprite.get('B'), assocSprite.get('V'), assocSprite.get('H'), assocSprite.get('P'), assocSprite.get('L')},
                {assocSprite.get('1'), assocSprite.get('2'), assocSprite.get('3'), assocSprite.get('4'), assocSprite.get(' ')},
                {assocSprite.get('C'), assocSprite.get('O'), assocSprite.get(' '), assocSprite.get(' '), assocSprite.get(' ')}
        };*/
    }
    
    @Test
    public void TestParserTestMap() throws Exception {/*
        IElement[][] map = this.controller.parser("BVHPL\n" +
                "1234 \n" +
                "CO   ");
        assertArrayEquals(this.expectedMap, map);*/
    }

    @Test
    public void TestParserLoadMap() throws Exception {/*
        this.model.loadMap("TEST");
        IElement[][] map = this.controller.parser(
                this.model.getMap()
        );
        assertArrayEquals(this.expectedMap, map);*/
    }
}