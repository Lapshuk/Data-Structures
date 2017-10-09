import java.util.LinkedList;

/**
 *  A simple mapping from string names to string values backed by an array.
 *  Supports only A-Z for the first character of the key name. Values can be
 *  any valid string.
 *
 *  @author You
 */
public class SimpleNameMap {

    LinkedList<Entry>[] simpleMap = new LinkedList[26];
    double load_factor = 0.75;
    int size = 0;

    SimpleNameMap(){
        for (int i = 0; i < simpleMap.length; i++){
            simpleMap[i] = new LinkedList<>();
        }
    }

    /** Returns true if the map contains the KEY. */
    boolean containsKey(String key){
        int index = hash(key)%simpleMap.length;
        if (simpleMap[index].size() != 0){
            for (Entry e : simpleMap[hash(key)]){
                if (e._key.equals(key)){
                    return true;
                }
            }
        }
        return false;
    }

    /** Returns the value for the specified KEY. */
    String get(String key){
        int index = hash(key)%simpleMap.length;
        if (simpleMap[index].size() != 0){
            for (Entry e : simpleMap[index]){
                if (e._key.equals(key)){
                    return e._value;
                }
            }
        }
        return null;
    }

    /** Put a (KEY, VALUE) pair into this map. */
    void put(String key, String value){
        int index = hash(key)%simpleMap.length;
        for (Entry e : simpleMap[index]){
            if (e._key.equals(key)){
                simpleMap[index].remove(e);
                simpleMap[index].add(new Entry(key,value));
                return;
            }
        }
        simpleMap[index].add(new Entry(key,value));
        size++;
        if (((double) size/ (double)simpleMap.length) >= load_factor){
            resize();
        }
    }

    /** Remove a single entry, KEY, from this table and return the VALUE if successful or NULL otherwise. */
    String remove(String key){
        int index = hash(key)%simpleMap.length;
        for (Entry e : simpleMap[index]){
            if (e._key.equals(key)){
                String toReturn = e._value;
                simpleMap[index].remove(e);
                return toReturn;
            }
        }
        return null;
    }

    int hash(String key) {
        return key.hashCode() & 0x7FFFFFFF;
    }

    public void resize(){
        LinkedList<Entry>[] temp = new LinkedList[simpleMap.length*2];
        for (int i = 0; i < temp.length; i++){
            temp[i] = new LinkedList<Entry>();
        }
        for (LinkedList<Entry> l: simpleMap) {
            if (l.size() > 0){
                for (Entry e : l){
                    temp[hash(e._key)%temp.length].add(e);
                }
            }

        }
        simpleMap = temp;
    }

    /** A wrapper class for holding each (KEY, VALUE) pair. */
    private static class Entry {

        /** The key used for lookup. */
        private String _key;
        /** The associated value. */
        private String _value;

        /** Create a new (KEY, VALUE) pair. */
        public Entry(String key, String value) {
            _key = key;
            _value = value;
        }

        /** Returns true if this key matches with the OTHER's key. */
        public boolean keyEquals(Entry other) {
            return _key.equals(other._key);
        }

        /** Returns true if both the KEY and the VALUE match. */
        @Override
        public boolean equals(Object other) {
            return (other instanceof Entry &&
                    _key.equals(((Entry) other)._key) &&
                    _value.equals(((Entry) other)._value));
        }

    }

    /** Returns true if the given KEY is a valid name that starts with A-Z. */
    private static boolean isValidName(String key) {
        return 'A' <= key.charAt(0) && key.charAt(0) <= 'Z';
    }

}