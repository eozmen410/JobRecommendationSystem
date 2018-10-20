public class Map<K extends Comparable<K>, V> {

    private RedBlackBST<K, V> tree;


    public Map() {
        tree = new RedBlackBST<>();
    }

    public int size() {
        return tree.size();
    }

    public boolean isEmpty() {
        return tree.isEmpty();
    }

    public V get(K key) {
        return tree.get(key);
    }

    public void put(K key, V value) {
        tree.put(key, value);
    }

    public void remove(K key) {
        tree.delete(key);
    }

    public Iterable<K> keySet() {
        return tree.keyTraverse();
    }

    public Iterable<V> valueSet() {
        return tree.valueTraverse();
    }


}