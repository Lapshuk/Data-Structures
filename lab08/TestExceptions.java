public class TestExceptions {

	public static void main (String [ ] args) {
		ModNCounter c = null;

		try {
			c.reset();

		} catch (NullPointerException e) {
			System.out.println ("got null pointer");
		}
		try {
			Object[] arr = new Double[10];
			arr[0] = new String("Boom");

		} catch (ArrayStoreException e) {
			System.out.println ("got illegal array store");
		}
		try {
			Object a = new Account(100);
			Object b = (ModNCounter) a;

		} catch (ClassCastException e) {
			System.out.println ("got illegal class cast");
		}
	}

}
