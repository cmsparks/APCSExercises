/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sparksc_karelprojects;

import java.awt.Color;

/**
 *
 * @author CSLAB313-1740
 */
public class RectangleBot extends AdvRobot {
    public RectangleBot(int street, int avenue, Direction d, int beepers, Color c) {
        super(street, avenue, d, beepers, c);
    }
    public void makeRow(int width)
    {
        for(int i = 0; i < width; i++)
        {
            this.move();
            this.putBeeper();
        }
    }
    public void cleanRow()
    {
        while(this.nextToABeeper())
        {
            this.pickBeeper();
            this.move();
        }
        this.turnAround();
        this.move();
        this.turnAround();
    }
    public void goToNextRowL()
    {
        this.move();
        this.turnRight();
        this.move();
        this.turnRight();
    }
    public void goToNextRowR()
    {
        this.move();
        this.turnLeft();
        this.move();
        this.turnLeft();
    }
    public void goToDownRowL()
    {
        this.move();
        this.turnLeft();
        this.move();
        this.turnLeft();
    }
    public void goToDownRowR()
    {
        this.move();
        this.turnRight();
        this.move();
        this.turnRight();
    }
    public void makeRectangle(int length, int width)
    {
        for(int i = 0; i < length; i++)
        {
            this.makeRow(width);
            if(facingWest()&&i<length-1)
            {
                this.goToNextRowL();
            }
            else if(facingEast()&&i<length-1)
            {
                this.goToNextRowR();
            }
            else if(facingNorth()&&i<length-1)
            {
                this.goToNextRowL();
            }
            else if(facingSouth()&&i<length-1)
            {
                this.goToNextRowR();
            }
        }
        this.move();
    }
    public boolean isBottomRect()
    {
        boolean isBottomRect = false;
        if(this.facingEast())
        {
            this.turnLeft();
            this.move();
            isBottomRect = this.nextToABeeper();
            this.turnAround();
            this.move();
            this.turnLeft();
        }
        else if(this.facingWest())
        {
            this.turnRight();
            this.move();
            isBottomRect = this.nextToABeeper();
            this.turnAround();
            this.move();
            this.turnRight();
        }
        return isBottomRect;
    }
    public void cleanUp()
    {
        this.move();
        while(this.nextToABeeper())
        {
            this.cleanRow();
            if(this.isBottomRect())
            {
                if(facingWest())
                {
                    this.goToNextRowL();
                }
                else if(facingEast())
                {
                    this.goToNextRowR();
                }
                else if(facingNorth())
                {
                    this.goToNextRowL();
                }
                else if(facingSouth())
                {
                    this.goToNextRowR();
                }
            }
            else
            {
                if(facingWest())
                {
                    this.goToDownRowL();
                }
                else if(facingEast())
                {
                    this.goToDownRowR();
                }
                else if(facingNorth())
                {
                    this.goToDownRowL();
                }
                else if(facingSouth())
                {
                    this.goToDownRowR();
                }
            }
            this.move();
        }
    }
}
