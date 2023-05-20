

import java.awt.Graphics;

/**
 *	Field osztály örököl belõle, és kezeli a pálya mezõinek a megjelenítését
 */
public interface FieldView {
	/**
	 * kirajzolja a mezõket
	 */
	public void drawField(Graphics g, GameFrame frame);
	/**
	 * kiraljzolja a mezõket összekötõvonalakat
	 */
	public void drawNeigbourLine(Graphics g, GameFrame frame);
	
	/**
	 * kirajzolja a macit és a virológust a mezõre
	 */
	public void drawIconOnField(Graphics g, GameFrame frame);	


}
