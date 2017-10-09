public class Measurement {

	private int _feet;
	private int _inches;
	private final int INCHES_IN_FOOT = 12;
	/**
	 * Constructor: initialize this object to be a measurement of 0 feet, 0
	 * inches
	 */
	public Measurement() {
		_feet = 0;
		_inches = 0;
	}

	/**
	 * Constructor: takes a number of feet as its single argument, using 0 as
	 * the number of inches
	 */
	public Measurement(int feet) {
        _feet = feet;
        _inches = 0;
	}

	/**
	 * Constructor: takes the number of feet in the measurement and the number
	 * of inches as arguments (in that order), and does the appropriate
	 * initialization
	 */
	public Measurement(int feet, int inches) {
        _feet = feet;
        setModInches(inches);
	}


	/**
	 * Returns the number of feet in in this Measurement. For example, if the
	 * Measurement has 1 foot and 6 inches, this method should return 1.
	 */
	public int getFeet() {
		return _feet;
	}

	/**
	 * Returns the number of inches in this Measurement. For example, if the
	 * Measurement has 1 foot and 6 inches, this method should return 6.
	 */
	public int getInches() {
		return _inches;
	}

	/** Adds the argument m2 to the current measurement */
	public Measurement plus(Measurement m2) {

        int len = _feet*12 + _inches + m2.getFeet()*12 + m2.getInches();
        _feet = 0; // so we do not double count inside setModInches
        setModInches(len);
		return new Measurement(_feet, _inches);
	}

	/**
	 * Subtracts the argument m2 from the current measurement. You may assume
	 * that m2 will always be smaller than the current measurement.
	 */
	public Measurement minus(Measurement m2) {

        int len = _feet*12 + _inches - m2.getFeet()*12 - m2.getInches();
        _feet = 0; // so we do not double count inside setModInches
        setModInches(len);
        return new Measurement(_feet, _inches);
    }

	/**
	 * Takes a nonnegative integer argument n, and returns a new object that
	 * represents the result of multiplying this object's measurement by n. For
	 * example, if this object represents a measurement of 7 inches, multiple
	 * (3) should return an object that represents 1 foot, 9 inches.
	 */
	public Measurement multiple(int multipleAmount) {

	    int len = _feet*INCHES_IN_FOOT + _inches;
	    len = multipleAmount*len;
	    _feet = 0;
        setModInches(len);

		return new Measurement(_feet, _inches);
	}

	/**
	 * toString should return the String representation of this object in the
	 * form f'i" that is, a number of feet followed by a single quote followed
	 * by a number of inches less than 12 followed by a double quote (with no
	 * blanks).
	 */
	@Override
	public String toString() {
		return _feet+"'"+_inches+"\"";
	}

    /**
     * If inches given are bigger then 12
     * add them to foot and remainder keep as inches
     */
    private void setModInches(int inches){
        int tempFeet = 0;
        if (inches >= INCHES_IN_FOOT) {
            tempFeet = inches/INCHES_IN_FOOT;
            inches = inches - tempFeet*INCHES_IN_FOOT;
        }
        _inches = inches;
        _feet += tempFeet;
    }

}
