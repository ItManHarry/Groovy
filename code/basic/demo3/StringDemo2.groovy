package groovy.basic.demo3;
import static org.junit.Assert.*;
import org.junit.Test;

class StringDemo2 {

	@Test
	public void test() {
		def greeting = "Hello, Groovy!!!";
		println greeting.startsWith("Hello");
		println greeting.getAt(0);
		println greeting[0];
		println greeting.getAt(0..4);
		println greeting[0..4];
		println greeting.indexOf("Groovy");
		println greeting.contains("Hello");
		println "Hi" + greeting - "Hello";
		println greeting;
		println greeting.count("o");
		println "X".padLeft(3);
		println "Y".padRight(3, "*");
		println "M".center(4);
		println "N" * 3;
		
		println "------------------------------------------------------------------";
		def sb = "Hello";
		sb <<= " Groovy";
		println sb;
		assert sb instanceof StringBuffer;
		sb << "!";
		println sb;
		sb[1..4] = 'i';
		println sb.toString();
	}
}
