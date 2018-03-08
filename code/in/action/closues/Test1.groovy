package groovy.in.action.closues;

import static org.junit.Assert.*;
import groovy.in.action.classes.MethodClosure;
import groovy.in.action.classes.MultiMethod;

import org.junit.Test;

class Test1 {

	@Test
	public void test() {
		def list = [1,2,3,4,5,6,7,8,9,10];
		def rg = 0..list.size()-1;
		(0..list.size()-1).each{ el ->
			println "Index is:\t" + el + ":\tValue is:\t" + list[el];
		}
		def tc = 0;
		def tp = 100;
		1.upto(tp) { gn ->
			tc += gn - 1;
		}
		println tc;
	}
	@Test
	public void declare(){
		
		println "---------------The first way to declare the closure-------------------";
		def log = '';
		(1..10).each { counter ->
			log += counter;
		}
		println log;
		println "----------------------------------";
		log = '';
		(1..10).each{
			log += it;
		}
		println log;
		println "----------------------------------";
		log = '';
		(1..10).each ({ log += it});
		println log;
		println "---------------The second way to declare the closure-------------------";
		def logger = { log += it};
		log = '';
		(1..10).each(logger);
		println log;
		println "----------------------------------";
		log = '';
		(1..10).each(getLogger());
		println log;
		println "---------------The third way to declare the closure-------------------";
		MethodClosure mc1 = new MethodClosure(6);
		MethodClosure mc2 = new MethodClosure(5);
		Closure c1 = mc1.&validate;
		def words = ['long string','tom','medium','short','tiny','harry'];
		words.grep(c1).each { 
			println it;
		};
		println "----------------------------------";
		words.grep(mc2.&validate).each { 
			println it;
		}
		println words.find(c1);
		println "----------------------------------";
		MultiMethod mm = new MultiMethod();
		Closure mc = mm.&getResult;
		println mc("I am Harry.Cheng");
		println mc([1,2,3,4,5,6,7,8,9,0]);
		println mc(100, 200);		
	}
	@Test
	public void fullDelaration(){
		def map = ['a':1, 'b':2];
		map.each { k, v ->
			map[k] = v * 2;
		}
		map.each { 
			println it.key + "\t:\t" + it.value;
		}
		println "----------------------------------";
		def doubler = { k, v ->
			map[k] = v * 2;
		}
		map.each(doubler);
		map.each {
			println it.key + "\t:\t" + it.value;
		}
//		println "----------------------------------";
//		MethodClosure mc = new MethodClosure();
//		Closure c = mc.&doubleValue;
		doubler = this.&doubleMethod;
//		c(map);
		map.each (doubler);
		map.each {
			println it.key + "\t:\t" + it.value;
		}
		println "----------------------------------";
	}
	@Test
	public void invokeTest(){
		def adder = {x ,y -> 
			return x + y;
		};
		println adder(3,4);
		println adder.call(2,8);
		println "-----------------------------------";
		def slow = benchmark(10000, {(int)it/2});
		println slow;
		def fast = benchmark(10000, {it.intdiv(2)});
		println fast;
		println "-----------------------------------";
		def adder2 = {x , y = 10 ->
			return x + y;
		};
		println adder2(100, 100);
		println adder2(200);
	}
	def getLogger(){
		return { log -> print log+"="};
	}
	def doubleMethod (entry){
		return {map[entry.key] = entry.value * 2};
	}
	def benchmark(repeat, Closure worker){
		def start = System.currentTimeMillis();
		repeat.times{worker(it)};
		def stop = System.currentTimeMillis();
		return  stop - start; 
	}
}
