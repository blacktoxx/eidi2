package exercise01;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArrayIterator<T> implements Iterator<T>{

	DynamicArray<T> dynamicArray;
	int position;
	
	public DynamicArrayIterator(DynamicArray<T> dynamicArray) {
		this.dynamicArray = dynamicArray;
		position = -1;
	}
	
	@Override
	public boolean hasNext() {
		return position < dynamicArray.size() - 1;
	}

	@Override
	public T next() throws NoSuchElementException {
		if(!hasNext()) {
			throw new NoSuchElementException();
		}
		
		return dynamicArray.get(++position);
	}

}
