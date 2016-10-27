/**
 * CSC 1600 Data Structures
 * CH2 Programming Lab
 *
 * The NoDuplicateQueueYoung class implements the NoDuplicateQueueInterfaceYoung Interface.
 *
 * @author Brandon Young
 */
public class NoDuplicateQueueYoung<T> implements NoDuplicateQueueInterfaceYoung<T> {

    // Starting size of the Queue and size after the Queue is resized
    private int queueSize = 10;
    // The backbone of the Queue
    private Object[] items;
    // The front and back and current size of the Queue
    private int front, back, count;

    /**
     * Creates a new Empty Queue
     */
    public NoDuplicateQueueYoung() {
        items = new Object[queueSize];
        front = 0;
        back = queueSize - 1;
        count = 0;
    } // end default constructor

    @Override
    public void enqueue(Object newEntry) {

    }  // end enqueue

    @Override
    public Object dequeue() {
        return null;
    } // end dequeue

    @Override
    public Object getFront() {
        return null;
    } // end getFront

    @Override
    public boolean isEmpty() {
        return false;
    } // end isEmpty

    @Override
    public void clear() {

    } // end clear

    @Override
    public void moveToBack(T newEntry) {

    } // end moveToBack
}
