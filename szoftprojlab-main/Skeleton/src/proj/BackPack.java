


/** 
 * Egy felszerel�s, ami a �v�helyen tal�lhat�, 
 * amit ha felvesz a virol�gus, 
 * akkor az anyag t�rol� kapacit�sa megdupl�z�dik. 
*/
public class BackPack extends Gear
{
	/**
	 * A h�tizs�khoz tartoz� effektus
	 */
	private BackPackEffect pbe;
	/**
	 * BackPack oszt�ly konstruktora. 
	 * L�trehozza a hozz� tartoz� effektust is �s be�ll�tja
	 */
	public BackPack()
	{
		pbe= new BackPackEffect();
		id="backPack"+(int)(Math.random()*1000);
	}
	/**
	 * pbe gettere
	 * A BackPack-hez tartoz� effektust adja vissza.
	 * @return pbe
	 */
	public BackPackEffect getPbe()
	{
		//System.out.println("\tgetPbe() pbe gettere megh�vodik");
		//System.out.println("\tgetPbe() BackPackEffect return");
		return pbe;
	}
	/** 
	 * Adott gear felv�tel�t szolg�l� f�ggv�ny
	 * Mikor a virol�gus felveszi 
	 * akkor megkapja a hozz� tartoz� effektust is.
	 * @param v Megkapja, hogy melyik virol�gus veszi fel
	 * */
	@Override
	public void TakeGear(Virologist v)
	{
		//System.out.println("\tTakeGear(v) Addot gear-t a virologus felveszi");
		v.getinventory().AddGear(this);
		v.AddEffect(pbe);
	}
	
	/** 
	 * Adott gear lev�tel�re, megsemmis�t�s�re szolg�l� f�ggv�ny
	 * Adott felszerel�s kiker�l a Virol�gus Inventoryb�l �s leker�l r�la a hozz� tartoz� effekt.
	 * @param v Megkapja, hogy melyik virol�gus vette le
	 * */
	@Override
	public void TakeGearOff(Virologist v)
	{
		//System.out.println("\tTakeGearOff(v) Addot gear-t a virologus megsemm�siti");
		v.RemoveEffect(pbe);
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
		fromV.RemoveEffect(pbe);
		whoV.AddGearFromSteal(this);
		whoV.AddEffect(pbe);
	}
}
