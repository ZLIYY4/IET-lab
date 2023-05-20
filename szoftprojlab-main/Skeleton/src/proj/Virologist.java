import java.util.ArrayList;

/** 
 * A j�t�kos, aki mozog a mez�k k�z�tt. 
 * Aki k�pes a sz�ks�ges genetikai k�d tud�s�val �s a sz�ks�ges aminosav �s 
 * nukleotid birtok�ban �genst k�sz�teni, 
 * amit egy m�sik virol�gusra vagy saj�t mag�ra tud kenni. 
 * A virol�gus k�pes a mez�kr�l felvenni felszerel�seket, amik hat�ssal vannak r�.
 */
public class Virologist implements Steppable
{
	/**
	 * A Virologushoz tartoz� id, amivel a felhaszn�l� azonos�tani tudja
	 */
	String id;
	/**
	 * A virol�gushoz tartoz� effektett list�ja
	 */
	private ArrayList<Effect> effects;
	/**
	 * A virol�gushoz tartoz� code-ok list�ja
	 */
	private ArrayList<Code> codes;
	/** 
	 * A virol�gus melyik mez�n van �ppen
	 */
	private Field fields;
	/**
	 * Field setter
	 * Be�ll�tja, hogy melyik mez�n �ll a virol�gus
	 * @param field
	 */
	public void setFields(Field f)
	{
		fields=f;
	}
	/**
	 * Field gettere
	 * Visszat�r azzal, hogy a virol�gus melyik mez�n �ll. 
	 * A virol�gus Field-j�nek gettere.
	 * @return fields
	 */
	public Field getField() {
		return fields;
	}
	/**
	 * A virol�gushoz tartoz� inventory
	 */
	private Inventory inventory;
	/**
	 * Konsturktor a virol�gus oszt�lyhoz,
	 * l�trehozza a virol�gushoz tartoz� objektumokat,list�kat.
	 */
	public Virologist() {
		effects=new ArrayList<Effect>();
		codes = new ArrayList<Code>();
		fields=null;
		inventory= new Inventory();
		id="virologist"+(int)(Math.random()*1000);
	}
	/**
	 * Visszat�r a Virologushoz tartoz� id-vel
	 * @return id Mi a Virol�gus id-je
	 */
	public String getid()
	{
		return id;
	}
	/**
	 * Be�ll�tja az id �rt�k�t
	 * @param nid mi legyen az id �rt�ke
	 */
	public void setid(String nid)
	{
		 id=nid;
	}
	/**
	 * Visszat�r a Virol�gushoz tartoz� code-kat tartalmaz� list�val
	 * @return codes a lista ami a Virol�gushoz tartozik
	 */
	public ArrayList<Code> getcode()
	{
		return codes;
	}
	/**
	 * Vizsg�lat, hogy a virol�guson van-e ParalyzedEffect.
	 * @return visszat�r igaz-zal ha van rajta B�nul�s, k�l�nben hamissal t�r vissza
	 */
	public boolean CheckParalyzedEffect() {
		EffectVisitor visit= new EffectVisitor();
		for(int i = 0;i<effects.size();i++)
			if(effects.get(i).Accept(visit)==6)
			{
				return true;
			}
		return false;
	}
	
	/**
	 * Az invenotry gettere
	 * @return inventory visszadja
	 */
	public Inventory getinventory()
	{
		return inventory;
	}
	/** 
	 * A virol�gus felvesz egy felszerel�st 
	 * @param g Megkapja, hogy mi az a felszerl�s amit felvessz
	 */
	public void TakeGear(Gear g)
	{
		inventory.AddGear(g);
	}
	
	/** 
	 * A virol�gus felvesz valamilyen anyagot
	 * @param mat Megkapja, mi az az anyag amit felvessz
	 */
	public void PickupMaterial(Material mat)
	{
		int matSize = inventory.MatSize();
		int maxMaterial = inventory.Getmax_Material();
		if(matSize!=maxMaterial)
		{
			((Storage) fields).Remove(mat);
			inventory.AddMaterial(mat);
		}
	}
	
	/** 
	 * A virol�gus felvesz valamit egy mez�r�l, amin �ll.
	 */
	public void PickUp()
	{
		if(!CheckParalyzedEffect()) 
		{
			fields.Use(this);
		}
	}
	
	/** 
	 * A virol�gus k�r�nek kezdete, a virol�gus l�ptett�se
	 */
	@Override
	public void Step()
	{
		for(int i=0; i<effects.size();i++)
			effects.get(i).Decrease(this);
		inventory.DecreaseAgens(this);
	}
	
	/** 
	 * A virol�gus r�l�p egy m�sik mez�re
	 * @param f Melyik mez�re l�p
	 */
	public void Move(Field f)
	{
		if(!CheckParalyzedEffect())
		{
			fields.Remove(this);
			f.Accept(this);
		}
	}
	/**
	 * A virol�gus letapogat egy genetikai k�dot
	 * @param c Mi az a k�d amit letapogatt
	 */
	public void Touch(Code c)
	{
		if(codes.contains(c)==false)
		codes.add(c);
		int b = (int)(Math.random()*(100)+1); 
		if(b<4 && canAttack(true)==true &&  fields!= null &&fields.getClass()==new Laboratory().getClass())
			this.AddEffect(new MaciEffekt());
		Game.EndGame(codes.size());
	}
	/** 
	 * A virol�gus megsemmis�t egy felszerel�st mag�r�l.
	 * @param g Mi aza felszerl�s amit megsemm�sit
	 */
	public void TakeGearOff(Gear g)
	{
		if(!CheckParalyzedEffect()) 
		{
			g.TakeGearOff(this);
		}
	}
	
	/** 
	 * A virol�gus egy effektet kap.
	 * @param e Mi az az effect amit a virol�gus kap
	 */
	public void AddEffect(Effect e)
	{
		effects.add(e);
	}
	/** 
	 * A virol�gus egy effektet elveszt
	 * @param e Mi az az effect amit elvesz�t a virol�gus*/
	public void RemoveEffect(Effect e)
	{
		effects.remove(e);
	}
	/**
	 * A virol�gus egy felszerel�st ellop egy m�sik virol�gust�l.
	 * @param v Kit�l vesszi el a felszerl�st
	 * @param g Milyen feszerel�st vesz el
	 */
	public void Steal(Virologist v, Gear g)
	{
		int gearsSize = inventory.Gearssize();
		int maxgear=inventory.Getmax_Gear();
		if(!CheckParalyzedEffect() && gearsSize!=maxgear) 
		{
			g.Steal(this, v);
		}
	}
	
	
	/** 
	 * A virol�gus �genst ken egy m�sik virol�gusra.
	 * @param a Milyen �genst ken
	 * @param v Kire kenni az �genst
	 */
	public void Attack(Agens a, Virologist v, boolean capeHaEffect)
	{
		if(!CheckParalyzedEffect())
		{
			boolean canAttack =false;
			if(!capeHaEffect)
				canAttack = v.Attacked(this, a, capeHaEffect);
			inventory.RemoveAgens(a);
		}
	}
	
	/** 
	 * A virol�gusra r�kent egy m�sik virol�gus a param�terk�nt kapott 
	 * �genst. Visszat�r, hogy tud-e t�madni a v�rol�gus, sikeres volt-e a 
	 * t�mad�s.
	 * Ha a t�mad�st a keszty�vel vert�k vissza, akkor a keszty� �letereje eggyel cs�kken �s 
	 * ha a keszty� �letereje elfogy, akkor a keszty� megsemmis�l. 
	 * @param v Ki kente r� az �genst a virol�gusra
	 * @param a Milyen �genst kentek r� a virol�gsusra
	 * @return Visszat�r, hogy sikeres volt-e a ken�s, meglehet-e �t t�madni
	 */
	public boolean Attacked(Virologist v, Agens a, boolean capeHaEffect)
	{
		EffectVisitor visit= new EffectVisitor();
		for(int i = 0;i<effects.size();i++)
			if(effects.get(i).Accept(visit)==2)
			{
				((GloveEffect) effects.get(i)).WearOut(this); 
				v.SelfAttack(a);
				return true;
			}
		boolean canAttack=canAttack(capeHaEffect);
		if(canAttack) 
		{
			a.Use(this);
		}
		return canAttack;
	}
	/**
	 *  virol�gus visszaadja, hogy a virol�gust meglehett-e t�madni, 
	 *  az az van neki k�penye, ami kiv�dte a t�mad�st 
	 *  vagy van rajta �rv�nyes v�rus v�delem effect.
	 * @return tamadhato e
	 */
	public boolean canAttack(boolean capeHaEffect) {
		EffectVisitor visit= new EffectVisitor();
		for(int i = 0;i<effects.size();i++) {
			if(effects.get(i).Accept(visit)==4)
			{
				return false;
			}
			if(effects.get(i).Accept(visit)==3 && capeHaEffect)
			{
				int b = (int)(Math.random()*(100)+1); 
				if(b<83) { 
				return false;
				}
			}
		}
		return true;
	}
	/**
	 * A virol�gus haszn�lja a fejsz�t egy m�sik virol�gusra, 
	 * ami a haszn�lat miatt meghal. A fejsze csak egyszer haszn�lhat�,
	 *  de a virol�gusn�l marad t�r�tt �llapotban. 
	 * @param aldozat Kit t�mad meg a fejsz�vel
	 */
	public void UseAxe(Virologist aldozat) {
		EffectVisitor visit= new EffectVisitor();
		for(int i = 0;i<effects.size();i++) {
			if(effects.get(i).Accept(visit)==8)
			{
				aldozat=null;
				effects.remove(i);
			}
		}
		return;
	}
	
	/** 
	 * Virol�gus saj�t mag�ra ken egy �genst.
	 *@param a Mi az az �gens, amit saj�t mag�ra ken
	 */
	public void SelfAttack(Agens a)
	{
		if(!CheckParalyzedEffect())
		{
			a.Use(this);
			inventory.RemoveAgens(a);
		}
	}
	
	/** 
	 * A virol�gus elfelejti az �sszes genetikai k�dot
	 */
	public void RemoveCode()
	{
		codes.clear();

	}
	
	/** 
	 * A virol�gus egy random mez�re l�p
	 */
	public void MoveRandom()
	{
		Field f=fields.GetRandomNeighbor();
		fields.Remove(this);
		f.Accept(this);
	}
	/**
	 * Virol�guson l�v� effecttekel t�r vissza, virologusnak effectjeinek gettere
	 * @return effects
	 */
	public ArrayList<Effect> getEffect(){
		return effects;
	}
	
	/** 
	 * A virol�gus egy �genst k�sz�t az ismert genetikai k�d seg�ts�g�vel
	 * @param c Melyik k�db�l k�sz�tsen �genst
	 */
	public void Craft(Code c)
	{
		if(!CheckParalyzedEffect())
		{
			inventory.Craft(c);
		}
	}
	
	/** 
	 * A virol�gushoz ker�l egy felszerel�s, amit ellopott. 
	 */
	public void AddGearFromSteal(Gear g)
	{
		inventory.AddGear(g);
	}
}
