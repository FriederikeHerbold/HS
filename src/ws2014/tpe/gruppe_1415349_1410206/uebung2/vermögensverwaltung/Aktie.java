package ws2014.tpe.gruppe_1415349_1410206.uebung2.vermögensverwaltung;

public class Aktie extends Vermoegensgegenstaende {
	int kurs;

	public Aktie(String name, long kaufPreis, Date kaufDatum, int kurs) {
		super(name, kaufPreis, kaufDatum);
		setKurs(kurs);
	}

	public void setKurs(int kurs) {
		this.kurs = kurs;
	}
	public int getKurs(){
		return kurs;
	}

	public long berechneWert(int anzahl) {
		return (kurs * anzahl);
	}
 
	public String toString() {	
		return "Name der Aktie: " + getName()+"\n" + "Kaufpreis betraegt: "
				+ getKaufPreis()+"\n" + "Kaufdatum ist: " + getKaufDatum()+"\n"
				+ "Kurs ist: " + this.kurs;

	}
}
