
/** 
 * Visitor pattern megval�s�t�s�ra szolg�l� interface
 */
public interface IVisitor
{
	/**
	 *  Seg�ts�g�vel ellen�rizz�k 
	 *  hogy tal�lhat� e a keresett oszt�lyban adott effect
	 *  @param bp Melyik effectett keres�k
	 *  @return Visszat�r, hogy tal�lhat�-e benne a keresett effect
	 */
	public default int Visit(BackPackEffect bp)
	{
		return 1;
	}
	
	/**
	 *  Seg�ts�g�vel ellen�rizz�k 
	 *  hogy tal�lhat� e a keresett oszt�lyban adott effect
	 *  @param gl Melyik effectett keres�k
	 *  @return Visszat�r, hogy tal�lhat�-e benne a keresett effect
	 */
	public default int Visit(GloveEffect gl)
	{
		return 2;
	}
	
	/**
	 *  Seg�ts�g�vel ellen�rizz�k 
	 *  hogy tal�lhat� e a keresett oszt�lyban adott effect
	 *  @param cp Melyik effectett keres�k
	 *  @return Visszat�r, hogy tal�lhat�-e benne a keresett effect
	 */
	public default int Visit(CapeEffect cp)
	{
		return 3;
	}
	
	/**
	 *  Seg�ts�g�vel ellen�rizz�k 
	 *  hogy tal�lhat� e a keresett oszt�lyban adott effect
	 *  @param vr Melyik effectett keres�k
	 *  @return Visszat�r, hogy tal�lhat�-e benne a keresett effect
	 */
	public default int Visit(VirusResistentEffect vr)
	{
		return 4;
	}
	
	/**
	 *  Seg�ts�g�vel ellen�rizz�k 
	 *  hogy tal�lhat� e a keresett oszt�lyban adott effect
	 *  @param vd Melyik effectett keres�k
	 *  @return Visszat�r, hogy tal�lhat�-e benne a keresett effect
	 */
	public default int Visit(VirusDanceEffect vd)
	{
		return 5;
	}
	
	/**
	 *  Seg�ts�g�vel ellen�rizz�k 
	 *  hogy tal�lhat� e a keresett oszt�lyban adott effect
	 *  @param p Melyik effectett keres�k
	 *  @return Visszat�r, hogy tal�lhat�-e benne a keresett effect
	 */
	public default int Visit(ParalyzedEffect p)
	{
		return 6;
	}
	/**
	 *  Seg�ts�g�vel ellen�rizz�k 
	 *  hogy tal�lhat� e a keresett oszt�lyban adott effect
	 *  @param p Melyik effectett keres�k
	 *  @return Visszat�r, hogy tal�lhat�-e benne a keresett effect
	 */
	public default int Visit(MaciEffekt p) {
		return 7;
	}
	/**
	 *  Seg�ts�g�vel ellen�rizz�k 
	 *  hogy tal�lhat� e a keresett oszt�lyban adott effect
	 *  @param p Melyik effectett keres�k
	 *  @return Visszat�r, hogy tal�lhat�-e benne a keresett effect
	 */
	public default int Visit(AxeEffect p) {
		return 8;
	}
}
