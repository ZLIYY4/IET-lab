import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 	Kezeli a képernyõn lévõ gombokat, és hogy azok lenyomásánál mi fog történni
 *
 */
public class OutFrame extends JFrame {
	/**
	 *  Ezt adjuk, majd át a hozzá tartozó gomboknak ezt tárolja, hogy milyen függvényt kell a gomb lenyomás esetén meghívni
	 */
	int mithiv;
	ArrayList<Button> gombok = new ArrayList<Button>();
	//Konstruktoroknak azért van 3 paraméterre, mert különben azonosak lennének hiáaba különbözõk a listák
	/**
	 * konstruktor, amikor a felhasználó Virologusok közül tud választani
	 * @param vir megkapja hogy melyik virologusok kozul kell valasztani
	 * @param mithiv megkapja, hogy milyen tevekenyseghez kell ez a valasztas
	 * @param controller a GameController osztály hogy tudja a gomb, minek kell jelezni ha megnyomtak
	 */
	public OutFrame(List<Virologist> vir, int mithiv, GameController controller) {
		this.setSize(450, 470);
		JPanel panel = new JPanel();
		int c=0;
		for(Virologist v: vir) {
			c++;
			Button b= new Button(v,mithiv, controller,this);
			b.setVisible(true);
			b.setText("Virologus"+c);
			this.setSize(600,600);
	        this.setLocationRelativeTo(null);  
	        this.setVisible(true);  
			b.setBounds(200,c*100,150,50);
			gombok.add(b);
			panel.add(b);
		}
		this.add(panel);
		this.setVisible(true);
	}
	/**
	 * konstruktor, amikor a felhasználó Gearek közül tud választani
	 * @param gears megkapja milyen felszerelések közül kell választani
	 * @param mithiv megkapja, hogy milyen tevekenyseghez kell ez a valasztas
	 * @param i csak azért van, hogy ne legyen gond az azonos konstruktorrokkal
	 * @param controller a GameController osztály hogy tudja a gomb, minek kell jelezni ha megnyomtak
	 */
	public OutFrame(List<Gear> gears, int mithiv, int i, GameController controller) {
		this.setSize(450, 470);
		JPanel panel = new JPanel();
		int c=0;
		for(Gear g: gears) {
			c++;
			Button b= new Button(g,mithiv, controller,this);
			b.setVisible(true);
			b.setText("Gear"+c);
			this.setSize(600,600);
	        this.setLocationRelativeTo(null);  
	        this.setVisible(true);  
			b.setBounds(200,c*100,150,50);
			gombok.add(b);
			panel.add(b);
		}
		this.add(panel);
		this.setVisible(true);
		//TODO grafika
	}
	/**
	 * konstruktor, amikor a felhasználó Agens közül tud választani
	 * @param agens megkapja milyen ágensek közül kell választani
	 * @param mithiv megkapja, hogy milyen tevekenyseghez kell ez a valasztas
	 * @param i csak azért van, hogy ne legyen gond az azonos konstruktorrokkal
	 * @param controller a GameController osztály hogy tudja a gomb, minek kell jelezni ha megnyomtak
	 */
	public OutFrame(List<Agens> agens, int mithiv, double i, GameController controller) {
		this.setSize(450, 470);
		JPanel panel = new JPanel();
		int c=0;
		for(Agens a: agens) {
			c++;
			Button b= new Button(a,mithiv, controller,this);
			b.setVisible(true);
			b.setText("Agens"+c);
			this.setSize(600,600);
	        this.setLocationRelativeTo(null);  
	        this.setVisible(true);  
			b.setBounds(200,c*100,150,50);
			gombok.add(b);
			panel.add(b);
		}
		this.add(panel);
		this.setVisible(true);
	}
	/**
	 * konstruktor, amikor a felhasználó Field közül tud választani
	 * @param fields megkapja milyen mezõk közül kell választani
	 * @param mithiv megkapja, hogy milyen tevekenyseghez kell ez a valasztas
	 * @param i csak azért van, hogy ne legyen gond az azonos konstruktorrokkal
	 * @param controller a GameController osztály hogy tudja a gomb, minek kell jelezni ha megnyomtak
	 */
	public OutFrame(List<Field> fields, int mithiv, float i, GameController controller) {
		this.setSize(450, 470);
		JPanel panel = new JPanel();
		int c=0;
		for(Field f:fields) {
			c++;
			Button b= new Button(f,mithiv, controller,this);
			this.setSize(1240,720);
	        this.setLocationRelativeTo(null);   
	        this.setVisible(true); 
			b.setVisible(true);
			b.setText(f.getid());
	        b.setBounds(200,c*100,150,50);
			gombok.add(b);
			panel.add(b);
		}
		this.add(panel);
		this.setVisible(true);
	}
	/**
	 * konstruktor, amikor a felhasználó Code közül tud választani
	 * @param codes megkapja milyen kódok közül kell választani
	 * @param mithiv megkapja, hogy milyen tevekenyseghez kell ez a valasztas
	 * @param i csak azért van, hogy ne legyen gond az azonos konstruktorrokkal
	 * @param controller a GameController osztály hogy tudja a gomb, minek kell jelezni ha megnyomtak
	 */
	public OutFrame(List<Code> codes, int mithiv, char i, GameController controller) {
		this.setSize(450, 470);
		JPanel panel = new JPanel();
		int cc=0;
		for(Code c: codes) {
			cc++;
			Button b= new Button(c,mithiv, controller,this);
			b.setVisible(true);
			b.setText("Code"+c);
			this.setSize(600,600);
	        this.setLocationRelativeTo(null);  
	        this.setVisible(true);  
			b.setBounds(200,cc*100,150,50);
			gombok.add(b);
			panel.add(b);
		}
		this.add(panel);
		this.setVisible(true);
	}
}
