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
public class Racer extends AdvRobot {
    public Racer(int street, int avenue, Direction d, int beepers, Color c) {
        super(street, avenue, d, beepers, c);
    }
    public void runRace()
    {
        for(int i = 0; i < 9; i++)
        {
            if(this.frontIsClear())
            {
                this.move();
            }
            else
            {
                jumpHurdle();
            }
        }
    }
    public void jumpHurdle()
    {
        int height = 0;
        this.turnLeft();
        this.move();
        this.turnRight();
        height = jumpUp();
        jumpOver();
        jumpDown(height);
        this.turnLeft();
    }
    public int jumpUp()
    {
        int height = 0;
        while(!frontIsClear())
        {
            height++;
            this.turnLeft();
            this.move();
            this.turnRight();
        }
        return height;
    }
    public void jumpOver()
    {
        this.move();
        this.turnRight();
        while(!frontIsClear())
        {
            this.turnLeft();
            this.move();
            this.turnRight();
        }
    }
    public void jumpDown(int height)
    {
        for(int i = 0; i < height+1; i++)
        {
            this.move();
        }
    }
}
