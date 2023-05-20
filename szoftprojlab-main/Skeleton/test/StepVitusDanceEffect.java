import static org.junit.Assert.*;

import org.junit.Test;

public class StepVitusDanceEffect {

	@Test
	public void test() {
		String in = new String();
        String out = new String();
        in = Main.inputreader("StepVitusDanceEffect.txt");
        out = Main.outputreader("StepVitusDanceEffect.txt");

        assertTrue(Main.compare(in, out));
	}

}
