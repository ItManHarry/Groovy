package groovy.in.action.part1
/**
 * Book class
 * @author 20112004
 * 20150114
 */
class Book {
	
	Book(String bookTitle){
		title = bookTitle;
	}
	
	String getTitle(){
		return title;
	}
	
	private String title;
}
