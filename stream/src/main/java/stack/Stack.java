package stack;

public class Stack {

    public static void main(String[] args) {
        Stack stack = new Stack(3);
        for (int i = 0; i < 3; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(stack.pop());
        }
    }

    int pos;
    Object [] data;

    Stack(int size) {
        data = new Object[size];
        pos = 0;
    }

    void push(Object o) {
        if ( pos == data.length) {
            Object[] newData = new Object[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
        data[pos++] = o;
    }

    Object pop() {
        return pos < 0 ? null : data[--pos];
    }
}
