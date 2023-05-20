import static org.junit.Assert.*;

import org.junit.Test;


public class RemoveAxe {

	@Test
	public void test() {
		String in = new String();
		String out = new String();
		in = Main.inputreader("RemoveAxe.txt");
		out = Main.outputreader("RemoveAxe.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
