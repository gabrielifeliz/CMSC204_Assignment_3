package cmsc204assignment3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * The implementation of a basic doubly-linked list
 * @author Gabriel I Feliz
 * @param <T> data type
 */
public class BasicDoubleLinkedList<T> implements Iterable<T> {
    
    /**
     * Size of basic doubly-linked list
     */
    protected int size = 0;
    /**
     * First element of basic doubly-linked list
     */
    protected Node first;
    /**
     * Last element of basic doubly-linked list
     */
    protected Node last;
    
    /**
     * No-arg constructor that initializes list
     */
    public BasicDoubleLinkedList() {
        first = last = null;
    }
    
    /**
     * Return size of doubly-linked list
     * @return size of list
     */
    public int getSize() {
        return size;
    }
    
    /**
     * Add new element to the end of list
     * @param data data to be inserted at the end of list
     * @return instance of doubly-linked list
     */
    public BasicDoubleLinkedList<T> addToEnd(T data) {
        if (last == null) {
            last = new Node(data);
            first = last;
        } else {
            Node newNode = new Node(data);
            last.next = newNode;
            newNode.previous = last;
            last = newNode;
        }
        size++;
        return this;
    }
    
    /**
     * Add new element to the beginning of list
     * @param data data to be inserted at the beginning of list
     * @return instance of doubly-linked list
     */
    public BasicDoubleLinkedList<T> addToFront(T data) {
        if (first == null) {
            first = new Node(data);
            last = first;
        } else {
            Node newNode = new Node(data);
            first.previous = newNode;
            newNode.next = first;
            first = newNode;
        }
        size++;
        return this;
    }
    
    /**
     * Return data of first element in the doubly-linked list
     * @return data of first element in list
     */
    public T getFirst() {
        return first.data;
    }
    
    /**
     * Return data of last element in the doubly-linked list
     * @return data of last element in list
     */
    public T getLast() {
        return last.data;

    }
    
    /**
     * Returns instance of iterator inner class to traverse over the doubly-linked list
     * @return Instance of iterator inner class
     * @throws UnsupportedOperationException method has not been implemented yet
     * @throws NoSuchElementException element does not exist
     */
    @Override
    public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException {
        MyListIterator iterator = new MyListIterator();
        return iterator;
    }
    
    /**
     * Delete first instance of data element in the doubly-linked list using
     * the compare method from the Comparator interface to search and compare
     * between target data and data set in the list
     * @param targetData data to be deleted in list
     * @param comparator interface to compare data of elements
     * @return instance of doubly-linked list
     */
    public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator) {
        Node node = first;
        while(node != null) {
            if (comparator.compare(node.data, targetData) == 0) {
                if (node == first) {
                    if (first.next != null) {
                        first = first.next;
                        first.previous = null;
                    } else {
                        first = last = null;
                    }
                } else if (node == last) {
                    if (last.previous != null) {
                        last = last.previous;
                        last.next = null;
                    } else {
                        first = last = null;
                    }
                } else {
                    node.previous.next = node.next;
                    node.next.previous = node.previous;
                }
                break;
            }
            node = node.next;
        }
        size--;
        return this;
    }
    
    /**
     * Delete first element in array and get data of deleted element
     * @return data of deleted element
     */
    public T retrieveFirstElement() {
        if (first != null) {
            Node firstElement = first;
            if (first.next != null) {
                first = first.next;
                first.previous = null;
            } else {
                first = last = null;
            }
            return firstElement.data;
        } else {
            return null;
        }
        
    }
    
    /**
     * Delete last element in array and get data of deleted element
     * @return data of deleted element
     */
    public T retrieveLastElement() {
        if (last != null) {
            Node lastElement = last;
            if (last.previous != null) {
                last = last.previous;
                last.next = null;
            } else {
                first = last = null;
            }
            return lastElement.data;
        } else {
            return null;
        }
    }
    
    /**
     * Return doubly-linked list in the form of an array list
     * @return array-list form of current list
     */
    public ArrayList<T> toArrayList() {
        ArrayList<T> list = new ArrayList<>();
        Node head = first;
        while(head != null) {
            list.add(head.data);
            head = head.next;
        }
        return list;      
    }
    
    /**
     * This inner class contains the structure of an element
     * in the doubly-linked list with data as well as
     * previous and next elements
     */
    protected class Node {
        /**
         * Data of current element
         */
        protected T data;
        /**
         * Next element of this element
         */
        protected Node next;
        /**
         * Previous element of this element
         */
        protected Node previous;
        
        /**
         * Constructor for node without links
         * @param element data of current element
         */
        Node(T element) {
            this.data = element;
            this.next = null;
            this.previous = null;
        }

        /**
         * Constructor for node with or without links
         * @param previous its previous element
         * @param element data of current element
         * @param next its next element
         */
        Node(Node previous, T element, Node next) {
            this.data = element;
            this.next = next;
            this.previous = previous;
        }
    }
    
    /**
     * Inner class responsible for iterating through doubly-linked list
     */
    protected class MyListIterator implements ListIterator<T> {

        /**
         * Iterator pointer
         */
        Node pointer;
        
        /**
         * Initialize pointer to be before first element
         */
        public MyListIterator() {
            pointer = new Node(null, null, first);
        }
        
        /**
         * Test whether a next element exists
         * @return true if a next element exist false otherwise
         */
        @Override
        public boolean hasNext() {
            return pointer.next != null;
        }

        /**
         * Returns the data of next element to the pointer
         * @return data of next element
         */
        @Override
        public T next() {
            
            if (!hasNext()) {
                throw new NoSuchElementException("There is no next element");
            } else {
                pointer.previous = pointer.next;
                pointer.next = pointer.previous.next;
                return pointer.previous.data;
            }            
            
        }

        /**
         * Tests whether a previous element exists
         * @return true if a previous element exist false otherwise
         */
        @Override
        public boolean hasPrevious() {
            return pointer.previous != null;
        }

        /**
         * Returns the data of previous element to the pointer
         * @return data of previous element
         */
        @Override
        public T previous() {
            
            if (!hasPrevious()) {
                throw new NoSuchElementException("There is no previous element");
            } else {
                pointer.next = pointer.previous;
                pointer.previous = pointer.next.previous;
                return pointer.next.data;            
            }
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void set(T e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void add(T e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
}