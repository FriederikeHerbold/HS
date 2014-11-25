package ws2014.tpe.gruppe_1415349_1410206.uebung3.binaer_hash_baum;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class Test {

	public static void main(String[] args) {
		
		Baum baum = new Baum("a", 6);
		baum.put("a", 3);
		baum.put("b", 3);
		
		baum.put("b", 5);
		baum.put("c", 4);
		baum.put("c", 9);
		baum.put("e", 8);
		baum.put("m", 1);
		baum.put("s", 1);
		baum.put("v", 1);
		baum.put("w", 1);
		baum.put("y", 1);
		
		
		System.out.println(baum.remove("s"));
		System.out.println(baum.toString());
		//System.out.println(baum.get("a"));
	/*	
		System.out.println(baum.containsValue(9));
		System.out.println("key " + baum.containsKey("e"));
		System.out.println(baum.get("kjhg"));
		
		System.out.println();
		
		System.out.println(baum.toString());
		
		System.out.println(baum.size());
		
		*/
		Baum liste4 = new Baum("n", 4);
		liste4.put("b", 5);
		liste4.put("bo", 5);
		liste4.put("ac", 5);
		liste4.put("af", 5);
		liste4.put("ad", 5);
		liste4.put("ba", 5);
		//System.out.println(liste4.toString());
		System.out.println(baum.toString());
		System.out.println(liste4.toString());
		baum.putAll(liste4);
		System.out.println(baum.toString());
		
		//liste4.update("b", 8);
		//System.out.println(liste4.get("b"));
		baum.extractAll(liste4);
		System.out.println(baum.toString());
		
		Baum liste = new Baum("a", 5);
		Baum liste2 = new Baum("a", 4);
		Baum liste3 = new Baum("a", 4);
		Baum liste5 = new Baum("a", 4);
		liste.put("c", 7);
		liste5.put("b", 5);
		liste5.put("bo", 5);
		liste5.put("ac", 5);
		liste.extractAll(liste5);
		System.out.println(liste5.toString());
		
		baum.remove("a");
		System.out.println(baum.toString());
		
		
		
		
		BiConsumer<String, String> cons = (a, b) -> {a + 1; b + 1};
		    
		    liste.forEach(cons, "aa", "bb");

		    
		BiFunction<String,String,String > funk = (x, y) -> (x + y);
		
		liste.map(funk, "aa", "bb");
		     

		      
	}
}
