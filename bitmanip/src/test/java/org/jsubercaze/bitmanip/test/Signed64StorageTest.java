package org.jsubercaze.bitmanip.test;

import static org.junit.Assert.assertEquals;

import org.jsubercaze.bitmanip.IntStorage64;
import org.junit.Test;

public class Signed64StorageTest {

	@Test
	public void test() {
		IntStorage64 test = new IntStorage64(16, 32, 16);
		System.out.println(test);
		long stored = 0; // 1 in the first field, 1 in the second
		stored = test.set(0, -1L, stored);
		
		stored = test.set(2, -2L, stored);
		assertEquals(-1L,test.getQuick(0, stored));
		assertEquals(-2L,test.getQuick(2, stored));
		// fail("Not yet implemented");
	}

}
