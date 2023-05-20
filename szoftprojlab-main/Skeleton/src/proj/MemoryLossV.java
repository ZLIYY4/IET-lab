


/** 
 * Ez egy �gens, amit genetikai k�db�l lehet k�sz�teni. 
 * Ami bizonyos id� ut�n lebomlik. 
 * Amit egy virol�gus r�ken egy m�sikra 
 * akkor m�sik virol�gus elfogja felejteni az �sszes megtanult genetikai k�dot.
*/
public class MemoryLossV extends Agens
{
	/**
	 * MemoryLossV konstruktorra
	 * a duration alapb�l mindig a feladat le�r�s alapj�n 3
	 */
	public MemoryLossV() {
		duration = 3;
	}
	/**
	 *  A param�ternek kapott Virologist codes list�j�nak �rt�keit t�rli.
	 *  @param v Melyik virol�gus feljetse el az �sszes codej�t
	 */
	public void Use(Virologist v)
	{
		//System.out.println("\tUse(v) MemoryLossV haszn�lata");
		v.RemoveCode();
	}
}
