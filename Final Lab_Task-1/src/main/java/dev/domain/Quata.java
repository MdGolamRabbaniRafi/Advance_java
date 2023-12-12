package dev.domain;

public class Quata {
    private int Id;
    private String Name;

    Quata(int Id, String Name)
    {
        this.Id=Id;
        this.Name=Name;
    }

    public void setId(int Id)
    {
        this.Id=Id;
    }
    public int getId(int Id)
    {
        return Id;
    }
    public void setName(String Name)
    {
        this.Name=Name;
    }
    public String getName(String Name)
    {
        return Name;
    }
}
