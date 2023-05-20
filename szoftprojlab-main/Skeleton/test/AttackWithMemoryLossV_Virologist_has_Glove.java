import static org.junit.Assert.*;

import org.junit.Test;


public class AttackWithMemoryLossV_Virologist_has_Glove {

	@Test
	public void test() {
		String in = new String();
		String out = new String();
		in = Main.inputreader("AttackWithMemoryLossV_Virologist_has_Glove.txt");
		out = Main.outputreader("AttackWithMemoryLossV_Virologist_has_Glove.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
