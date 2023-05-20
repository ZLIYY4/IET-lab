

/** 
 * Effekteket reprezent�l� oszt�ly.
 * */
public abstract class Effect
{
	/** 
	 *  Sz�ml�l�, amely jelzi, hogy m�g mennyi ideig hat az effekt
	 */
	protected int duration;
	String id;
	
	public String getId() {
		return id;
	}
	public void setId(String dd) {
		id=dd;
	}
	/** 
	 *  Az effect leboml�s�t kezeli
	 *  @param v Megkapja, hogy melyik virol�gushoz tartozik az effect
	 */
	public void Decrease(Virologist v)
	{
		//System.out.println("\tDecrease(v) Effect bomlik �s eggyel kevesebb k�rig marad �letben");
		duration=duration-1;
		if(duration<=0)
			v.RemoveEffect(this);
	}
	
	/** 
	 * Ez a f�ggv�ny teszi lehet�v�, hogy az oszt�ly fogadni tudjon IVisitort.
	 * Megkapja, hogy melyik IVisitor l�togajta meg �s visszat�r, hogy sikeres volt-e a l�togat�s.
	 * @param v Megkapja, hogy melyik IVisitor l�togatja meg
	 */
	public int Accept(IVisitor v)
	{
		//System.out.println("\tAccept(i)IVisitor pattern haszn�lata");
		//System.out.println("\tAccept(i) 0 return");
		return 0;
	}
	
	
}
