import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

/** 
 * Egy speci�lis mez�, amire a virol�gus l�phet 
 * Ez a mez� tartalmaz genetikai k�dot, 
 * aminek letapogat�sa sz�ks�ges a j�t�k megnyer�s�hez.
 * */
public class Laboratory extends Field
{
	/** 
	 * Az adott mez�n l�v� genetikai k�d
	 */
	private Code code;
	/**
	 * Laboratory konstruktora
	 * l�trehozza a Code-t amit tartalmaz, amit random m�don hozz l�tre
	 */
	public Laboratory() 
	{
		int rand = (int)(Math.random()*(4)+1);  
		switch(rand) {
		case 1:
			code=new Code(5,5,new StunV());
			break;
		case 2:
			code=new Code(3,3,new MemoryLossV());
			break;
		case 3:
			code=new Code(4,4,new Vaccine());
			break;
		case 4:
			code=new Code(6,6,new VitusDanceV());
			break;
		}
	}
	/** 
	 * A param�terk�nt kapott virol�gusnak �tadja a code v�ltoz� tartalm�t
	 * Ha Maci tapogataj, le akkor nem t�rt�nik semmi (nem tud ilyet csin�lni)
	 * @param v Melyik virol�gus tapogatja le a labor fal�t
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
		v.Touch(code);
	}
	/**
	 * A Code getter, visszat�r a mez�n tal�lhat� k�ddal
	 * @return code a mez�n tartalmazo k�d
	 */
	public Code getCode() {
		return code;
	}
	/**
	 * Kirajzolja a mez�n tal�lhat� dolgokat ha van rajta valami
	 */
	@Override
	public void drawIconOnField(Graphics g, GameFrame frame) {
		if(code!=null) {
			Graphics2D g2d = (Graphics2D)g;
			Image image;
			image = Toolkit.getDefaultToolkit().getImage("./Pictures/Code.png");
			g2d.drawImage(image, x, y,40,40, frame);
		}
	}
	/**
	 * Kirajzolja Labort
	 */
	@Override
	public void drawField(Graphics g, GameFrame frame) {
		Graphics2D g2d = (Graphics2D)g;
		Image image;
		image = Toolkit.getDefaultToolkit().getImage("./Pictures/Labor.png");
		g2d.drawImage(image, x, y,150,100, frame);
		g2d.drawString(this.id, (x+140), (y+15));
	}
}
