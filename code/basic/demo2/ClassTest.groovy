package groovy.basic.demo2;
import static org.junit.Assert.*;
import org.junit.Test;

class ClassTest {

	@Test
	public void test() {
		Money m1 = new Money(1000, "50%");
		Money m2 = new Money(1000, "50%");
		assert m1.equals(m2);
		println m1.hashCode();
		println m2.hashCode();
		Money m3 = m1.plus(m2);
		println "Amount:\t" + m3.amount;
		println "Currency\t" + m3.currency;
	}
}
