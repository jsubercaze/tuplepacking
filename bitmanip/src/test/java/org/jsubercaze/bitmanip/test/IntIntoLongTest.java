package org.jsubercaze.bitmanip.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.jsubercaze.bitmanip.UIntIntoLong;
import org.junit.Test;

public class IntIntoLongTest {

	@Test
	public void test() {
		UIntIntoLong test = new UIntIntoLong(16, 32, 16);
		System.out.println(test);
		long stored = 65537; // 1 in the first field, 1 in the second
		stored = test.set(0, 32000L, stored);
		
		stored = test.set(2, 32001L, stored);
		assertEquals(32000L,test.getQuickLong(0, stored));
		assertEquals(32001L,test.getQuickLong(2, stored));
		// fail("Not yet implemented");
	}

}
