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
        gui.initializeGUI();
        characterManager.initializeAllCharacters(path);
        tree.buildTree();
    }
}