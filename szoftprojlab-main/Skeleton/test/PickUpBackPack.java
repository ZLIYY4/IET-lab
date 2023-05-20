import static org.junit.Assert.*;

import org.junit.Test;


public class PickUpBackPack {

	@Test
	public void test() {
		String in = new String();
		String out = new String();
		in = Main.inputreader("PickUpBackPack.txt");
		out = Main.outputreader("PickUpBackPack.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
