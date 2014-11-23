package ws2014.tpe.gruppe_1415349_1410206.uebung3.binaer_hash_baum;

import static org.junit.Assert.*;

import org.junit.Test;

public class BaumTest {

	Baum liste = new Baum("a", 4);
	Baum liste2 = new Baum("a", 4);
	Baum liste3 = new Baum("a", 4);
	Baum liste4 = new Baum("a", 4);

	@Test
	public void putSizeTest() {
		assertEquals(1, liste.size());
		liste.put("ab", 3);
		liste.put("d", 3);
		liste.put("ei", 3);
		liste.put("de", 3);
		liste.put("hu", 3);
		liste.put("kjhg", 3);
		liste.put("hzu", 3);
		liste.put("aum", 3);
		liste.put("dzd", 3);
		assertEquals(10, liste.size());

		liste2.put("ab", 3);
		assertEquals(2, liste2.size());
		liste2.put("ab", 3);
		assertEquals(2, liste2.size());
	}

	@Test
	public void clearTest() {
		liste3.clear();
		assertEquals(0, liste3.size());
	}

	@Test
	public void containsValueTest() {
		liste.put("ab", 3);
		liste.put("d", 3);
		liste.put("ei", 3);
		liste.put("de", 3);
		liste.put("hu", 3);
		liste.put("kjhg", 3);
		liste.put("hzu", 3);
		liste.put("aum", 3);
		liste.put("dzd", 3);
		assertEquals(true, liste.containsValue(3));
		assertEquals(false, liste.containsValue(5));
	}

	@Test
	public void continsKeyTest() {
		liste.put("ab", 3);
		liste.put("d", 3);
		liste.put("ei", 3);
		liste.put("de", 3);
		liste.put("hu", 3);
		liste.put("kjhg", 3);
		liste.put("hzu", 3);
		liste.put("aum", 3);
		liste.put("dzd", 3);
		assertEquals(true, liste.containsKey("dzd"));
		assertEquals(false, liste.containsKey("AB"));
	}

	@Test
	public void getTest() {
		liste.put("ab", 3);
		liste.put("d", 3);
		liste.put("ei", 3);
		liste.put("de", 3);
		liste.put("hu", 3);
		liste.put("kjhg", 3);
		liste.put("hzu", 3);
		liste.put("aum", 3);
		liste.put("dzd", 3);
		assertEquals(4, liste.get("a"));
		assertEquals(3, liste.get("ei"));
	}

	@Test
	public void isEmptyTest() {
		assertEquals(false, liste.isEmpty());
		assertEquals(false, liste3.isEmpty());
	}

	@Test
	public void putAllTest() {
		liste.put("ab", 3);
		liste.put("d", 3);
		liste.put("ei", 3);
		liste.put("de", 3);
		liste4.put("af", 5);
		liste4.put("ad", 5);
		liste4.put("ba", 5);
		liste.putAll(liste4);
		assertEquals("{a=4, d=3, ab=3, ad=5, af=5, ba=5, de=3, ei=3}",
				liste.toString());
	}
	
	@Test
	public void removeTest() {
		liste.put("ab", 3);
		liste.put("d", 3);
		liste.put("ei", 3);
		liste.put("de", 3);
		liste.put("af", 5);
		liste.put("ad", 5);
		liste.put("ba", 5);
		liste.remove("a"); //Wurzelknoten entfernen
		assertEquals("{d=3, ab=3, ad=5, af=5, ba=5, de=3, ei=3}",
				liste.toString());
		
		liste.remove("ad");
		assertEquals("{d=3, ab=3, af=5, ba=5, de=3, ei=3}",
				liste.toString());
		
	}

	@Test
	public void updateTest() {
		assertEquals(4, liste.get("a"));
		liste.update("a", 8);
		assertEquals(8, liste.get("a"));
	}

	@Test
	public void forEachTest() {
	}

	@Test
	public void extractAllTest() {
		liste4.put("b", 5);
		liste4.put("bo", 5);
		liste4.put("ac", 5);
		liste.extractAll(liste4);
		assertEquals("{a=4, b=5, ac=5, bo=5}", liste4.toString());

	}

	@Test
	public void mapTest() {
	}

	@Test
	public void toStringTest() {
		liste4.put("b", 5);
		liste4.put("bo", 5);
		liste4.put("ac", 5);
		liste4.put("af", 5);
		liste4.put("ad", 5);
		liste4.put("ba", 5);

		assertEquals("{a=4, b=5, ac=5, ad=5, af=5, ba=5, bo=5}",
				liste4.toString());
	}
}