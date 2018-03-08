package groovy.basic.closure

class MethodClosureSample {
	
	MethodClosureSample(){
		
	}
	
	MethodClosureSample(int limit){
		this.limit = limit;
	}
	
	boolean validate(String value){
		return value.length() <= limit;
	}
	
	int limit;
}
