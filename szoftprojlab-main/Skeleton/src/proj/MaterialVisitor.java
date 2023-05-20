
/** 
 * A visitor pattern egy material visitor�t megval�s�t� oszt�ly
 */
public class MaterialVisitor implements IVisitorM
{
	/** 
	 * Seg�ts�g�vel ellen�rizz�k hogy tal�lhat� e benne a keresett anyag
	 * @param a Megkapja, milyen anyagot keres�nk
	 * @return Visszat�r, hogy tal�lhat�-e benne 
	 */
	@Override
	public int Visit(AminoAcid a)
	{
		return 1;
	}
	
	/** 
	 * Seg�ts�g�vel ellen�rizz�k hogy tal�lhat� e benne a keresett anyag
	 * @param a Megkapja, milyen anyagot keres�nk
	 * @return Visszat�r, hogy tal�lhat�-e benne 
	 */
	@Override
	public int Visit(Nucleotid a)
	{
		return 2;
	}
}
