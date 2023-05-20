import static org.junit.Assert.*;

import org.junit.Test;


public class AttackWithVirusDanceV {

	@Test
	public void test() {
		String in = new String();
		String out = new String();
		in = Main.inputreader("AttackWithVirusDanceV.txt");
		out = Main.outputreader("AttackWithVirusDanceV.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
