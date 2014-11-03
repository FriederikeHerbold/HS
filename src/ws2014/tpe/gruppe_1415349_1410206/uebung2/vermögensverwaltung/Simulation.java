package ws2014.tpe.gruppe_1415349_1410206.uebung2.vermögensverwaltung;

public class Simulation {

	public static void main(String[] args) {
		Date datum = new Date(1, 10, 2014);
		
		//Aktien(name, kaufPreis, kaufDatum, kurs)
		Aktie muenchnerRueck = new Aktie("Muenchner Rueck", 100, datum, 2);
		Aktie basf = new Aktie("BASF", 120, datum, 3);
		Aktie man = new Aktie("MAN", 130, datum, 4);
		Aktie siemens = new Aktie("Siemens", 140, datum, 2);
		Aktie daimler = new Aktie("Daimler", 150, datum, 5);
		Aktie bmw = new Aktie("BMW", 160, datum, 2);
		Aktie volkswagen = new Aktie("Volkswagen", 107, datum, 2);

		//Fonds
		Aktienfonds indexfond = new Aktienfonds("Indexfond",50000, datum,
				muenchnerRueck, 1,basf, 1,man,1,siemens,1,daimler,1,bmw,1,
				volkswagen,1);
		Aktienfonds autofond = new Aktienfonds("Autofond" ,95000, datum,daimler,
				4, bmw, 3,volkswagen,5);
	
		//Festgeld
		Rentenpapier bundesschatzbrief = new Rentenpapier("Bundesschatzbrief",
				100,datum, 1.5, 10, 2);
		Festgeld sparkasseMannheim = new Festgeld("Sparkasse Mannheim", 100,
			datum, 2.0, 3);
	
		public void kaufTag(){
			muenchnerRueck.setKurs(11110);
			basf.setKurs(6127);
			man.setKurs(8824);
			siemens.setKurs(9678);
			daimler.setKurs(4993);
			bmw.setKurs(5867);
			volkswagen.setKurs(11550);
		}

		public void naechstesJahr(){
			muenchnerRueck.setKurs(12030);
			basf.setKurs(6127);
			man.setKurs(8824);
			siemens.setKurs(9678);
			daimler.setKurs(4993);
			bmw.setKurs(5867);
			volkswagen.setKurs(11550);
		}
		public static int hallo(){
		return 0;
		}

	}
}
