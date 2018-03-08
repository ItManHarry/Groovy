package groovy.basic.closure;
import static org.junit.Assert.*;
import org.junit.Test;

class ClosureTest2 {

	@Test
	public void test() {
		def configurator = { format, filter, line ->
			filter(line) ? format(line) : null;		
		}
		
		def appender = { config, append, line ->
			def out = config(line);
			if(out)
				append(out);
		}
		
		def dateFormat = {line -> "${new Date()} : $line"};
		def debug = {line -> line.contains("debug")};
		def consoleAppender = {line -> println line};
		
		def myConf = configurator.curry(dateFormat, debug);
		def myLog = appender.curry(myConf, consoleAppender);
		
		myLog("here is some debug message");
		myLog("this will not be printed");
	}
	
	@Test
	public void test2() {
		def k = "harry";
		switch(k){
			case {it == "tom"}:
				println "It's Tom!";
				break;
			case {it == "jack"}:
				println "It's Jack!";
				break;
			case {it == "harry"}:
				println "It's Harry!";
				break;
			default:
				println "Some body I don't know!";
				break;
		}
		//Test Mother Class
		def acc = foo(1);
		println acc;
		println acc(2);
		println acc(3);
	}
	
	def foo(n){
		return  { n += it}
	}
}
