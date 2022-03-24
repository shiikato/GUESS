package com.company.tree_data;

import com.company.Main;
import com.company.characters.character;

public class CharacterTree {

    //region Common-Prompts
    private String _real = "Is your character real?";
    private String _alive = "Is your character alive?";
    private String _activist = "Is your character an activist?";
    private String _civilRights = "Did your character fight segregation?";
    private String _ceo = "Is your character a CEO?";
    private String _artist = "Is your character an artist?";
    private String _scientist = "Is your character a scientist?";
    private String _german = "Is your character German?";
    private String _british = "Is your character British?";
    private String _book = "Is your character from a book?";
    private String _harryPotter = "Is your character from Harry Potter?";
    private String _SW = "Is your character from Star Wars?";
    private String _percyJackson = "Is your character from Percy Jackson?";
    //endregion

    //region Node-definitions
    private Node root = new Node("Is your character male?");
    public Node pointer = root;

        private Node male = new Node(_real);
            private Node real_M = new Node(_alive);
                private Node alive_M = new Node(_activist);
                    private Node notActivist_M_Alive = new Node(_ceo);
                        private Node ceo_M = new Node("Does your character sell electric cars?");
                            private Node notCars = new Node("Does your character run Amazon?");
                        private Node not_ceo_M = new Node(_artist);
                            private Node artist_M = new Node("Is your character a rapper?");
                            private Node notArtist_M = new Node("Does your character play video games?");
                                private Node videoGames = new Node("Is your character a Valorant pro?");
                                private Node notVideoGames = new Node("Is your character a YouTuber?");
                                    private Node youtuber = new Node("Does your character animate his videos?");
                private Node dead_M = new Node(_activist);
                    private Node activist_M_Dead = new Node(_civilRights);
                    private Node notActivist_M_Dead = new Node(_scientist);
                        private Node scientist_M = new Node(_german);
                        private Node notScientist_M = new Node(_artist);
                            private Node artist_M_D = new Node("Is your character a musician?");
                                private Node musician_M = new Node("Is your character a classical composer?");
                                    private Node composer = new Node("Is your character Austrian?");
                                        private Node not_Austrian = new Node("Was your character born in the 1600s?");
                                private Node not_musician_M = new Node("Is your character a painter?");
                                    private Node painter = new Node("Was your character born in the 1800s?");
                                    private Node notPainter = new Node("Was your character a poet/writer?");
                                        private Node writer_M = new Node(_german);
                                            private Node writer_M_G = new Node("Did your character write the book Faust?");
                                            private Node writer_M_notG = new Node(_british);
            private Node fictional_M = new Node(_book);
                private Node book_M = new Node(_harryPotter);
                    private Node hp_M = new Node("Does your character have a scar on his forehead?");
                    private Node not_hp_M = new Node(_percyJackson);
                        private Node percy_jackson_M = new Node("Is your character a son of Poseidon?");
                private Node movie_M = new Node(_SW);
                    private Node sw_M = new Node("Is your character a jedi?");
        private Node female = new Node(_real);
            private Node real_F = new Node(_alive);
                private Node alive_F = new Node(_activist);
                    private Node notActivist_F_alive = new Node(_ceo);
                        private Node not_ceo_F = new Node("Is your character a musician?");
                            private Node musician_F_alive = new Node("Is your character an Indie Artist?");
                private Node dead_F = new Node(_activist);
                    private Node activist_F_Dead = new Node(_civilRights);
                    private Node notActivist_F_Dead = new Node(_scientist);
                        private Node notScientist_F = new Node(_artist);
                            private Node artist_F = new Node("Was your character a musician?");
                                private Node not_musician_F_Dead = new Node("Was your character a poet/writer?");
            private Node fictional_F = new Node(_book);
                private Node book_F = new Node(_harryPotter);
                    private Node hp_F = new Node("Does your character have red hair?");
                    private Node not_hp_F = new Node(_percyJackson);
                        private Node percy_jackson_F = new Node("Is your character a daughter of Athena?");
                private Node movie_F = new Node(_SW);
                    private Node sw_F = new Node("Does your character appear in the original movies?");
    //endregion

    private boolean characterFound = false;

    public void buildTree()
    {
        //Hard coding character tree to individualize questions for each path
        //region Male
        root.leftChild = male;
            //region Real
            male.leftChild = real_M;
                //region Alive
                real_M.leftChild = alive_M;
                    alive_M.rightChild = notActivist_M_Alive;
                        notActivist_M_Alive.leftChild = ceo_M;
                            ceo_M.rightChild = notCars;
                        notActivist_M_Alive.rightChild = not_ceo_M;
                            not_ceo_M.leftChild = artist_M;
                            not_ceo_M.rightChild = notArtist_M;
                                notArtist_M.leftChild = videoGames;
                                notArtist_M.rightChild = notVideoGames;
                                    notVideoGames.leftChild = youtuber;
                //endregion
                //region Dead
                real_M.rightChild = dead_M;
                    dead_M.leftChild = activist_M_Dead;
                    dead_M.rightChild = notActivist_M_Dead;
                        notActivist_M_Dead.leftChild = scientist_M;
                        notActivist_M_Dead.rightChild = notScientist_M;
                            notScientist_M.leftChild = artist_M_D;
                            artist_M_D.leftChild = musician_M;
                                musician_M.leftChild = composer;
                                    composer.rightChild = not_Austrian;
                            artist_M_D.rightChild = not_musician_M;
                                not_musician_M.leftChild = painter;
                                not_musician_M.rightChild = notPainter;
                                    notPainter.leftChild = writer_M;
                                    writer_M.leftChild = writer_M_G;
                                    writer_M.rightChild = writer_M_notG;
                //endregion
            //endregion
            //region Fictional
            male.rightChild = fictional_M;
                fictional_M.leftChild = book_M;
                    book_M.leftChild = hp_M;
                    book_M.rightChild = not_hp_M;
                        not_hp_M.leftChild = percy_jackson_M;
                fictional_M.rightChild = movie_M;
                    movie_M.leftChild = sw_M;
            //endregion
        //endregion male
        //region Female
        root.rightChild = female;
            //region Real
            female.leftChild = real_F;
                //region Alive
                real_F.leftChild = alive_F;
                    alive_F.rightChild = notActivist_F_alive;
                        notActivist_F_alive.rightChild = not_ceo_F;
                            not_ceo_F.leftChild = musician_F_alive;
                //endregion
                //region Dead
                real_F.rightChild = dead_F;
                    dead_F.leftChild = activist_F_Dead;
                    dead_F.rightChild = notActivist_F_Dead;
                        notActivist_F_Dead.rightChild = notScientist_F;
                            notScientist_F.leftChild = artist_F;
                                artist_F.rightChild = not_musician_F_Dead;
                //endregion
            //endregion
            //region Fictional
            female.rightChild = fictional_F;
                fictional_F.leftChild = book_F;
                    book_F.leftChild = hp_F;
                    book_F.rightChild = not_hp_F;
                        not_hp_F.leftChild = percy_jackson_F;
                fictional_F.rightChild = movie_F;
                    movie_F.leftChild = sw_F;
            //endregion
        //endregion
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
        if(characterFound) Main.gui.exit(); //if character is found or program is at dead-end and yes/exit is pressed, exit the program
        if(pointer.leftChild == null) //if it does not have a left child to go to
        {
            pointer = new Node("Character not found!", true); //set pointer to new end-node
            Main.gui.setQuestion(pointer.prompt); //set prompt to character not found
        }
        if(pointer.leftChild != null && !pointer.isCharacter) //if there is a left child and character was not found yet/dead-end
        {
            pointer = pointer.leftChild; //go to left child
            Main.gui.setQuestion(pointer.prompt); //set question to the node's one
        }
        if(pointer.isCharacter) //if character is found/dead-end
        {
            Main.gui.setYesBtn("Exit"); //change yes btn to exit
            Main.gui.setNoBtn("Play again"); //change no btn to play again
            characterFound = true; //character was found
        }
    }

    public void onFalse()
    {
        if (characterFound) //if character is found/at dead-end and no/play again is pressed
        {
            pointer = root; //go back to root
            characterFound = false; //set character to not found
            Main.gui.setQuestion(pointer.prompt); //set question to root
            Main.gui.restartGui(); //restart GUI
            return; //skip other if-statements
        }
        if(pointer.rightChild == null) //if there is no right child to go to
        {
            pointer = new Node("Character not found!", true); //set pointer to new end-node
            Main.gui.setQuestion(pointer.prompt); //set prompt to character not found
        }
        if(pointer.rightChild != null && !pointer.isCharacter) //if there is a right child and character was not found yet/dead-end
        {
            pointer = pointer.rightChild; //go to right child
            Main.gui.setQuestion(pointer.prompt); //set question to node's one
        }
        if(pointer.isCharacter) //if character is found/dead-end
        {
            Main.gui.setYesBtn("Exit"); //set yes btn to exit
            Main.gui.setNoBtn("Play again"); //set no btn to play again
            characterFound = true; //character was found
        }
    }
    //endregion
}