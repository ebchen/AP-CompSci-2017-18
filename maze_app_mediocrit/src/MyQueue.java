import java.util.*;



public class MyQueue<T> implements QueueADT<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyQueue()
    {
        head = null;
        tail = null;
        this.size = 0;
    }

    public void enqueue(T item)
    {
        if (isEmpty())
        {
            Node<T> newNode = new Node();
            newNode.data = item;
            newNode.next = null;
            newNode.previous = null;
            this.head = newNode;
            this.tail = newNode;

        }
        else {
            Node<T> newNode = new Node();
            newNode.data = item;
            newNode.next = null;
            newNode.previous = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }


    public T dequeue() throws NoSuchElementException
    {
        Node<T> result;
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }
        else if (this.head.next== null)
        {
            result = this.head;
            this.head = null;

        }
        else {
            result = this.head;
            this.head = this.head.next;
            this.head.previous = null;

        }
        this.size--;
        return result.data;
    }

    /**
     * Return the front item in the queue without removing it
     * @return the front item in the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public T front() throws NoSuchElementException
    {
        if (isEmpty()) throw new NoSuchElementException();
        return this.head.data;
    }
    /**
     * Find how many items are in the queue
     * @return the number of items in the queue
     */
    public int size()
    {
        return this.size;
    }

    /**
     * Determine if the queue is empty
     * @return true if the size is 0, false otherwise
     */
    public boolean isEmpty()
    {
        if (size == 0) return true;
        else return false;
    }
    /**
     * Clear out the data structure
     */
    public void clear()
    {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
}

class Node<T>
{
    public T data;
    public Node next;
    public Node previous;
}
