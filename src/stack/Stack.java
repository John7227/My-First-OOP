package stack;

public class Stack {

    private int count;
    String[] elements = new String[5];

    public boolean isEmpty() {
        return count == 0;
    }

    public void push(String word) {
        elements[count++] = word;
    }

    public String pop() {
        if(isEmpty())
            throw new IllegalArgumentException("Stack is empty");

        return elements[--count];
    }

    public String peek() {
        if(isEmpty())
            throw new IllegalArgumentException("Stack is empty");

        String word = elements[--count];
        count++;
        return word;
    }

    public int search(String word) {
        for(int index = 0; index < elements.length; index++) {
            if(elements[index] == word) {
                return count - index;
            }
        }
        return -1;
    }
}
