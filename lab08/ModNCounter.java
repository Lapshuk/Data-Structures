public class ModNCounter {

	private int myCount, mod;

	public ModNCounter(int n) {
		myCount = 0;
		mod = n;
	}

	public void increment() {
		myCount++;
		if(myCount == mod){
			myCount = 0;
		}
	}

	public void reset() {
		myCount = 0;
	}

	public int value() {
		return myCount;
	}

}
