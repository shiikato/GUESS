package com.company.tree_data;

import com.company.Main;
import com.company.characters.character;

public class CharacterTree {

    //region Node-definitions
    private Node root = new Node("Is your character male?"); //create root node
    public Node pointer = root;

        private Node male = new Node("Is your character real?"); //create male node (male=true)
        private Node female = new Node("Is your character real?"); //create female node (male=false)
    //endregion

    public void buildTree()
    {
        //region Tree-organization
        //Hard coding character tree to individualize questions for each path
        root.leftChild = male; //set male as root's left child
        root.rightChild = female; //set female as root's right child®
        //endregion

        insertCharacters(Main.characterManager.characters); //insert the characters into the tree
    }

    public void insertCharacters(character[] _characters)
    {
        for (int i = 0; i < _characters.length; i++) //for all the characters in the list do:
        {
            boolean[] parameters = _characters[i].getParameters(); //fetch parameters
            Node insertionPointer = root;
            for (int j = 0; j < parameters.length; j++) //go to child that parameter states: true -> left child; false -> right child
            {
                if(parameters[j]) //if parameter is true
                {
                    if(insertionPointer.leftChild == null) insertionPointer.leftChild = new Node("placeholder"); //create new placeholder node
                        insertionPointer = insertionPointer.leftChild; //go to left child
                } else { //if parameter is false
                    if(insertionPointer.rightChild == null) insertionPointer.rightChild = new Node("placeholder"); //create new placeholder node
                        insertionPointer = insertionPointer.rightChild; //go to right child
                }
            }
            System.out.println(insertionPointer.prompt + " is now " + _characters[i].getName()); //delete later -> shows where character was inserted
            insertionPointer.prompt = _characters[i].getName(); //insert character at insertionPointer
        }
    }

    //region Button-reactions
    public void onTrue()
    {
        if(Main.gui.question == "Character not found.") Main.gui.exit(); //if character was not found -> exit
        if(pointer.leftChild != null)
        {
            pointer = pointer.leftChild;
        } else { //if character == null
            Main.gui.setQuestion("Character not found."); //set question to "Character not found."

            Main.gui.setYesBtn("Exit");
            Main.gui.setNoBtn("Retry");
        }
    }

    public void onFalse()
    {
        if(Main.gui.question == "Character not found.") Main.gui.exit(); //if character was not found -> exit
        if(pointer.rightChild != null)
        {
            pointer = pointer.rightChild;
        } else {
            Main.gui.setQuestion("Character not found."); //set question to "Character not found."
            
            Main.gui.setYesBtn("Exit");
            Main.gui.setNoBtn("Retry");
        }
    }
    //endregion
}
