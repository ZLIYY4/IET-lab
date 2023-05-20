import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
/**
 * Egy játék képernyõn lévõ gombot reprezentáló osztály
 * Kezeli, hogy milyen gomb és mit történik, ha megnyomják
 */
public class MyButton extends JButton{
	/**
	 * Milyen tipusú a gomb, mit történjen ha megnyomják
	 */
	int milyen;
	/**
	 * GameConrtoller, a grafikus vezértlõt jegyzi meg, hogy minek kell szólnia ha megnyomják
	 */
	GameController controll;
	/**
	 * Inizcializálja a gombot
	 * @param p megkapja, hogy milyen tipusú a gomb, minek kell rajta lennie
	 * @param c megkapja GaemController-t akinek szólnia kell ha lenyomták
	 */
	public void init(int p,GameController c){
		milyen=p;
		controll=c;
		if(milyen==1) {
			this.setText("Attack");
		}
		if(milyen==2) {
			this.setText("Drop Item");
		}
		if(milyen==3) {
			this.setText("Move");
		}
		if(milyen==4) {
			this.setText("PickUp");
		}
		if(milyen==6) {
			this.setText("Craft");
		}
		if(milyen==0) {
			this.setText("Steal");
		}
		this.addActionListener(new Push());
	}
	/**
	 * JButton-os belsõ ActionListener kezeli ha lenyomják a gombot
	 */
	public class Push implements ActionListener{
		/**
		 * Felüldefiniált belsõ függvény, hogy mi történjen ha megnyomják a gombot
		 * jelen esetünkben szólunk a GameControllernek
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
				controll.ButtonPushd(milyen);
		}  
		
	}
}
