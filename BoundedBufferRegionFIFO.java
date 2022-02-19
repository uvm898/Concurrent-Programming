package rs.ac.bg.etf.kdp.urosm8;

public class BoundedBufferRegionFIFO<T> implements BoundedBuffer<T> {

	private int counter;
	private int head, tail;
	private T buffer[];
	private simpleCLH consumers;
	private simpleCLH producers;

	@SuppressWarnings("unchecked")
	public BoundedBufferRegionFIFO(int size) {
		this.buffer = (T[]) new Object[size];
		this.consumers = new simpleCLH();
		this.producers = new simpleCLH();
	}

	@Override
	public void put(T data) {
		synchronized (buffer) {
			this.producers.put(Thread.currentThread());
			while (counter == buffer.length || this.producers.firstThread() != Thread.currentThread())
				try {
					buffer.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			this.producers.remove();
			buffer[tail] = data;
			tail = (tail + 1) % buffer.length;
			counter++;
			buffer.notifyAll();
		}
	}

	@Override
	public T get() {
		T data = null;
		synchronized (buffer) {
			this.consumers.put(Thread.currentThread());
			while (counter == 0 || this.consumers.firstThread() != Thread.currentThread())
				try {
					buffer.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			this.consumers.remove();
			data = buffer[head];
			head = (head + 1) % buffer.length;
			counter--;
			buffer.notifyAll();
		}
		return data;
	}

}
