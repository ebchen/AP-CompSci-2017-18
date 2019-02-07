
/**
 * Write a description of class DoorPractice here.
 *
 * @author EBChen
 * @version 11 September 2017
 */
public class DoorPractice
{
    private boolean doorOpen;
    private boolean doorLocked;
    
    public DoorPractice()
    {
        doorOpen = false;
        doorLocked = true;
    }
    public boolean getLocked()
    {
        if (doorLocked == true) return true;
        else return false;
    }
    public boolean getOpened()
    {
        if (doorOpen == true) return true;
        else return false;
    }
    public void lockDoor()
    {
        if (!doorOpen) doorLocked = true;
    }
    public void unlockDoor()
    {
        doorLocked = false;
    }
    public void openDoor()
    {
        if (!doorLocked) doorOpen = true;
        else doorOpen = true;
    }
    public void closeDoor()
    {
        doorOpen = false;
    }
    public String toString()
    {
        String open;
        String locked;
        if (doorOpen) open = "open";
        else open = "closed";
        if (doorLocked) locked = "locked";
        else locked = "unlocked";
        return "Door is " + open + " and " + locked;
    }
    
    public static void main (String [] args)
    {
        DoorPractice door = new DoorPractice();
        System.out.println(door.toString());
    }
}

