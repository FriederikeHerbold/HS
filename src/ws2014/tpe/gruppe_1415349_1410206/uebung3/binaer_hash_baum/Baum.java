package ws2014.tpe.gruppe_1415349_1410206.uebung3.binaer_hash_baum;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class Baum<B, T> implements AssoziativesArray {

	private Knoten<B, T> wurzel;

	private Baum() {
		wurzel = null;
	}

	public Baum(B schluessel, T wert) {
		put(schluessel, wert);
	}

	/**
	 * Innere Klasse die, einen Knoten darstellt.
	 * 
	 * @author FH-Netbook
	 * 
	 * @param <B>
	 * @param <T>
	 */
	class Knoten<B, T> {
		private Knoten<B, T> links;
		private Knoten<B, T> rechts;
		private B schluessel;
		private T wert;

		public Knoten(B schluessel, T wert) {
			this.schluessel = schluessel;
			this.wert = wert;
			this.links = null;
			this.rechts = null;
		}

		/**
		 * Gibt Schluessel und Wert von Knoten als String zurueck
		 * 
		 * @return String
		 */
		@Override
		public String toString() {
			return schluessel + "=" + wert;
		}

		/**
		 * Stellt den Wert des Feldes schluesser zur verfügunf
		 * 
		 * @return schluessel
		 */
		public B getSchluessel() {
			return this.schluessel;
		}

		/**
		 * Stellt den Wert des Feldes wert zur verfügung
		 * 
		 * @return wert
		 */
		public T getWert() {
			return this.wert;
		}

	}

	/**
	 * Macht den Baum leer
	 */
	@Override
	public void clear() {
		wurzel = null;

	}

	/**
	 * Ueberprueft, ob der uebergebene Wert im assoziativen Array vorkommt
	 * 
	 * @param wert
	 * @return true oder false
	 */
	@Override
	public boolean containsValue(Object wert) {
		return value(wurzel, wert);
	}

	/**
	 * hilfsmathode für contaunsValue durchläuft den Baum rekursiv und prüft, ob
	 * der Wert in dem Baum Vorkommt.
	 * 
	 * @param knoten
	 * @param wert
	 * @return True oder False
	 */
	private boolean value(Knoten<B, T> knoten, Object wert) {
		boolean a = false;
		if (knoten.links != null) {
			a = a || value(knoten.links, wert);
		}

		a = a || (knoten.wert.equals(wert));

		if (knoten.rechts != null) {
			a = a || value(knoten.rechts, wert);
		}
		return a;
	}

	/**
	 * Ueberprueft, ob der uebergebene Schluessel im Baum vorkommt
	 * 
	 * @param schluessel
	 * @return true oder false
	 */
	@Override
	public boolean containsKey(Object schluessel) {
		Knoten zeiger = wurzel;

		while (zeiger != null) {
			if (zeiger.schluessel.hashCode() == schluessel.hashCode()) {
				return true;
			} else if (schluessel.hashCode() < zeiger.schluessel.hashCode()) {
				zeiger = zeiger.links;
			} else {
				zeiger = zeiger.rechts;
			}
		}
		return false;
	}

	/**
	 * Gibt den passenden Wert zum uebergebenen Schluessel zurueck
	 * 
	 * @param schluessel
	 * @return wert
	 */
	@Override
	public Object get(Object schluessel) {
		return getKnoten(schluessel).wert;
	}

	/**
	 * Hilfsmethode, die den Passenden Knoten zu einem gegebenen Schlüssel sucht
	 * und zue verfügung stellt
	 * 
	 * @param schluessel
	 * @return Knoten eingegebenem Schlüssel
	 */
	private Knoten getKnoten(Object schluessel) {
		Knoten zeiger = wurzel;

		while (zeiger != null) {
			if (zeiger.schluessel.hashCode() == schluessel.hashCode()) {
				return zeiger;
			} else if (schluessel.hashCode() < zeiger.schluessel.hashCode()) {
				zeiger = zeiger.links;
			} else {
				zeiger = zeiger.rechts;
			}
		}
		return null;
	}

	/**
	 * Ueberprueft, ob das assoziative Array leer ist
	 * 
	 * @return true oder false
	 */
	@Override
	public boolean isEmpty() {
		if (wurzel == null) {
			return true;
		}
		return false;
	}

	/**
	 * Erzeugt Knoten, an dem Schlüssel entsprechender Stelle, im Baum
	 * 
	 * @param schluessel
	 */
	@Override
	public void put(Object schluessel, Object wert) {

		Knoten node = wurzel;

		if (isEmpty()) {
			wurzel = new Knoten(schluessel, wert);
		} else {
			while (schluessel.hashCode() != node.schluessel.hashCode()) {

				if (schluessel.hashCode() < node.schluessel.hashCode()) {
					if (node.links == null) {
						node.links = new Knoten(schluessel, wert);
					}
					node = node.links;

				} else {
					if (node.rechts == null) {
						node.rechts = new Knoten(schluessel, wert);

					}
					node = node.rechts;
				}
			}
		}
	}

	/**
	 * Fuegt alle Schluussel-Wert-Paare des uebergebenen assoziativen Arrays zum
	 * aktuellen assoziativen Array hinzu
	 * 
	 * @param baum
	 */
	public void putAll(Baum baum) {
		putAllKnoten(baum.wurzel);
	}

	/**
	 * Hilfsmathode die, die putAll methode intern auch für Knoten zur verfügung
	 * stellt
	 * 
	 * @param hilf
	 */
	private void putAllKnoten(Knoten hilf) {
		Baum baum = new Baum();
		baum.wurzel = hilf;
		Knoten[] knoten = baum.liste();
		for (int index = 0; index < knoten.length; index++) {
			put(knoten[index].schluessel, knoten[index].wert);
		}
	}

	/**
	 * Entfernt das Schluessel-Wert-Paar des uebergebenen Schluessels aus dem
	 * assoziativen Array und liefert den Wert zurueck
	 * 
	 * @param schluessel
	 * @return wert
	 */
	@Override
	public Object remove(Object schluessel) {
		Knoten entf = getKnoten(schluessel);
		Object wert = entf.wert;
		Knoten links = entf.links;
		Knoten rechts = entf.rechts;
		Knoten vor = getVor(wurzel, entf);
		if (vor == null) {
			wurzel = null;
		} else {
			if (vor.rechts.equals(entf)) {
				vor.rechts = null;
			} else {
				vor.links = null;
			}
		}
		entf = null;
		if (links != null) {
			putAllKnoten(links);
		}
		if (rechts != null) {
			putAllKnoten(rechts);
		}
		return wert;
	}

	/**
	 * Hilfsmethode, sucht Knoten, der vor dem zu löschemden Knoten steht
	 * 
	 * @param knoten
	 *            wurzel des Baumes von dem entfernt wird
	 * @param entf
	 *            zu entfernender Knoten
	 * @return Vorgänger des übergebenen Knotens
	 */
	private Knoten getVor(Knoten knoten, Knoten entf) {

		if (knoten.schluessel.equals(entf.schluessel)) {
			return null;
		} else {
			return getVorRek(knoten, entf);
		}

	}

	/**
	 * Hilfsmethode für getVor zum rekursieven durchlauf
	 * 
	 * @param knoten
	 * @param entf
	 * @return Vorgänger des übergebenen Knotens
	 */
	private Knoten getVorRek(Knoten knoten, Knoten entf) {
		Knoten eltern = null;
		if (knoten.links != null) {
			if (knoten.links.schluessel.equals(entf.schluessel)) {
				eltern = knoten;
			} else {
				eltern = getVorRek(knoten.links, entf);
			}
		}
		if (eltern == null) {
			if (knoten.rechts != null) {
				if (knoten.rechts.schluessel.equals(entf.schluessel)) {
					eltern = knoten;
				} else {
					eltern = getVorRek(knoten.rechts, entf);
				}
			}
		}
		return eltern;
	}

	/**
	 * Gibt Anzahl der Schluessel-Wert-Paare zurueck
	 * 
	 * @return anzahl
	 */
	@Override
	public int size() {
		if (wurzel == null) {
			return 0;
		} else {
			return size(wurzel);
		}
	}

	/**
	 * Hilfsmethode, die rekursiv alle Knoten durchlaeuft
	 * 
	 * @param knoten
	 * @return
	 */
	private int size(Knoten knoten) {
		int sizeLinks = 0;
		int sizeRechts = 0;
		if (knoten.links != null) {
			sizeLinks = size(knoten.links);
		}
		if (knoten.rechts != null) {
			sizeRechts = size(knoten.rechts);
		}
		return 1 + sizeLinks + sizeRechts;
	}

	/**
	 * Aktualisiert den Wert des uebergebenen Schluessels mit dem uebergebenen
	 * Wert
	 * 
	 * @param schluessel
	 *            , wert von Typ Object
	 */
	@Override
	public void update(Object schluessel, Object wert) {
		updateRek(wurzel, schluessel, wert);
	}

	/**
	 * Hilfsmethode, die benoetigten Knoten sucht
	 * 
	 * @param knoten
	 * @param schluessel
	 * @param wert
	 */
	private void updateRek(Knoten knoten, Object schluessel, Object wert) {
		if (knoten.links != null) {
			updateRek(knoten.links, schluessel, wert);
		}

		containsKey(schluessel);
		if (containsKey(schluessel)) {
			knoten.wert = wert;
		}

		if (knoten.rechts != null) {
			updateRek(knoten.links, schluessel, wert);
		}

	}

	/**
	 * Fuegt alle Schluessel-Wert-Paare des aktuellen assoziativen Arrays zum
	 * uebergebenen assoziativen Array hinzu
	 * 
	 * @param baum
	 */
	@Override
	public void extractAll(Baum baum) {
		if (baum != null) {
			if (!baum.isEmpty()) {
				baum.putAll(this);
			}
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((wurzel == null) ? 0 : wurzel.hashCode());
		return result;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Baum other = (Baum) obj;
		if (wurzel == null) {
			if (other.wurzel != null)
				return false;
		} else if (!wurzel.equals(other.wurzel))
			return false;
		return true;
	}

	/**
	 * Verwendet den uebergebenen BiConsumer fuer alle Knoten
	 * 
	 * @param cons
	 * @param wertA
	 * @param wertB
	 */
	@Override
	public void forEach(BiConsumer cons, Object wertA, Object wertB) {
		forEachRek(wurzel, cons, wertA, wertB);
	}

	/**
	 * Hilfsmethode fuer rekursiven Duechlauf
	 * 
	 * @param knoten
	 * @param cons
	 * @param wertA
	 * @param wertB
	 */
	private void forEachRek(Knoten knoten, BiConsumer cons, Object wertA,
			Object wertB) {
		if (knoten.links != null) {
			forEachRek(knoten.links, cons, wertA, wertB);
		}

		cons.accept(wertA, wertB);

		if (knoten.rechts != null) {
			forEachRek(knoten.rechts, cons, wertA, wertB);
		}
	}

	/**
	 * Fuehrt die uebergebene BiFunction fuer alle Knoten aus und erzeugt ein
	 * neuen Baum mit neuen Werten
	 * 
	 * @param funk
	 * @param wertA
	 * @param wertB
	 * @return Baum
	 */
	@Override
	public Baum map(BiFunction funk, Object wertA, Object wertB) {
		Baum erg = new Baum(wurzel.schluessel, funk.apply(wertA, wertB));
		mapRek(wurzel, funk, wertA, wertB, erg);
		return erg;
	}

	/**
	 * Hilfsmethode fuer rekursiven Durchlauf
	 * 
	 * @param knoten
	 * @param funk
	 * @param wertA
	 * @param wertB
	 * @param erg
	 */
	private <B, T> void mapRek(Knoten knoten, BiFunction funk, Object wertA,
			Object wertB, Baum erg) {
		if (knoten.links != null) {
			mapRek(knoten.links, funk, wertA, wertB, erg);
		}

		erg.put(knoten.schluessel, funk.apply(wertA, wertB));

		if (knoten.rechts != null) {
			mapRek(knoten.rechts, funk, wertA, wertB, erg);
		}

	}

	/**
	 * Konvertiert alle Knoten in einen fortlaufenden String für die Ausgabe
	 * 
	 * @return Baum als String
	 */
	@Override
	public String toString() {
		Knoten[] knoten = liste();
		String ausgabe = "{" + knoten[0].toString();
		for (int index = 1; index < knoten.length; index++) {
			ausgabe += ", " + knoten[index].toString();
		}
		ausgabe += "}";
		return ausgabe;
	}

	/**
	 * Speichert alle knoten des Baumes,in preorder, in ein Array um die spätere
	 * bearbeitung zu vereinfachen
	 * 
	 * @return Array von Knoten
	 */
	public Knoten[] liste() {
		Knoten[] erg = new Knoten[size()];
		int index = 0;
		return listeRek(wurzel, erg, index);
	}

	/**
	 * Hilfsmethode für rekuriven Durchlauf
	 * 
	 * @param knoten
	 * @param erg
	 * @param index
	 * @return Array von Knoten
	 */
	private Knoten[] listeRek(Knoten knoten, Knoten[] erg, int index) {
		if (erg[index] == null) {
			erg[index] = knoten;
			index++;
		}
		if (knoten != null && knoten.links != null) {

			listeRek(knoten.links, erg, index);
			index++;
		}
		if (knoten != null && knoten.rechts != null) {

			listeRek(knoten.rechts, erg, index);
			index++;

		}
		index++;
		return erg;
	}
}
