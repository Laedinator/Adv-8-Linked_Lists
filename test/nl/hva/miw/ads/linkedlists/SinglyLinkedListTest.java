package nl.hva.miw.ads.linkedlists;

import org.junit.Test;

import static org.junit.Assert.*;

public class SinglyLinkedListTest {
    SinglyLinkedList l = new SinglyLinkedList();

    @Test
    public void add() {
        l.add(0, 400);
        l.add(0, 100);
        l.add(1, 200);
        l.add(2, 300);
        l.add(4, 500);

        String expected = "SinglyLinkedList{size=5} 100 200 300 400 500";
        String actual = l.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void get() {
        l.add(0, 100);
        l.add(1, 200);
        l.add(2, 300);
        l.add(3, 400);
        l.add(4, 500);

        int expected = 400;

        assertEquals(expected, l.get(3));
    }

    @Test
    public void delete() {
        l.add(0, 100);
        l.add(1, 200);
        l.add(2, 300);
        l.add(3, 400);
        l.add(4, 500);

        String expected = "SinglyLinkedList{size=4} 100 200 400 500";
        l.remove(2);
        String actual = l.toString();
        System.out.println(l.toString());
        assertEquals(expected, actual);
    }

    @Test
    public void deleteNull() {
        l.add(0, 100);
        l.add(1, 200);
        l.add(2, 300);
        l.add(3, 400);
        l.add(4, 500);

        String expected = "SinglyLinkedList{size=4} 200 300 400 500";
        l.remove(0);
        String actual = l.toString();
        System.out.println(l.toString());

        assertEquals(expected, actual);
    }

    @Test
    public void deleteLast() {
        l.add(0, 100);
        l.add(1, 200);
        l.add(2, 300);
        l.add(3, 400);
        l.add(4, 500);

        String expected = "SinglyLinkedList{size=4} 100 200 300 400";
        l.remove(4);
        String actual = l.toString();
        System.out.println(l.toString());

        assertEquals(expected, actual);
    }
}