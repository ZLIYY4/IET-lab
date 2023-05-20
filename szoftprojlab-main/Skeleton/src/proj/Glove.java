

/** 
 * Egy felszerel�s, ami a �v�helyen tal�lhat�, amit ha felvesz a virol�gus, 
 * akkor a r� kent �genst k�pes lesz visszadobni arra, aki r� kente.
*/
public class Glove extends Gear
{
	
	/**
	 * A keszty�h�z tartoz� effektus
	 * l�trehozza a hozz� tartoz� effektust is
	 */
	private GloveEffect ge;
	/**
	 * Glove konstruktorra
	 */
	public Glove()
	{
		ge= new GloveEffect(this);
		id="glove";//+(int)(Math.random()*1000);
	}
	/**
	 * ge gettere
	 * Visszat�r a keszty�h�z tartoz� effektussal.
	 * @return ge
	 */
	public GloveEffect getGe()
	{
		//System.out.println("\tgetGe() ge gettere lefutt");
		//System.out.println("\tgetGe() GloveEffect return");
		return ge;
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
		v.AddEffect(ge);
	}
	
	/** 
	 * Adott gear lev�tel�re, megsemmis�t�s�re szolg�l� f�ggv�ny
	 *  Adott felszerel�s kiker�l a Virol�gus Inventoryb�l �s leker�l r�la a hozz� tartoz� effekt.
	 * @param v Megkapja, hogy melyik virol�gus vette le
	 * */
	public void TakeGearOff(Virologist v)
	{
		//System.out.println("\tTakeGearOff(v) Addot gear-t a virologus megsemm�siti");
		v.RemoveEffect(ge);
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
		fromV.RemoveEffect(ge);
		whoV.AddGearFromSteal(this);
		whoV.AddEffect(ge);
	}
}
