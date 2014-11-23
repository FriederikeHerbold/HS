package ws2014.tpe.gruppe_1415349_1410206.uebung3.binaer_hash_baum;

public class Test {

	public static void main(String[] args) {
		
		Baum baum = new Baum("a", 2);
		
		baum.put("b", 3);
		baum.put("c", 4);
		
		System.out.println(baum.containsValue(2));
		System.out.println(baum.containsKey("b"));
		System.out.println(baum.get("a"));
		
		System.out.println(baum.toString());
	}

}
