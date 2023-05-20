import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

/** 
 * Egy speci�lis mez�, amire a virol�gus l�phet 
 * Ez a mez� tartalmazhat anyagokat, 
 * amik sz�ks�gesek az �gensek elk�sz�t�shez.
*/
public class Storage extends Field
{
	/**
	 * A mez�n l�ve� anyagok list�ja
	 */
	List<Material> mat;
	/**
	 * Storage konstruktora
	 * l�trehozza a list�t
	 */
	public  Storage() {
		mat = new ArrayList<Material>();
	}
	/**
	 * Materi�l hozz�ada�sa a rakt�rhoz
	 */
	public void matAdd(Material m) 
	{
		//System.out.println("\tmatAdd(m)  Anyag felv�tele rakt�rba");
		mat.add(m);
		//System.out.println("\tmatAdd(m)  void return");
	}
	/** 
	 * A param�terk�nt kapott virol�gusnak �tadja a mat v�ltoz� tartalm�t
	 * Ha MaciEffect- van rajta, akkor a mez�r�l mindent elt�ntett, megesik
	 *@param v Melyik virol�gus vesszi fele a rakt�rb�l a dolgokat
	 */
	@Override
	public void Use(Virologist v)
	{
		//System.out.println("\tUse(v) Anyag felv�tel rakt�rb�l.");
		EffectVisitor visit= new EffectVisitor();
		for(int i = 0;i<v.getEffect().size();i++) {
			if(v.getEffect().get(i).Accept(visit)==7)
			{
				mat.clear();
				return;
			}
		}
		while (!mat.isEmpty() && v.getinventory().Getmax_Material() != v.getinventory().getMaterial().size()) {
			v.PickupMaterial(mat.get(0));
		}
		//System.out.println("\tUse(v) void return");
	}
	
	/** 
	 * A mat v�ltoz� list�b�l t�rli a param�terk�nt kapott Material-t(anyagot)
	 * @param m Melyik anyag legyen t�r�lve
	 */
	public void Remove(Material m)
	{
		//System.out.println("\tRemove(m) Anyag t�rl�se a rakt�rb�l.");
		if(!mat.remove(m)) System.out.println("Remove(m) Hiba,nem tudom ezt a Materialt torolni mert nincsen a listaban!");
		else mat.remove(m);
		//System.out.println("\tRemove(m) void return");
	}
	/**
	 * Kirajzolja a mez�n tal�lhat� dolgokat ha van rajta valami
	 */
	@Override
	public void drawIconOnField(Graphics g, GameFrame frame) {
		if(mat.size()>=0) {
			int nucleotid=0;
			int aminoacid=0;
			MaterialVisitor visitor = new MaterialVisitor();
			for(Material m: mat) {
				if(m.Accept(visitor)==1)
					aminoacid++;
				if(m.Accept(visitor)==2)
					nucleotid++;
			}
			Graphics2D g2d = (Graphics2D)g;
			if(aminoacid>0 && nucleotid>0) {
				Image image;
				image = Toolkit.getDefaultToolkit().getImage("./Pictures/AminoAcid.png");
				g2d.drawImage(image, x, y,40,40, frame);
				image = Toolkit.getDefaultToolkit().getImage("./Pictures/Nucleotid.png");
				g2d.drawImage(image, x+45, y,40,40, frame);
			} else if(aminoacid>0) {
				Image image;
				image = Toolkit.getDefaultToolkit().getImage("./Pictures/AminoAcid.png");
				g2d.drawImage(image, x, y,40,40, frame);
			} else if(nucleotid>0) {
				Image image;
				image = Toolkit.getDefaultToolkit().getImage("./Pictures/Nucleotid.png");
				g2d.drawImage(image, x, y,40,40, frame);
			}
		}
	}
	/**
	 * Kirajzolja az storage-t mez�t
	 */
	@Override
	public void drawField(Graphics g, GameFrame frame) {
		Graphics2D g2d = (Graphics2D)g;
		Image image;
		image = Toolkit.getDefaultToolkit().getImage("./Pictures/Storage.jpg");
		g2d.drawImage(image, x, y,150,100, frame);
		g2d.drawString(this.id, (x+140), (y+15));
	}
}
