


/** 
 *  A felszerel�seket reprezent�l� interface
 */
public abstract class Gear 
{
	/** 
	 * Adott gear felv�tel�t szolg�l� f�ggv�ny
	 * @param v Megkapja, hogy melyik virol�gus veszi fel
	 * */
	public abstract void TakeGear(Virologist v);
	/**
	 * Egy id, amivel a felhaszn�l� azonos�tani tudja a felszerel�st
	 */
	protected String id;
	/**
	 * Visszat�r, a Gear id-j�val
	 * @return
	 */
	public String getid()
	{
		return id;
	}
	/**
	 * Be�ll�tja a Gear idj�nak amit param�terk�nt kapott
	 * @param nid mi legyen az id
	 */
	public void setid(String nid)
	{
		 id=nid;
	}
	
	/** 
	 * Egy felszerel�st vesz le(semmis�t meg) a virol�gus
	 * @param v melyik virol�gus semmis�ti meg a felszerel�st
	 */
	public abstract void TakeGearOff(Virologist v);
	
	/**
	 * Adott gear ellop�s�t szolg�l� f�ggv�ny
	 * @param whoV melyik virol�gus lopott el
	 * @param fromV melyik virol�gust�l loptak el
	*/
	public abstract void Steal(Virologist whoV, Virologist fromV);
}
