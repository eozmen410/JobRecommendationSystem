public class Queue<E> {

    private E[] data;
    private int size;
    private int firstIndex;
    private static final int DEFAULTCAPACITY = 50;


    public Queue () {
        data = (E[]) new Object[DEFAULTCAPACITY];
        size = 0;
        firstIndex = 0;
    }

    public Queue(int initialCapacity) {
        data = (E[])  new Object[initialCapacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //circular usage of array
    public void enqueue(E e) {
        if (size == data.length) {
            resizeArray(data.length*2);
        }
        int available = (firstIndex + size) % data.length;
        data[available] = e;
        size++;
    }

    public E first () {
        if (isEmpty()){
            return null;
        }
        return data[firstIndex];
    }

    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E answer = data[firstIndex];
        data[firstIndex] = null;
        firstIndex = (firstIndex+1) % data.length;
        size--;
        return answer;
    }

    public boolean contains(E element) {
        if (isEmpty()) {
            return false;
        }
        for (int i = 0; i<data.length; i++) {
            if (data[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    private void resizeArray (int capacity) {
        E[] temp = (E[]) new Object[capacity];
        for (int i=0; i<data.length; i++) {
            temp[i] = data [i];
        }
        data = temp;
    }

    public E[] toArray() {
        E[] array = (E[]) new Object[size];
        for(int i= 0; i<size; i++) {
            int pos = firstIndex;
            array[i] = data[pos];
            pos++;
            if(pos>data.length) {
                pos = pos % data.length;
            }
        }
        return array;
    }

    public String toString() {
        String message = "";
        for(E e : this.toArray()) {
            message = message + e.toString() + " ";
        }
        return message;
    }

}
