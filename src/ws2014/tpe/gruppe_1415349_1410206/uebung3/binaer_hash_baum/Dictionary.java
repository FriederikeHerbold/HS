package ws2014.tpe.gruppe_1415349_1410206.uebung3.binaer_hash_baum;

/**
 * Klasse, die das generische Assoziativ Array auf ein String, String Assoziativ
 * Array abbildet, angelehnt an ein w�rterbuch
 *
 */
public class Dictionary extends Baum<String, String> {

	public Dictionary(String schluessel, String wert) {
		super(schluessel, wert);
	}

	/**
	 * Speichert alle Schl�ssel in ein Array und gibt es zur�ck
	 * 
	 * @return Liste (Arrsy) der Schl�ssel
	 */
	public String[] keys() {
		String[] keys = new String[size()];
		Knoten[] knoten = liste();
		for (int index = 0; index < keys.length; index++) {
			keys[index] = (String) knoten[index].getSchluessel();
		}
		return keys;

	}

	/**
	 * Speichert alle Werte in ein Array ung gibt es zur�ck
	 * 
	 * @return Liste (Array) der Werte
	 */
	public String[] values() {
		String[] values = new String[size()];
		Knoten[] knoten = liste();
		for (int index = 0; index < values.length; index++) {
			values[index] = (String) knoten[index].getWert();

		}
		return values;
	}

}
