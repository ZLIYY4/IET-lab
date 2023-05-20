

/** 
 * Az anyagot reprezent�l� oszt�ly
*/
public interface Material
{
	/** 
	 * /** IVisitorM fogad�s�ra alkalmazott f�ggv�ny.
	 * @param i megkapja hogy melyik visitor akkarja megl�ttogatni
	 */
	public default int Accept(IVisitorM i) {return 3;}
}
