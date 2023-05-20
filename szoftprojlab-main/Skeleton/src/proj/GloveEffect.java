

/** 
 * V�rusok visszadob�s�t lehet�v� tev� effektust reprezent�l� oszt�ly
 */
public class GloveEffect extends Effect
{
	/**
	 * Az effect-hez tartoz� keszty�
	 */
	private Glove glove;
	
	/**
	 * Az oszt�ly konstruktora
	 * be�ll�tja a duration �rt�k�t 3-ra �s be�ll�tja,
	 * hogy melyik keszty�h�z tartozik.
	 * @param g megkapja, hogy melyik keszty�h�z tartozik
	 */
	public GloveEffect(Glove g) {
		duration=3;
		glove=g;
		id="gloveEffect";
	}
	/** 
	 * Ez a f�ggv�ny teszi lehet�v�, hogy az oszt�ly fogadni tudjon IVisitort.
	 * @param v Megkapja, hogy melyik IVisitor l�togatja meg
	 * @return sikeres volt-e a l�togat�s
	 * */
	@Override
	public int Accept(IVisitor v)
	{
		//System.out.println("\tAccept(i)IVisitorM pattern haszn�lata");
		int x=v.Visit(this);
		//System.out.println("\tAccept(i) "+x+" return");
		return x;
	}
	/**
	 *  Ennek a f�ggv�nyenek a seg�ts�g�vel haszn�l�dik el a keszty�. 
	 *  A keszty� haszn�latakor az �rt�k�t cs�kkenti duration �rt�k�t cs�kkenti, ha 0 akkor megsemmis�ti.
	 * @param v megkapja, hogy melyik virol�gus h�vta meg rajta
	 * @return
	 */
	public void WearOut(Virologist v)
	{
		duration--;
		if(duration==0) {
			v.RemoveEffect(this); //TODO check j�-e
			glove=null;
		}
	}
	/**
	 *  Csak fel�l van defini�lva, egy �res f�ggv�nnyel, mivel a GloveEffect nem sz�nik meg a k�r�k hat�s�ra.
	 *  @param v Megkapja, hogy melyik virol�gus h�vta meg rajta
	 */
	public void Decrease(Virologist v){	}
	/**
	 * Az oszt�ly konstruktora
	 */
	public GloveEffect() {
		id="gloveEffect";//+(int)(Math.random()*1000);
	}
}
