
// TODO: Auto-generated Javadoc
/**
 * The Class IntegerConverter. This class provides static methods for converting
 * integer, binary and hex strings to specified numeric primitives (int, shor
 */
public class IntegerConvert {
	
	/** The Constant BASE_10. */
	private static final int BASE_10 = 10;
	
	/** The Constant PREFIX_OFFSET. */
	private static final int PREFIX_OFFSET = 2;
	
	/** The Constant NIB_WIDTH. */
	private static final int NIB_WIDTH = 4;	
	
	/** The debug. */
	private static boolean DEBUG = false;
	
	/**
	 * Instantiates a new integer converter. This constructor is not used.
	 */
	public IntegerConvert() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Pre-process the string of integer values, removing underscores and the first +/-
	 *
	 * @param in the in
	 * @return the string
	 */
	private static String preProcessIntegerString(String in) {
		String result = "";
		char[] chars = in.toCharArray();
		int i=0;
		char firstChar=chars[0];
		if ((firstChar == '+' || firstChar == '-')) 
			i++;
		for (; i < chars.length; i++) {		
			if (chars[i] !='_') result += chars[i];
		}
		return result;
	}
	
	/**
	 * Convert an Integer String to an int value. The string will be pre-processed to remove
	 * an initial + or - and all _, and then placed in a char array. Note that if the input string
	 * represents a negative number, then every character will be processed as a negative
	 * value. This make error and overflow detection much easier.
	 *
	 * @param in - the input string..
	 * @return the integer value represented
	 * @throws NumberFormatException the number format exception
	 */
	private static int convertIntegerStringToDec(String in) throws NumberFormatException {
		int value = 0;
		int result;
		if (in.isEmpty())  
			throw new NumberFormatException("No Data detected: "+in);
		char firstChar = in.charAt(0);
		if (firstChar == '_')
			throw new NumberFormatException("Incorrect Number Format: "+in);
		boolean isNegative = (in.charAt(0) == '-');
		
		char[] chars = preProcessIntegerString(in).toCharArray();
		
		if (chars.length == 0)
			throw new NumberFormatException("No Data detected: "+in);
				
		for (int i = 0; i < chars.length; i++) {
			char aChar = chars[i];
			if ((aChar>='0') && (aChar<='9')) {
				int digitVal = aChar-'0';
				result = BASE_10*value + ((isNegative)?-1*digitVal:digitVal);
				if ((result/BASE_10) != value)    
					throw new NumberFormatException("Value overflowed integer range: "+in);
				value = result;
			} else {
				throw new NumberFormatException("Incorrect Number Format: "+in);
			}
		}	
		return value;
	}

	/**
	 * Convert string to int.
	 *
	 * @param in the String to convert
	 * @return the converted value of the string represented as an int
	 * @throws NumberFormatException the number format exception
	 */
	public static int parseInt(String in) throws NumberFormatException {
		int value = convertIntegerStringToDec(in);	
		return value;
	}

	/**
	 * Convert string to byte.
	 *
	 * @param in the String to convert
	 * @return the converted value of the string represented as a byte
	 * @throws NumberFormatException the number format exception
	 */
	public static byte parseByte(String in) throws NumberFormatException {
		int value = convertIntegerStringToDec(in);
		// check value vs range here
		if (value > Byte.MAX_VALUE  || value < Byte.MIN_VALUE)
			throw new NumberFormatException("Value outside legal range: "+in);
		return ((byte) value);
	}
	
	/**
	 * Convert a Binary String to an int value. This method performs all error checking.
	 * Note that the prefix is check and removed and the rest of the data is 
	 * placed in a char[]. Underscores are ignored, and invalid characters are handled by the 
	 * for loop. Overflow is detected at the end of the loop
	 *
	 * @param in - the binary string input..
	 * @param numBits - the maximum number of bits to process
	 * @return the integer value represented
	 * @throws NumberFormatException the number format exception
	 */
	private static int convertBinaryStringToDec(String in,String prefix, int numBits) throws NumberFormatException {
		int prefixLength = prefix.length();
		int length = in.length();
		if ((length <= prefixLength) || !prefix.equals(in.substring(0,prefixLength)))  
			throw new NumberFormatException("Incorrect Prefix or No Data detected: "+in);
		
		char[] chars = in.substring(PREFIX_OFFSET).toCharArray();
		
		int value = 0;
		int pow = 0;
		for (int i = chars.length-1; i>=0; i--) {
			char aChar = chars[i];
			if ((aChar>='0') && (aChar<='1')) {
				value += (aChar-'0')* (int) Math.pow(2,pow);
				if (DEBUG) System.out.print("\ni="+i+"   aChar="+aChar+"   pow="+pow+"   value="+value);
				pow++;
			} else if (aChar != '_') 
				throw new NumberFormatException("Incorrect Number Format: "+in);
		}
		if (pow > numBits) 
			throw new NumberFormatException("Incorrect Number Format: "+in);
		return value;
	}


	/**
	 * Parses a binary string and returns the equivalent integer value (signed).
	 *
	 * @param in   the input binary string. Should have a leading "0b"
	 * @return  the integer value of the converted string
	 * @throws NumberFormatException the number format exception
	 */
	public static int parseBinStrToInt(String in) throws NumberFormatException {
		return(convertBinaryStringToDec(in, "0b",Integer.SIZE));
	}
	
	/**
	 * Parses an unsigned binary string and returns the equivalent byte value (signed) .
	 *
	 * @param in  the input binary string. Should have a leading "0b"
	 * @return the byte value of the converted string
	 * @throws NumberFormatException the number format exception
	 */
	public static byte parseBinStrToByte(String in) throws NumberFormatException {
		return ((byte) convertBinaryStringToDec(in, "0b",Byte.SIZE));
	}
	
	/**
	 * Convert a Hex String to an int value. Algorithm is the same as convertBinaryStringToDec
	 * except that it handles a nibble (4 bits at a time). 
	 *
	 * @param in - the hex string input..
	 * @param numBits - the maximum number of bits to process
	 * @return the integer value represented
	 * @throws NumberFormatException the number format exception
	 */
	private static int convertHexStringToDec(String in,String prefix, int numBits) throws NumberFormatException {
		int prefixLength = prefix.length();
		int length = in.length();
		if ((length <= prefixLength) || prefix.equals(in.substring(0,prefixLength)))  
			throw new NumberFormatException("Incorrect Prefix or No Data detected: "+in);
		
		char[] chars = in.substring(PREFIX_OFFSET).toCharArray();
		
		int value = 0;
		int count = 0;
		for (char aChar : chars) {
			if ((aChar>='0') && (aChar<='9')) {
				value = aChar - '0' + (value << NIB_WIDTH);
				count += NIB_WIDTH;
			} else if ((aChar>='a') && (aChar<='f')) {
				value = aChar - 'a' + BASE_10 + (value << NIB_WIDTH);
				count += NIB_WIDTH;				
			} else if (aChar != '_') 
				throw new NumberFormatException("Incorrect Number Format: "+in);
		}
		if (count > numBits) 
			throw new NumberFormatException("Incorrect Number Format: "+in);
		return value;
	}


	/**
	 * Parses an unsigned hex string and returns the equivalent integer value (signed).
	 *
	 * @param in   the input hex string. Should have a leading "0b"
	 * @return  the integer value of the converted string
	 * @throws NumberFormatException the number format exception
	 */
	public static int parseHexStrToInt(String in) throws NumberFormatException {
		return(convertHexStringToDec(in, "0x",Integer.SIZE));
	}
	
	/**
	 * Parses an unsigned binary string and returns the equivalent byte value (signed) .
	 *
	 * @param in  the input binary string. Should have a leading "0b"
	 * @return the byte value of the converted string
	 * @throws NumberFormatException the number format exception
	 */
	public static byte parseHexStrToByte(String in) throws NumberFormatException {
		return ((byte) convertHexStringToDec(in, "0x",Byte.SIZE));
	}
	
	/**
	 * Convert to binary str.
	 *
	 * @param in the in
	 * @param numBits the num bits
	 * @return the string
	 */
	private static String convertToBinaryStr(int in, int numBits) {
		int mask = 0x1 << (numBits -1);
		char[] chars = new char[numBits];
		for (int i=0; i < numBits; i++) {
			chars[i] = ((mask & in) != 0)  ? '1' : '0';
			mask = mask >>> 1;
		}
		return(new String(chars));	
	}

	/**
	 * Returns the equivalent unsigned binary string (32 bits).
	 *
	 * @param in the integer to convert
	 * @return the equivalent binary string representaton (32 bits)
	 */
	public static String intToBinaryString(int in) {
		return(convertToBinaryStr(in,Integer.SIZE));
	}
	
	/**
	 * Returns the equivalent unsigned binary string (8 bits).
	 *
	 * @param in the byte to convert
	 * @return the equivalent binary string representaton (8 bits)
	 */
	public static String byteToBinaryString(byte in) {
		return(convertToBinaryStr(in,Byte.SIZE));
	}
	
	/**
	 * Convert to hex str.
	 *
	 * @param in the in
	 * @param numHex the num hex
	 * @return the string
	 */
	private static String convertToHexStr(int in, int numBits) {
		int numHex = numBits/NIB_WIDTH;
		int shift = (numHex-1)*NIB_WIDTH;
		int mask = 0xF << shift;

		char[] chars = new char[numHex];
		for (int i=0; i < numHex; i++) {
			int nibVal = (in & mask) >>> shift;
			chars[i] = (char) ((nibVal < BASE_10) ?  nibVal + '0' : (nibVal-BASE_10)+'a');
			mask = mask >>> NIB_WIDTH;
			shift -= NIB_WIDTH;
		}
		return(new String(chars));	
	}

	/**
	 * Returns the equivalent unsigned hex string (8 hex chars).
	 *
	 * @param in the integer to convert
	 * @return the equivalent hex string representation (8 hex chars)
	 */
	public static String intToHexString(int in) {
		return(convertToHexStr(in,Integer.SIZE));
	}
	
	/**
	 * Returns the equivalent unsigned hex string (2 hex chars).
	 *
	 * @param in the integer to convert
	 * @return the equivalent hex string representaton (2 hex chars)
	 */
	public static String byteToHexString(byte in) {
		return(convertToHexStr(in,Byte.SIZE));
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// You should write basic testing of each of your methods here.
		// I will provide a more comprehensive testing using JUnit later.
		System.out.println("Int conversion of 128 = "+parseInt("1_2_8"));
//		System.out.println("Short conversion of 128 = "+parseShort("128"));
		System.out.println("Byte conversion of 128 = "+parseByte("1_27"));
		System.out.println("Int conversion of 32768 = "+parseInt("32_76_8"));
//		System.out.println("Short conversion of 32768 = "+parseShort("32767"));
		System.out.println("Byte conversion of 32768 = "+parseByte("-128"));
		System.out.println("Binary conversion of 0b1011 = "+parseBinStrToInt("0b1011"));
		System.out.println("Binary conversion of 0b1011 = "+parseBinStrToByte("0b1011"));
		System.out.println("Binary conversion of 0b0110_0100 = "+parseBinStrToInt("0b0110_0100"));
		System.out.println("Binary conversion of 0b0110_0100 = "+parseBinStrToByte("0b0110_0100"));

		System.out.println("Testing byte to binary:  170 = "+byteToBinaryString((byte) 170));
		System.out.println("Testing int to binary:   170 = "+intToBinaryString(170));
		System.out.println("Testing byte to Hex:     170 = "+byteToHexString((byte) 170));
		System.out.println("Testing int to Hex:      170 = "+intToHexString(170));
		
	}

}
