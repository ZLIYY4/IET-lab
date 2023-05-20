
/** 
 * A v�rusok �ltali v�delmet reprezent�l� oszt�ly
*/
public class VirusResistentEffect extends Effect
{
	/** 
	 * Ez a f�ggv�ny teszi lehet�v�, hogy az oszt�ly fogadni tudjon IVisitort.
	 * @param v Megkapja, hogy melyik IVisitor l�togatja meg
	 * @return Visszat�r, hogy sikeres volt-e a l�togat�s
	 */
	@Override
	public int Accept(IVisitor v)
	{
		//System.out.println("\tAccept(i)IVisitorM pattern haszn�lata");
		int x=v.Visit(this);
		//System.out.println("\tAccept(i) "+x+" return");
		return x;
	}
	/**
	 * Az oszt�ly konstruktora
	 */
	public VirusResistentEffect() {
		id="virusResistentEffect";//+(int)(Math.random()*1000);
		duration=2;
	}
}
