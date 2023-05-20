import static org.junit.Assert.*;

import org.junit.Test;


public class RemoveBackPack {

	@Test
	public void test() {
		String in = new String();
		String out = new String();
		in = Main.inputreader("RemoveBackPack.txt");
		out = Main.outputreader("RemoveBackPack.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
