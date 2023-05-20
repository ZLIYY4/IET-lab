import static org.junit.Assert.*;

import org.junit.Test;


public class MaciInfectsVirologist {

	@Test
	public void test() {
		String in = new String();
		String out = new String();
		in = Main.inputreader("MaciInfectsVirologist.txt");
		out = Main.outputreader("MaciInfectsVirologist.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
