package ws2014.tpe.gruppe_1415349_1410206.uebung3.binaer_hash_baum;

/**
 * Klasse, die das generische Assoziativ Array auf teil generiches Assoziativ
 * Array abbildet in dem alle Schlüssel vom typ String sind
 *
 */
public class AssoziativesSringArray<String, T> extends Baum<String, T> {

	public AssoziativesSringArray(String schluessel, T wert) {
		super(schluessel, wert);
	}

}
