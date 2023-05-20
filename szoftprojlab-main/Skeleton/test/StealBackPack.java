import static org.junit.Assert.*;

import org.junit.Test;
public class StealBackPack {

	@Test
	public void test() {
		String in = new String();
        String out = new String();
        in = Main.inputreader("StealBackPack.txt");
        out = Main.outputreader("StealBackPack.txt");

        assertTrue(Main.compare(in, out));
	}

}
