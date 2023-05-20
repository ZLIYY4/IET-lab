import static org.junit.Assert.*;

import org.junit.Test;


public class PickUpGlove {

	@Test
	public void test() {
		String in = new String();
		String out = new String();
		in = Main.inputreader("PickUpGlove.txt");
		out = Main.outputreader("PickUpGlove.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
