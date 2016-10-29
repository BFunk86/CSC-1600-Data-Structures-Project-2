/* Class: CS111C
 * Author: Marat Pernabekov
 * Assignment: Lab D
 * File: NoDuplicatesArrayQueue.java
 */
@SuppressWarnings("unchecked")         // ignore the compiler warnings,
// concerning the usage of generics

public class NoDuplicatesArrayQueue<T> implements NoDuplicatesQueueInterfaceYoung<T>,
        java.io.Serializable
{
    private T[] queue;                         // circular array of queue entries
    // with one unused location
    private int frontIndex;                       // the first index at the front
    private int backIndex;                          // the last index at the back
    private static final int DEFAULT_INITIAL_CAPACITY = 10; // default array size

    public NoDuplicatesArrayQueue()
    {
        this(DEFAULT_INITIAL_CAPACITY); // passes the size to the value constructor
    } // end default constructor


    public NoDuplicatesArrayQueue(int initialCapacity)
    {
        queue = (T[]) new Object[initialCapacity + 1]; // creates a new queue

        // Sets the values of the queue's first and last index.
        frontIndex = 0;
        backIndex = initialCapacity;
    } // end constructor

    // The enqueue method adds a new entry to the back of the queue if it is not a
    // duplicate.
    public void enqueue(T newEntry)
    {
        // Checks if the array is full and expands it if needed.
        if (isArrayFull())
            doubleArray();

        // The duplicate check. Adds a new entry and updates the back index.
        if (!isDuplicate(newEntry))
        {
            backIndex = (backIndex + 1) % queue.length;
            queue[backIndex] = newEntry;
        } // end if
    } // end enqueue

    // The getFront method finds the first entry in the front of the queue.
    // Returns the entry to the caller.
    public T getFront()
    {
        T front = null;      // the entry from the front of the queue

        if (!isEmpty())
            front = queue[frontIndex];

        return front;
    } // end getFront

    // The dequeue method removes the first entry from the front of the queue.
    // Returns the removed entry to the caller.
    public T dequeue()
    {
        T front = null;     // the entry from the front of the queue

        if (!isEmpty())
        {
            front = queue[frontIndex];
            queue[frontIndex] = null;     // removes the entry by setting it to null

            // Updates the front index by shifting it to the right by 1.
            frontIndex = (frontIndex + 1) % queue.length;
        } // end if

        return front;
    } // end dequeue

    // The isEmpty method checks whether the queue is empty.
    public boolean isEmpty()
    {
        return frontIndex == ((backIndex + 1) % queue.length);
    } // end isEmpty

    // The clear method empties the queue by calling dequeue method repeatedly
    public void clear()
    {
        while (!isEmpty())
            dequeue();
    } // end clear

    // The display method traverses the queue, displaying the each element,
    // starting with frontIndex.
    public void display()
    {
        int crntIndex = frontIndex;    // current index reference

        // Traverses the entire queue
        for (int count = 0; count < queue.length; count++)
        {
            // Displays each entry that is not null.
            if (queue[crntIndex] != null)
                System.out.println( queue[crntIndex] );

            // Increments the index counter.
            crntIndex = (crntIndex + 1) % queue.length;
        } // end for

    } // end display

    // The moveToBack method finds a matching entry in the queue and moves it to the
    // back of the queue. If the entry was not not in the queue, it just adds it to
    // the back of the queue.
    public void moveToBack(T newEntry)
    {
        // Finds the matching entry in the list and removes it.
        for (int i = 0; !isEmpty() && i < queue.length; i++) {
            if (newEntry.equals(queue[i]))
                queue[i] = null;
        } // end for

        // Updates the reference to the backIndex.
        backIndex = (backIndex + 1) % queue.length;

        // Adds the new entry to the back of the queue.
        queue[backIndex] = newEntry;
    }

    //********************** Private helper methods*********************************

    // The isArrayFull method checks whether the array is full.
    private boolean isArrayFull()
    {
        return frontIndex == ((backIndex + 2) % queue.length);
    } // end isArrayFull

    // The isDuplicate method checks whether the new entry is already in the queue.
    private boolean isDuplicate(T entry)
    {
        for (int i = 0; !isEmpty() && i < queue.length; i++)
        {
            // The entry is a duplicate if queue is not empty and the value matches
            // an existing entry.
            if (queue[i] != null && entry.equals(queue[i]))
                return true;
        } //end for

        return false;
    } // end isDuplicate

    // The doubleArray method dynamically expands the array to double of its size
    // when the queue array becomes full.
    private void doubleArray()
    {
        T[] oldQueue = queue;              // references the full queue's array
        int oldSize = oldQueue.length;     // references the size of the old queue

        // Creates a new array that is double the size of the old one
        queue = (T[]) new Object[2 * oldSize];

        // Traverses the old array to copy the elements over to the new one.
        for (int index = 0; index < oldSize - 1; index++)
        {
            queue[index] = oldQueue[frontIndex];
            frontIndex = (frontIndex + 1) % oldSize;
        } // end for

        // Sets the front and back index references for the new queue.
        frontIndex = 0;
        backIndex = oldSize - 2;
    } // end doubleArray

} // end NoDuplicatesArrayQueue