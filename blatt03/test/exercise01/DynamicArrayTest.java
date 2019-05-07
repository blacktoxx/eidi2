package exercise01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

class DynamicArrayTest {
	
	
	@Test
	void testConstructor() {
		DynamicArray<Integer> dynamicArray = new DynamicArray<Integer>(10, 5, 100, 2, 9, 65, 158);
		assertEquals(7, dynamicArray.size());
	}
	
	@Test
	void testIsEmpty() {
		DynamicArray<String > dynamicArray = new DynamicArray<String>();
		assert dynamicArray.isEmpty();
		
		dynamicArray = new DynamicArray<String>("Bolle");
		assert !dynamicArray.isEmpty();
	}
	
	@Test
	void testEquals() {
		DynamicArray<String> dynamicArray1 = new DynamicArray<String>("Hallo", "Ich", "bin", "der", "Horst");
		DynamicArray<String> dynamicArray2 = new DynamicArray<String>("Hallo", "Ich", "bin", "der", "Horst");
		DynamicArray<String> dynamicArray3 = new DynamicArray<String>("Hallo", "Ich", "bin", "der");
		DynamicArray<String> dynamicArray4 = new DynamicArray<String>("Hallo", "Ich", "bin", "der", "Heino");
		Object o = new Object();
		
		assert dynamicArray1.equals(dynamicArray2);
		assert dynamicArray1.equals((Object) dynamicArray2);
		assert !dynamicArray1.equals(dynamicArray3);
		assert !dynamicArray1.equals(dynamicArray4);
		assert !dynamicArray1.equals(o);
	}
	
	@Test
	void testContains() {
		DynamicArray<String> dynamicArray = new DynamicArray<String>("Hallo", "Ich", "bin", "der", "Horst");
		assert dynamicArray.contains("Horst");
		assert !dynamicArray.contains("Bolle");
		
	}
	
	@Test
	void testForEach() {
		DynamicArray<String> dynamicArray = new DynamicArray<String>("Hallo", "Ich", "bin", "der", "Heino");
		
		String[] array = new String[5];
		int i = 0;
		
		for(String s : dynamicArray) {
			array[i++] = s;
		}
		
		for(int j = 0; i < 5; j++) {
			assert array[j].equals(dynamicArray.toArray()[j]);
		}
	}

	@Test
	void testAdd() {
		DynamicArray<Double> dynamicArray1 = new DynamicArray<Double>(10.0, 5.0, 100.0, 2.0, 9.0, 65.0, 158.0);
		dynamicArray1.add(99.0);
		DynamicArray<Double> dynamicArray2 = new DynamicArray<Double>(10.0, 5.0, 100.0, 2.0, 9.0, 65.0, 158.0);
		assertEquals(dynamicArray2, dynamicArray2);
		
	}
	
	@Test
	@Disabled
	void testToArray() {
		DynamicArray<Double> dynamicArray = new DynamicArray<Double>(10.0, 5.0, 100.0, 2.0, 9.0, 65.0, 158.0);
		Double[] array = {10.0, 5.0, 100.0, 2.0, 9.0, 65.0, 158.0};
		assertEquals(dynamicArray.toArray(), array);
	}
	
	
}
