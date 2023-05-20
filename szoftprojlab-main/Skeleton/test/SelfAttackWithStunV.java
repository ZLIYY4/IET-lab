import static org.junit.Assert.*;

import org.junit.Test;

public class SelfAttackWithStunV {

	@Test
	public void test() {
		String in = new String();
        String out = new String();
        in = Main.inputreader("SelfAttackWithStunV.txt");
        out = Main.outputreader("SelfAttackWithStunV.txt");

        assertTrue(Main.compare(in, out));
	}

}
