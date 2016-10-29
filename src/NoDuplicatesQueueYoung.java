/**
 * CSC 1600 Data Structures
 * CH2 Programming Lab
 *
 * The NoDuplicatesQueueYoung class implements the NoDuplicatesQueueInterfaceYoung Interface.
 *
 * @author Brandon Young
 */
// File Name: NoDuplicatesQueueYoung.java
public class NoDuplicatesQueueYoung<T> implements NoDuplicatesQueueInterfaceYoung<T> {

    // Starting size of the Queue and size after the Queue is resized
    private int queueSize = 10;
    // The backbone of the Queue
    private Object[] items;
    // The front and back and current size of the Queue
    private int front, back, count;

    /**
     * Creates a new Empty Queue
     */
    public NoDuplicatesQueueYoung() {
        items = new Object[queueSize];
        front = 0;
        back = queueSize - 1;
        count = 0;
    } // end default constructor

    /**
     * Checks to see if the Queue is full
     * Preconditions: None
     * Post Condition: Returns true if the array is full, false otherwise
     * @return (boolean): True if the Queue is full, false otherwise.
     */
    private boolean isFull() {
        return count == queueSize;
    } // end isFull

    /**
     * The contains method returns true if item is in the Queue already, false otherwise
     * Precondition: none
     * Post Condition: Returns true if the item is in the Queue and false otherwise
     * @param entry T: The item to check if is in Queue
     * @return (boolean): True if the item is in the Queue, false otherwise
     */
    private boolean contains(T entry) {
        for (int index = 0; index < items.length; index++) {
            // If the item is in the Queue return true
            if(entry.equals( items[index] )) {
                return true;
            }
        }
        return false;
    } // end contains

    /**
     * The resize method doubles the size of the current array. It adds the current items in the
     * array to their respective place in the array.
     * Precondition: None
     * Post Condition: doubles the current arrays size and all items stay at their current index and updates queueSize
     * to the new size.
     */
    private void resize() {
        // creates a new array double the size of the original
        Object[] newArray = new Object[items.length * 2];
        // copies the contents of the old array to the new array
        for(int index = 0; index < items.length; index++) {
            newArray[index] = items[index];
        } // end for loop
        // changed reference of original array and update new queueSize
        queueSize = items.length * 2;
        items = newArray;
    } // end resize

    @Override
    public void enqueue(T newEntry) {
        // if array is full resize array
        if( isFull() ) {
            resize();
        } // end if
        // updates the back of the Queue
        back = (back + 1) % (queueSize);
        // add the item to the new back
        items[back] = newEntry;
        ++count;
    }  // end enqueue

    @Override
    public T dequeue() throws QueueException {
        if( isEmpty() ) {
            throw new QueueException("QueueException on dequeue: " + "Queue empty");
        } else {
            Object queFront = items[front];
            front = (front + 1) % (queueSize);
            --count;
            return (T) queFront;
        }
    } // end dequeue

    @Override
    public T getFront() {
        // if Queue is empty return null
        if( isEmpty() ) {
            return null;
        } else {
            // retrieves item at front
            return (T) items[front];
        } // end if else
    } // end getFront

    @Override
    public boolean isEmpty() {
        return count == 0;
    } // end isEmpty

    @Override
    public void clear() {
        // resets the Queue
        items = new Object[queueSize];
        front = 0;
        back = queueSize - 1;
        count = 0;
    } // end clear

    @Override
    public void moveToBack(T newEntry) {
        // If newEntry is already in Queue
        if (contains(newEntry)) {
            if (newEntry.equals( items[back] ))
        } else {  // If newEntry is not in Queue

        }
    } // end moveToBack

} // end NoDuplicateQueueYoung