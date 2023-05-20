/**
 * Fejsz�t reprezent�l� oszt�ly, felv�telekor a virol�gusra AxeEffect ker�l. Haszn�latakor elt�rik �s a AxeEffect leker�l a virologusr�l.
 * 
 */
public class Axe extends Gear {
	/**
	 * A fejsz�hez tartoz� effektus.
	 */
	private AxeEffect pbe;
	/**
	 * A fejsze konstruktora, l�trehoz egy �j effect-et a fejsz�hez
	 */
	public Axe() {
		pbe= new AxeEffect();
		id="axe"+(int)(Math.random()*1000);
	}
	/**
	 * Adott gear felv�tel�t szolg�l� f�ggv�ny. Mikor a virol�gus felveszi akkor megkapja a hozz� tartoz� effektust is.
	 * @param v Megkapja, hogy melyik virologus veszi fel
	 */
	@Override
	public void TakeGear(Virologist v) {
		//System.out.println("\tTakeGear(v) Addot gear-t a virologus felveszi");
		v.getinventory().AddGear(this);
		if(pbe!=null) v.AddEffect(pbe);
	}
	/**
	 * Adott gear lev�tel�t szolg�l� f�ggv�ny. Adott felszerel�s kiker�l a Virol�gus Inventoryb�l �s leker�l r�la a hozz� tartoz� effekt.
	 * @param v Melyik virol�gus veszi le a felszerel�st
	 */
	@Override
	public void TakeGearOff(Virologist v) {
		v.RemoveEffect(pbe);
		v.getinventory().RemoveGear(this);
	}
	/**
	 * Adott gear ellop�s�t szolg�l� f�ggv�ny. A whoV Virol�gus ellopja a felszerel�st a fromV Virologust�l. 
	 * @param whoV melyik virol�gus lopja ell
	 * @param fromV melyik virol�gust�l lopj�k el
	 */
	@Override
	public void Steal(Virologist whoV, Virologist fromV)
	{
		//System.out.println("\tSteal(whoV, fromV) Addot gear-t a virologust�l elopta egy m�sik virologus");
		//fromV.TakeGearOff(this);
		this.TakeGearOff(fromV);
		EffectVisitor visit= new EffectVisitor();
		fromV.RemoveEffect(pbe);
		for(int i = 0;i<whoV.getEffect().size();i++) {
			if(whoV.getEffect().get(i).Accept(visit)==8) {
			pbe=null;
			break;
			}
		}
		whoV.AddGearFromSteal(this);
		whoV.AddEffect(pbe);
	}
	/**
	 * Visszat�r a fejsz�hez tartoz� effectel
	 * @return pbe
	 */
	public AxeEffect GetEffect() {
		return pbe;
	}
}
