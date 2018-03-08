package groovy.basic.map;
import static org.junit.Assert.*;
import org.junit.Test;

class MapTest1 {

	@Test
	public void test() {
		def map = [a:1,b:2,c:3];
		assert map instanceof HashMap;
		println map.size();
		println map.a;
		println map["a"];
		//empty map
		def emap = [:];
		println emap.size();
		def tmap = new TreeMap();
		tmap.putAll(map);
		println tmap.size();
		println tmap.get("a");
		println tmap.get("d",10);
		tmap.d = 3;
		println tmap.d;
		tmap["d"] = 5;
		println tmap["d"];
 	}
	@Test
	public void test2(){
		def myMap = [a:1, b:2, c:3];
		def other = [b:2, c:3, a:1];
		println "myMap == other:\t" + (myMap == other);
		assert myMap == other;
		println "myMap is not empty:\t" + myMap.isEmpty();
		assert myMap.isEmpty() == false;
		println "myMap size:\t" + myMap.size();
		assert myMap.size() == 3;
		println "myMap contains key a:\t" + myMap.containsKey("a");
		println "myMap contains value 2:\t" + myMap.containsValue(2);
		myMap.keySet().each { k ->
			println k;
		}
		println "------------------------------------";
		myMap.values().each { v ->
			println v;
		}
		println "------------------------------------";
		myMap.each { e ->
			println e.key;
			println e.value;
		}
		assert toSet(myMap.values()) == toSet([1,2,3]);
		println "------------------------------------";
		def m = [:];
		if(m.size() != 0)
			m.each { e->
				println e.key;
				println e.value;
			}
		else
			println "Map is empty";
		println "------------------------------------";
		assert myMap.any { e ->
			e.value > 2;
		}
		assert myMap.every{e ->
			e.key < 'd'
		}
		println "------------------------------------";
		def store = "";
		myMap.each { e ->
			store += e.key;
			store += e.value;
		}
		println store;
		println "------------------------------------";
		def s = "";
		myMap.each { k, v ->
			s += k;
			s += v;
		}
		println s;
	}
	@Test
	public void test3(){
		def map = [a:1,b:2,c:3];
		map.clear();
		println "map is empty:\t" + map.isEmpty();
		map = [a:1,b:2,c:3];
		map.remove("a");
		println "------------------------------------";
		map.each { k, v->
			println k;
			println v;
		}
		println "------------------------------------";
		def sm1 = map.findAll{ e ->
			e.value < 3;
		}
		sm1.each { e ->
			println e.key;
			println e.value;
		}
		println "------------------------------------";
		def sm2 = map.find{ e ->
			e.value = 3;	
		}
		println sm2.key;
		println sm2.value;
	}
	def toSet(list){
		new java.util.HashSet(list);
	}
}
