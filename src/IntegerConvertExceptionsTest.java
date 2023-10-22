import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigInteger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

// TODO: Auto-generated Javadoc
/**
 * The Class IntegerConvertPart1Test.
 */
@TestMethodOrder(OrderAnnotation.class)
class IntegerConvertExceptionsTest {


	/**
	 * Sets the up before class.
	 *
	 * @throws Exception the exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Tear down after class.
	 *
	 * @throws Exception the exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}


	/**
	 * Tests exceptions for parseByte.
	 */
	@Test
	@Order(1)
	void test_parseByteExceptions() {
		System.out.println("\nparseByte Exception Test:");
		System.out.print("   Testing No Data checks: ");
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseByte("+");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseByte("-");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseByte("_");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseByte("");});
		System.out.println("PASSED");
		System.out.print("   Testing Bad Character checks: ");
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseByte("++");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseByte("+-");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseByte("--");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseByte("-+");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseByte("+_");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseByte("-_");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseByte("+a");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseByte("-a");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseByte("_a");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseByte("a");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseByte("+1c2");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseByte("-2z3");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseByte("_4");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseByte("_42q");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseByte("57a9");});
		System.out.println("PASSED");
		System.out.print("   Testing Bounds: ");
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseByte("128");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseByte("-129");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseByte("127g");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseByte("-128x");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseByte("256");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseByte("2147483647");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseByte("-2147483648");});
		System.out.println("PASSED");

	}
	
	/**
	 * Tests exceptions for parseInt.
	 */
	@Test
	@Order(2)
	void test_parseIntExceptions() {
		System.out.println("\nparseInt Exception Test:");
		System.out.print("   Testing No Data checks: ");
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseInt("+");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseInt("-");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseInt("_");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseInt("");});
		System.out.println("PASSED");
		System.out.print("   Testing Bad Character checks: ");
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseInt("++");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseInt("+-");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseInt("--");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseInt("-+");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseInt("+_");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseInt("-_");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseInt("+a");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseInt("-b");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseInt("_z");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseInt("y");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseInt("+1c2");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseInt("-2z3");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseInt("_4");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseInt("_42q");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseInt("57a9");});
		System.out.println("PASSED");
		System.out.print("   Testing Bounds: ");
		BigInteger value = new BigInteger(Long.toString(Long.MAX_VALUE));
		System.out.println("Value= "+value.toString());
		BigInteger value2 = value.add(value);
		System.out.println("Value2= "+value2.toString());
		BigInteger sum = value2.add(new BigInteger("2"));
		System.out.println("Value + value2= "+sum.toString());
		
		
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseInt("2147483648");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseInt("-2147483649");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseInt("2147483637g");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseInt("-2147383648x");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseInt("5000000001");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseInt("3000000001");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseInt("6500000020");});
		System.out.println("testing with BigInteger "+sum.toString());
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseInt(sum.toString());});
		System.out.println("PASSED");

	}
		
	/**
	 * Tests exceptions for parseBinStrToByte.
	 */
	@Test
	@Order(3)
	void test_parseBinStrToByteExceptions() {
		System.out.println("\nparseBinStrToByte Exception Test:");
		System.out.print("   Testing No Data checks: ");
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToByte("");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToByte("0b");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToByte("0x");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToByte("0");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToByte("b");});
		System.out.println("PASSED");
		System.out.print("   Testing Bad Character checks: ");
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToByte("0b2");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToByte("0b3");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToByte("Ob10");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToByte("0b127");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToByte("0b9");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToByte("0b8");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToByte("0b7");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToByte("0b6");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToByte("0b5");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToByte("0b4");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToByte("0b101b");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToByte("0b101c");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToByte("0b0110z10");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToByte("0b001_1_2");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToByte("0b10111z");});
		System.out.println("PASSED");
		System.out.print("   Testing Bounds: ");
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToByte("0b000000000");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToByte("0b000000001");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToByte("0b101011010");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToByte("0b111111110");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToByte("0b010101010");});
		System.out.println("PASSED");

	}
	
	@Test
	@Order(4)
	/**
	 * Tests exceptions for parseBinStrToInt.
	 */
	void test_parseBinStrToIntExceptions() {
		System.out.println("\nparseBinStrToInt Exception Test:");
		System.out.print("   Testing No Data checks: ");
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToInt("");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToInt("0b");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToInt("0x");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToInt("0");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToInt("b");});
		System.out.println("PASSED");
		System.out.print("   Testing Bad Character checks: ");
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToInt("0b2");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToInt("0b3");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToInt("Ob10");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToInt("0b127");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToInt("0b9");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToInt("0b8");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToInt("0b7");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToInt("0b6");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToInt("0b5");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToInt("0b4");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToInt("0b101b");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToInt("0b101c");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToInt("0b0110z10");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToInt("0b001_1_2");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToInt("0b10111z");});
		System.out.println("PASSED");
		System.out.print("   Testing Bounds: ");
		String bigData = "0b0_0000_0000_0000_0000_0000_0000_0000_0000";
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToInt(bigData);});
		String bigData1 = "0b0_0000_0000_0000_0000_0000_0000_0000_0001";
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToInt(bigData1);});
		String bigData2 = "0b0_1001_1010_1011_1111_0011_0010_0101_1110";
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToInt(bigData2);});
		String bigData3 = "0b1_1111_1111_1111_1111_1111_1111_1111_1110";
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseBinStrToInt(bigData3);});
		System.out.println("PASSED");

	}
	

	/**
	 * Tests exceptions for parseHexStrToByte.
	 */
	@Test
	@Order(5)
	@Disabled
	void test_parseHexStrToByteExceptions() {
		System.out.println("\nparseHexStrToByte Exception Test:");
		System.out.print("   Testing No Data checks: ");
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToByte("");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToByte("0b");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToByte("0x");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToByte("0");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToByte("x");});
		System.out.println("PASSED");
		System.out.print("   Testing Bad Character checks: ");
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToByte("0b2");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToByte("0b3");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToByte("Ob10");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToByte("0xpz");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToByte("0x9x");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToByte("0xx8");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToByte("0x7g");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToByte("0xq3");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToByte("0x56h");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToByte("0x-4");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToByte("0x+3");});
		System.out.println("PASSED");
		System.out.print("   Testing Bounds: ");
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToByte("0x000");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToByte("0x001");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToByte("0xdc9");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToByte("0x___111");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToByte("0x600d");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToByte("0xaced");});
		System.out.println("PASSED");

	}

	/**
	 * Tests exceptions for parseHexStrToInt.
	 */
	@Test
	@Order(6)
	@Disabled
	void test_parseHexStrToIntExceptions() {
		System.out.println("\nparseHexStrToInt Exception Test:");
		System.out.print("   Testing No Data checks: ");
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToInt("");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToInt("0b");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToInt("0x");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToInt("0");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToInt("b");});
		System.out.println("PASSED");
		System.out.print("   Testing Bad Character checks: ");
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToInt("0b2");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToInt("0b3");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToInt("Ob10");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToInt("0xpz");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToInt("0x9x");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToInt("0xx8");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToInt("0x7g");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToInt("0xq3");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToInt("0x56h");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToInt("0x-4");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToInt("0x+3");});
		System.out.println("PASSED");
		System.out.print("   Testing Bounds: ");
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToByte("0x000000000");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToByte("0x000000001");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToByte("0x1fedc980a");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToByte("0x___111111111");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToByte("0x600dbeefa");});
		assertThrows(NumberFormatException.class, () -> {IntegerConvert.parseHexStrToByte("0xaced_acedf");});
		System.out.println("PASSED");

	}
	

}
