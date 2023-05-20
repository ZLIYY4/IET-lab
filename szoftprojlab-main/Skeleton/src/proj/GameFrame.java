import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.Line;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GameFrame extends JFrame {
	
	private int x;
	private int y;
	ArrayList<MyButton> gombok = new ArrayList<MyButton>();
	GameController controller;

	
	/**
	 * Letrehoz egy gamecontrollert
	 */
	public GameFrame(GameController contr) {
		SwingUtilities.updateComponentTreeUI(this);
		controller = contr;
		x=0;
		y=0;
		this.add(new PaintComp());
		this.setSize(1290,720);
        this.setLocationRelativeTo(null);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setVisible(true);  
        gombok.add(new MyButton());
        gombok.get(gombok.size()-1).setVisible(true);
        gombok.get(gombok.size()-1).init(0, contr);
        gombok.get(gombok.size()-1).setBounds(10,600,150,50);
        this.add(gombok.get(gombok.size()-1));
        gombok.add(new MyButton());
        gombok.get(gombok.size()-1).setVisible(true);
        gombok.get(gombok.size()-1).init(1, contr);
        gombok.get(gombok.size()-1).setBounds(170,600,150,50);
        this.add(gombok.get(gombok.size()-1));
        gombok.add(new MyButton());
        gombok.get(gombok.size()-1).setVisible(true);
        gombok.get(gombok.size()-1).setVisible(true);
        gombok.get(gombok.size()-1).init(2, contr);
        gombok.get(gombok.size()-1).setBounds(330,600,150,50);
        this.add(gombok.get(gombok.size()-1));
        gombok.add(new MyButton());
        gombok.get(gombok.size()-1).setVisible(true);
        gombok.get(gombok.size()-1).setVisible(true);
        gombok.get(gombok.size()-1).init(3, contr);
        gombok.get(gombok.size()-1).setBounds(490,600,150,50);
        this.add(gombok.get(gombok.size()-1));
        gombok.add(new MyButton());
        gombok.get(gombok.size()-1).setVisible(true);
        gombok.get(gombok.size()-1).setVisible(true);
        gombok.get(gombok.size()-1).init(4, contr);
        gombok.get(gombok.size()-1).setBounds(650,600,150,50);
        this.add(gombok.get(gombok.size()-1));
        gombok.add(new MyButton());
        gombok.get(gombok.size()-1).setVisible(true);
        gombok.get(gombok.size()-1).setVisible(true);
        gombok.get(gombok.size()-1).init(6, contr);
        gombok.get(gombok.size()-1).setBounds(810,600,150,50);
        this.add(gombok.get(gombok.size()-1));
        MyButton temp=new MyButton();
        temp.setVisible(false);
        this.add(temp);
	}
	
	/**
	 * Kirajzolja a virológusokat
	 * @param f meghatarozza a fieldet amire ki kell rajzolni a virologust
	 * @param onthemove meghatarozza, hogy a jelen virologus jon
	 */
	public void drawVirologinst(Field f, Virologist onthemove, Graphics g) {
			Graphics2D g2d = (Graphics2D)g;
			List<Virologist> vir = f.getVirologist();
			int x=f.getX()+150-40;
			int y=f.getY()+100-40;
			int kepX=40;
			int kepY=40;
			for(Virologist v: vir) {
				boolean maci=false;
				ArrayList<Effect> effects = v.getEffect();
				EffectVisitor visitor = new EffectVisitor();
				for(Effect e: effects) {
					if(e.Accept(visitor)==7)
						maci=true;
				}
				if(maci) {
						Image image;
						image = Toolkit.getDefaultToolkit().getImage("./Pictures/Maci.png");
						g2d.drawImage(image, x, y,kepX,kepY, this);
				}else {
					if(v==onthemove) {
						Image image;
						image= Toolkit.getDefaultToolkit().getImage("./Pictures/Virologist_Main.png");
					
						g2d.drawImage(image, x, y,kepX,kepY, this);
					}else {
						Image image;
						image = Toolkit.getDefaultToolkit().getImage("./Pictures/Virologist.png");
						g2d.drawImage(image, x, y,kepX,kepY, this);
					}
				}
				x = x - kepX- 5;
			}	
 	}
	
	/**
	 * Kirajzolja az inventoryt
	 * @param hanydb meghatarozza mennyi van a virologusnal az adott dologbol
	 * @param milyen meghatarozza milyen dolog van a virologusnal
	 */
	public void drawInventory(int hanydb,int milyen, Graphics g) {
		int x = 1040;
		int y = 30;
		if(milyen%2==0) {
			x=1140;
		}
		if(milyen%2!=0) {
			y=(int) (y+(Math.floor(milyen/2)*100));
		}else {
			y=(int) (y+(Math.floor((milyen-1)/2)*100));
		}
		
		Graphics2D g2d = (Graphics2D)g;
		String imgurl="";
		if(milyen==10) {
			if(hanydb==0) 
				imgurl="./Pictures/NucleotidBW.png";
			else 
				imgurl="./Pictures/NucleotidI.png";
		}		if(milyen==1) {
			if(hanydb==0)
				imgurl="./Pictures/GloveBW.png";
			else
				imgurl="./Pictures/GloveI.png";
		}		if(milyen==2) {
			if(hanydb==0)
				imgurl="./Pictures/BackpackBW.png";
			else
				imgurl="./Pictures/BackpackI.png";
		}		if(milyen==3) {
			if(hanydb==0)
				imgurl="./Pictures/CapeBW.png";
			else
				imgurl="./Pictures/CapeI.png";
		}		if(milyen==4) {
			if(hanydb==0)
				imgurl="./Pictures/AxeBW.png";
			else
				imgurl="./Pictures/AxeI.png";
		}		if(milyen==5) {
			if(hanydb==0)
				imgurl="./Pictures/MemoryLossVBW.png";
			else
				imgurl="./Pictures/MemoryLossVI.png";
		}		if(milyen==6) {
			if(hanydb==0)
				imgurl="./Pictures/VitusDanceVBW.png";
			else
				imgurl="./Pictures/VitusDanceI.png";
		}		if(milyen==7) {
			if(hanydb==0)
				imgurl="./Pictures/StunVBW.png";
			else
				imgurl="./Pictures/StunVI.png";
		}		if(milyen==8) {
			if(hanydb==0)
				imgurl="./Pictures/VaccineBW.png";
			else
				imgurl="./Pictures/VaccineI.png";
		}		if(milyen==9) {
			if(hanydb==0)
				imgurl="./Pictures/AminoAcidBW.png";
			else
				imgurl="./Pictures/AminoAcidI.png";
		}
		Image image;
		image = Toolkit.getDefaultToolkit().getImage(imgurl);
		g2d.drawImage(image, x, y,100,100, this);
		g2d.drawString(String.valueOf(hanydb), (x), (y+10));
	}
	
	/**
	 * Kirajzolja az effekteket
	 * @param virologus aminek ki kell rajzolni az effectjeit
	 */
	public void drawEffects(ArrayList<Effect> effects,Graphics g) {
		int y=570;
		int x=1040;
		for(int i=0;i<effects.size();i++) {
			
			y=y+20;
		EffectVisitor visit= new EffectVisitor();
		if(effects.get(i).Accept(visit)==1)
		{
			g.drawString("BackPackEffect",x,y);
		}
		if(effects.get(i).Accept(visit)==2)
		{
			g.drawString("GloveEffect",x,y);
		}
		if(effects.get(i).Accept(visit)==3)
		{
			g.drawString("CapeEffect",x,y);
		}
		if(effects.get(i).Accept(visit)==4)
		{
			g.drawString("VirusResistentEffect",x,y);
		}
		if(effects.get(i).Accept(visit)==5)
		{
			g.drawString("VitusDanceEffect",x,y);
		}
		if(effects.get(i).Accept(visit)==6)
		{
			g.drawString("ParalyzedEffect",x,y);
		}
		if(effects.get(i).Accept(visit)==7)
		{
			g.drawString("MaciEffect",x,y);
		}
		if(effects.get(i).Accept(visit)==8)
		{
				g.drawString("AxeEffect",x,y);
		
		}
		}
		
	}
	class PaintComp extends Component{
		@Override
		public void paint(Graphics g) {
			  controller.setG(g);
			  if(g!=null)
				  controller.RajzolMinden();
			  this.repaint();
		}
	}
	
	


}
