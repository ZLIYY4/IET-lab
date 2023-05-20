import static org.junit.Assert.*;

import org.junit.Test;


public class SelfAttackWithMemoryLossV {

	@Test
	public void test() {
		String in = new String();
        String out = new String();
        in = Main.inputreader("SelfAttackWithMemoryLossV.txt");
        out = Main.outputreader("SelfAttackWithMemoryLossV.txt");

        assertTrue(Main.compare(in, out));
	}

}
