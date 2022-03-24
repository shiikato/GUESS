package com.company;

import com.company.characters.CharacterManager;
import com.company.gui.GUI;
import com.company.tree_data.CharacterTree;

public abstract class Main {

    public static String path = "src/com/company/characters/files";
    public static GUI gui = new GUI();
    public static CharacterManager characterManager = new CharacterManager();
    public static CharacterTree tree = new CharacterTree();

    public static void main(String[] args)
    {
        gui.initializeGUI(); //load GUI
        characterManager.initializeAllCharacters(path); //read characters from txt files
        tree.buildTree(); //hard code the nodes into tree
        tree.insertCharacters(characterManager.characters); //insert the characters into the tree
    }
}