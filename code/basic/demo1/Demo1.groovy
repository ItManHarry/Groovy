package groovy.basic.demo1;

import static org.junit.Assert.*;

import org.junit.Test;

class Demo1 {

	@Test
	public void test() {
		def list = [1,2,3,4,5,6,7,8,9,10];
		list.add(10);
		list.each { i ->
			println "\tElement:\t"+i;
		}
		def map = [100:'requesting',200:'ok',300:'service normal',400:'not found'];
		map.put(700, "unknown");
		println "------------------------------------------------------------";
		println map.size() + "\t" + map[700];
		println "------------------------------------------------------------";
		def range = 1..10;
		println range.size();
		range.each{
			i ->
			println "Element:\t" + i;
		}
		println "------------------------------------------------------------";
		if(null)
			println "null";
		else
			println "not null";
	}
}
