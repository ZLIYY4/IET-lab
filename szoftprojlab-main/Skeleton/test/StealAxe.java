import static org.junit.Assert.*;

import org.junit.Test;

public class StealAxe {

	@Test
	public void test() {
		String in = new String();
        String out = new String();
        in = Main.inputreader("StealAxe.txt");
        out = Main.outputreader("StealAxe.txt");

        assertTrue(Main.compare(in, out));
	}

}
