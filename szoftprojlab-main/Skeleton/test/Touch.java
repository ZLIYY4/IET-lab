import static org.junit.Assert.*;

import org.junit.Test;

public class Touch {

	@Test
	public void test() {
		String in = new String();
        String out = new String();
        in = Main.inputreader("Touch.txt");
        out = Main.outputreader("Touch.txt");

        assertTrue(Main.compare(in, out));
	}

}
