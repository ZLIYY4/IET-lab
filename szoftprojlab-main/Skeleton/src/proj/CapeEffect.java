


/** 
 * K�peny effectet reprezent�l� oszt�ly, 
 * Virol�guson alkalmazhat� effect, 
 * Cape felv�tel�n kereszt�l.
 * */
public class CapeEffect extends Effect
{
	/** 
	 * Ez a f�ggv�ny teszi lehet�v�, hogy az oszt�ly fogadni tudjon IVisitort.
	 * @param v Megkapja, hogy melyik IVisitor l�togatja meg
	 * @return Visszat�r, hogy sikeres volt-e a l�togat�s
	 */
	@Override
	public int Accept(IVisitor v)
	{
		int x=v.Visit(this);
		return x;
	}
	/**
	 *  Csak fel�l van defini�lva, egy �res f�ggv�nnyel, 
	 *  mivel a CapeEffect nem sz�nik meg a k�r�k hat�s�ra. 
	 */
	public void Decrease(Virologist v){}
	/**
	 * Az oszt�ly konstruktora
	 */
	public CapeEffect() {
		id="capeEffect";//+(int)(Math.random()*1000);
	}
}
