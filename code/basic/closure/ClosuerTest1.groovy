package groovy.basic.closure;
import static org.junit.Assert.*;
import org.junit.Test;

class ClosuerTest1 {

	@Test
	public void test() {
		new File("d:/t.txt").eachLine {
			println it;
		}
		println "--------------------------------------";
		def log = "";
		(1..10).each {
			log += it;
		}
		println "Log:\t" + log;
		println "--------------------------------------";
		def printer = {line -> println line};
		println printer;
		(1..10).each(printer);
		println "--------------------------------------";
		MethodClosureSample f = new MethodClosureSample(6);
		MethodClosureSample s = new MethodClosureSample(4);
		
		Closure fc = s.&validate;
		def words = ['long string','medium','me','time','tiny'];
		words.findAll(fc).each { e ->
			println e;
		}
		println "--------------------------------------";
		MultiMethodSample mms = new MultiMethodSample();
		Closure mc = mms.&mysteryMethod;
		println mc("Harry.Cheng");
		println mc(['a','b','c']);
		println mc(10, 20);
		println "--------------------------------------";
		def map = ['a':1, 'b':2];
		map.each { key, value ->
			map[key] = value * 2;
		}
		map.each { e ->
			println "key:\t" + e.key + "\tvalue:\t" + e.value;
		}
		def doubler = {k,v->map[k] = v * 2};
		map.each(doubler);
		println "--------------------------------------";
		map.each { e ->
			println "key:\t" + e.key + "\tvalue:\t" + e.value;
		}
		Closure c = this.&doubleMethod;
		c(map);
		println "--------------------------------------";
		map.each { e ->
			println "key:\t" + e.key + "\tvalue:\t" + e.value;
		}
		println "Methoed of calling closure...";
		def adder = {x,y-> return x +y};
		println adder(4,9);
		println adder.call(23, 20);
		println "-------------------------------------------";
		def slow = this.&benchmark(10000){(int)it/2};
		println "Slow:\t" + slow;
		def fast = this.&benchmark(10000){it.intdiv(2)};
		println "Fast:\t" + fast;
		println "After multy 15 times the result is:" + (fast*15 < slow);
		println "-------------------------------------------";
		def adder2 = {x, y=5 -> return x +y};
		println adder2(4,21);
		println adder2(10);
		println "-------------------------------------------";
		println this.&caller{ one ->};
		println this.&caller{one, two ->};
		println "-------------------------------------------";
		def adder3 = {x, y -> return x + y};
		def co = adder3.curry(5);
		println co(15);
	}
	
	def doubleMethod(Map map){
		map.each{ k,v ->
			map[k] = v * 2;
		}
	}
	def benchmark(repeat, Closure worker){
		def start = System.currentTimeMillis();
		repeat.times{worker(it)};
		def stop = System.currentTimeMillis();
		return stop - start;
	}
	def caller(Closure c){
		c.getParameterTypes().size();
	}
}