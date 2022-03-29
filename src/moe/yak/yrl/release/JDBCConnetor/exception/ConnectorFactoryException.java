package moe.yak.yrl.release.JDBCConnetor.exception;

public class ConnectorFactoryException extends Exception {
	public ConnectorFactoryException(String s) {
		super(s);
	}
	public ConnectorFactoryException(String s ,Exception e) {
		super(s,e);
	}
}
