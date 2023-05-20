import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

/** 
 * Egy speci�lis mez�, amire a virol�gus l�phet. Ez a mez� tartalmazhat felszerel�st.
 */
public class Refuge extends Field
{
	/** 
	 * Az adott j�t�kmez�n l�v� felszerel�s
	 */
	private Gear gear;
	/**
	 * Gear getter
	 * @return gear
	 */
	public Gear getGear() {
		return gear;
	}
	/**
	 * gear settere
	 * be�ll�tja, hogy milyen felszerel�s van az adott mez�n
	 */
	public void setGear(Gear g) 
	{
		//System.out.println("\tsetGear(g)  �vohelyhez felszerel�s hozz�ad�sa.");
		gear=g;
	}
	/** 
	 * A param�terk�nt kapott virol�gusnak �tadja a gear v�ltoz� tartalm�t
	 * Ha Macieffect van rajta nem tud felszerel�st felvenni �gy itt nem t�rt�nik, semmi ha olyan effect van ratja
	 * @param v Melyik virol�gus veszi fel a felszerel�st
	 */
	@Override
	public void Use(Virologist v)
	{
		EffectVisitor visit= new EffectVisitor();
		for(int i = 0;i<v.getEffect().size();i++) {
			if(v.getEffect().get(i).Accept(visit)==7)
			{
				return;
			}
		}
		int gearSize = v.getinventory().Gearssize();
		int maxGear = v.getinventory().Getmax_Gear();
		if(gearSize<=maxGear && gear!=null)
			gear.TakeGear(v);
		this.Remove();
	}
	
	/** 
	 * A gear v�ltoz� �rt�k�t null-ra v�ltoztatja, felszerl�s elv�ttele a mez�r�l
	 */
	public void Remove()
	{
		this.gear=null;
	}
	/**
	 * Kirajzolja a mez�n tal�lhat� dolgokat ha van rajta valami
	 */
	@Override
	public void drawIconOnField(Graphics g, GameFrame frame) {
		if(gear!=null) {
			Graphics2D g2d = (Graphics2D)g;
			Image image=null;
			if(gear.getClass()==new Glove().getClass())
				image = Toolkit.getDefaultToolkit().getImage("./Pictures/Glove.png");
			if(gear.getClass()==new BackPack().getClass())
				image = Toolkit.getDefaultToolkit().getImage("./Pictures/Backpack.png");
			if(gear.getClass()==new Cape().getClass())
				image = Toolkit.getDefaultToolkit().getImage("./Pictures/Cape.png");
			if(gear.getClass()==new Axe().getClass())
				image = Toolkit.getDefaultToolkit().getImage("./Pictures/Axe.png");
			if(image!=null) {
				g2d.drawImage(image, x, y,40,40, frame);
			}
		}
	}
	/**
	 * Kirajzolja az Refuge-t mez�t
	 */
	@Override
	public void drawField(Graphics g, GameFrame frame) {
		Graphics2D g2d = (Graphics2D)g;
		Image image;
		image = Toolkit.getDefaultToolkit().getImage("./Pictures/Shelter.jpg");
		g2d.drawImage(image, x, y,150,100, frame);
		g2d.drawString(this.id, (x+140), (y+15));
	}
}
