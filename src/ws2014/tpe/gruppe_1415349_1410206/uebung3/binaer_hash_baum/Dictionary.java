package ws2014.tpe.gruppe_1415349_1410206.uebung3.binaer_hash_baum;

public class Dictionary extends Baum<String, String> {
	
	public Dictionary(String schluessel, String wert){
		super(schluessel,wert);
	}

	public String[] keys() {
		String[] keys = new String[size()];
		Knoten[] knoten= liste();
		for (int index=0;index<keys.length;index++){
			keys[index]= (String)knoten[index].getSchluessel();
		}
		return keys;
		
	}
	
	
	public String[] values() {
		String[] values = new String[size()];
		Knoten[] knoten= liste();
		for (int index=0;index<values.length;index++){
			values[index]= (String)knoten[index].getWert();
			
		}
		return values;
	}

}
