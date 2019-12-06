package com.server.utils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

public class Database {
	
	private DataSource dataSource;
	private Connection db;
	private DatabaseMetaData dbm;
	
	public Database() {
		
	}
	
	public Database(DataSource dataSource) {
		setDataSource(dataSource);
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		db = dataSource.getConnection();
		try {
			dbm = db.getMetaData();
		} catch (Exception e) {
			System.out.println("Error : "+e.getMessage());
		}
	}
	
	public String delimit(String name) {
		if (name.contains(" ")) {
			name = dataSource.startDelimiter()+name+dataSource.endDelimiter();
		}
		return name;
	}

	public String[][] executeQuery(String query)
	{
		System.out.println("Query : " + query);	
		try {
			Statement sql = db.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY
			);
			ResultSet rs = sql.executeQuery(query);
			ResultSetMetaData rsm = rs.getMetaData();//getMetaData info sur la table resultat
			
			int cols = rsm.getColumnCount();
			rs.last();//se place a la fin
			int rows = rs.getRow();//return le numero de ligne courante
			rs.beforeFirst();//retour a notre place
			
			String data[][] = new String[rows + 1][cols];
			
			//premiere ligne avec les noms des champs
			for (int i = 0; i < cols; i++) {
				data[0][i] = rsm.getColumnName(i + 1);
			}
			
			int row = 0;
			
			while(rs.next())
			{
				row++;
				for (int i = 0; i < cols; i++) {
					data[row][i] = rs.getString(i + 1);
				}
				//System.out.println(rs.getString(1) + " - " + rs.getString(2));
			}
			
			return data;
			
			//sql.executeUpdate(); requete DML de mise a jour ( Update, Delete,  )
			//sql.executequerry Select
			//sql.execute();  requetes DDL(create, alter, drop, use, ...)
			
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			return null;
		}
	}

	public String[][] select(String tableName){
		return executeQuery("SELECT * FROM "+delimit(tableName));
	}
	
	public String[][] select(String tableName, String key, Object value){
		
		String query = "SELECT * FROM "+delimit(tableName)+" WHERE "+delimit(key)+" = '"+value+"'";
		return executeQuery(query);
	}

	public String[][] selectLike(String tableName, String key, String value){
	
		String query = "SELECT * FROM "+delimit(tableName)+" WHERE "+delimit(key)+" =  '"+value+"'";
		return executeQuery(query);
	}
	
	
	public int insert(String tableName, Object ...row)
	{
		try {
			Statement sql = db.createStatement();
			StringBuffer query = new StringBuffer("INSERT INTO "+delimit(tableName)+" VALUES( "+row[0]+" ");
			
			for (int i = 1; i < row.length; i++) {
				query.append(","+row[i]+" ");
			}
			query.append(");");

			System.out.println("query: " + query);
			
			return sql.executeUpdate(query.toString());	
		} catch (Exception e) {
			System.out.println("Error : "+e.getMessage());
			return 0;
		}
	}
	
	public String[] getColumnNames(String tableName)
	{
		try {
			Statement sql = db.createStatement();
			ResultSet rs = sql.executeQuery("SELECT * FROM "+delimit(tableName));
			ResultSetMetaData rsm = rs.getMetaData();//getMetaData info sur la table resultat
			int cols = rsm.getColumnCount();
			
			String columns[] = new String[cols];
			for (int i = 0; i < cols; i++) {
				columns[i] = rsm.getColumnName(i + 1);
			}
			
			rs.close();
			return columns;
		} catch (Exception e) {
			System.out.println("Error : "+e.getMessage());
			return null;
		}
	}
	
	public int update(String tableName, Object ...row)
	{
		tableName = delimit(tableName);
		try {
			Statement sql = db.createStatement();
			String cols[] = getColumnNames(delimit(tableName));

			System.out.println("hello: " + row[0]);
			String data[] = row[0].toString().split(",");
			
			StringBuffer query = new StringBuffer("UPDATE "+tableName+" SET "+delimit(cols[1])+" = "+data[1]+"");
			
			for (int i = 2; i < cols.length; i++) {
				query.append(","+ delimit(cols[i]) + " ="+data[i]+"");
			}
			
			query.append(" WHERE "+delimit(cols[0])+" = "+data[0]+ " ");
			
			return sql.executeUpdate(query.toString());
		} catch (Exception e) {
			System.out.println("Error : "+e.getMessage());
			return -1;
		}
	}
	
	public int delete(String tableName, String key, Object value)
	{
		try {
			Statement sql = db.createStatement();
			String query = "DELETE FROM "+delimit(tableName)+" WHERE "+delimit(key)+" = '"+value+"'";
			
			return sql.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Error : "+e.getMessage());
			return 0;
		}
	}

	public String[] getTableNames() {
		try {
			ResultSet rs = dbm.getTables(null, null, null, new String[] {"TABLE"/*, "VIEW", "SYSTEM TABLE"*/});
			
			/*
			int n = rs.getMetaData().getColumnCount();
			for (int i = 1; i <= n; i++) {
				System.out.println(rs.getMetaData().getColumnName(i));
			}*/
			
			Vector<String> v = new Vector<>();
			while(rs.next()) {
				v.add(rs.getString(3));
			}
			String t[] = new String[v.size()];
			v.toArray(t);
			
			return t;
		} catch (Exception e) {
			System.out.println("Error : "+e.getMessage());
			return null;
		}
	}
	
}
