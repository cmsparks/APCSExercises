/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sparksc_karelprojects;

import kareltherobot.*;
import java.awt.Color;

/**
 *
 * @author CSLAB313-1740
 */
public class AdvRobot extends Robot{
    AdvRobot(int street,int avenue,Direction d, int beepers, Color c)
    {
        //call to super class constructor
        //send parameters to UrRobot
        super(street,avenue,d,beepers,c);
    }
    public void turnRight()
    {
        this.turnLeft();
        this.turnLeft();
        this.turnLeft();
    }
    public void move(int corners)
    {
        for(int i = corners; i>0; i--)
        {
            this.move();
        }
    }
    public void turnAround()
    {
        this.turnLeft();
        this.turnLeft();
    }
    public void reverse()
    {
        this.turnAround();
        this.move();
        this.turnAround();
    }
    public void stepLeft()
    {
        this.turnLeft();
        this.move();
        this.turnRight();
    }
    public void stepRight()
    {
        this.turnRight();
        this.move();
        this.turnLeft();
    }
    public void pickBeepers(int numBeepers)
    {
        for(int i = numBeepers; i>0; i--)
        {
	    this.pickBeeper();
        }
    }
    public void putBeepers(int numBeepers)
    {
        for(int i = numBeepers; i>0; i--)
        {
	    this.putBeeper();
        }
    }
    public void faceEast()
    {
        while(!this.facingEast())
        {
            this.turnLeft();
        }
    }
    
    public void faceWest()
    {
        while(!this.facingWest())
        {
            this.turnLeft();
        }
    }
    public void faceSouth()
    {
        while(!this.facingSouth())
        {
            this.turnLeft();
        }
    }
    public void faceNorth()
    {
        while(!this.facingNorth())
        {
            this.turnLeft();
        }
    }
}
