package ws2014.tpe.gruppe_1415349_1410206.uebung3.binaer_hash_baum;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public interface AssoziativesArray<B, T> {

	public void clear();

	public boolean containsValue(T wert);

	public boolean containsKey(B schluessel);

	public T get(B schluessel);

	public boolean isEmpty();

	public void put(B schluessel, T wert);

	public void putAll(Baum knoten);

	public T remove(B schluessel);

	public int size();

	public void update(B schluessel, T wert);

	public void forEach(BiConsumer bi, B wertA, T wertB);

	public void extractAll(Baum<?, ?> baum);

	public Baum map(BiFunction funk, B wertA, T wertB);
}
