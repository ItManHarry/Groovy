package groovy.in.action.list;
import static org.junit.Assert.*;
import groovy.in.action.classes.Money;

import org.junit.Test;

class Test1 {

	@Test
	public void test() {
		def roman = ['','I','II','II','IV','V','VI','VII'];
		println roman.size();
		println roman[4];
		roman[8] = 'VIII';
		println roman.size();
	}
	@Test
	public void testList(){
		def ml = [1,2,3];
		println ml.size();
		println ml[0];
		println ml instanceof ArrayList;
		println "====================================";
		def el = [];
		println el.size();
		println el.isEmpty();	
		println "====================================";
		el = (0..100).toList();
		println el.size();
		println el.isEmpty();
		println "====================================";
		def ll = new LinkedList(el);
		println ll.size();
	}
	@Test
	public void testListMethods(){
		def list = ['a','b','c','d','e','f','g'];
		def subList1 = list[0..3];
		subList1.each { e ->
			println e;
		}
		println "====================================";
		def subList2 = list[2,4,5];
		subList2.each{ e ->
			println e;
		}
		list[0..2] = ['x','y','z'];
		println "====================================";
		list.each { e ->
			println e;
		}
		list[3..5] = [];
		println "====================================";
		list.each { e ->
			println e;
		}
		list[1..1] = ['1','2','3'];
		println "====================================";
		list.each { e ->
			println e;
		}
		list[10] = 'G';
		println "====================================";
		println "List size:\t" + list.size();
		list.each { e ->
			if(e)
				println e;
			else
				println "Null element!";
		}
		println "====================================";
		list = [];
		println list.size();
		10.times { e ->
			list << ''+e;		
		}
		println list.size();
		list.each{ e ->
			println e;
		}
	}
	@Test
	public void testListStructures(){
		def list = ['a','b','c','1','2'];
		if(list.contains('a')){
			println "list contains a character";
		}
		println "====================================";
		def c = 'f';
		switch(c){
			case list :
				println "Character c is in the list";
				break;
			default :
				println "Character is not in the list";
				break;			
		}
		println "====================================";
		for(e in list){
			println e;
		}
		println "====================================";
		def nl = ['a','z','s','r','b'];
		nl.grep(list).each{ e ->
			println e;			
		}
		println "====================================";
		nl.sort().each { e ->
			println e;
		}
		println "====================================";
		nl.sort().reverse().each{ e ->
			println e;
		}
		println "====================================";
		def ml = [];
		20.times { i ->
			ml.push(new Money(i, "\$"));
		}
		ml.each { e ->
			println (e instanceof Money);
			Money m = (Money)e;
			println m.amount;
			println m.currency;
		}
	}
}
