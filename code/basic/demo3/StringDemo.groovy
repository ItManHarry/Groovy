package groovy.basic.demo3;
import static org.junit.Assert.*;
import org.junit.Test;

class StringDemo {

	@Test
	public void test() {
		def me = "Harry";
		def you = "Jack";
		println me;
		def line = "I am $me, and you are $you";
		assert line instanceof GString;
		println "strings[0]\t"+line.strings[0];
		println "strings[1]" + line.strings[1];
		println "strings[2]" + line.strings[2];
		println "values[0]" + line.values[0];
		println "values[1]" + line.values[1];
		//println "values[0]" + line.values[2];
		println line;
		Date date = new Date();
		println "Year:$date.year";
		println "Month:$date.month";
		println "Day:$date.date";
		println date.toLocaleString();
		println "Time:${date.toLocaleString()}";
		def sql = """ 
			SELECT * FROM CP_EMPLOYEE
			WHERE NAME = 'HARRY'
		""";
		println sql;
		println sql.indexOf("\n");
		def money = '100,000\$';
		println money;
	}
}
