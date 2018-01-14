
public class GrammarTest {
	
	public static void main(String[] args) {
		
		//grammar init
		CFGrammar g = new CFGrammar("Test");
		
		//adding rule A ->  aBa | aB
		String A1[] = {"a", "B", "a"};
		String A2[] = {"a", "B"};
		String A3[] = {CFGrammar.epsilon}; //using epsilon "Э"
		g.addRule("A", A1, A2, A3);
		
		//adding rule B -> a
		String B1[] = {"a"};
		String B2[] = {CFGrammar.epsilon};
		g.addRule("B", B1, B2);
		
		//mark the start of the grammar otherwise some errors will be shown
		g.setStart("A");
		
		System.out.println(g);
		System.out.println(g.isInfinit());
	}

}
