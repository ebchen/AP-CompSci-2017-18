

public class Door
{
    private String name; //instance variable exists in the object
    private boolean isOpened;
    
    
    public Door(String name, boolean openOrClose)
    {
        this.isOpened = openOrClose;
        this.name = name;
    }
    
    public void open()
    {
        this.isOpened = true;
    }
    
    public void close()
    {
        this.isOpened = false;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public boolean getOpenOrClosed()
    {
        return this.isOpened;
    }
    
    public void setName(String newName)
    {
       this.name = newName; //parameter variable
    }
}


// backDoor.setName("blue back door"); 
// the implicit parameter: the object backDoor
// the explicit parameter: "blue black door"