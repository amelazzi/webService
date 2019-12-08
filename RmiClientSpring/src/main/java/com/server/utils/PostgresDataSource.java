package com.server.utils;

public class PostgresDataSource extends DataSource{
	private static final String HOSTNAME = "localhost";
	private static final String DB_NAME = "rmidb";
	private static final String USER = "postgres";
	private static final String PWD = "toor";

	public static final String POSTGRES_DRIVER = "org.postgresql.Driver";
	public static final String POSTGRESL_BRIDGE = "jdbc:postgresql:";
	
	public PostgresDataSource() {
		super(POSTGRES_DRIVER, POSTGRESL_BRIDGE, HOSTNAME, DB_NAME, USER, PWD);
	}

	public PostgresDataSource(String host, String source, String user, String password) {
		super(POSTGRES_DRIVER, POSTGRESL_BRIDGE, host, source, user, password);
	}

	public PostgresDataSource(String host, String source, String user) {
		super(POSTGRES_DRIVER, POSTGRESL_BRIDGE, host, source, user, "toor");
	}
	
	public PostgresDataSource(String host, String source) {
		super(POSTGRES_DRIVER, POSTGRESL_BRIDGE, host, source, "root", "toor");
	}
	
	public PostgresDataSource(String source) {
		super(POSTGRES_DRIVER, POSTGRESL_BRIDGE, "localhost", source, "root", "toor");
	}

	public String getUrl()
	{
		return POSTGRESL_BRIDGE + "//" + getHost() + "/" + getSource();
	}

	public char startDelimiter() {
		return '`';
	}

	public char endDelimiter() {
		return '`';
	}

}
