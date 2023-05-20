import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.Font;
/** 
 * A p�lya egy �p�t�eleme, amire a virol�gus l�phet.
 * */
public class Field implements FieldView
{

	/**
	 * Egy id amivel tudjuk az adott mez�t a ki�r�sn�l azonos�tani a felhaszn�l� fogja hasszn�lni
	 */
	String id;
	/**
	 * Mezo helye kirajzolasnal
	 */
	int x,y;
	/**
	 * A mez�n tart�zk�d� virologusok list�ja
	 */
	private List<Virologist> virologist;
	/** 
	 *  Az adott j�t�kmez� szomsz�dos mez�inek list�ja
	 */
	private List<Field> neighbors;
	/**
	 * Visszaadja, hogy melyik virologusok vannak az adott mez�n.
	 * @return virologist Lista hogy milyen virol�gusok vannak a mez�n
	 */
	public List<Virologist> getVirologist(){
		return virologist;
	}
	/**
	 * Getter a szomszedok lekerdezesere.
	 * @return
	 */
	public List<Field> getNeighbors(){
		return neighbors;
	}
	public void addNeighbour(Field f) {
		neighbors.add(f);
	}
	/**
	 * Az oszt�ly konstruktora.
	 * L�trehozza a list�kat, amikben t�rolva lesz a szomsz�dos mez�
	 * �s a virol�gus ami rajta �ll
	 */
	public void setId(String s) {id=s;}
	public Field() {
		virologist=new ArrayList<Virologist>();
		neighbors = new ArrayList<Field>();
		id=""+(int)(Math.random()*10);
	}
	/**
	 * A param�terk�nt kapott mez�t be�ll�tja szomsz�dnak
	 * @param f melyik mez� a szomsz�dja
	 */
	public void AddField(Field f)
	{
		neighbors.add(f);
	}
	/** 
	 *  A virologists list�ba a param�ternek kapott Virologist-et viszi fel
	 *  @param v Megkapja, hogy melyik virologus l�pett r�
	 */
	public void Accept(Virologist v)
	{
		//System.out.println("\tAccept(v) Virol�gus hozz�ad�dik egy mez�h�z");
		virologist.add(v);
		v.setFields(this);
	}
	
	public String getid()
	{
		return id;
	}
	
	public void setid(String nid)
	{
		 id=nid;
	}
	/** 
	 *  A param�ternek kapott Virologist-et t�rli a virologists list�b�l
	 *  @param v Megkapja, hogy melyik virol�gus l�pett le a mez�r�l, melyiket kell t�rl�lni a list�b�l
	 */
	public void Remove(Virologist v)
	{
		//System.out.println("\tRemove(v) Az adott mez� elhagyja a Virologus");
		virologist.remove(v);
	}
	
	/** 
	 *  A param�ternek kapott Virologist-nek ad valamit, 
	 *  a lesz�rmazottak fel�l defini�lj�k (ez a valami, lehet felszerel�s, code, anyag)
	 */
	public void Use(Virologist v)
	{
	}
	
	/** 
	 * Visszat�r egy v�letlenszer�en v�lasztott szomsz�dos mez�vel
	 * @return a v�letlenszer� szomsz�dos mez�
	 */
	public Field GetRandomNeighbor()
	{
		//System.out.println("\tGetRandomNeighbor() Egy random szomsz�dos mez�t kapunk meg a mez�t�l");
        Random rand = new Random();
        //System.out.println("\tGetRandomNeighbor() Field return");
        return neighbors.get(rand.nextInt(neighbors.size()));
	}
	/**
	 * X pozitic� setter
	 * @param f megkapja, mire �ll�tsa x-et
	 */
	public void setX(int f) {x=f;}
	/**
	 * Y pozici� settere
	 * @param f megkapja mire �ll�ta y-t
	 */
	public void setY(int f) {y=f;}
	/**
	 * Y getter
	 * @return visszat�r y pozici�j�val
	 */
	public int getY() {return y;}
	/**
	 * X getter
	 * @return visszat�r X pozici�j�val
	 */
	public int getX() {return x;}
	//1000*650 a fieldeket tartalamzo resz
	/**
	 * Kirajzolja az �res mez�t
	 */
	@Override
	public void drawField(Graphics g, GameFrame frame) {
		Graphics2D g2d = (Graphics2D)g;
		Image image;
		image = Toolkit.getDefaultToolkit().getImage("./Pictures/Empty.jpg");
		g2d.drawImage(image, x, y,150,100, frame);//TODO a k�p el�r�si �tvonala
		g2d.setFont(new Font("TimesRoman", Font.BOLD, 15)); 
		g2d.setPaint(Color.RED);
		g2d.drawString(this.id, (x+140), (y+15));
	}
	@Override
	public void drawNeigbourLine(Graphics g, GameFrame frame) {
		for(Field f: neighbors) {
			Graphics2D g2d = (Graphics2D)g;
			g2d.setStroke(new BasicStroke(5));
			g2d.setColor(Color.BLACK);
			g2d.draw(new Line2D.Float(x+75, y+50, f.x+75, f.y+50));
		}
	}
	/**
	 * Kirajzolja a mez�n l�v� dolgokat jelen esetben ez semmit jelent
	 */
	@Override
	public void drawIconOnField(Graphics g, GameFrame frame) {
		//Lesz�mrazottakban van implement�lva itt �res
	}
}
