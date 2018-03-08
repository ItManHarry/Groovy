package groovy.in.action.part1;
import static org.junit.Assert.*;
import groovy.in.action.classes.Greeter
import groovy.in.action.classes.Money;

import org.junit.Test;
/**
 * assertion
 * @author 20112004
 *
 */
class Test1 {

	@Test
	public void test() {
		assert(true);
		assert 1 == 1;
		def x = 1;
		assert x == 1;
		def y = 2;
		assert y > x;
		Book b = new Book("Groovy in action");
		println b.getTitle();
		println b.getTitle().reverse();
		def bb ;
		if(bb){
			println "The bb is not null.";
		}else{
			println "The bb is null, now initial it.";
			bb = new groovy.in.action.beans.Book();
		}
		bb.setAuthor("Harry");
		bb.setTitle("Groovy in action");
		bb.setPrice(98.5);
		println "The author is:\t"+bb.getAuthor();
		println "The title is :\t"+bb.getTitle();
		println "The price is :\t"+bb.getPrice();
		println System.getProperty("os.version");
		new Greeter('harry').salute();
		Money m1 = new Money(100, "RMB");
		println "Money amount:\t"+m1.amount;
		println "Money currency:\t"+m1.currency;
		Money m2 = new Money(100, "RMB");
		println m1.equals(bb);
		Money m3 = m1.plus(m2);
		println "Money amount:\t"+m3.amount;
		println "Money currency:\t"+m3.currency;
		Money m4 = m3 + 500;
		println "Money amount:\t"+m4.amount;
		println "Money currency:\t"+m4.currency;
	}
}
