package groovy.basic.list;
import static org.junit.Assert.*;
import org.junit.Test;

class ListTest {

	@Test
	public void test() {
		//声明方式一
		def list1 = [4,5,6];
		for(x in list1){
			println "Index:\t" + list1.indexOf(x) + "\tValue:\t" + x;
		}
		println "---------------------------------------------------";
		for(int i = 0; i < list1.size(); i++){
			println "Index:\t"+i+"\tValue:\t"+list1[i];
		}
		println "---------------------------------------------------";
		list1.each(){
			x ->
			println "Index:\t" + list1.indexOf(x) + "\tValue:\t" + x;
		}
		if(list1 instanceof ArrayList){
			println "ArrayList";
		}else{
			println "Not ArrayList";	
		}
		//声明方式二
		def list2 = (1..10).toList();
		println "Size:\t" + list2.size();
		println "---------------------------------------------------";
		for(x in list2){
			println x;
		}
		if(list2 instanceof ArrayList){
			println "ArrayList";
		}else{
			println "Not ArrayList";
		}
		println "---------------------------------------------------";
		//声明方式三
		def list3 = new ArrayList();
		list3.addAll(list2);
		list3[0] = 10;
		for(x in list3){
			println "List3:\t" + x;
		}
		println "---------------------------------------------------";
		//声明方式四
		def list4 = new LinkedList(list3);
		for(x in list4){
			println "List4:\t" + x;
		}
		//数组操作
		def myList = ["a","b","c","d","e","f"];
		println "------------------Get Elements-----------------------";
		println myList[0..2];
		println myList[0,2,4];
		println "------------------Change Elements-----------------------";
		myList[0..2] = ["x","y","z"];
		println myList[0..myList.size()-1];
		myList[0,2,4] = ["m","n","l"];
		println myList[0..myList.size()-1];
		myList[4..5] = [];
		println myList[0..myList.size()-1];
		myList[3..3] = ["o","p","q","r","t"];
		println myList[0..myList.size()-1];
		println myList[-1..-(myList.size())];
	}
	@Test
	public void testMehtods(){
		def mylist = [];
		println "-----------------plus method-------------------------";
		mylist = mylist.plus("a");
		mylist += "b";
		mylist += ["c","d","e"];
		mylist = mylist.plus(["x","y","z"]);
		println mylist;
		println "-----------------leftShift method-------------------------";
		mylist << "f" << "g";
		println mylist;
		//mylist.clear();//清空列表
		println mylist;
		println "-----------------minux method-------------------------";
		mylist - ["g"];
		println mylist;
		println "-----------------multiply method-------------------------";
		mylist = mylist * 2;
		println mylist;
	}
	@Test
	public void testMethods2(){
		def mylist = ["a","b","c"];
		if(mylist.isCase("a")){
			println "The list contains the a element";
		}else{
			println "The list doesn't contain the a element";
		}
		println mylist.contains("a");
		def e = "a";
		switch(e){
			case mylist:
				println "Element is in the list";
				break;
			default:
				println "Element is not in the list";
				break;
		}
		def ml = ["z","a","c"].grep(mylist);
		println ml;
		//flatten method
		def list = [1,[2,3]];
		def fl = list.flatten();
		println fl;
		//intersect elements
		def l1 = [1,2,3];
		def l2 = l1.intersect([4,3,1]);
		println l2;
		//pop method
		def p = l1.pop();
		println p;
		println l1;
		//push method
		l1.push(4);
		println l1;
		//reverse method
		def vl = [1,3,2,5,5];
		println vl;
		println vl.reverse();
		//sort
		println vl.sort();
		println vl.sort().reverse();
		def sl = [[1,0],[0,1,2],[3,2,3]];
		println sl;
		def ssl = sl.sort {a,b->
			a[0] <=> b[0];
		}
		println ssl;
		//remove
		def ll = [1,2,3,4,5,6];
		println ll;
		ll.remove(2);
		println ll;
		ll.remove(ll.indexOf(4));
		println ll;
		ll.removeAll([1,2]);
		println ll;
		def lll = ll.collect { i ->
			i * 3;
		}
		println lll;
		def llll = [1,2,3,4,5,6,7,8,9];
		println llll;
		def lllll = llll.findAll { i ->
			i % 2 == 0;
		}
		println lllll;
		def l = [1,2,3];
		def l2l = l.disjoint([3,5,6]);
		println l;
		println l2l;
		//去除重复元素
		def ul = [1,1,2,3,4,3,5,6,7];
		println ul;
		println new HashSet(ul).toList();
		println ul;
		println ul.unique();
		println ul;
		//去除空元素
		def nl = [1,null,2,3,null];
		println nl.findAll{
			it != null;
		};
		println nl;
		println nl.grep{it};
	}
	@Test
	public void testMthods3(){
		def list = [1,4,3,2,3];
		println list.count(2);	//统计元素个数
		println list.max();		//取得列表中最大的元素
		println list.min();		//取得列表中最小的元素
		def even = list.find{ i ->
			i % 2 == 0;
		};						//使用闭包获取第一个符合条件的元素	
		println even;
		println list.every { e ->
			e < 4
		};
		println list.any{e ->
			e < 2
		};
		def str = "";
		list.each { e ->
			str += e;
		};
		println list.join(",");
		println str;
		list.sort().reverse().each{ e ->
			str += e;
		};
		println str;
		println list.sum();
		//inject
		def rlt = list.inject(0) { c, g ->
			c += g;
		};
		println rlt;
		def rlt2 = list.inject(1) { f, i ->
			f *= i;
		};
		println rlt2;
	}
}
