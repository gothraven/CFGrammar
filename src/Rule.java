import java.util.ArrayList;
import java.util.Iterator;

public class Rule {
	private String id;
	private ArrayList<Dirivate> dirivates;
	
	public Rule(String id, String[] ... dirvs) {
		this.id = id;
		this.dirivates = new ArrayList<>();
		for (String[] dir : dirvs) {
			Dirivate d = new Dirivate(dir);
			if (!this.dirivates.contains(d)) {	
				this.dirivates.add(d);
			}
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		return this.id.equals(((Rule)obj).getId());
	}

	public void addDirivates(String[] ... dirvs) {
		for (String[] dir : dirvs) {
			Dirivate d = new Dirivate(dir);
			if (!this.dirivates.contains(d)) {	
				this.dirivates.add(d);
			}
		}
	}
	
	public ArrayList<Dirivate> getDirivates() {
		return dirivates;
	}
	
	public String getId() {
		return id;
	}
	
	@Override
	public String toString() {
		String result = "";
		result += id + " -> ";
		for (Iterator<Dirivate> it = dirivates.iterator(); it.hasNext();) {
			Dirivate dir = (Dirivate) it.next();
			result += dir.toString();
			if (it.hasNext())
				result += " | ";
		}
		return result;
	}
}
