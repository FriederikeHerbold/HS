package ws2014.tpe.gruppe_1415349_1410206.uebung3.binaer_hash_baum;

public class Baum<B, T> implements AssoziativesArray {
	private Knoten<B, T> wurzel;

	public Baum(B schluessel, T wert) {
		put(schluessel, wert);
	}

	class Knoten<B, T> {
		Knoten<B, T> links;
		Knoten<B, T> rechts;
		B schluessel;
		T wert;

		public Knoten(B schluessel, T wert) {
			this.schluessel = schluessel;
			this.wert = wert;
			this.links = null;
			this.rechts = null;
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean containsValue(Object wert) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsKey(Object schluessel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object get(Object schluessel) {
		// TODO Auto-generated method stub
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
		if (wurzel == null) {
			this.wurzel = new Knoten(schluessel, wert);
		} else {
			Knoten temp = new Knoten(schluessel, wert);
			Knoten hilf = wurzel;
			put(temp, hilf);
		}

	}

	private void put(Knoten temp, Knoten n) {
		if (n == null) {
			n = temp;
		} else if (temp.hashCode() < n.hashCode()) {
			put(temp, n.links);
		} else if (temp.hashCode() > n.hashCode()) {
			put(temp, n.rechts);
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Object schluessel, Object wert) {
		// TODO Auto-generated method stub

	}

	@Override
	public void extractAll(Baum baum) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
