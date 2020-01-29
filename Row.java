<<<<<<< HEAD
=======
//Row class

>>>>>>> 46cda60e79dfdb318c17d1ae4c2b2a30d05d7b70
import java.util.*;

public class Row implements Comparable<Row> {
	Set<Object> values;
	String first;

	public Row(Set<Object> val) {
		this.values = val;
		this.first = getFirst();
	}

	public Set<Object> getValues() {
		return values;
	}

	//Returns the leading entry in a row
	public String getFirst() {
		return (String)values.toArray()[0];
	}

	//Compares the leading entries of 2 rows
	public int compareTo(Row o) {
		int cmp = first.compareTo(o.getFirst());
		return cmp;
	}
}
