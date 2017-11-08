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
public class Carpeter extends AdvRobot{
    public Carpeter(int street, int avenue, Direction d, int beepers, Color c) {
        super(street, avenue, d, beepers, c);
    }
    public void carpetRooms(int length)
    {
        turnLeft();
        move();
        for(int i = 0; i < length; i++)
        {
            if(this.isSmallRoom())
            {
                carpetRoom();
            }
            else
            {
                exitRoom();
            }
            changeRoom();
        }
    }
    public boolean isSmallRoom()
    {
        if(!checkNorth() && !checkEast() && !checkWest())
        {
            return true;
        }
        else if(!checkEast() && !checkWest())
        {
            faceNorth();
            move();
            return isSmallRoom();
        }
        else
        {
            return false;
        }
    }
    public boolean checkNorth()
    {
        faceNorth();
        return frontIsClear();
    }
    public boolean checkEast()
    {
        faceEast();
        return frontIsClear();
    }
    public boolean checkSouth()
    {
        faceSouth();
        return frontIsClear();
    }
    public boolean checkWest()
    {
        faceWest();
        return frontIsClear();
    }
    public void changeRoom()
    {
        faceSouth();
        turnLeft();
        move();
        turnLeft();
        move();
    }
    public void carpetRoom()
    {
        if(!checkEast() && !checkWest())
        {
            faceSouth();
            putBeeper();
            move();
            carpetRoom();
        }
    }
    public void exitRoom()
    {
        faceSouth();
        move();
        if(!checkEast() || !checkWest())
        {
            faceSouth();
            move();
        }
    }
}
