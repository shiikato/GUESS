package com.company.characters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CharacterManager
{
    public character[] characters; //list of all characters

    private character initializeCharacter(String _path)
    {
        File file = new File(_path); //filepath for the character
        try {

            //region get-parameters
            Scanner scanner = new Scanner(file);

            String name = scanner.nextLine(); //get first line of txt as name

            boolean[] parameters = new boolean[(int)countLines(_path)-1]; //set length of boolean array to length of file -1 (without name)

            int i = 0;
            while(scanner.hasNextBoolean()) //as long as there is a next line that contains a boolean
            {
                parameters[i] = scanner.nextBoolean(); //the boolean is added to the list of parameters
                i++;
            }
            //endregion

            System.out.println("Character " + name + " initialized."); //-> success creating character

            return new character(name, parameters); //return character

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        return null; //if file is not found return null
    }

    public String[] getFiles(String _path) //get String[] of all character file names
    {
        File path = new File(_path);
        String[] pathNames; //empty string for character file names
        pathNames = path.list(); //parse all character file names into the array

        return pathNames; //return the path names
    }

    private int getFileAmount(String _path) //get the amount of character files -> how many characters need to be creted
    {
        String[] pathNames = getFiles(_path); //get array of file names
        return pathNames.length; //return length of file name array
    }

    public void createNewCharacter(character _character, String _path) //unused -> method for character creation through txt files
    {
        String path = _path + "/" + _character.getName() + ".txt"; //convert raw path to filepath
        try { //surrounded by try catch in case file is not found
            File file = new File(path);

            if(file.createNewFile())
            {
                System.out.println("File was created: " + file.getName());
                FileWriter fileWriter = new FileWriter(path); //initialize new fileWriter

                //write character information to file
                fileWriter.write(_character.getName() + "\n");
                for (int i = 0; i < _character.getParameters().length; i++) {
                    fileWriter.write(String.valueOf(_character.getParameters()[i]) + "\n"); //isMale returns a boolean -> valueOf converts bool to String
                }

                fileWriter.close();
            } else {
                System.out.println("Character exists already!");
            }
        } catch (IOException e) {
            System.out.println("File could not be created!");
        }
    }

    public character[] initializeAllCharacters(String _path)
    {
        String[] characterNames = getFiles(_path); //get file path
        characters = new character[getFileAmount(_path)]; //
        for (int i=0; i<getFileAmount(_path); i++) //repeat for every character in the folder
        {
            characters[i] = initializeCharacter(_path + "/" + characterNames[i]); //initialize character i
        }
        return characters; //return list of all characters
    }


    //method from mykong.com
    public static long countLines(String fileName) {

        Path path = Paths.get(fileName);

        long lines = 0;
        try
        {
            lines = Files.lines(path).count();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }
}
