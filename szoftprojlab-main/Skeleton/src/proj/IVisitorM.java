


/** 
 * Matterial visitor pattern megval�s�t�s�ra szolg�l� interface
 */
public interface IVisitorM
{
	/** 
	 * Seg�ts�g�vel ellen�rizz�k hogy tal�lhat� e benne a keresett anyag
	 * @param a Megkapja, milyen anyagot keres�nk
	 * @return Visszat�r, hogy tal�lhat�-e benne 
	 */
	public default int Visit(AminoAcid a)
	{
		return 1;
	}
	
	/** 
	 * Seg�ts�g�vel ellen�rizz�k hogy tal�lhat� e benne a keresett anyag
	 * @param a Megkapja, milyen anyagot keres�nk
	 * @return Visszat�r, hogy tal�lhat�-e benne 
	 */
	public default int Visit(Nucleotid a)
	{
		return 2;
	}
}
