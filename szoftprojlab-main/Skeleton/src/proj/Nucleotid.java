

/** 
 * Egy anyag, ami a laborat�riumban tal�lhat�. 
 * Ez sz�ks�ges bizonyos �gensek elk�sz�t�s�hez.
 */
public class Nucleotid implements Material
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
		int x=i.Visit(this);
		return x;
	}
	/**
	 * Az oszt�ly konstruktora.
	 */
	public Nucleotid() {
		id="nucleotid"+(int)(Math.random()*1000);
	}
}
