package ws2014.tpe.gruppe_1415349_1410206.uebung3.binaer_hash_baum;

public class Baum<B, T> implements AssoziativesArray {

	private Knoten<B, T> wurzel;

	public Baum() {
		wurzel = null;
	}

	public Baum(Knoten knoten) {
		wurzel = knoten;
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
		private Knoten<B, T> eltern;
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
		 * Setzt den linken Nachfolger und verknüpft ihn mit seinem Vorgänger.
		 * 
		 * @param zeiger
		 *            von Typ Knoten
		 */
		public void setLeft(Knoten zeiger) {
			links = zeiger;
			if (zeiger != null) {
				zeiger.eltern = this;
			}
		}

		/**
		 * Setzt den rechten Nachfolger und verknüpft ihn mit seinem Vorgänger.
		 * 
		 * @param zeiger
		 *            von Typ Knoten
		 */
		public void setRight(Knoten zeiger) {
			rechts = zeiger;
			if (zeiger != null) {
				zeiger.eltern = this;
			}
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
	 *            von Typ Object
	 * @return true oder false
	 */
	@Override
	public boolean containsValue(Object wert) {
		return Value(wurzel, wert);
	}

	/**
	 * 
	 * @param knoten
	 * @param wert
	 * @return
	 */
	private boolean Value(Knoten<B, T> knoten, Object wert) {
		boolean a = false;
		if (knoten.links != null) {
			a = a || Value(knoten.links, wert);
		}

		a = a || (knoten.wert.equals(wert));

		if (knoten.rechts != null) {
			a = a || Value(knoten.rechts, wert);
		}
		return a;
	}

	/**
	 * Ueberprueft, ob der uebergebene Schluessel im assoziativen Array vorkommt
	 * 
	 * @param schluessel
	 *            von Typ Object
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
	 *            von Typ Object
	 * @return wert
	 */
	@Override
	public Object get(Object schluessel) {
		Knoten zeiger = wurzel;

		while (zeiger != null) {
			if (zeiger.schluessel.hashCode() == schluessel.hashCode()) {
				return zeiger.wert;
			} else if (schluessel.hashCode() < zeiger.schluessel.hashCode()) {
				zeiger = zeiger.links;
			} else {
				zeiger = zeiger.rechts;
			}
		}
		return 0;

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
	 * Speichert den uebergebenen Schluessel und Wert im assoziativen Array
	 * 
	 * @param schluessel
	 *            , wert von Typ Object
	 */
	@Override
	public void put(Object schluessel, Object wert) {

		Knoten node = wurzel;

		if (isEmpty()) {
			wurzel = new Knoten(schluessel, wert);
			return;
		}
		while (node != null) {
			if (schluessel.hashCode() == node.schluessel.hashCode()) {
				break;
			}

			if (schluessel.hashCode() < node.schluessel.hashCode()) {
				if (node.links == null) {
					node.links = new Knoten(schluessel, wert);
					break;
				}
				node = node.links;

			} else {
				if (node.rechts == null) {
					node.rechts = new Knoten(schluessel, wert);
					break;
				}
				node = node.rechts;
			}
		}
	}

	/**
	 * Fuegt alle Schluussel-Wert-Paare des uebergebenen assoziativen Arrays zum
	 * aktuellen assoziativen Array hinzu
	 * 
	 * @param baum
	 *            von Typ Bam
	 */
	public void putAll(Baum baum) {
		if (baum != null) {
			if (!baum.isEmpty()) {
				putAllrek(baum.wurzel);
			}
		}
	}

	/**
	 * Hilfsmethode fuer putAll-Methode
	 * 
	 * @param knoten
	 */
	private void putAllrek(Knoten knoten) {
		if (knoten.links != null) {
			putAllrek(knoten.links);
		}

		put(knoten.schluessel, knoten.wert);

		if (knoten.rechts != null) {
			putAllrek(knoten.rechts);
		}
	}

	/**
	 * Entfernt das Schluessel-Wert-Paar des uebergebenen Schluessels aus dem
	 * assoziativen Array und liefert den Wert zurueck
	 * 
	 * @param schluessel
	 *            von Typ Object
	 * @return wert
	 */
	@Override
	public Object remove(Object schluessel) {
		Knoten zeiger = null;
		Object rueckwert = null;

		if (!containsKey(schluessel)) {
			return rueckwert;
		}
		if (wurzel.schluessel == schluessel) {
			Baum linkerUnterbaum = new Baum(wurzel.links);
			Baum rechterUnterbaum = new Baum(wurzel.rechts);

			rueckwert = wurzel.wert;
			wurzel = null;
			putAll(linkerUnterbaum);
			putAll(rechterUnterbaum);
			return rueckwert;

		} else {
			Knoten zuLoeschender = null;
			Knoten elternKnoten = elternSuche(wurzel, schluessel);
			if (elternKnoten.links != null) {
				if (elternKnoten.links.schluessel == schluessel) {
					zuLoeschender = elternKnoten.links;
				}
			}

			if (elternKnoten.rechts != null) {
				if (elternKnoten.rechts.schluessel == schluessel) {
					zuLoeschender = elternKnoten.rechts;
				}
			}

			Baum linkerUnterbaum = new Baum(zuLoeschender.links);
			Baum rechterUnterbaum = new Baum(zuLoeschender.rechts);

			rueckwert = zuLoeschender.wert;
			if (elternKnoten.links != null) {
				if (elternKnoten.links.schluessel == schluessel) {
					elternKnoten.links = null;
				}
			}
			if (elternKnoten.rechts != null) {
				if (elternKnoten.rechts.schluessel == schluessel) {
					elternKnoten.rechts = null;
				}
			}
			zuLoeschender = null;
			putAll(linkerUnterbaum);
			putAll(rechterUnterbaum);
			return rueckwert;
		}

	}

	/**
	 * Hilfsmethode, sucht Knoten, der vor dem zu löschemden Knoten steht
	 * 
	 * @param knoten
	 * @param schluessel
	 * @return
	 */

	private Knoten elternSuche(Knoten knoten, Object schluessel) {
		Knoten eltern = null;

		if (knoten.links != null) {
			if (knoten.links.schluessel == schluessel) {

				eltern = knoten;
			} else {
				eltern = elternSuche(knoten.links, schluessel);

			}
		}
		if (eltern == null) {

			if (knoten.rechts != null) {
				if (knoten.rechts.schluessel == schluessel) {

					eltern = knoten;
				} else {
					eltern = elternSuche(knoten.rechts, schluessel);
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
	 * Aktualisiert den Wert des ubergebenen Schlussels mit dem ubergebenen
	 * Wert
	 * 
	 * @param schluessel, wert von Typ Object
	 */
	@Override
	public void update(Object schluessel, Object wert) {
		updateRek(wurzel, schluessel, wert);
	}
	/**
	 * Hilfsmethode, die benoetigten Knoten sucht
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
	 *            von Typ Baum
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
	 * Konvertiert alle Knoten in einen fortlaufenden String für die Ausgabe
	 * 
	 * @return Baum als String
	 */

	@Override
	public String toString() {
		String ausgabe = "";
		if (wurzel != null) {
			ausgabe = toStringInOrder(wurzel);
		}
		if (ausgabe != "") {
			ausgabe = ausgabe.substring(0, ausgabe.length() - 2);

		}
		return "{" + ausgabe + "}";
	}

	/**
	 * Fuehrt zuerst den linken Teilbaum, dann die Wurzel und schließlich den
	 * rechten Teilbaum aus
	 * 
	 * @param knoten
	 * @return
	 */
	public String toStringInOrder(Knoten<B, T> knoten) {
		String a = "";
		if (knoten.links != null) {
			a = a + toStringInOrder(knoten.links);
		}

		a = a + knoten.toString() + ", ";

		if (knoten.rechts != null) {
			a = a + toStringInOrder(knoten.rechts);
		}
		return a;
	}
}
