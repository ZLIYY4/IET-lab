
/** 
 * Ez egy �gens, amit genetikai k�db�l lehet k�sz�teni. 
 * Ami bizonyos id� ut�n lebomlik. 
 * Amit egy virol�gus r�ken egy m�sikra akkor m�sik virol�gus le 
 * fog b�nulni t�le �s kimarad 3 k�rb�l.
*/
public class StunV extends Agens
{
	/**
	 * Milyen effect tartozik hozz�
	 */
	private ParalyzedEffect pe;
	/**
	 * StunV konstruktora l�trehoza a hozz� tartoz� Agenst
	 * a duration alapb�l mindig a feladat le�r�s alapj�n 3
	 */
	public StunV() {
		pe = new ParalyzedEffect();
		duration = 3;
		id="stunV"+(int)(Math.random()*1000);
	}
	/**
	 * A param�terk�nt kapott virol�gusnak adja a pe mez� �rt�k�t
	 *  @param v Melyik virol�gus kapja meg az effect-et
	 */
	public void Use(Virologist v)
	{
		//System.out.println("\tUse(v) StunV haszn�lata");
		v.AddEffect(pe);
	}
}
