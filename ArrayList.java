import com.sun.tools.internal.ws.wsdl.document.jaxws.*;

import java.util.Arrays;

public class ArrayList {

    private Object[] arr;
    private int MAX_SIZE = 1000;
    private static int index = 0;

    public ArrayList() {
        arr = new Object[50];
    }

    public ArrayList(int i) {
        arr = new Object[i];
    }

    public void add(Object e) {
        if(index == arr.length) {
            if(arr.length * 2 >= MAX_SIZE) {
                throw new RuntimeException("Reached maximum size");
            }
            arr = Arrays.copyOf(arr, arr.length * 2);
        }

        arr[index] = e;
        index++;
    }

    public Object get(int i) {
        if(i < 0 || i >= arr.length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        return arr[i];
    }


    public Object set(int i, Object e) {
        if(i < 0 || i >= arr.length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Object original = arr[i];
        arr[i] = e;

        return original;
    }

    public int size() {
        return arr.length;
    }

}
