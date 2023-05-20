import static org.junit.Assert.*;

import org.junit.Test;


public class SelfAttackWithVacina {

	@Test
	public void test() {
		String in = new String();
        String out = new String();
        in = Main.inputreader("SelfAttackWithVacina.txt");
        out = Main.outputreader("SelfAttackWithVacina.txt");

        assertTrue(Main.compare(in, out));
		
		
		
	}

}
