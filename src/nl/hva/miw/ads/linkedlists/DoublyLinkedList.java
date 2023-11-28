package nl.hva.miw.ads.linkedlists;

/**
 * Doubly linked list.
 *
 * @author michel
 */
public class DoublyLinkedList {

    private class Node {
        int value;

        Node next = null;      // Link to next node
        Node prev = null;      // Link to previous node

        public Node(int value) {
            this.value = value;
        }
    }

    private int size = 0;           // Length of list
    private Node head = null;      // Link to first node

    public DoublyLinkedList() {
    }

    public int getSize() {
        return size;
    }

    public int get(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Too large of a number.");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public void add(int index, int value) {
        // Implement, create a new Node for this entry.
        Node n = new Node(value);
        if (index < 0 || index > size) {
            return;
        }
        size++;
        if (index == 0) {
            n.next = head;
            head = n;
            return;
        }
        Node current = head;
        Node previous = null;
        for (int count = 0; count < index - 1; count++) {
            previous = current;
            current = current.next;
        }
        if (current.next != null) {
            n.prev = current;
            current.next.prev = n;
        }
        n.next = current.next;
        current.next = n;

    }

    public void remove(int index) {
        // Implement, remove the corresponding node from the linked list.
        if (index < 0 || index > size) {
            return;
        }
        Node current = head;
        Node previous = null;

        if (index == 0) {
            head = current.next;
            head.prev = null;
            size--;
        } else {
            for (int i = 0; i < index; i++) {
                if (i == index - 1) {
                    previous = current;
                }
                current = current.next;
            }
            setNode(current, previous);
        }
    }

    private void setNode(Node current, Node before) {
        if (current.next != null) {
            current.next.prev = before;
            before.next = current.next;
        } else {
            before.next = null;
            current.prev = null;
        }
        size--;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("DoublyLinkedList{size=").append(size).append("}");

        Node current = this.head;
        while (current != null) {
            sb.append(" ");
            sb.append(current.value);
            current = current.next;
        }

        return sb.toString();
    }
}
