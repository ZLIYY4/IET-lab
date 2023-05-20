/**
 * Fejsze effectet reprezent�l� oszt�ly, Virol�guson alkalmazhat� effect, 
 * fejsze felv�tel�n kereszt�l. 
 * Csak akkor tudja a virol�gus haszn�lni a fejsz�t, ha ez rajta van
 *
 */
public class AxeEffect extends Effect {
	/** 
	 * Ez a f�ggv�ny teszi lehet�v�, hogy az oszt�ly fogadni tudjon IVisitort.
	 * @param v Megkapja, hogy melyik IVisitor l�togatja meg
	 * @return sikeres volt-e a l�togat�s
	 * */
	@Override
	public int Accept(IVisitor v)
	{
		//System.out.println("\tAccept(i)IVisitor pattern haszn�lata");
		int x=v.Visit(this);
		//System.out.println("\tAccept(i) "+x+" return");
		return x;
	}
	/**
	 * Csak fel�l van defini�lva, egy �res f�ggv�nnyel, 
	 * mivel a AxeEffect nem sz�nik meg a k�r�k hat�s�ra. 
	 * @param v Megkapja, hogy melyik virol�gus h�vja meg rajta
	 */
	@Override
	public void Decrease(Virologist v){}
	/**
	 * Az oszt�ly konstruktora
	 */
	public AxeEffect() {
		id="axeEffect";//+(int)(Math.random()*1000);
	}
}
