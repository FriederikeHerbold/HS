package ws2014.tpe.gruppe_1415349_1410206.uebung3.binaer_hash_baum;

public class Baum<B, T> implements AssoziativesArray {
	private Knoten<B, T> wurzel;

	public Baum(B schluessel, T wert) {
		put(schluessel, wert);
	}

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

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "[schluessel=" + schluessel + ", wert=" + wert + " hash "
					+ schluessel.hashCode() + "]";
		}
		


		/**
		 * Setzt den linken Nachfolger und verknüpft ihn mit seinem Vorgänger.
		 * 
		 * @param n
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
		 * @param n
		 */
		public void setRight(Knoten zeiger) {
			rechts = zeiger;
			if (zeiger != null) {
				zeiger.eltern = this;
			}
		}
		

}

	@Override
	public void clear() {
		wurzel = null;

	}
//nicht fertig
	@Override
	public boolean containsValue(Object wert) {
		Knoten zeiger = wurzel;

		while (zeiger != null) {
			if (zeiger.wert.equals(wert)) {
				return true;
			} else if (!zeiger.wert.equals(wert)) {
				zeiger = zeiger.links;
			} else {
				zeiger = zeiger.rechts;
			}
		}
		return false;
	}

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
		return null;
	}

	/**
	 * 
	 */
	@Override
	public boolean isEmpty() {
		if (wurzel == null) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 */

	@Override
	public void put(Object schluessel, Object wert) {
		Knoten parent = null;
		Knoten node = wurzel;

		while (node != null) {
			parent = node;
			if (schluessel.hashCode() < node.schluessel.hashCode()) {
				node = node.links;
			} else {
				node = node.rechts;
			}
		}

		Knoten newNode = new Knoten(schluessel, wert);
		if (parent == null) {
			wurzel = newNode;
			
		} else if (schluessel.hashCode() < parent.schluessel.hashCode()) {
			parent.setLeft(newNode);
			
		} else {
			parent.setRight(newNode);
		}

	}

	/**
	 * @return Wert Generisch
	 */
	@Override
	public T remove(Object schluessel) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int size() {
		 if (wurzel == null) {
		 return 0;
		 } else {
		 return size(wurzel);
		 }
		 }
		

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
		
	@Override
	public void update(Object schluessel, Object wert) {
		// TODO Auto-generated method stub

	}

	@Override
	public void extractAll(Baum baum) {
		// TODO Auto-generated method stub

	}

	/*
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

	/*
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String ausgabe = "";
		if (wurzel != null) {
			ausgabe = toStringInOrder(wurzel, "");
		}
		return ausgabe;
	}

	public String toStringInOrder(Knoten<B, T> knoten, String a) {
		if (knoten.links != null) {
			a = a + toStringInOrder(knoten.links, "");
		}

		a = a + knoten.toString();

		if (knoten.rechts != null) {
			a = a + toStringInOrder(knoten.rechts, "");
		}
		return a;
	}
}
