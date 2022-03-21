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
    public character[] characters;

    private character initializeCharacter(String _path)
    {
        File file = new File(_path);
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

            System.out.println("Character " + name + " initialized."); //delete later -> shows that the character was created

            return new character(name, parameters);

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        return null;
    }

    public String[] getFiles(String _path)
    {
        File path = new File(_path);
        String[] pathNames;
        pathNames = path.list();

        return pathNames;
    }

    private int getFileAmount(String _path)
    {
        File path = new File(_path);
        String[] pathNames;
        pathNames = path.list();
        return pathNames.length;
    }

    public void createNewCharacter(character _character, String _path)
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
                for (int i = 0; i < 5; i++) {
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
        String[] characterNames = getFiles(_path);
        characters = new character[getFileAmount(_path)];
        for (int i=0; i<getFileAmount(_path); i++)
        {
            characters[i] = initializeCharacter(_path + "/" + characterNames[i]);
        }
        return characters;
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
