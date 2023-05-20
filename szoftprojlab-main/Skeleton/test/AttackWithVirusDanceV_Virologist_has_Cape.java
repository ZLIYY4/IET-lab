import static org.junit.Assert.*;

import org.junit.Test;


public class AttackWithVirusDanceV_Virologist_has_Cape {

	@Test
	public void test() {
		String in = new String();
		String out = new String();
		in = Main.inputreader("AttackWithVirusDanceV_Virologist_has_Cape.txt");
		out = Main.outputreader("AttackWithVirusDanceV_Virologist_has_Cape.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
