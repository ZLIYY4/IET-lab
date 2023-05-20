import static org.junit.Assert.*;

import org.junit.Test;


public class RemoveGlove {

	@Test
	public void test() {
		String in = new String();
		String out = new String();
		in = Main.inputreader("RemoveGlove.txt");
		out = Main.outputreader("RemoveGlove.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
