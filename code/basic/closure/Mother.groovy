package groovy.basic.closure

class Mother {
	int field = 1;
	int foo(){
		return 2;
	}
	Closure birth(param){
		def local = 3;
		def closure = { caller ->
			[this, field, foo(), local, param, caller, this.owner]
		}
		return closure;
	}
}
