package com.company.characters;

public class character
{
    private String name;
    private boolean[] parameters;

    public character(String _name, boolean[] _parameters) //constructor function
    {
        name = _name;

        parameters = _parameters;
    }

    public String getName()
    {
        return name;
    }

    public boolean[] getParameters()
    {
        return this.parameters;
    }
}
