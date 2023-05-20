import static org.junit.Assert.*;

import org.junit.Test;


public class Craft {

	@Test
	public void test() {
		String in = new String();
		String out = new String();
		in = Main.inputreader("Craft.txt");
		out = Main.outputreader("Craft.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
