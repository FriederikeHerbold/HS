package ws2014.tpe.gruppe_1415349_1410206.uebung2.vermögensverwaltung;

public class Immobilie extends FestverzinslicheVermoegensgegenstaende {

	public Immobilie(String name, long kaufpreis, Date kaufDatum,
			double zinssatz, int laufzeit) {
		super(name, kaufpreis, kaufDatum,1.0, laufzeit);
		setZinssatz();
	}
	
	public void setZinssatz(){
		setZinssatz( getKaufPreis() / getLaufzeit());
	}

	@Override
	public long berechneWert(int restLaufzeit) {
		if(getLaufzeit() ==restLaufzeit){
			return getKaufPreis();
		}else if(getRestlaufzeit() ==0){
		return 0;
		}else{
			return berechneWert(restLaufzeit);
		}
	}

	public String toString() {
		return "Name der Immobilie " + getName() + "\n" + "Kaufpreis betraegt "
				+ getKaufPreis() + "\n" + "Kaufdatum ist " + getKaufDatum()
				+ "\n" + "Zinssatz betraegt " + getZinssatz() + "\n"
				+ "Laufzeit ist " + getLaufzeit();
	}

}
