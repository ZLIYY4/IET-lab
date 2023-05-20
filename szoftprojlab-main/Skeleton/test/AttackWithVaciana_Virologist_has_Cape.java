import static org.junit.Assert.*;

import org.junit.Test;


public class AttackWithVaciana_Virologist_has_Cape {

	@Test
	public void test() {
		String in = new String();
		String out = new String();
		in = Main.inputreader("AttackWithVaciana_Virologist_has_Cape.txt");
		out = Main.outputreader("AttackWithVaciana_Virologist_has_Cape.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
