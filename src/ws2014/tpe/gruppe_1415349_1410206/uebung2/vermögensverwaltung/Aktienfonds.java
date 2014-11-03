package ws2014.tpe.gruppe_1415349_1410206.uebung2.vermögensverwaltung;

public class Aktienfonds extends Aktie {

	private Aktie[] fond = new Aktie[7];
	private int[] anzahl = new int[7];
	private int index = 0;

	public Aktienfonds(String name, long kaufPreis, Date kaufDatum,
			Aktie aktie, int anzahl) {
		super(name, kaufPreis, kaufDatum, 1);
		this.setElement(aktie, anzahl);
	}

	public Aktienfonds(String name, long kaufPreis, Date kaufDatum,
			Aktie aktie1, int anzahl1, Aktie aktie2, int anzahl2) {
		this(name, kaufPreis, kaufDatum, aktie1, anzahl1);
		this.setElement(aktie2, anzahl2);
	}

	public Aktienfonds(String name, long kaufPreis, Date kaufDatum,
			Aktie aktie1, int anzahl1, Aktie aktie2, int anzahl2, Aktie aktie3,
			int anzahl3) {
		this(name, kaufPreis, kaufDatum, aktie1, anzahl1, aktie2, anzahl2);
		this.setElement(aktie3, anzahl3);
	}

	public Aktienfonds(String name, long kaufPreis, Date kaufDatum,
			Aktie aktie1, int anzahl1, Aktie aktie2, int anzahl2, Aktie aktie3,
			int anzahl3, Aktie aktie4, int anzahl4) {
		this(name, kaufPreis, kaufDatum, aktie1, anzahl1, aktie2, anzahl2,
				aktie3, anzahl3);
		this.setElement(aktie4, anzahl4);
	}

	public Aktienfonds(String name, long kaufPreis, Date kaufDatum,
			Aktie aktie1, int anzahl1, Aktie aktie2, int anzahl2, Aktie aktie3,
			int anzahl3, Aktie aktie4, int anzahl4, Aktie aktie5, int anzahl5) {
		this(name, kaufPreis, kaufDatum, aktie1, anzahl1, aktie2, anzahl2,
				aktie3, anzahl3, aktie4, anzahl4);
		this.setElement(aktie5, anzahl5);
	}

	public Aktienfonds(String name, long kaufPreis, Date kaufDatum,
			Aktie aktie1, int anzahl1, Aktie aktie2, int anzahl2, Aktie aktie3,
			int anzahl3, Aktie aktie4, int anzahl4, Aktie aktie5, int anzahl5,
			Aktie aktie6, int anzahl6) {
		this(name, kaufPreis, kaufDatum, aktie1, anzahl1, aktie2, anzahl2,
				aktie3, anzahl3, aktie4, anzahl4, aktie5, anzahl5);
		this.setElement(aktie6, anzahl6);
	}

	public Aktienfonds(String name, long kaufPreis, Date kaufDatum,
			Aktie aktie1, int anzahl1, Aktie aktie2, int anzahl2, Aktie aktie3,
			int anzahl3, Aktie aktie4, int anzahl4, Aktie aktie5, int anzahl5,
			Aktie aktie6, int anzahl6, Aktie aktie7, int anzahl7) {
		this(name, kaufPreis, kaufDatum, aktie1, anzahl1, aktie2, anzahl2,
				aktie3, anzahl3, aktie4, anzahl4, aktie5, anzahl5, aktie6,
				anzahl6);
		this.setElement(aktie7, anzahl7);
	}

	/**
	 * 
	 * @param fond
	 * @param anzahl
	 */
	private void setElement(Aktie fond, int anzahl) {
		this.fond[index] = fond;
		this.anzahl[index] = anzahl;
		index++;
	}

	@Override
	public int getKurs() {
		int kurs = 0;
		for (int i = 0; i < index; i++) {
			kurs = kurs + fond[i].getKurs();
		}
		return kurs;
	}

	public long berechneWert() {
		long wert = 0;
		for (int i = 0; i < index; i++) {
			wert = wert + (fond[i].berechneWert(anzahl[i]));
		}
		return wert;
	}
	@Override
	public String toString(){
		return "Aktienfond " + getName()+ " ";
	}

}