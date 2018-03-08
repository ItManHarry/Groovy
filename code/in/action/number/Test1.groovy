package groovy.in.action.number;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 * Groovy number
 * @author 20112004
 *
 */
class Test1 {

	@Test
	public void test() {
		int x = 2;
		println x.toString();
		def y = 3;
		println y*3;
		println x + y;
		println x.plus(y);
		
	}
	@Test
	public void testMethods(){
		def str = '';
		10.times { 
			str += 'X';
		}		
		println "Str now is :\t$str";
		println "----------------------------------------";
		def list = ["A","B","C"];
		list.size().times { i ->
			println i;
			println list[i];
		}
		println "----------------------------------------";
		list.each { i->
			println i;
		}
		println "----------------------------------------";
		str = '';
		1.upto(10) { n ->
			str += n;			
		}
		println "Now Str is:\t$str";
		println "----------------------------------------";
		str = '';
		2.downto(-2) { n->
			str += n+'  ';
		}
		println "Now The Str is:\t$str";
		println "----------------------------------------";
		str = '';
		0.step(0.5, 0.1) { n->
			str += n +  '   ';
		}
		println "Now The Str is:\t$str";
	}
}
