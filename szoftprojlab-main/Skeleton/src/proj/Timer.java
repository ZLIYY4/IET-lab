import java.util.List;

/** 
 * Ez az oszt�ly felel a Steppable interfacet megval�s�t� objektumok 
 * ir�ny�t�s��rt. Ir�ny�tja a virol�gusok l�p�seinek sorrendj�t, valamint az �
 * effektek hat�s�t
 */
public class Timer
{
	/**
	 * T�rolja a l�pni k�pes objektumokat
	 */
	private List<Steppable> steppable;
	/** 
	 * Ciklikusan megh�vja a soron lev� Steppable interfacet megval�s�t� 
	 * oszt�ly step() f�ggv�ny�t, eg�szen m�g a j�t�k v�get nem �r
	 */
	public void Run()
	{
		//System.out.println("\tRun() Timer l�ptett minden Steappable-t");
		for(int i=0; i<steppable.size();i++)
			steppable.get(i).Step();
	}
}
