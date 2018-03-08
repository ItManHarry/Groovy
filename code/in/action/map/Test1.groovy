package groovy.in.action.map;
import static org.junit.Assert.*;
import org.junit.Test;

class Test1 {

	@Test
	public void test() {
		def map = [100:'CONTINUE',
			200:'OK',
			400:'BAD REQUEST'];
		println map.size();
		println map[100];
		println map.get(100);
		map[500] = 'INTERNAL SERVER ERROR';
		println map.size();
		println map[500];
	}
	@Test
	public void testInActionMap(){
		def map = [a:1,b:2,c:3,d:4];
		println map.size();
		map.each { k, v ->
			println k;
			println v;
		}
		println "----------------------------------------";
		map.each { 
			println it;
		}
		println "----------------------------------------";
		def tm = new TreeMap();
		tm.putAll(map);
		tm.each { k,v ->
			println k;
			println v;
		}
		assert ['a':1] == [a:1];
		//default value
		def dv = map.get("f", 100);
		println "default value is :\t$dv" ;
		println "----------------------------------------";
		map.put("g",10000);
		println map.g;
		println "Any method:\t"+map.any { e -> e.value > 2};
		println "Every method:\t"+map.every { e ->
			e.key < 'c'
		}
		map.clear();
		println "Map is empty?\t"+map.isEmpty()
	}
}
