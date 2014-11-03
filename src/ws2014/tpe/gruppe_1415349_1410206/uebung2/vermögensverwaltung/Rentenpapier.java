package ws2014.tpe.gruppe_1415349_1410206.uebung2.vermögensverwaltung;

public class Rentenpapier extends FestverzinslicheVermoegensgegenstaende {

	private int kurs;

	public Rentenpapier(String name, long kaufpreis, Date kaufDatum,
			double zinssatz, int laufzeit, int kurs) {
		super(name, kaufpreis, kaufDatum, zinssatz, laufzeit);
		setKurs(kurs);
	}

	public void setKurs(int kurs) {
		this.kurs = kurs;
	}

	public long berechneWert(int anzahl) {
		if (getRestlaufzeit() != 0) {
			return anzahl * kurs;
		}else{
			return getEndWert();
		}
	}

	public String toString() {
		return "Name des Rentenpapiers " + getName() + "\n"
				+ "Kaufpreis betraegt " + getKaufPreis() + "\n"
				+ "Kaufdatum ist " + getKaufDatum() + "\n"
				+ "Zinssatz betraegt " + getZinssatz() + "\n" + "Laufzeit ist "
				+ getLaufzeit() + "\n" + "Kurs ist " + this.kurs;

	}

}
