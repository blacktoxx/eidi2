package exercise01;

import java.util.Iterator;
import java.util.RandomAccess;
import java.lang.Iterable;

public class DynamicArray<T> implements RandomAccess, Iterable<T> {

    private T[] array;
    // Gibt den naechsten freien Speicherplatzindex an
    private int nextFree = 0;

    @SuppressWarnings("unchecked")
    public DynamicArray() {
        array = (T[]) new Object[10];
    }

    @SuppressWarnings("unchecked")
    public DynamicArray(int n) {
        array = (T[]) new Object[n];
    }

    @SuppressWarnings("unchecked")
    public DynamicArray(T... values) {

        if (values == null) {
            return;
        }

        array = (T[]) new Object[values.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = values[i];
        }

        nextFree = array.length;
    }

    public void add(T val) {

        if (nextFree == array.length) {
            resize(array.length * 2);
        }

        array[nextFree++] = val;
    }

    @SuppressWarnings("unchecked")
    public void addAll(T... values) {
    	
        for(int i = 0; i < values.length; i++) {
        	add(values[i]);
        }
    }

    public boolean contains(T compare) {
    	
    	for(int i = 0; i < nextFree; i++) {
    		if(compare.equals(array[i])) {
    			return true;
    		}
    	}
        return false;
    }

    public T get(int index) {

        if (index < 0 || index >= nextFree) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return array[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= nextFree) {
            //Nothing to do
            return;
        }

        for (int i = index; i < nextFree - 1; i++) {
            array[i] = array[i + 1];
        }

        array[nextFree - 1] = null;
        nextFree--;
    }


    /**
     * Vergrößert / Verkleinert das Array auf die übergebene Länge.
     */
    @SuppressWarnings("unchecked")
    private void resize(int newLength) {

        T[] newArray = (T[]) new Object[newLength];

        for (int i = 0; i < Math.min(nextFree, newArray.length); i++) {
            newArray[i] = array[i];
        }

        nextFree = Math.min(nextFree, newArray.length);
        array = newArray;
    }

    public boolean isEmpty() {
        return nextFree == 0;
    }

    public int size() {
        //TODO: d)
        return nextFree;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray() {
    	T[] out = (T[]) new Object[nextFree];
    	for(int i = 0; i < nextFree; i++) {
    		out[i] = array[i];
    	}
    	return out;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i != array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return new String(sb);
    }

    @Override
    public boolean equals(Object o) {
    	if(o instanceof DynamicArray<?>) {
    		return equals((DynamicArray<?>) o);
    	}
    	return false;
    }			
    
    public boolean equals(DynamicArray<?> compare) {
    	if(compare.size() != nextFree) {
    		return false;
    	}
    	
    	for(int i = 0; i < nextFree; i++) {
    		if (!compare.get(i).equals(get(i))) {
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    @Override
    public int hashCode() {
    	int hash = 0;
        for(int i = 0; i < nextFree; i++) {
        	hash += array[i].hashCode();
        }
        return hash;
    }

	@Override
	public Iterator<T> iterator() {
		
		return new DynamicArrayIterator<T>(this);
	}
}