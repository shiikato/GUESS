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
        isCharacter = false;
    }

    public Node(String _prompt, boolean _isCharacter)
    {
        prompt = _prompt;
        isCharacter = _isCharacter;
    }
}