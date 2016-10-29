/**
 * CSC 1600 Data Structures
 * CH2 Programming Lab
 *
 * The QueueException class is used to throw an Runtime Exception when an item is dequeue from an empty Queue.
 *
 * @author Brandon Young
 */
// File Name: QueueException.java
public class QueueException extends RuntimeException {

    public QueueException(String s) {
        super(s);
    }  // end constructor

}  // end QueueException
