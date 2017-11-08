/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordchecker;

import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.Character.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dyanek
 */
public class Password {
    
    private String pwd;
    private ArrayList<String> dictionary;
    
    public Password(String p)
    {
        pwd = p;
        dictionary = new ArrayList<String>();
    }
    
    public String toString()
    {
        return pwd;
    }
    public void getDictionary() {
        File file = new File("commonwords.txt");
        
        try {
            Scanner sc = new Scanner (file);
            
            while (sc.hasNext())
            {
                String i = sc.next();
                dictionary.add(i);
                //System.out.println(i);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("error: "+ e);
        }
    }
    public boolean hasUppercase()
    {
        for(int i = 0; i < pwd.length(); i++)
        {
            if(isUpperCase(pwd.charAt(i)))
            {
                return true;
            }
        }
        return false;
    }
    public boolean hasLowercase()
    {
        for(int i = 0; i < pwd.length(); i++)
        {
            if(isLowerCase(pwd.charAt(i)))
            {
                return true;
            }
        }
        return false;
    }
    public boolean hasDigit()
    {
        for(int i = 0; i < pwd.length(); i++)
        {
            if(isDigit(pwd.charAt(i)))
            {
                return true;
            }
        }
        return false;
    }
    public boolean hasSymbol()
    {
        for(int i = 0; i < pwd.length(); i++)
        {
            if(!isDigit(pwd.charAt(i))&&!isAlphabetic(pwd.charAt(i)))
            {
                return true;
            }
        }
        return false;
    }
    public boolean noThreeChars()
    {
        for(int i = 0; i < pwd.length(); i++)
        {
            int numberOfLetters = 0;
            for(int w = 0; w < pwd.length(); w++)
            {
                if(pwd.charAt(i)==pwd.charAt(w))
                {
                    numberOfLetters++;
                }
                if(numberOfLetters > 3)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean testDictionary()
    {
        for(int i = 0; i < dictionary.size(); i++)
        {
            String word = dictionary.get(i);
            if(pwd.contains(word))
            {
                return false;
            }
        }
        return true;
    }
    public int pwdStrength()
    {
        int str = 0;
        if(this.getLength()>8)
        {
            str++;
        }
        if(this.testDictionary())
        {
            str++;
        }
        if(this.hasUppercase())
        {
            str++;
        }
        if(this.hasLowercase())
        {
            str++;
        }
        if(this.hasDigit())
        {
            str++;
        }
        if(this.hasSymbol())
        {
            str++;
        }
        if(this.noThreeChars())
        {
            str++;
        }
        System.out.print(str);
        return str;
    }
    public int getLength()
    {
        return pwd.length();
    }
}
