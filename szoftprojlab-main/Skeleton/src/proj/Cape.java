

/** 
 * Egy felszerel�s, ami a �v�helyen tal�lhat�. V�d�k�peny hat�sra, 
 * a virol�gus 82,3%-os hat�sfokkal tartja tartja mag�t�l t�vol az �genseket.
 * */
public class Cape extends Gear
{	
	/**
	 * A k�penyhez tartoz� effektus
	 */
	private CapeEffect ce;
	/**
	 * Cape konstruktorra
	 *  L�trehozza a hozz� tartoz� effektust is �s be�ll�tja
	 */
	public Cape()
	{
		ce= new CapeEffect();
		id="cape"+(int)(Math.random()*1000);
	}
	/**
	 * ce gettere
	 * A cape-hez tartoz� effektussal t�r vissza
	 * @return ce  cape-hez tartoz� 
	 */
	public CapeEffect getCe()
	{
		//System.out.println("\tgetCe() CapeEffect lek�rdez�se");
		//System.out.println("\tgetCe() CapeEffect return");
		return ce;
	}
	/** 
	 * Adott gear felv�tel�t szolg�l� f�ggv�ny
	 * Mikor a virol�gus felveszi akkor megkapja a hozz� tartoz� effektust is.
	 * @param v Megkapja, hogy melyik virol�gus veszi fel
	 * */
	public void TakeGear(Virologist v)
	{
		//System.out.println("\tTakeGear(v) Addot gear-t a virologus felveszi");
		v.getinventory().AddGear(this);
		v.AddEffect(ce);
	}
	
	/** 
	 * Adott gear lev�tel�t szolg�l� f�ggv�ny
	 * Adott felszerel�s kiker�l a Virol�gus Inventoryb�l 
	 * �s leker�l r�la a hozz� tartoz� effekt.
	 * @param v Megkapja, hogy melyik virol�gus vette le
	 * */
	public void TakeGearOff(Virologist v)
	{
		//System.out.println("\tTakeGearOff(v) Addot gear-t a virologus megsemm�siti");
		v.RemoveEffect(ce);
		v.getinventory().RemoveGear(this);
	}
	
	/**
	 * Adott gear ellop�s�t szolg�l� f�ggv�ny
	 * @param whoV melyik virol�gus lopott el
	 * @param fromV melyik virol�gust�l loptak el
	 *  */
	public void Steal(Virologist whoV, Virologist fromV)
	{
		//System.out.println("\tSteal(whoV, fromV) Addot gear-t a virologust�l elopta egy m�sik virologus");
		//fromV.TakeGearOff(this);
		this.TakeGearOff(fromV);
		fromV.RemoveEffect(ce);
		whoV.AddGearFromSteal(this);
		whoV.AddEffect(ce);
	}
}
