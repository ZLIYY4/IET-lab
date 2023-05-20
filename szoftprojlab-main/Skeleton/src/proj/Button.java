import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 *	Kezeli az összes OutFramen megjelenõ gombot
 * Egy konkrét gombot reprezentál
 */
public class Button extends JButton{
	/**
	 * Itt tárolja el amit kap adatokat, hogy õ mit reprezentál
	 */
	private Object obj;
	private OutFrame frame;
	/**
	 * 	Ezt kapja meg az OutFramebõl, ebbõl tudja, hogy lennyomás esetén minek kell meghívnia
	 */
	private int mithiv;
	/**
	 * A GameController megjegyzi
	 */
	private GameController controller;
	/**
	 * lenyomás funkcióját valósítja meg
	 */
	public void Push() {
		if(mithiv==0) {
			controller.steal((Virologist) obj);
			this.setText("Rablas");
		}
		if(mithiv==1) {
			controller.steal((Gear) obj);
			this.setText("Gear rablas");
		}
		if(mithiv==2) {
			controller.attack((Virologist) obj);
			this.setText("Attack");
		}
		if(mithiv==3) {
			controller.attack((Agens)obj);
			this.setText("Attack");
		}if(mithiv==4) {
			controller.dropitem((Gear)obj);
			this.setText("Dropitem");
		}if(mithiv==5) {
			controller.move((Field)obj);
			this.setText("Move");
		}if(mithiv==6) {
			controller.craft((Code) obj);
			this.setText("Craft");
		}
		frame.dispose();
		controller.lep();
	}
	/**
	 * konstruktor, amikor egy Virológust reprezentál a gomb
	 * @param v amit reprezentál
	 * @param mithiv hogy mit kell hivnia mikor megtamadjak
	 * @param controller a GameController osztály hogy tudja a gomb, minek kell jelezni ha megnyomtak
	 */
	public Button(Virologist v, int mithiv, GameController controller,OutFrame f) {
		this.controller = controller;
		obj = v;
		this.mithiv=mithiv;
		this.addActionListener(new Push());
		frame=f;
	}
	/**
	 * konstruktor, amikor egy Agenst reprezentál a gomb
	 * @param a amit reprezentál
	 * @param mithiv hogy mit kell hivnia mikor megtamadjak
	* @param controller a GameController osztály hogy tudja a gomb, minek kell jelezni ha megnyomtak
	 */
	public Button(Agens a, int mithiv, GameController controller,OutFrame f) {
		this.controller = controller;
		obj = a;
		this.mithiv=mithiv;
		this.addActionListener(new Push());
		frame=f;
		}
	/**
	 * konstruktor, amikor egy Code reprezentál a gomb
	 * @param c amit reprezentál
	 * @param mithiv hogy mit kell hivnia mikor megtamadjak
	 * @param controller a GameController osztály hogy tudja a gomb, minek kell jelezni ha megnyomtak
	 */
	public Button(Code c, int mithiv, GameController controller,OutFrame f) {
		this.controller = controller;
		obj = c;
		this.mithiv = mithiv;
		this.addActionListener(new Push());
		frame=f;
	}
	/**
	 * konstruktor, amikor egy Gear reprezentál a gomb
	 * @param g amit reprezentál
	 * @param mithiv hogy mit kell hivnia mikor megtamadjak
	  * @param controller a GameController osztály hogy tudja a gomb, minek kell jelezni ha megnyomtak
	 */
	public Button(Gear g, int mithiv, GameController controller,OutFrame f) {
		this.controller = controller;
		obj = g;
		this.mithiv = mithiv;
		this.addActionListener(new Push());
		frame=f;
	}
	/**
	 * konstruktor, amikor egy Field reprezentál a gomb
	 * @param f amit reprezentál
	 * @param mithiv hogy mit kell hivnia mikor megtamadjak
	* @param controller a GameController osztály hogy tudja a gomb, minek kell jelezni ha megnyomtak
	 */
	public Button(Field f, int mithiv, GameController controller,OutFrame ff) {
		this.controller = controller;
		obj = f;
		this.mithiv = mithiv;
		frame=ff;
		this.addActionListener(new Push());
	}
	/**
	 * Az implementál osztály, ami a lenyomast kezeli
	 *
	 */
	public class Push implements ActionListener{
		/**
		 * A gomblenyomast kezeli
		 * @param e milyen event tortent
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			Push();
		}
	}
}
