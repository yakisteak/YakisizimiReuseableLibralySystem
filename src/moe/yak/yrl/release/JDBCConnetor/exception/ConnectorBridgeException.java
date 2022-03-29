package moe.yak.yrl.release.JDBCConnetor.exception;

public class ConnectorBridgeException extends Exception {
	public ConnectorBridgeException(String s) {
		super(s);
	}
	public ConnectorBridgeException(String s ,Exception e) {
		super(s,e);
	}
}
