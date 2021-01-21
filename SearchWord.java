//This program takes text from a file and splits it up into words.
//It can then see how many times a sent with word is found in the text
//How to use: java filename.txt searchword
//Search word can only be any sequence of characters, but is not case sensitive

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class SearchWord {
    public static void main(String[] args) { //args: 0: file name, 1: keyword
        if (args.length<=2) {
            String fileName = args[0]; //set filename
            String kwdata = args[1];  //set keyword
            String kw = kwdata.toUpperCase();
            try {   
                File myFile = new File(fileName); //open filepath 
                int count = 0; //counter for number of matches
                Scanner myReader = new Scanner(myFile); //contain the file in a scanner
                kw = kwdata.toUpperCase();
                String sw;

                while (myReader.hasNextLine()) { //go through file line by line
                        String data = myReader.nextLine(); //see if text has a line to go through                        
                        String[] arr = data.split(" ");   //separates a line into words, by " "
                        
                        for(int i=0; i<arr.length; i++){  //go through the words in one line
                            sw = arr[i].toUpperCase();
                            if(sw.contains(kw)) {     //if a match is found
                                count++;
                            }                        
                        }
                    }
                    myReader.close();  //closes scanner
                    System.out.println("Number of times '" +kwdata+ "' was found is: " +count); //output msg
            }
            catch (FileNotFoundException e) {
                System.out.println("An error occured"); //error message
            }
        }
        else {
            System.out.println("Please enter two and only two arguments.");
        }
    }
}