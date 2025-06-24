package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private BSTNode<K, V> root;
    private int size;

    public BSTMap() {
        root = null;
        size = 0;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean containsKey(K key) {
        BSTNode<K, V> node = root;
        while (node != null) {
            if (node.key.equals(key)) {
                return true;
            } else if (node.key.compareTo(key) < 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        return getRecursion(root, key);
    }

    private V getRecursion(BSTNode<K, V> root, K key) {
        if (root == null) return null;
        if (root.key.compareTo(key) == 0) {
            return root.value;
        } else if (root.key.compareTo(key) < 0) {
            return getRecursion(root.left, key);
        } else {
            return getRecursion(root.right, key);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(K key, V value) {
        root = putRecursion(root, key, value);
        size++;
    }

    private BSTNode<K, V> putRecursion(BSTNode<K, V> root, K key, V value) {
        if (root == null) {
            return new BSTNode<>(key, value, null, null);
        } else if (root.key.compareTo(key) == 0) {
            root.value = value;
        } else if (root.key.compareTo(key) < 0) {
            root.left = putRecursion(root.left, key, value);
        } else {
            root.right = putRecursion(root.right, key, value);
        }
        return root;
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }

    static private class BSTNode<K extends Comparable<K>, V> {
        K key;
        V value;
        BSTNode<K, V> left;
        BSTNode<K, V> right;

        public BSTNode(K key, V value, BSTNode<K, V> left, BSTNode<K, V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
