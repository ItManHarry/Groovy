package groovy.in.action.classes

class MethodClosure {
	
	MethodClosure( int limit){
		this.limit = limit;
	}
	
	boolean validate(String v){
		return v.length() <= limit;
	}
	
	Map doubleValue(Map map){
		return map.each { k, v ->
			map[k] = v * 2;
		}
	}
	
	int limit;
}
