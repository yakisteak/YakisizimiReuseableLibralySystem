package moe.yak.yrl.release.JDBCConnetor;

import java.sql.Connection;

import moe.yak.yrl.release.JDBCConnetor.exception.ConnectorBridgeException;

public abstract class AbstractConnector {
	public abstract Connection getConnection() throws ConnectorBridgeException;

	public abstract boolean commit();

	public abstract void rollback();
}
