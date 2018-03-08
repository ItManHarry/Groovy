package groovy.in.action.classes

class Greet {
	def name;
	
	Greet(){
		
	}
	
	Greet(who){
		name = who[0].toUpperCase()+who[1..-1];
	}
	def salute(){
		println "Hello $name";
	}
}
