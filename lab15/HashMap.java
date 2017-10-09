import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by romanlapshuk on 7/20/17.
 */
public class HashMap<K, V> implements Map61BL<K, V> {

    LinkedList<Entry>[] map;
    double load_factor = 0.7;
    int size = 0;

    HashMap() {
        map = new LinkedList[16];

        for (int i = 0; i < map.length; i++) {
            map[i] = new LinkedList<>();
        }
    }


    HashMap(int initSize, double l_factor) {
        map = new LinkedList[initSize];
        load_factor = l_factor;

        for (int i = 0; i < map.length; i++) {
            map[i] = new LinkedList<>();
        }
    }

    HashMap(int initSize) {
        map = new LinkedList[initSize];

        for (int i = 0; i < map.length; i++) {
            map[i] = new LinkedList<>();
        }
    }

    public int capacity(){
        return map.length;
    }

    public void resize(){
        LinkedList<Entry>[] temp = new LinkedList[capacity()*2];
        for (int i = 0; i < temp.length; i++){
            temp[i] = new LinkedList<Entry>();
        }
        for (LinkedList<Entry> l: map) {
            if (l.size() > 0){
                for (Entry<K,V> e : l){
                    temp[hash(e._key)%temp.length].add(e);
                }
            }

        }
        map = temp;
    }

    @Override
    public void clear() {
        for (int i = 0; i < map.length; i++) {
            map[i] = new LinkedList<>();
        }
        size = 0;
    }

    @Override
    public boolean containsKey(K key) {
        int index = hash(key) % map.length;
        if (map[index].size() != 0) {
            for (Entry<K,V> e : map[index]) {
                if (e._key.equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        int index = hash(key) % map.length;
        if (map[index].size() != 0) {
            for (Entry<K,V> e : map[index]) {
                if (e._key.equals(key)) {
                    return e._value;
                }
            }
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        int index = hash(key) % map.length;
        for (Entry e : map[index]) {
            if (e._key.equals(key)) {
                e._value = value;
                return;
            }
        }
        map[index].add(new Entry(key, value));
        size++;

        int cap = capacity();
        if (((double) size()/ (double) cap) > load_factor){
            resize();
        }

    }

    @Override
    public V remove(K key) {
        int index = hash(key) % map.length;
        for (Entry<K, V> e : map[index]) {
            if (e._key.equals(key)) {
                size--;
                V toReturn = e._value;
                map[index].remove(e);
                return toReturn;
            }
        }
        return null;
    }

    @Override
    public boolean remove(K key, V value) {
        int index = hash(key) % map.length;
        for (Entry e : map[index]) {
            if (e.equals(new Entry(key, value))) {
                size--;
                map[index].remove(e);
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<K> iterator() {
        return new MapIterator();
    }

    int hash(K key) {
        return key.hashCode() & 0x7FFFFFFF;
    }
    

    private class MapIterator implements Iterator<K>{
        int currBucket = 0;
        int currElem = 0;

        @Override
        public boolean hasNext() {
            if (currBucket == capacity()){
                return false;
            } else if (currElem <  map[currBucket].size()){
                return true;
            } else {
                currBucket++;
                currElem = 0;
                return hasNext();
            }
        }

        @Override
        public K next() {
            K itemToReturn = (K) map[currBucket].get(currElem)._key;
            currElem++;
            return itemToReturn;
        }
    }

    /**
     * A wrapper class for holding each (KEY, VALUE) pair.
     */
    private static class Entry<K, V> {

        /**
         * The key used for lookup.
         */
        private K _key;
        /**
         * The associated value.
         */
        private V _value;

        /**
         * Create a new (KEY, VALUE) pair.
         */
        public Entry(K key, V value) {
            _key = key;
            _value = value;
        }

        /**
         * Returns true if this key matches with the OTHER's key.
         */
        public boolean keyEquals(Entry other) {
            return _key.equals(other._key);
        }

        /**
         * Returns true if both the KEY and the VALUE match.
         */
        @Override
        public boolean equals(Object other) {
            return (other instanceof Entry &&
                    _key.equals(((Entry) other)._key) &&
                    _value.equals(((Entry) other)._value));
        }

    }
}
