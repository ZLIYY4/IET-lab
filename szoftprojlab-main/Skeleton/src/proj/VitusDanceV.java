/** 
 * Ez egy �gens, amit genetikai k�db�l lehet k�sz�teni. 
 * Ami bizonyos id� ut�n lebomlik. Amit egy virol�gus r�ken egy m�sikra 
 * akkor m�sik virol�gus v�letlenszer�en el fog mozdulni egy m�sik mez�re.
 */
public class VitusDanceV extends Agens
{
	/**
	 * Milyen effect tartozik hozz�
	 */
	private VirusDanceEffect vde;
	/**
	 * VitusDanceV konstruktora l�trehoza a hozz� tartoz� Agenst
	 * a duration alapb�l mindig a feladat le�r�s alapj�n 3
	 */
	public VitusDanceV() {
		vde = new VirusDanceEffect();
		duration = 3;
		id="vitusdanceV"+(int)(Math.random()*1000);
	}
	/**
	 * A param�terk�nt kapott virol�gusnak adja a vde mez� �rt�k�t
	 *  @param v Melyik virol�gus kapja meg az effect-et
	 */
	public void Use(Virologist v)
	{
		//System.out.println("\tUse(v) StunV haszn�lata");
		v.AddEffect(vde);
	}
}
