package ws2014.tpe.gruppe_1415349_1410206.uebung2.vermögensverwaltung;

public abstract class Vermoegensgegenstaende {
	private String name;
	private long kaufPreis;
	private Date kaufDatum;
	
	public Vermoegensgegenstaende(String name, long kaufpreis, Date kaufDatum){
		this.name=name;
		this.kaufPreis=kaufPreis;
		this.kaufDatum=kaufDatum;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the kaufpreis
	 */
	public long getKaufPreis() {
		return kaufPreis;
	}

	/**
	 * @return the kaufDatum
	 */
	public Date getKaufDatum() {
		return kaufDatum;
	}

	abstract public long berechneWert(int anzahl);
	
}
