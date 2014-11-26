package ws2014.tpe.gruppe_1415349_1410206.uebung3.binaer_hash_baum;

/**
 * Klasse, die das generische Assoziativ Array auf teil generiches Assoziativ
 * Array abbildet in dem alle Werte vom typ Integer sind
 *
 */
public class IntegerAssoziativeArray<B, Integer> extends Baum<B, Integer> {
	public IntegerAssoziativeArray(B schluessel, Integer wert) {
		super(schluessel, wert);
	}
}
