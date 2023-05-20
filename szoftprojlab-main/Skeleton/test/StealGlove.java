import static org.junit.Assert.*;

import org.junit.Test;
public class StealGlove {

	@Test
	public void test() {
		String in = new String();
        String out = new String();
        in = Main.inputreader("StealGlove.txt");
        out = Main.outputreader("StealGlove.txt");

        assertTrue(Main.compare(in, out));
	}

}
