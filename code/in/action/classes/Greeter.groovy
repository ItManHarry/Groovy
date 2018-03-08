package groovy.in.action.classes
import org.apache.commons.lang.WordUtils;

class Greeter extends Greet {
	Greeter(who){
		name = WordUtils.capitalize(who);
	}
}
