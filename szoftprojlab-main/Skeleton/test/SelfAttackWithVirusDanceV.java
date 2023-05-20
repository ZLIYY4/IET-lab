import static org.junit.Assert.*;

import org.junit.Test;

public class SelfAttackWithVirusDanceV {

	@Test
	public void test() {
		String in = new String();
        String out = new String();
        in = Main.inputreader("SelfAttackWithVirusDanceV.txt");
        out = Main.outputreader("SelfAttackWithVirusDanceV.txt");

        assertTrue(Main.compare(in, out));
	}

}
