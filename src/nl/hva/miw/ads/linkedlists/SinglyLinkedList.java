package nl.hva.miw.ads.linkedlists;

/**
 * Singly linked list.
 *
 * @author michel
 */
public class SinglyLinkedList {

    private class Node {
        int value;

        Node next = null;      // Link to next node

        public Node(int value) {
            this.value = value;
        }
    }

    private int size = 0;           // Length of list
    private Node head = null;      // Link to first node

    public SinglyLinkedList() {
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
        if (index < 0 || index > size) {
            return;
        }
        Node n = new Node(value);
        size++;

        if (index == 0) {
            n.next = head;
            head = n;
            return;
        }

        Node current = head;
        for (int count = 0; count < index - 1; count++) {
            current = current.next;
        }
        n.next = current.next;
        current.next = n;
    }

    public void remove(int index) {
        if (index < 0 || index > size) {
            return;
        }
        Node current = head;
        Node before = null;

        if (index == 0) {
            head = current.next;
            size--;
        } else {
            for (int i = 0; i < index; i++) {
                if (i == index - 1) {
                    before = current;
                }
                current = current.next;
            }
            setNode(current, before);
        }
    }

    private void setNode(Node current, Node before) {
        if (current.next != null) {
            before.next = current.next;
        } else {
            before.next = null;
        }
        size--;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("SinglyLinkedList{size=").append(size).append("}");

        Node current = this.head;
        while (current != null) {
            sb.append(" ");
            sb.append(current.value);
            current = current.next;
        }

        return sb.toString();
    }
}
