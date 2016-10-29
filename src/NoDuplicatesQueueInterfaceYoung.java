/**
 * CSC 1600 Data Structures
 * CH2 Programming Lab
 *
 * The NoDuplicatesQueueInterfaceYoung Interface is an interface that allows only a single copy of an object in the
 * queue. If an object is added to the queue, but is already there then the item is moved to the back of the Queue
 *
 * @author Brandon Young
 */
// File Name: NoDuplicatesQueueInterfaceYoung.java
public interface NoDuplicatesQueueInterfaceYoung<T> extends QueueInterface<T> {

    /**
     * Takes the item passed as an argument and adds it to the back of the Queue. If the item is already in the Queue
     * it moves it to the back of the Queue. If the item is already at the back of the Queue it does nothing.
     * Precondition: The item is not in the back of the Queue otherwise the method does nothing
     * Post Condition: Adds the item to the back of the Queue if it is not already there. Shifts all other items one
     * spot forward in the Queue.
     * @param newEntry T: The item to move to the back of the Queue.
     */
    public void moveToBack(T newEntry);

} // end NoDuplicateQueueInterfaceYoung
