import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.*;

public class Sudoku extends CSP {

	static Object[] grid = new Object[81];
	static Object[] gridIndices = new Object[81];

	//Define rows and their grid-values
	static Set<Object> row1 = new TreeSet<Object>(
		Arrays.asList(new String[] {"A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9"}));

	static Set<Object> row2 = new TreeSet<Object>(
		Arrays.asList(new String[] {"B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9"}));

	static Set<Object> row3 = new TreeSet<Object>(
		Arrays.asList(new String[] {"C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9"}));

	static Set<Object> row4 = new TreeSet<Object>(
		Arrays.asList(new String[] {"D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9"}));

	static Set<Object> row5 = new TreeSet<Object>(
		Arrays.asList(new String[] {"E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9"}));

	static Set<Object> row6 = new TreeSet<Object>(
		Arrays.asList(new String[] {"F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9"}));

	static Set<Object> row7 = new TreeSet<Object>(
		Arrays.asList(new String[] {"G1", "G2", "G3", "G4", "G5", "G6", "G7", "G8", "G9"}));

	static Set<Object> row8 = new TreeSet<Object>(
		Arrays.asList(new String[] {"H1", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9"}));

	static Set<Object> row9 = new TreeSet<Object>(
		Arrays.asList(new String[] {"I1", "I2", "I3", "I4", "I5", "I6", "I7", "I8", "I9"}));


	//Define columns and their grid-values
	static Set<Object> column1 = new TreeSet<Object>(
		Arrays.asList(new String[] {"A1", "B1", "C1", "D1", "E1", "F1", "G1", "H1", "I1"}));

	static Set<Object> column2 = new TreeSet<Object>(
		Arrays.asList(new String[] {"A2", "B2", "C2", "D2", "E2", "F2", "G2", "H2", "I2"}));

	static Set<Object> column3 = new TreeSet<Object>(
		Arrays.asList(new String[] {"A3", "B3", "C3", "D3", "E3", "F3", "G3", "H3", "I3"}));

	static Set<Object> column4 = new TreeSet<Object>(
		Arrays.asList(new String[] {"A4", "B4", "C4", "D4", "E4", "F4", "G4", "H4", "I4"}));

	static Set<Object> column5 = new TreeSet<Object>(
		Arrays.asList(new String[] {"A5", "B5", "C5", "D5", "E5", "F5", "G5", "H5", "I5"}));

	static Set<Object> column6 = new TreeSet<Object>(
		Arrays.asList(new String[] {"A6", "B6", "C6", "D6", "E6", "F6", "G6", "H6", "I6"}));

	static Set<Object> column7 = new TreeSet<Object>(
		Arrays.asList(new String[] {"A7", "B7", "C7", "D7", "E7", "F7", "G7", "H7", "I7"}));

	static Set<Object> column8 = new TreeSet<Object>(
		Arrays.asList(new String[] {"A8", "B8", "C8", "D8", "E8", "F8", "G8", "H8", "I8"}));

	static Set<Object> column9 = new TreeSet<Object>(
		Arrays.asList(new String[] {"A9", "B9", "C9", "D9", "E9", "F9", "G9", "H9", "I9"}));


	//Define boxes and their grid-values
	static Set<Object> box1 = new TreeSet<Object>(
		Arrays.asList(new String[] {"A1", "A2", "A3", "B1", "B2", "B3", "C1", "C2", "C3"}));

	static Set<Object> box2 = new TreeSet<Object>(
		Arrays.asList(new String[] {"A4", "A5", "A6", "B4", "B5", "B6", "C4", "C5", "C6"}));

	static Set<Object> box3 = new TreeSet<Object>(
		Arrays.asList(new String[] {"A7", "A8", "A9", "B7", "B8", "B9", "C7", "C8", "C9"}));

	static Set<Object> box4 = new TreeSet<Object>(
		Arrays.asList(new String[] {"D1", "D2", "D3", "E1", "E2", "E3", "F1", "F2", "F3"}));

	static Set<Object> box5 = new TreeSet<Object>(
		Arrays.asList(new String[] {"D4", "D5", "D6", "E4", "E5", "E6", "F4", "F5", "F6"}));

	static Set<Object> box6 = new TreeSet<Object>(
		Arrays.asList(new String[] {"D7", "D8", "D9", "E7", "E8", "E9", "F7", "F8", "F9"}));

	static Set<Object> box7 = new TreeSet<Object>(
		Arrays.asList(new String[] {"G1", "G2", "G3", "H1", "H2", "H3", "I1", "I2", "I3"}));

	static Set<Object> box8 = new TreeSet<Object>(
		Arrays.asList(new String[] {"G4", "G5", "G6", "H4", "H5", "H6", "I4", "I5", "I6"}));

	static Set<Object> box9 = new TreeSet<Object>(
		Arrays.asList(new String[] {"G7", "G8", "G9", "H7", "H8", "H9", "I7", "I8", "I9"}));


	public static void main(String[] args) {
		Sudoku csp = new Sudoku();

		Row r1 = new Row(row1);
		Row r2 = new Row(row2);
		Row r3 = new Row(row3);
		Row r4 = new Row(row4);
		Row r5 = new Row(row5);
		Row r6 = new Row(row6);
		Row r7 = new Row(row7);
		Row r8 = new Row(row8);
		Row r9 = new Row(row9);

		Column col1 = new Column(column1);
		Column col2 = new Column(column2);
		Column col3 = new Column(column3);
		Column col4 = new Column(column4);
		Column col5 = new Column(column5);
		Column col6 = new Column(column6);
		Column col7 = new Column(column7);
		Column col8 = new Column(column8);
		Column col9 = new Column(column9);

		Box bx1 = new Box(box1);
		Box bx2 = new Box(box2);
		Box bx3 = new Box(box3);
		Box bx4 = new Box(box4);
		Box bx5 = new Box(box5);
		Box bx6 = new Box(box6);
		Box bx7 = new Box(box7);
		Box bx8 = new Box(box8);
		Box bx9 = new Box(box9);

		TreeSet<Row> rows = mergeRows(r1, r2, r3, r4, r5, r6, r7, r8, r9);
		TreeSet<Column> columns = mergeColumns(col1, col2, col3, col4, col5, col6, col7, col8, col9);
		TreeSet<Box> boxes = mergeBoxes(bx1, bx2, bx3, bx4, bx5, bx6, bx7, bx8, bx9);

		buildGrid();
		buildIndices(rows);
		addDomains(csp, rows);

		//Uniqueness constraints
		for(Row row : rows) 
			for(Object X : row.getValues()) 
				for(Object Y : row.getValues()) 
					csp.addBidirectionalArc(X,Y);

		for(Column column : columns) 
			for(Object X : column.getValues()) 
				for(Object Y : column.getValues()) 
					csp.addBidirectionalArc(X,Y);

		for(Box box : boxes) 
			for(Object X : box.getValues()) 
				for(Object Y : box.getValues()) 
					csp.addBidirectionalArc(X,Y);
 

		JFrame.setDefaultLookAndFeelDecorated(true);
    	JFrame frame = new JFrame("Sudoku Puzzle");
    	frame.setLayout(new GridLayout(9, 9));
    	
    	for(int i = 0; i < 81; i ++) {
    		if(grid[i] != null)	{
    			frame.add(new JButton("" + grid[i]));
    			continue;
    		}
    		frame.add(new JButton(""));
    	}

    	frame.pack();
    	frame.setVisible(true);

    	Scanner sc = new Scanner(System.in);
    	String next = sc.next();

    	if(next.equals("solve")) {
    		frame.dispose();	//dispose of initial, unsolved puzzle
			solve(csp, rows, frame); 	//displays solved puzzle
    	}
	}

	public static void solve(Sudoku csp, TreeSet<Row> rows, JFrame frame) {
		JFrame.setDefaultLookAndFeelDecorated(true);
    	frame = new JFrame("Sudoku Puzzle");
    	frame.setLayout(new GridLayout(9, 9));

		Search search = new Search(csp);
    	Map<Object, Object> solution = search.BacktrackingSearch();

    	int index = 0;
    	for(Row row : rows)
    		for(Object X : row.getValues()) 
    			frame.add(new JButton("" + solution.get(X)));

    	frame.pack();
    	frame.setVisible(true);
	}

	public boolean isGood(Object X, Object Y, Object x, Object y) {
		if(!C.containsKey(X))
			return true;

		if(!C.get(X).contains(Y))
			return true;

		//This is actually the only condition needed to work....not sure why
		//if(x.equals(y)) return false;

		//unique among rows
		if(!isDiffRow(X, Y) && !X.equals(Y) && x.equals(y)) return false;

		//unique among columns
		if(!isDiffColumn(X, Y) && !X.equals(Y) && x.equals(y)) return false;

		//unique among boxes
		if(!isDiffBox(X, Y) && !X.equals(Y) && x.equals(y)) return false;
		
		return true;
	}

	//Returns true if X and Y are in different rows
	public static boolean isDiffRow(Object X, Object Y) {
		if(row1.contains(X) && !row1.contains(Y)) return true;
		else if(row2.contains(X) && !row2.contains(Y)) return true;
		else if(row3.contains(X) && !row3.contains(Y)) return true;
		else if(row4.contains(X) && !row4.contains(Y)) return true;
		else if(row5.contains(X) && !row5.contains(Y)) return true;
		else if(row6.contains(X) && !row6.contains(Y)) return true;
		else if(row7.contains(X) && !row7.contains(Y)) return true;
		else if(row8.contains(X) && !row8.contains(Y)) return true;
		else if(row9.contains(X) && !row9.contains(Y)) return true;
		else return false;
	}

	//Returns true if X and Y are in different columns
	public static boolean isDiffColumn(Object X, Object Y) {
		if(column1.contains(X) && !column1.contains(Y)) return true;
		else if(column2.contains(X) && !column2.contains(Y)) return true;
		else if(column3.contains(X) && !column3.contains(Y)) return true;
		else if(column4.contains(X) && !column4.contains(Y)) return true;
		else if(column5.contains(X) && !column5.contains(Y)) return true;
		else if(column6.contains(X) && !column6.contains(Y)) return true;
		else if(column7.contains(X) && !column7.contains(Y)) return true;
		else if(column8.contains(X) && !column8.contains(Y)) return true;
		else if(column9.contains(X) && !column9.contains(Y)) return true;
		else return false;
	}

	//Returns true if X and Y are in different boxes
	public static boolean isDiffBox(Object X, Object Y) {
		if(box1.contains(X) && !box1.contains(Y)) return true;
		else if(box2.contains(X) && !box2.contains(Y)) return true;
		else if(box3.contains(X) && !box3.contains(Y)) return true;
		else if(box4.contains(X) && !box4.contains(Y)) return true;
		else if(box5.contains(X) && !box5.contains(Y)) return true;
		else if(box6.contains(X) && !box6.contains(Y)) return true;
		else if(box7.contains(X) && !box7.contains(Y)) return true;
		else if(box8.contains(X) && !box8.contains(Y)) return true;
		else if(box9.contains(X) && !box9.contains(Y)) return true;
		else return false;
	}

	//Goes through every cell and gives it the appropriate domain
	//Domains for empty cells are 1-9; nonempty cells have one domain value
	public static void addDomains(Sudoku csp, TreeSet<Row> rows) {

		Integer[] domain = new Integer[9];
		for(int i = 0; i < 9; i++) 
			domain[i] = i + 1;

		//Give each cell domain 1-9
		for(Row row : rows)
			for(Object X : row.getValues()) 
				csp.addDomain(X, domain);

		//Modify domains of nonempty cells to be a single value
		for(int i = 0; i < 81; i++) {
			if(grid[i] != null) {
				Set<Object> cellVal = csp.D.remove("" + gridIndices[i]);
				for(int j = 0; j < 10; j++) {
					if(j == (int)grid[i]) continue;
					cellVal.remove(j);
				}
				csp.D.put("" + gridIndices[i], cellVal);
			}
		}
	}

	//Puts all rows into one Set
	public static TreeSet<Row> mergeRows(Row row1, Row row2, Row row3, Row row4, Row row5, Row row6,
	 Row row7, Row row8, Row row9) {

		TreeSet<Row> rows = new TreeSet<Row>();

		rows.add(row1); 
		rows.add(row2);
		rows.add(row3);
		rows.add(row4);
		rows.add(row5);
		rows.add(row6);
		rows.add(row7);
		rows.add(row8);
		rows.add(row9);
		return rows;
	}

	//Puts all columns into one Set
	public static TreeSet<Column> mergeColumns(Column col1, Column col2, Column col3,
	 Column col4, Column col5, Column col6, Column col7, Column col8, Column col9) {
		
		TreeSet<Column> columns = new TreeSet<Column>();

		columns.add(col1);
		columns.add(col2);
		columns.add(col3);
		columns.add(col4);
		columns.add(col5);
		columns.add(col6);
		columns.add(col7);
		columns.add(col8);
		columns.add(col9);
		return columns;
	}

	//Puts all boxes into one Set
	public static TreeSet<Box> mergeBoxes(Box box1, Box box2, Box box3,
	 Box box4, Box box5, Box box6, Box box7, Box box8, Box box9) {
		
		TreeSet<Box> boxes = new TreeSet<Box>();

		boxes.add(box1);
		boxes.add(box2);
		boxes.add(box3);
		boxes.add(box4);
		boxes.add(box5);
		boxes.add(box6);
		boxes.add(box7);
		boxes.add(box8);
		boxes.add(box9);
		return boxes;
	}

	public static void buildGrid() {
		grid[0] = 1;
		grid[5] = 7;
		grid[7] = 9;
		grid[10] = 3;
		grid[13] = 2;
		grid[17] = 8;
		grid[20] = 9;
		grid[21] = 6;
		grid[24] = 5;
		grid[29] = 5;
		grid[30] = 3;
		grid[33] = 9;
		grid[37] = 1;
		grid[40] = 8;
		grid[44] = 2;
		grid[45] = 6;
		grid[50] = 4;
		grid[54] = 3;
		grid[61] = 1;
		grid[64] = 4;
		grid[71] = 7;
		grid[74] = 7;
		grid[78] = 3;
	}

	//Associates every cell with a value. 
	//e.g. grid[0] = A1, grid[1] = A2... grid[9] = B1...
	public static void buildIndices(TreeSet<Row> rows) {
		int nextIndex = 0;
		for(Row row : rows) {
			for(Object X : row.getValues()) {
				gridIndices[nextIndex++] = X;	
			}
		}	
	}
}