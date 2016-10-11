package edu.osu.cs362;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.rules.Timeout;

public class WarmupTest  {
	
    @Test
    public void testFindIntegerExample() {

		int result = WarmUp.findInteger(new int[] { 1, 2, 3, 4, 5 }, 100);
		assertEquals(result, -1);

		for (int i = 1; i < 5; i++) {
			int result2 = WarmUp.findInteger(new int[] { 1, 2, 3, 4, 5 }, i + 1);
			assertEquals("findInteger(new int[]{1,2,3,4,5}," + i + ")", result2, i);
		}
	}
	@Test
	public void testlastZero()
		{
			int result = WarmUp.lastZero(new int[] {1,2,3,4,5});
			assertEquals(result, -1);

			int result2 = WarmUp.lastZero(new int[] {1,0,3,4,5});
			assertEquals(result2, 1);
			
			int result3 = WarmUp.lastZero(new int[] {1,0,3,4,0});
			assertEquals(result3, 4);
			
			int result4 = Warmup.lastZero(new int[] {0});
			assertEquals(result4, 0);	

			int result5 = Warmup.lastZero(new int{} {2});
			assertEquals(result5, -1);

		}

	@Test(expected=IndexOutOfBoundsException.class)
	public void testlast() {
		int result = WarmUp.last(new int[] {1,2,3,4,1}, 2);
		assertEquals(result, 1);
		}		
		

	
	@Test
	public void testpositive(){
		int result = WarmUp.positive(new int[] {-1,0,1,2,3});
		assertEquals(result, 3);
		}
		
	@Test public void testoddOrPos(){
		int result = WarmUp.oddOrPos(new int[] {-1,0,1,2});
		assertEquals(result, 2);	
		}
}
