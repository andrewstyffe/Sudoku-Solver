//Column class

import java.util.*;

public class Column implements Comparable<Column> {
	Set<Object> values;
	String first;

	public Column(Set<Object> val) {
		this.values = val;
		this.first = getFirst();
	}

	public Set<Object> getValues() {
		return values;
	}

	//Returns the leading entry in a column
	public String getFirst() {
		return (String)values.toArray()[0];
	}

	//Compares the leading entries of 2 columns
	public int compareTo(Column o) {
		int cmp = first.compareTo(o.getFirst());
		return cmp;
	}
}