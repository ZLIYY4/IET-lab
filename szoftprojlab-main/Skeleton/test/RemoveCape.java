import static org.junit.Assert.*;


import org.junit.Test;


public class RemoveCape {

	@Test
	public void test() {
		String in = new String();
		String out = new String();
		in = Main.inputreader("RemoveCape.txt");
		out = Main.outputreader("RemoveCape.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
