package rs.ac.bg.etf.kdp.urosm8;

public class Main {
	public static void main(String[] args) {
		int N = 3;
		Producer producers[] = new Producer[N];
		Consumer consumers[] = new Consumer[N];
		BoundedBuffer<Integer> buffer = new BoundedBufferRegionFIFO<Integer>(3);

		for (int i = 0; i < N; ++i) {
			producers[i] = new Producer("Producer_" + i, buffer);
			consumers[i] = new Consumer("Consumer_" + i, buffer);
			producers[i].start();
			consumers[i].start();
		}
	}
}
