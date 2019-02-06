import java.util.*;
public class MyStack<T> implements StackADT<T>
{
    private int size;
    private int top;
    private ArrayList<T> stack = new ArrayList<T>();
    public MyStack()
    {
        size= 0;
        top = -1;
    }
    public void push(T item)
    {
        if (size == stack.size())
        {
            stack.add(item);
            size++;
        }
        else
        {
            stack.set(top+1, item);
        }
        top++;

    }
    public T pop() throws NoSuchElementException
    {
        T result;
        if (!stack.isEmpty())
        {
            size--;
            result = stack.remove(top);
            top--;
        }
        else
        {
            throw new NoSuchElementException();
        }
        return result;
    }
    public T top() throws NoSuchElementException
    {
        if (!stack.isEmpty())
        {
            return stack.get(top);
        }
        else
        {
            throw new NoSuchElementException();
        }

    }
    public int size()
    {
        return size;

    }
    public boolean isEmpty()
    {
        return size == 0;
    }
    public void clear() {
        size = 0;
        stack = new ArrayList<>();
    }
        // add a toString method.
}
