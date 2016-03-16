package org.jsubercaze.bitmanip.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.jsubercaze.bitmanip.UIntStorage64;
import org.junit.Test;

public class Unsigned64StorageTest {

	@Test
	public void test() {
		UIntStorage64 test = new UIntStorage64(16, 32, 16);
		System.out.println(test);
		long stored = 65537; // 1 in the first field, 1 in the second
		stored = test.set(0, 32000L, stored);
		
		stored = test.set(2, 32001L, stored);
		assertEquals(32000L,test.getQuick(0, stored));
		assertEquals(32001L,test.getQuick(2, stored));
		// fail("Not yet implemented");
	}

}
