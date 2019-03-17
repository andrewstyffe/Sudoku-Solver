//Box class

import java.util.*;

public class Box implements Comparable<Box> {
	Set<Object> values;
	String first;

	public Box(Set<Object> val) {
		this.values = val;
		this.first = getFirst();
	}

	public Set<Object> getValues() {
		return values;
	}

	//Returns the leading entry in a box
	public String getFirst() {
		return (String)values.toArray()[0];
	}

	//Compares the leading entries of 2 boxes
	public int compareTo(Box o) {
		int cmp = first.compareTo(o.getFirst());
		return cmp;
	}
}