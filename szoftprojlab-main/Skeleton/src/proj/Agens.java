



/** 
 * Az oszt�ly reprezent�l egy �genst, amely azt�n felkenhet� egy virol�gusra.
 * */
public abstract class Agens
{
	/** 
	 * Sz�ml�l�, amely jelzi, hogy m�g mennyi ideig haszn�lhat� fel az �gens. (m�g h�ny k�rig)
	 */
	protected int duration;
	/**
	 * Az Agens id-je amivel lehet r� hivatkozni
	 */
	protected String id;
	
	/** 
	 * A param�ternek kapott Virologist-nek ad egy bizonyos Effect-et, absztrakt, a lesz�rmazottaik val�s�tj�k meg.
	 * @param v Ki az a Virologus akire haszn�lva van az �gens 
	 */
	public abstract void Use(Virologist v);
	/**
	 * Visszadja az id-t
	 * @return id
	 */
	public String getid()
	{
		return id;
	}
	/**
	 * Be�ll�tja az id-t
	 * @param nid megkapja param�terk�nt, hogy mi legyen az id
	 */
	public void setid(String nid)
	{
		 id=nid;
	}
	
	/** 
	 * Megval�s�tja egy anyag boml�s�t
	 * A duration �rt�k�t cs�kkenti k�r�nk�nt eggyel, ha a duration �rt�ke 0 lesz, 
	 * akkor a virol�gus Inventory-b�l elt�vol�tja az �genst.
	 * @param i Melyik inventory h�vta meg rajta a decrase f�ggv�nyt, melyik Inventoryhoz tartozik
	 * */
	public void Decrase(Inventory i)
	{
		//System.out.println("\t Decrase(i) Az �gens bomlik.");
		duration=duration-1;
		if(duration<=0)
			i.RemoveAgens(this);
	}
}
