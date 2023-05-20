

/** 
 * H�tizs�k effectet reprezent�l� oszt�ly, 
 * Virol�guson alkalmazhat� effect, 
 * H�tizs�k felv�tel�n kereszt�l.
 * */
public class BackPackEffect extends Effect
{
	/** 
	 * Ez a f�ggv�ny teszi lehet�v�, hogy az oszt�ly fogadni tudjon IVisitort.
	 * @param v Megkapja, hogy melyik IVisitor l�togatja meg
	 * @return sikeres volt-e a l�togat�s
	 * */
	@Override
	public int Accept(IVisitor v)
	{
		int x=v.Visit(this);
		return x;
	}
	/**
	 *  Csak fel�l van defini�lva, egy �res f�ggv�nnyel, 
	 *  mivel a BackPackEffect nem sz�nik meg a k�r�k hat�s�ra. 
	 */
	@Override
	public void Decrease(Virologist v){}
	/**
	 * Az oszt�ly konstruktora
	 */
	public BackPackEffect() {
		id="backPackEffect";//+(int)(Math.random()*1000);
	}
}
