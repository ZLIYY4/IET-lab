

/** 
 * Egy anyag, ami a rakt�rban tal�lhat�. 
 * Ez sz�ks�ges bizonyos �gensek elk�sz�t�s�hez..
*/
public class AminoAcid implements Material
{
	String id;
	/**
	 * Getter az idre
	 * @return
	 */
	public String getId() {
		return id;
	}
	/**
	 * Setter az idre
	 * @param d
	 */
	public void setId(String d) {
		id=d;
	}
	/** IVisitorM fogad�s�ra alkalmazott f�ggv�ny.
	 * @param i megkapja hogy melyik visitor akkarja megl�ttogatni
	 */
	@Override
	public int Accept(IVisitorM i)
	{
		//System.out.println("\tAccept(i)IVisitorM pattern haszn�lata");
		int x=i.Visit(this);
		//System.out.println("\tAccept(i) "+x+" return");
		return x;
	}
	/**
	 * Az oszt�ly konstruktora
	 */
	public AminoAcid() {
		id="aminoacid"+(int)(Math.random()*1000);
	}
}
