package rs.ac.bg.etf.kdp.urosm8;

public interface BoundedBuffer<T> {

	public void put(T data);

	public T get();
}
