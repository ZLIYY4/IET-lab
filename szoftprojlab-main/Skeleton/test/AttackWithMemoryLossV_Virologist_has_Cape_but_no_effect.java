import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AttackWithMemoryLossV_Virologist_has_Cape_but_no_effect {

	@Test
	public void test() {
		String in = new String();
		String out = new String();
		in = Main.inputreader("AttackWithMemoryLossV_Virologist_has_Cape_but_no_effect.txt");
		out = Main.outputreader("AttackWithMemoryLossV_Virologist_has_Cape_but_no_effect.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
