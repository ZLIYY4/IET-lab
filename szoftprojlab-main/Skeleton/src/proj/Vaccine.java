
/** 
 * Ez egy �gens, amit genetikai k�db�l lehet k�sz�teni. 
 * Ami bizonyos id� ut�n lebomlik. 
 * Amit egy virol�gus r�ken egy m�sikra a m�sik virol�gusra/saj�t mag�ra, 
 * akkor 2 k�rig v�delmet �lvez m�sik �gensekkel szemben.
*/
public class Vaccine extends Agens
{
	/**
	 * Milyen effect tartozik hozz�, hozz� tartoz� effektett t�rolja
	 */
	private VirusResistentEffect vre;
	/**
	 * Vaccine konstruktora l�trehoza a hozz� tartoz� Agenst
	 * a duration alapb�l mindig a feladat le�r�s alapj�n 3
	 */
	public Vaccine() {
		vre = new VirusResistentEffect();
		duration = 3;
		id="vaccine"+(int)(Math.random()*1000);
	}
	/**
	 * A param�terk�nt kapott virol�gusnak adja a vre mez� �rt�k�t
	 *  @param v Melyik virol�gus kapja meg az effect-et
	 */
	public void Use(Virologist v)
	{
		//System.out.println("\tUse(v) Vaccine haszn�lata");
		v.AddEffect(vre);
	}
}
