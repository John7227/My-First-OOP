package queue;

import java.util.NoSuchElementException;

public class Queue {

    private int count;
    String[] elements = new String[5];
    private int counter;

    public boolean isEmpty() {
        return count == 0;
    }

    public void add(String word) {
        boolean isFull = true;

        for(int count = 0; count < elements.length; count++) {
            if(elements[count] == null) {
                isFull = false;
                break;
            }
        }
        if(isFull)
            throw new IllegalArgumentException("Queue is Full");

        elements[count++] = word;
    }

    public String remove() {
        if(isEmpty())
            throw new NoSuchElementException("Queue is Empty");

        return elements[counter++];
    }

    public String poll() {
        return elements[counter++];
    }

    public String peek() {
            String word = elements[counter++];
            counter--;
        return word;
    }
}
