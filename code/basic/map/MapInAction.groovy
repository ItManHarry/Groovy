package groovy.basic.map;
import static org.junit.Assert.*;
import org.junit.Test;

class MapInAction {

	@Test
	public void test() {
		def words = """
			I am Cheng Guoqian from china
			I am 32 years old now, now I
			am working at doosan 
		""";
		def m = [:];
		words.each { w ->
			if(w.trim() != "")
				m[w] = m.get(w, 0) +1;
		}
		m.each{k, v ->
			println "Key:\t" + k + "\tValue:\t" + v;
		}
	}
}
