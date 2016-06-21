package model.mobile;

import model.Element;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

/**
 * FireBall test class
 * @author Quentin Strinati
 */

public class FireBallTest {
    /**
     * FireBall object used for tests
     */
    private FireBall    fireBall;
    /**
     * Element object used for tests
     */
    private Element     element;

    /** Used to set up the test variables
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        this.fireBall = new FireBall(new Point(0, 0));
        this.element = new Element("fireball_1.png", false) {};
    }

    /** Testing the animate function
     * @throws Exception
     */
    @Test
    public void animate() throws Exception {
        Assert.assertEquals(1, this.fireBall.getStep());
        Assert.assertArrayEquals(((DataBufferByte) this.element.getImage().getData().getDataBuffer()).getData(), ((DataBufferByte) this.fireBall.getImage().getData().getDataBuffer()).getData());
        this.fireBall.animate();
        this.element = new Element("fireball_2.png", false) {};
        Assert.assertArrayEquals(((DataBufferByte) this.element.getImage().getData().getDataBuffer()).getData(), ((DataBufferByte) this.fireBall.getImage().getData().getDataBuffer()).getData());
        Assert.assertEquals(2, this.fireBall.getStep());
        this.fireBall.animate();
        this.element = new Element("fireball_3.png", false) {};
        Assert.assertArrayEquals(((DataBufferByte) this.element.getImage().getData().getDataBuffer()).getData(), ((DataBufferByte) this.fireBall.getImage().getData().getDataBuffer()).getData());
        Assert.assertEquals(3, this.fireBall.getStep());
        this.fireBall.animate();
        this.element = new Element("fireball_4.png", false) {};
        Assert.assertArrayEquals(((DataBufferByte) this.element.getImage().getData().getDataBuffer()).getData(), ((DataBufferByte) this.fireBall.getImage().getData().getDataBuffer()).getData());
        Assert.assertEquals(4, this.fireBall.getStep());
        this.fireBall.animate();
        this.element = new Element("fireball_5.png", false) {};
        Assert.assertArrayEquals(((DataBufferByte) this.element.getImage().getData().getDataBuffer()).getData(), ((DataBufferByte) this.fireBall.getImage().getData().getDataBuffer()).getData());
        Assert.assertEquals(5, this.fireBall.getStep());
        this.fireBall.animate();
        Assert.assertEquals(6, this.fireBall.getStep());
    }
}