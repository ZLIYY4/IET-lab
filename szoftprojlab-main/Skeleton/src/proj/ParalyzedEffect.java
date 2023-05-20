


/** 
 * Ez hat�s, amit a v�rologus, 
 * kap ha bizonyos �genssel kenik meg, 
 * ekkor a k�r�b�l kimarad �s nem tud semmit csin�lni.
 */
public class ParalyzedEffect extends Effect
{
	/** 
	 * Ez a f�ggv�ny teszi lehet�v�, hogy az oszt�ly fogadni tudjon IVisitort.
	 * @param v Megkapja, hogy melyik IVisitor l�togatja meg
	 * */
	@Override
	public int Accept(IVisitor v)
	{
		int x=v.Visit(this);
		return x;
	}
	/**
	 * Az oszt�ly konstruktora
	 */
	public ParalyzedEffect() {
		id="paralyzedEffect";//+(int)(Math.random()*1000);
	}
}
