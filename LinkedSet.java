public class LinkedSet<T> {


    private class Node<T> {
        private T data;
        private Node<T> next;


        private Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        private T getData() {
            return data;
        }

        private Node<T> getNext() {
            return next;
        }

        private void setNext(Node<T> newNext) {
            next = newNext;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedSet() {
        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        head.setNext(tail);
        size = 0;
    }

    public LinkedSet(LinkedSet<T> copying) {
        head = new Node<> (copying.head.getData(), null);
        tail = null;
        head.setNext(tail);
        Node<T> adding = copying.head.getNext();
        while(adding != null) {
            this.add(adding.getData());
            adding =adding.getNext();
        }
    }


    public void add(T element) {
        Node<T> newNode = new Node(element, null);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }


    public void remove(T element) throws IllegalArgumentException {
        if (contains(element)) {
            if(head.getData().equals(element)) {
                head = head.next;
            } else {
                Node<T> searching = head;
                while(!searching.getNext().getData().equals(element)) {
                    searching = searching.getNext();
                }
                if (searching.next == tail) {
                    tail = searching;
                } else {
                    searching.setNext(searching.getNext().getNext());
                }
            }
            size--;
        } else {
            throw new IllegalArgumentException("Element does not exist in this set.");
        }

    }


    public boolean contains(T element) {
        boolean found = false;
        Node<T> searching = head;
        while (!found && searching.getNext() != null) {
            if(searching.getData().equals(element)) {
                found = true;
            }
            searching = searching.getNext();
        }
        return found;
    }


    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public T[] toArray() {
        T[] array = (T[]) new Object[size];
        Node<T> adding  = head;
        int index = 0;
        while(adding!=null) {
            array[index] = adding.getData();
            adding = adding.getNext();
            index ++;
        }
        return array;
    }

    public String toString() {
        String message = "[ ";
        if (isEmpty()) {
            return "[ No elements ]";
        }
        Node<T> adding  = head;
        while(adding!=null) {
            if(message.equals("[ ")) {
                message = message + adding.getData().toString();
            } else {
                message = message + ", "+ adding.getData().toString();
            }
            adding = adding.getNext();
        }
        return message + " ]";
    }

}