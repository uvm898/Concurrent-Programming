package rs.ac.bg.etf.kdp.urosm8;

public class Consumer extends Thread {

	BoundedBuffer<Integer> buffer;

	public Consumer(String name, BoundedBuffer<Integer> buffer) {
		super(name);
		this.buffer = buffer;
	}

	@Override
	public void run() {
		for (int i = 0; i < 3; ++i) {
			int data = buffer.get();
			System.out.println(String.format("%s consumed %d. time data: %d", this.getName(), i + 1, data));
			try {
				sleep((int) (Math.random() * 1200));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}

		System.out.println(this.getName() + " finished");
	}

}
