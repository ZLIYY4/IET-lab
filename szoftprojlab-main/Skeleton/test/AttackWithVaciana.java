import static org.junit.Assert.*;

import org.junit.Test;


public class AttackWithVaciana {

	@Test
	public void test() {
		String in = new String();
		String out = new String();
		in = Main.inputreader("AttackWithVaciana.txt");
		out = Main.outputreader("AttackWithVaciana.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
