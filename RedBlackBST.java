/*
Red Black Binary Search Tree, adapted from the book:
Algorithms 4th Edition by Robert Sedgewick and Kevin Wayne
 */
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class RedBlackBST<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node<K extends Comparable<K>,V> {
        private K key;
        private V value;
        private Node<K,V>  left, right;
        private int n;
        private boolean color;

        private Node (K k, V v, int nb, boolean myColor) {
            key= k;
            value = v;
            n =nb;
            color = myColor;
            left = null;
            right = null;
        }

        private K getKey() {
            return key;
        }

        private V getValue() {
            return value;
        }

        private boolean getColor() {
            return color;
        }

        private void setKey(K newKey) {
            key = newKey;
        }

        private void setValue(V newValue) {
            value = newValue;
        }

        private void setColor(boolean newColor) {
            color = newColor;
        }


    }

    private Node<K,V> root;

    public RedBlackBST() {
        root = null;
    }

    private boolean isRed(Node<K, V> x) {
        if (x == null) {
            return false;
        }
        return x.getColor();
    }

    private Node<K,V> rotateLeft(Node<K, V> h) {
        Node<K,V> x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.n = h.n;
        adjustSize(h);
        return x;
    }
    private Node<K,V> rotateRight(Node<K,V> h) {
        Node<K,V> x = h.left;
        h.left = x.right;
        x.right = h;
        x.color =h.color;
        h.color = RED;
        x.n = h.n;
        adjustSize(h);
        return x;
    }

    private void adjustSize(Node<K,V> h) {
        h.n = 1 + size(h.left) + size(h.right);
    }

    private int size(Node<K,V> x) {
        if (x==null) {
            return 0;
        } else {
            return x.n;
        }
    }

    private void flipColors(Node<K,V> h) {
        h. color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public void put(K key, V value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    public V get(K key) {
        return find(root, key);
    }

    private V find(Node<K,V> searchStart, K key) {
        if(searchStart==null) {
            return null;
        }
        int compareValue = key.compareTo(searchStart.key);
        if(compareValue<0) {
            return find(searchStart.left, key);
        } else if (compareValue>0) {
            return find(searchStart.right, key);
        } else{
            return searchStart.value;
        }
    }

    private Node<K,V> put(Node<K,V> h, K key, V value) {
        if(h==null){
            return new Node(key, value, 1, RED);
        }
        int compareValue = key.compareTo(h.key);
        if (compareValue<0) {
            h.left = put(h.left, key, value);
        } else if (compareValue>0) {
            h.right = put(h.right, key, value);
        } else {
            h.value = value;
        }
        if(isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h =rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }
        return h;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node<K,V> delete(Node<K,V> x, K key) {
        if (x == null) {
            return null;
        }
        int compareValue = key.compareTo(x.key);
        if(compareValue<0) {
            x.left = delete(x.left, key);
        } else if (compareValue>0) {
            x.right = delete(x.right, key);
        } else {
            if (x.right==null) {
                return x.left;
            }
            if (x.left==null) {
                return x.right;
            }
            Node<K,V> temp = x;
            x = min(temp.right);
            x.right = deleteMin(temp.right);
            x.left = temp.left;
        }
        adjustSize(x);
        return x;
    }

    private Node<K,V> min(Node<K,V> x) {
        if (x.left == null) {
            return x;
        }
        return min(x.left);
    }

    private Node<K,V> deleteMin(Node<K,V> x) {
        if(x.left==null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        adjustSize(x);
        return x;
    }

    public void deleteMin(){
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        root = deleteMin(root);
    }

    public K min() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<K,V> x = min(root);
        return x.key;
    }

    public int size() {
        return size(root);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public List<K> keyTraverse() {
        List<K> keys = new ArrayList<>();
        inOrderTraverseKey(keys, root);
        return keys;

    }

    private void inOrderTraverseKey(List<K> list, Node<K,V> startingNode) {
        if (startingNode != null) {
            if(startingNode.left!=null) {
                inOrderTraverseKey(list, startingNode.left);
            }
            list.add(startingNode.key);
            if(startingNode.right!=null) {
                inOrderTraverseKey(list, startingNode.right);
            }
        }

    }

    public Iterable<V> valueTraverse() {
        List<V> values = new ArrayList<>();
        inOrderTraverseValues(values, root);
        return values;

    }

    private void inOrderTraverseValues(List<V> list, Node<K,V> startingNode) {
        if (startingNode != null) {
            if(startingNode.left!=null) {
                inOrderTraverseValues(list, startingNode.left);
            }
            list.add(startingNode.value);
            if(startingNode.right!=null) {
                inOrderTraverseValues(list, startingNode.right);
            }
        }
    }
}
