/**
 * Maci effectet reprezent�l� oszt�ly, 
 * Virol�guson alkalmazhat� effect, ami a Laboratroy-on l�v� megfert�z�d�ssel ker�lhet a Virol�gusra. 
 *
 */
public class MaciEffekt extends Effect {
	
	/** 
	 * Ez a f�ggv�ny teszi lehet�v�, hogy az oszt�ly fogadni tudjon IVisitort.
	 * @param v Megkapja, hogy melyik IVisitor l�togatja meg
	 * @return Visszat�r, hogy sikeres volt-e a l�togat�s
	 */
	@Override
	public int Accept(IVisitor v)
	{
		//System.out.println("\tAccept(i)IVisitorM pattern haszn�lata");
		int x=v.Visit(this);
		//System.out.println("\tAccept(i) "+x+" return");
		return x;
	}
	
	/**
	 * Amikor az effecten megh�vodik a met�dus, akkor a Virol�gus megfert�z mindenkit akivel egy mez�n �ll, 
	 * majd ut�n egy random szomsz�dos mez�re l�p 
	 * �s ott is megpr�b�l minden m�sik virol�gust megfert�zni MaciEffect-tel.
	 * @param v Virologus, aki megh�vja ezt a met�dust.
	 */
	@Override
	public void Decrease(Virologist v) {
		if(v.getField()!=null) {
			Field f = v.getField();
			for(Virologist virologus : f.getVirologist()) {
				if(virologus.canAttack(true)&& !virologus.equals(v))
					virologus.AddEffect(new MaciEffekt());
			}
			v.MoveRandom();
			f = v.getField();
			for(Virologist virologus : f.getVirologist()) {
				if(virologus.canAttack(true) && !virologus.equals(v))
				virologus.AddEffect(new MaciEffekt());
			}
			f.Use(v);
		}
	}
	/**
	 * Az oszt�ly konstruktora
	 */
	public MaciEffekt() {
		id="maciEffect";//+(int)(Math.random()*1000);
	}
}
