package groovy.basic.demo1;
import static org.junit.Assert.*;
import org.junit.Test;

class DataTypeDemo {

	@Test
	public void test() {
		println "ABCD".indexOf(67);
		assert 1+1 == 1.plus(1);
	}
}
