import java.util.ArrayList;
import java.util.Stack;

public class CFGrammar {
	public static String epsilon = "Э";
	private String name;
	private ArrayList<Rule> rules;
	private String start;
	
	public CFGrammar(String name) {
		this.name = name;
		this.rules = new ArrayList<>();
	}
	
	public void addRule(String id, String[] ... dirvs) { 
		for (Rule rule : rules) {
			if (rule.getId().equals(id)) {
				rule.addDirivates(dirvs);
				return ;
			}
		}
		this.rules.add(new Rule(id, dirvs));
	}
	
	public boolean isEmpty() {
		
		return false;
	}
	
	public boolean isInfinit() {
		if (this.start == null || this.start.isEmpty()) {
			System.err.println("please specify the start rule");
			return false;
		}
		Stack<Rule> nonTerminals = new Stack<>();
		Rule start = getRule(this.start);
		nonTerminals.add(start);
		while(!nonTerminals.empty()) {
			Rule r = nonTerminals.pop();
			for (Dirivate dir : r.getDirivates()) {
				for (String part : dir.getParts()) {
					if (!isTerminal(part)) {
						Rule nr = getRule(part);
						if (!nonTerminals.contains(nr))
							nonTerminals.add(nr);
					}
				}
			}
		}

		return true;
	}
	
	private boolean isTerminal(String id) {
		for (Rule rule : rules) {
			if (rule.getId().equals(id))
				return false;
		}
		return true;
	}
	
	public Rule getRule(String id) {
		for (Rule rule : rules) {
			if (rule.getId().equals(id))
				return rule;
		}
		System.err.println("Rule <"+id+"> doesn't exist in the grammar");
		return null;
	}
	
	public String expand() {
		
		return "start";
	}
	
	public void setStart(String start) {
		for (Rule rule : rules) {
			if (rule.getId().equals(start))
				this.start = start;
		}
	}
	
	public String getStart() {
		return start;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		String result = "";
		result += "Grammar : " + this.name + "\n\n";
		for (Rule rule : rules) {
			if (rule.getId().equals(start))
				result += "\t#> " + rule.toString() + "\n";
			else
				result += "\t   " + rule.toString() + "\n";
		}
		return result;
	}

}