package com.company.tree_data;

import com.company.Main;
import com.company.characters.character;

public class CharacterTree {

    //region Prompts
    private String _real = "Is your character real?";
    private String _alive = "Is your character alive?";
    private String _activist = "Is your character an activist?";
    private String _civilRights = "Is your character part of the civil rights movement?";
    private String _ceo = "Is your character a CEO?";
    private String _artist = "Is your character an artist";
    //endregion

    //region Node-definitions
    private Node root = new Node("Is your character male?");
    public Node pointer = root;

        private Node male = new Node(_real);

            private Node real_M = new Node(_alive);

                private Node alive_Male = new Node(_activist);

                    private Node notActivist_Male_Alive = new Node(_ceo);

                        private Node ceo_M = new Node("Does your character sell electric cars?");

                            private Node notCars = new Node("Does your character run an online business?");

                        private Node not_ceo_M = new Node(_artist);

                            private Node artist_M = new Node("Is your character a rapper?");

                            private Node noArtist_M = new Node("Does your character play video games?");

                                private Node videoGames = new Node("Does your character play Valorant competetively?");

                private Node dead_Male = new Node(_activist);

                    private Node activist_Male_Dead = new Node(_civilRights);

            private Node fictional_M = new Node(_activist);

        private Node female = new Node(_real);
    //endregion

    private boolean characterFound = false;

    public void buildTree()
    {
        //region Tree-organization
        //Hard coding character tree to individualize questions for each path
        root.leftChild = male;
            male.leftChild = real_M;
                real_M.leftChild = alive_Male;
                    alive_Male.rightChild = notActivist_Male_Alive;
                        notActivist_Male_Alive.leftChild = ceo_M;
                            ceo_M.rightChild = notCars;
                real_M.rightChild = dead_Male;

            male.rightChild = fictional_M;
        root.rightChild = female;
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
            insertionPointer.prompt = _characters[i].getName(); //insert character at insertionPointer
            insertionPointer.isCharacter = true;
        }
    }

    //region Button-reactions
    public void onTrue()
    {
        if(characterFound) Main.gui.exit();
        if(pointer.leftChild != null && !pointer.isCharacter)
        {
            pointer = pointer.leftChild;
            Main.gui.setQuestion(pointer.prompt);
        }
        if(pointer.isCharacter)
        {
            Main.gui.setYesBtn("Exit");
            Main.gui.setNoBtn("Play again");
            characterFound = true;
        }
    }

    public void onFalse()
    {
        if (characterFound)
        {
            pointer = root;
            characterFound = false;
            Main.gui.setQuestion(pointer.prompt);
            Main.gui.restartGui();
            return;
        }
        if(pointer.rightChild != null && !pointer.isCharacter)
        {
            pointer = pointer.rightChild;
            Main.gui.setQuestion(pointer.prompt);
        }
        if(pointer.isCharacter)
        {
            Main.gui.setYesBtn("Exit");
            Main.gui.setNoBtn("Play again");
            characterFound = true;
        }
    }
    //endregion
}
