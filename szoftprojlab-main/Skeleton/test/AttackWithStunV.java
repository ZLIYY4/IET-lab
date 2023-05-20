import static org.junit.Assert.*;

import org.junit.Test;


public class AttackWithStunV {

	@Test
	public void test() {
		String in = new String();
		String out = new String();
		in = Main.inputreader("AttackWithStunV.txt");
		out = Main.outputreader("AttackWithStunV.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
