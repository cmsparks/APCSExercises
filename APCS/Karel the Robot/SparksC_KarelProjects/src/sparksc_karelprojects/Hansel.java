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
public class Hansel extends AdvRobot {
    Hansel(int street,int avenue,Direction d, int beepers, Color c)
    {
        //call to super class constructor
        //send parameters to UrRobot
        super(street,avenue,d,beepers,c);
    }
    public void goHome()
    {
        this.followTrail();
        while(!endTrail())
        {
            this.followTrail();
        }
    }
    public boolean endTrail()
    {
        this.pickBeeper();
        if(this.nextToABeeper())
        {
            this.pickBeeper();
            return true;
        }
        else
        {
            return false;
        }
    }
    public void followTrail()
    {
        Direction beeperDir = this.beeperCheck();
        if(beeperDir==North)
        {
            this.faceNorth();
            this.move();
        }
        else if(beeperDir==South)
        {
            this.faceSouth();
            this.move();
        }
        else if(beeperDir==East)
        {
            this.faceEast();
            this.move();
        }
        else if(beeperDir==West)
        {
            this.faceWest();
            this.move();
        }
    }
    public Direction beeperCheck()
    {
        if(this.checkUp())
        {
            return North;
        }
        else if(this.checkDown())
        {
            return South;
        }
        else if(this.checkRight())
        {
            return East;
        }
        else if(this.checkLeft())
        {
            return West;
        }
        else
        {
            return null;
        }
    }
    public boolean checkUp()
    {
        this.faceNorth();
        this.move();
        boolean isBeeper = this.nextToABeeper();
        this.turnAround();
        this.move();
        return isBeeper;
    }
    public boolean checkDown()
    {
        this.faceSouth();
        this.move();
        boolean isBeeper = this.nextToABeeper();
        this.turnAround();
        this.move();
        return isBeeper;
    }
    public boolean checkRight()
    {
        this.faceEast();
        this.move();
        boolean isBeeper = this.nextToABeeper();
        this.turnAround();
        this.move();
        return isBeeper;
    }
    public boolean checkLeft()
    {
        this.faceWest();
        this.move();
        boolean isBeeper = this.nextToABeeper();
        this.turnAround();
        this.move();
        return isBeeper;
    }
}
