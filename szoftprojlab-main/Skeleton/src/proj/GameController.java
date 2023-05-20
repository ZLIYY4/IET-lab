import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

/**
 * Fõosztály, irányítja a játék mûködését, a benne zajló mûveleteket(lopás, mozgás, felvétel, támadás, felszerelések eldobása)
 *
 */
public class GameController{
	/**
	 * Az éppen körön lévõ virológus 
	 */
	private Virologist main;
	private int hanyadik=0;
	/**
	 * A mezők a pályán
	 */
	private ArrayList<Field> mezok = new ArrayList<Field>();
	/**
	 * A konkret GameFrame
	 */
	private GameFrame jatekframe;
	/**
	 * Az a virológus akin éppen cselekvést végzünk el, támadjuk, lopunk tõle
	 */
	private Virologist temp;
	/**
	 * A pályán lévõ virologusok listája
	 */
	private ArrayList<Virologist> virologusok = new ArrayList<Virologist>();
	/**
	 * Létrehozza a képernyőt és a rajta lévő framet
	 * @param v megkapja, melyik virologus kezd
	 * @param f mezők listája
	 * @param virologusok virologusok listája
	 */
	public void init() {
		main=virologusok.get(0);
		jatekframe=new GameFrame(this);
		jatekframe.setTitle("Map");
	}

	public void lep() {
		hanyadik++;
		if(hanyadik==3) hanyadik=0;
		main=virologusok.get(hanyadik);
		main.Step();
	}

	public void initmap() {
		mezok.add(new Field());
		mezok.add(new Laboratory());
		
		mezok.add(new Laboratory());
		mezok.add(new Laboratory());
		mezok.add(new Laboratory());
		mezok.add(new Refuge());
		Refuge f=(Refuge) mezok.get(mezok.size()-1);
		f.setGear(new Glove());
		mezok.add(new Refuge());
		f=(Refuge) mezok.get(mezok.size()-1);
		f.setGear(new Cape());
		mezok.add(new Refuge());
		f=(Refuge) mezok.get(mezok.size()-1);
		f.setGear(new Axe());
		mezok.add(new Refuge());
		f=(Refuge) mezok.get(mezok.size()-1);
		f.setGear(new BackPack());
		mezok.add(new Storage());
		Storage l=(Storage) mezok.get(mezok.size()-1);
		l.matAdd(new Nucleotid());
		l.matAdd(new AminoAcid());
		mezok.add(new Storage());
		l=(Storage) mezok.get(mezok.size()-1);
		l.matAdd(new Nucleotid());
		l.matAdd(new AminoAcid());
		l.matAdd(new Nucleotid());
		l.matAdd(new AminoAcid());
		mezok.add(new Storage());
		l=(Storage) mezok.get(mezok.size()-1);
		l.matAdd(new Nucleotid());
		l.matAdd(new AminoAcid());
		l.matAdd(new Nucleotid());
		l.matAdd(new AminoAcid());
		virologusok.add(new Virologist());
		virologusok.add(new Virologist());
		virologusok.add(new Virologist());
		for(int i=0;i<3;i++) if(i<mezok.size()-1) {
			mezok.get(i).addNeighbour(mezok.get(i+1));
			mezok.get(i+1).addNeighbour(mezok.get(i));
		}	
		mezok.get(0).addNeighbour(mezok.get(5));
		mezok.get(10).addNeighbour(mezok.get(7));
		mezok.get(4).addNeighbour(mezok.get(8));
		mezok.get(0).addNeighbour(mezok.get(4));
		mezok.get(2).addNeighbour(mezok.get(6));
		mezok.get(6).addNeighbour(mezok.get(9));
		mezok.get(7).addNeighbour(mezok.get(11));
		mezok.get(5).addNeighbour(mezok.get(0));
		mezok.get(7).addNeighbour(mezok.get(10));
		mezok.get(8).addNeighbour(mezok.get(4));
		mezok.get(4).addNeighbour(mezok.get(0));
		mezok.get(6).addNeighbour(mezok.get(2));
		mezok.get(9).addNeighbour(mezok.get(6));
		mezok.get(11).addNeighbour(mezok.get(7));
		for(int i=8;i<11;i++) if(i<mezok.size()-1) {
			mezok.get(i).addNeighbour(mezok.get(i+1));
			mezok.get(i+1).addNeighbour(mezok.get(i));
		}
		mezok.get(0).setX(10);	mezok.get(1).setX(250);	mezok.get(2).setX(500); 	mezok.get(3).setX(750);
		mezok.get(4).setX(10);	mezok.get(5).setX(250);	mezok.get(6).setX(500);		mezok.get(7).setX(750);
		mezok.get(8).setX(10);	mezok.get(9).setX(250);	mezok.get(10).setX(500);		mezok.get(11).setX(750);
		
		mezok.get(0).setY(10);	mezok.get(1).setY(10);	mezok.get(2).setY(10); 	mezok.get(3).setY(10);
		mezok.get(4).setY(200);	mezok.get(5).setY(200);	mezok.get(6).setY(200);	mezok.get(7).setY(200);
		mezok.get(8).setY(430);	mezok.get(9).setY(430);	mezok.get(10).setY(430);	mezok.get(11).setY(430);
		
		mezok.get(3).Accept(virologusok.get(0));
		mezok.get(6).Accept(virologusok.get(1));
		mezok.get(9).Accept(virologusok.get(2));
		for(int i=0;i<mezok.size();i++) mezok.get(i).setid(Integer.toString(i));
		Game.ga=this;
	}
	/**
	 * Kiválasztunk egy másik virológust akitõl lopni szeretnénk, majd ezt eltároljuk egy temp változóban
	 * @param v a virologus akitõl lopni szeretnénk
	 */
	public void steal(Virologist v) {
		temp = v;
		Inventory i = temp.getinventory();
		List<Gear> geras = i.GetGears();
		OutFrame o = new OutFrame(geras, 1, 0, this);
	}
	/**
	 * Miután választottunk virológust, utána kiválasztjuk, hogy mit szeretnénk lopni tõle
	 * @param g felszerelés amit elszeretnénk a másik virologustól lopni
	 */
	public void steal(Gear g) {
		main.Steal(temp, g);

	}
	//TODO
	public void addInput(int input) {
		//TODO
	}
	/**
	 * Kiválasztunk egy másik virológust akit meg szeretnénk támadni, majd ezt eltároljuk egy temp változóban
	 * @param v a virologus akit megszertnénlk támadni
	 */
	public void attack(Virologist v) {
		temp = v;
		Inventory i = main.getinventory();
		List<Agens> agens = i.GetAgens();
		OutFrame o = new OutFrame(agens, 3, 0, this);
		RajzolMinden();
		
	}
	/**
	 * A kiválasztott virológust egy választott ágenssel megtámadjuk
	 * @param a az ágens amivel támadni akkarunk
	 */
	public void attack(Agens a) {
		main.Attack(a, temp, false);
		RajzolMinden();
		
	}
	public int getkijon() {return hanyadik;}
	/**
	 * A virológus eldob egy felszerelést
	 * @param g a felszerelés amit elszeretnénk dobni
	 */
	public void dropitem(Gear g) {
		main.TakeGearOff(g);
		RajzolMinden();
	}
	/**
	 * Virologus mozgatása, A virológussal melyik mezõre lépünk
	 * @param f a mezõ amire lépni szeretnénk
	 */
	public void move(Field f) {
		main.Move(f);
		RajzolMinden();
	
	}
	/**
	 * A paraméterként kapott 
	 * @param c melyik kódból craftoljuk le
	 */
	public void craft(Code c) {
		main.Craft(c);
		RajzolMinden();
	
	}
	/**
	 * Kiváltja a lenyomott gomb mûködéséhez kapcsolódó metódust
	 * @param milyen megkapja, hogy mit reprezental a gomb amit lenyomtak
	 */
	public void ButtonPushd(int milyen) {
		if(milyen == 0) {//Steal
			Field f = main.getField();
			List<Virologist> vir = f.getVirologist();
			OutFrame o = new OutFrame(vir, 2, this);
		}
		if(milyen == 1) {//Attack
			Field f = main.getField();
			List<Virologist> vir = f.getVirologist();
			OutFrame o = new OutFrame(vir, 2, this);
		}
		if(milyen == 2) {//Drop Item
			Inventory i = main.getinventory();
			List<Gear> gears = i.GetGears();
			OutFrame o = new OutFrame(gears,4, 0, this);
		}
		if(milyen == 3) {//Move
			Field f = main.getField();
			List<Field> fields = f.getNeighbors();
			OutFrame o = new OutFrame(fields, 5, 0, this);
		}
		if(milyen == 4) {//PickUp
			main.PickUp();
			lep();
		}
		if(milyen==6) {//Craft
			List<Code> codes= main.getcode();
			OutFrame o = new OutFrame(codes, 6, 'a', this);
		}
		
	}
	/**
	 * Graphics belső vátlozó aminek segítségével rajzolunk
	 */
	private Graphics g;
	/**
	 * Graphics g settere
	 * @param g megkapja a Graphics-t
	 */
	public void setG(Graphics g) {
		this.g = g;
	}
	/**
	 * Kirajzolja az egész pályát
	 */
	public void RajzolMinden() {
		Graphics2D g2d = (Graphics2D)g;
		Image image;
		image = Toolkit.getDefaultToolkit().getImage("./Pictures/City.jpg");
		g2d.drawImage(image, 0, 0,1000,550, jatekframe);
		for(Field f: mezok) {
			f.drawNeigbourLine(g, jatekframe);			
		}
		for(Field f: mezok) {
			f.drawField(g, jatekframe);
			f.drawIconOnField(g, jatekframe);
		}
		for(Field f: mezok) {
			if(jatekframe!=null)
				jatekframe.drawVirologinst(f, main,g);
		}
		Inventory i=main.getinventory();
		List<Gear> gears = i.GetGears();
		int glove =0;
		int backPack=0;
		int cape = 0;
		int axe=0;
		for(Gear g1: gears) {
			if(g1.getClass()==new Glove().getClass())
				glove++;
			if(g1.getClass()==new BackPack().getClass())
				backPack++;
			if(g1.getClass()==new Cape().getClass())
				cape++;
			if(g1.getClass()==new Axe().getClass())
				axe++;
		}
		jatekframe.drawInventory(glove, 1,g);//glove
		jatekframe.drawInventory(backPack, 2,g);//BackPack
		jatekframe.drawInventory(cape, 3,g);//Cape
		jatekframe.drawInventory(axe, 4,g);//Axe
		List<Agens> agens = i.GetAgens();
		int memoryLossV=0;
		int vitusDanceV=0;
		int stunV=0;
		int vaccine=0;
		for(Agens a: agens) {
			if(a.getClass()==new MemoryLossV().getClass())
				memoryLossV++;
			if(a.getClass()==new VitusDanceV().getClass())
				vitusDanceV++;
			if(a.getClass()==new StunV().getClass())
				stunV++;
			if(a.getClass()==new Vaccine().getClass())
				vaccine++;
		}
		jatekframe.drawInventory(memoryLossV, 5,g);//MemoryLossV
		jatekframe.drawInventory(vitusDanceV, 6,g);//VitusDanceV
		jatekframe.drawInventory(stunV, 7,g);//StunV
		jatekframe.drawInventory(vaccine, 8,g);//Vaccine
		List<Material> mat = i.getMaterial();
		MaterialVisitor visit= new MaterialVisitor();
		int aminoAcid=0;
		int nucleotid=0;
		for(Material m: mat) {
			if(m.Accept(visit)==1)
				aminoAcid++;
			if(m.Accept(visit)==2)
				nucleotid++;
		}
		jatekframe.drawInventory(aminoAcid, 9,g);//AminoAcid
		jatekframe.drawInventory(nucleotid, 10,g);//Nucleotid
	    ArrayList <Effect> effects = main.getEffect();
		jatekframe.drawEffects(effects,g);
	}
	/**
	 * Kirajzoltattja a befejezõ képernyõt mikor valaki megnyeri a jatékot
	 */
	public void JatekVege() {
		jatekframe.setVisible(false);
		WinFrame wf = new WinFrame();
		
	}
}
