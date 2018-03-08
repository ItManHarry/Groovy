package groovy.basic.closure

class MultiMethodSample {
	
	int mysteryMethod(String arg){
		return arg.length();
	}
	
	int mysteryMethod(List list){
		return list.size();
	}
	
	int mysteryMethod(int x, int y){
		return x + y;
	}
}

