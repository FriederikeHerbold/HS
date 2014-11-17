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

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "[schluessel=" + schluessel + ", wert=" + wert + "]";
		}
		
		
	}

	@Override
	public void clear() {
		wurzel = null;

	}

	@Override
	public boolean containsValue(Object wert) {
		Knoten n = wurzel;

        while (n != null) {
            if (n.wert.equals(wert)) {
                return true; 
            } else if (!n.wert.equals(wert)) {
                n = n.links;
            } else {
                n = n.rechts;
            }
        }
        return false;
    }
	

	@Override
	public boolean containsKey(Object schluessel) {
		Knoten n = wurzel;

        while (n != null) {
            if (n.schluessel.equals(schluessel)) {
                return true; 
            } else if (!n.schluessel.equals(schluessel)) {
                n = n.links;
            } else {
                n = n.rechts;
            }
        }
        return false;
	}

	@Override
	public Object get(Object schluessel) {
		Knoten n = wurzel;
	
		while (n != null) {
			if(n.schluessel.equals(schluessel)){
			return n.wert;
		}else if(!n.schluessel.equals(schluessel)){
			n = n.links;
		 } else {
             n = n.rechts;
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

	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((wurzel == null) ? 0 : wurzel.hashCode());
		return result;
	}

	/* (non-Javadoc)
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String text = "";
		Knoten n = wurzel;
		while(n!=null){
			return text += n.toString();
		}
		return text;
	}
			
			
		  
		
	}

	


