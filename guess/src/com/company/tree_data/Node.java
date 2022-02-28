package com.company.tree_data;

public class Node
{
    public Node leftChild; //true child
    public Node rightChild; //false child
    public String prompt;

    public Node(String _prompt) //Constructor for new Node
    {
        prompt = _prompt;
    }
}