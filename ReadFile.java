/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Monisiaa
 */

//podobno jak @ w payloadzie to po niej nie czytac bo sa bledy, czy mamy to uwzglednic w programie?
public class ReadFile {
    public void ReadFile(){
        FileReader file = null;
        String line;
        List<Character> charList = new ArrayList<Character>();
        try{
            file = new FileReader("RS232_0.txt");
        } catch (FileNotFoundException e)
        {
            System.out.println("Invalid input file");
        }
        BufferedReader buffor = new BufferedReader(file);
        
        try {
            while ((line = buffor.readLine())!=null)
            {
                String fieldMessageNo = line.substring(34, 36);
                if (fieldMessageNo.equals(",5"))
                {
                    //We have our message no 5
                    for (char c : line.toCharArray()){
                        charList.add(c);
                    }
                    
                    String fieldSequences = line.substring(27,28);
                    System.out.println(fieldSequences);
                    
                    int foo = Integer.parseInt(fieldSequences);
                    
                    for(int i=1; i<foo; i++){
                        line=buffor.readLine();                        
                        for (char c : line.substring(0).toCharArray()){
                            charList.add(c);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println ("Invalid read from file");
        }
    }
}
