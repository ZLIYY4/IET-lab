/** 
 * A jtk kezdett s vgt kezel osztly
*/
public class Game
{
	/**
	 * Megkapja a gameControlert, hogy tudjunk neki szólni, hogy rajzolja ki
	 */
	static GameController ga;
	/** 
	 *  Ellenï¿½rzi, hogy megvan-e az adott virolgusnak a megfelel szm 
	 *  genetikai kdja, az adott virolgusnl lv genetikai kdok szmt 
	 *  kapja meg paramterknt
	 *  @param codeNumber hany darab code-dal rendelkezik a virolgus
	 */
	public static void EndGame(int codeNumber)
	{
		if(codeNumber==4)
		{
			ga.JatekVege();
		}
	}
}
