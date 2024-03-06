package HandleCSV;

import java.io.*;

public class ReadCSV {
	private String CSVSource;
	
	public ReadCSV(String CSVSource){
		this.CSVSource = CSVSource;
	}
	
	// Method used to store CSV universal top spotify songs which is in proper csv format
	public String[][] storeCSV() {
		String file = CSVSource;
		BufferedReader reader = null;
		String line = "";
		int rows = getRowCount();
		int columns = getColumnCount();
		
		// One added to columns so that key can be made in final column for each row
		String[][] data = new String[rows][columns + 1];
			
		try {
			reader = new BufferedReader(new FileReader(file));
			int i = 0;
			while((line = reader.readLine()) != null) {
				 String[] row = line.split(",");
				 for (int j = 0; j < columns && j < row.length; j++) {
					 data[i][j] = row[j];
				 }
				i++;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	// Method used to store CSV Spotify and Youtube which has extra info thats not in csv format
	public String[][] storeCSVNonCSVFormat() {
		String file = CSVSource;
		BufferedReader reader = null;
		String line = "";
		int rows = getRowCount();
		int columns = getColumnCount();
		
		// One added to columns so that key can be made in final column for each row
		String[][] data = new String[rows][columns + 1];
		
		try {
			reader = new BufferedReader(new FileReader(file));
			int i = 0;
			while((line = reader.readLine()) != null) {
				if (line.startsWith((i + 1) + ",")) {
					 String[] row = line.split(",");
					    for (int j = 0; j < columns && j < row.length; j++) {
					        data[i][j] = row[j];
					    }
					    i++;
				}
				else
					continue;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public int getRowCount() {
		String file = CSVSource;
		BufferedReader reader = null;
		String line = "";
		int rowCount = 0;
		
		try {
			reader = new BufferedReader(new FileReader(file));
			while((line = reader.readLine()) != null) {
				rowCount++;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return rowCount;
	}
	
	public int getColumnCount() {
		String file = CSVSource;
		BufferedReader reader = null;
		String line = "";
		int columnCount = 0;
		
		try {
			reader = new BufferedReader(new FileReader(file));
			while((line = reader.readLine()) != null) {
				String[] row = line.split(",");
				columnCount = row.length;
				break;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return columnCount;
	}
}
