package groovy.in.action.ranges;

import static org.junit.Assert.*;

import org.junit.Test;

class Test1 {

	@Test
	public void test() {
		def rg = 1..10;
		println rg.contains(5);
		println rg.size();
		println rg.from;
		println rg.to;
		println rg.reverse();
	}
	@Test
	public void testRange(){
		def range = 0..10;
		assert range.contains(0);
		assert range.contains(10);
		assert range.contains(5);
		
		println range.contains(-1);
		println range.contains(11);
		
		def r = 0..<10;
		println r.contains(10);
		println r.contains(9);
		println r instanceof Range;
		def sr = 0.0..1.0;
		println "===================================";
		sr.each { e ->
			println e;
		}
		println sr.contains(0.5)
		println "===================================";
		println  (0..10).isCase(5);
		def age = 32;
		switch(age){
			case 1..15:
				println "B";
				break;
			case 16..20:
				println "S";
				break;
			case 21..30:
				println "L";
				break;
			case 31..40:
				println "XL";
				break;
			case 41..80:
				println "O";
				break;
			default:
				println "VO";
				break;
		}
		println "===================================";
		def list = [20,36,42,48,33,56,65,67,78];
		def gp = 20..50;
		list.grep(gp).each { e->
			println e;
		}
	}
}
