package com.company.tree_data;

public class Node
{
    public Node leftChild; //true child
    public Node rightChild; //false child
    public String prompt;
    public boolean isCharacter;

    public Node(String _prompt) //Constructor for new Node
    {
        prompt = _prompt;
        isCharacter = false; //default: set as not a character
    }

    public Node(String _prompt, boolean _isCharacter) //Constructor for new Node; determine if it is a character/end-node or not
    {
        prompt = _prompt;
        isCharacter = _isCharacter;
    }
}