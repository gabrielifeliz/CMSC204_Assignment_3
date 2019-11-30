package cmsc204assignment3;

import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * The implementation of a sorted doubly-linked list
 * @author Gabriel I Feliz
 * @param <T> data type
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
   
    /**
     * Comparator interface that will sort the doubly-linked list
     */
    protected Comparator<T> comparator = null;
        
    /**
     * Constructor to set type of comparator for doubly-linked list 
     * @param comparator sorting tool 
     */
    public SortedDoubleLinkedList(Comparator<T> comparator) {
       this.comparator = comparator;
    }
    
    /**
     * Add element with the compare method from 
     * to insert it into the right position
     * @param data data to be entered
     * @return instance of sorted doubly-linked list
     */
    public SortedDoubleLinkedList<T> add(T data) {
        Node newNode = new Node(data);
        
        if (size == 0) {
            first = last = newNode;
        } else if (comparator.compare(first.data, data) > 0) {
            first.previous = newNode;
            newNode.next = first;
            first = newNode;
        } else if (comparator.compare(last.data, data) < 0) {
            last.next = newNode;
            newNode.previous = last;
            last = newNode;
        } else {
            Node search = first;
            while (search != null) {
                if (comparator.compare(search.data, data) <= 0) {
                    Node before = search;
                    Node after = search.next;
                    after.previous = before.next = newNode;
                    newNode.next = after;
                    newNode.previous = before;   
                }
                search = search.next;
            }
        }
        
        size++;
        return this;
    }
    
    /**
     * Add new element to the end of list, no longer needed here
     * @param data data to be inserted at the end of list
     * @return instance of doubly-linked list
     */    
    @Override
    public BasicDoubleLinkedList<T> addToEnd(T data) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Add new element to the beginning of list, no longer needed here
     * @param data data to be inserted at the beginning of list
     * @return instance of doubly-linked list
     */
    @Override
    public BasicDoubleLinkedList<T> addToFront(T data) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Returns instance of iterator from basic doubly-linked list's inner class 
     * to traverse over the doubly-linked list
     * @return Instance of iterator inner class in basic doubly-linked list
     * @throws UnsupportedOperationException method has not been implemented yet
     * @throws NoSuchElementException element does not exist
     */
    @Override
    public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException {
        return super.iterator();
    }
 
    /**
     * Delete first instance of data element in the doubly-linked list using
     * the remove method from the basic doubly-linked list class
     * @param data data to be deleted in list
     * @param comparator interface to compare data of elements
     * @return instance of sorted doubly-linked list
     */
    @Override
    public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comparator) {
        super.remove(data, comparator);
        return this;
    }
    
}

