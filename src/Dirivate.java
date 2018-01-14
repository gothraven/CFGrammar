import java.util.ArrayList;

public class Dirivate {
	private ArrayList<String> parts;
	
	public Dirivate(String[] dir) {
		this.parts = new ArrayList<>();
		for (String d : dir)
			this.parts.add(d);
	}
	
	public ArrayList<String> getParts() {
		return parts;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		return this.parts.equals(((Dirivate)obj).parts);
	}
	
	@Override
	public String toString() {
		String result = "";
		for (String d : parts) {
			result += "["+d+"]";
		}
		return result;
	}
}
