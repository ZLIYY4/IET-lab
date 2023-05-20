/** 
 * Ez hatï¿½s, amit a vï¿½rologus, kap ha bizonyos ï¿½genssel kenik meg,
 *  ekkor bizonyos kï¿½rig ha mï¿½s keni meg ï¿½genssel nem kapja meg az adott ï¿½gens hatï¿½sï¿½t. 
 * (Kivï¿½ve: ha kesztyï¿½vel dobjï¿½k rï¿½ vissza).
 */
public class VirusDanceEffect extends Effect
{
	/** 
	 * Ez a fï¿½ggvï¿½ny teszi lehetï¿½vï¿½, hogy az osztï¿½ly fogadni tudjon IVisitort.
	 * @param v Megkapja, hogy melyik IVisitor lï¿½togatja meg
	 * @return Visszatï¿½r, hogy sikeres volt-e a lï¿½togatï¿½s
	 */
	@Override
	public int Accept(IVisitor v)
	{
		int x=v.Visit(this);
		return x;
	}
	/**
	 * Az osztï¿½ly konstruktora
	 */
	public VirusDanceEffect() {
		id="virusDanceEffect";//+(int)(Math.random()*1000);
		duration=1;
	}
	/** 
	 *  Az effect lebomlï¿½sï¿½t kezeli
	 *  és random szomszédos mezõre mozgatja a virológust
	 *  @param v Megkapja, hogy melyik virolï¿½gushoz tartozik az effect
	 */
	@Override
	public void Decrease(Virologist v)
	{
		duration=duration-1;
		if(duration<=0)
			v.RemoveEffect(this);
		v.MoveRandom();
	}
}
