

/** 
 * Genetikai k�d, ami a laborat�riumban lehet letapogatni.
 *  Ez egy recept, aminek birtok�ban a virol�gus bizonyos �genst el tudd k�sz�teni. 
 * Ennek a birtokl�sa sz�ks�ges a j�t�k megnyer�s�hez.
 */
public class Code
{
	
	/** 
	 * Adott �gens l�trehoz�s�hoz sz�ks�ges aminosav mennyis�ge
	 * */
	private int cost_to_make_N;
	/**
	 * A Code-hoz tartoz� id amivel a Mainben azonos�tjuk
	 */
	private String id;
	
	/** 
	 * Adott �gens l�trehoz�s�hoz sz�ks�ges nukleotid mennyis�ge
	 */
	private int cost_to_make_A;
	/**
	 * Adott �gens amit l�tre fog hozni a k�d.
	 */
	private Agens agens;
	/**
	 * Agens gettere
	 * @return agens
	 */
	public Agens getAgens() {
		System.out.println("\tgetAgens() Agens gettere lefutt");
		System.out.println("\tgetAgens() Agens return");
		return agens;
	}
	/**
	 * cost_to_make_N gettere
	 * @return cost_to_make_N
	 */
	public int getCost_to_make_N() {
		System.out.println("\tgetCost_to_make_N() Agens Nucleotid �r�nak legk�rdez�se");
		System.out.println("\tgetCost_to_make_N() "+cost_to_make_N+" return");
		return cost_to_make_N;
	}
	/**
	 * Visszat�r, hogy milyen azonos�tott haszn�lunk neki a Main-ben
	 * @return
	 */
	public String getid()
	{
		return id;
	}
	/**
	 * Be�ll�tjuk az azonos�tott amivel a kirat�sok sorr�n hivatkozni fogunk r�
	 * @param nid azonos�t� amivel hivatkozunk majd r�
	 */
	public void setid(String nid)
	{
		 id=nid;
	}
	/**
	 * cost_to_make_A gettere
	 * @return cost_to_make_A
	 */
	public int getCost_to_make_A() {
		//System.out.println("\tgetCost_to_make_A() Agens aminosav �r�nak legk�rdez�se");
		//System.out.println("\tgetCost_to_make_A() "+cost_to_make_A+" return");
		return cost_to_make_A;
	}
	/**
	 * Konstruktor amely megadja a Code-hoz tartoz� adatokat.
	 * @param cost_N
	 * @param cost_A
	 * @param a
	 */
	public Code(int cost_N,int cost_A,Agens a) {
		cost_to_make_N=cost_N;
		cost_to_make_A=cost_A;
		agens=a;
		id="code";//;+(int)(Math.random()*1000);
	}

}
