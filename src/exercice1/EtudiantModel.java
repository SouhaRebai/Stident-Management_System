package exercice1;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class EtudiantModel extends AbstractTableModel{
ResultSetMetaData rsmd ;
ArrayList<Object[]> data = new ArrayList<Object[]>();
EtudiantDAO et = new EtudiantDAO();
	public EtudiantModel(ResultSet result) {
		try {
			rsmd= result.getMetaData();
			while(result.next())
			{
				Object[] ligne = new Object[rsmd.getColumnCount()];
				for (int i =1 ; i<= rsmd.getColumnCount();i++) {
					ligne[i-1]=	result.getObject(i) +" ";
				}
				data.add(ligne);
			}
		} catch (SQLException e) {
			System.out.println("Error :"+e.getErrorCode());
		}
	}
	public int getRowCount() {
		return data.size();
		
	}
	public int getColumnCount() {
		try {
			return rsmd.getColumnCount();
		} catch (SQLException e) {
			System.out.println("error:" + e.getMessage());
			return 0;
		}
	}
	public Object getValueAt(int line, int column) {
		
		return (data.get(line))[column];
	}
	public String getColumnName(int column) {
		try {
			return rsmd.getColumnName(column+1);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
