package rs.ac.bg.etf.kdp.urosm8;

public class Producer extends Thread {

	BoundedBuffer<Integer> buffer;

	public Producer(String name, BoundedBuffer<Integer> buffer) {
		super(name);
		this.buffer = buffer;
	}

	@Override
	public void run() {
		for (int i = 0; i < 3; ++i) {
			int data = (int) (Math.random() * 100);
			buffer.put(data);
			System.out.println(String.format("%s produced %d. time data: %d", this.getName(), i + 1, data));
			try {
				sleep((int) (Math.random() * 1200));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		System.out.println(this.getName() + " finished");
	}

}
