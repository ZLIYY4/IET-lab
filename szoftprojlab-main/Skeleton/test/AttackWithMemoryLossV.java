import static org.junit.Assert.*;

import org.junit.Test;


public class AttackWithMemoryLossV {

	@Test
	public void test() {
		String in = new String();
		String out = new String();
		in = Main.inputreader("AttackWithMemoryLossV.txt");
		out = Main.outputreader("AttackWithMemoryLossV.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
