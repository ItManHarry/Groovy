package groovy.in.action.gstrings;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 * Groovy Gstrings
 * @author 20112004
 *
 */
class GstringsTest {

	@Test
	public void test() {
		def name = "Harry";
		println "I am $name";
		if('xxxxds33' =~ /\d+/){
			println "All Numbers.";
		}else{
			println "Not all numbers.";
		}
	}
}
