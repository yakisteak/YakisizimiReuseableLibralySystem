package moe.yak.yrl.release.JDBCConnetor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import moe.yak.yrl.release.JDBCConnetor.exception.ConnectorFactoryException;

public abstract class AbstractDaoFactory {
	
	@SuppressWarnings("deprecation")
	public static AbstractConnectorFactory getFactory(String path,String key) throws ConnectorFactoryException {
		//プロパティファイルからClassクラスのインスタンスを取得し
		//対応するクラスのインスタンスを返す？
		AbstractConnectorFactory factory = null;
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(path));
			//下記は本番環境用
			//prop.load(new FileInputStream("/opt/tomcat-8.5/props/ConnectorCommands.properties"));

			String name = prop.getProperty(key);
			factory = (AbstractConnectorFactory)Class.forName(name).newInstance();
		}catch(FileNotFoundException e) {
			throw new ConnectorFactoryException("PropFileNotFound");
			//独自例外にラップしてスローする？
		}catch(IOException e) {
			throw new ConnectorFactoryException("IOExcep");
		}catch(ClassNotFoundException e) {
			throw new ConnectorFactoryException("CNFExcep");
		}catch(InstantiationException e) {
			throw new ConnectorFactoryException("INSExcep");
		}catch(IllegalAccessException e) {
			throw new ConnectorFactoryException("ILAExcep");
		}

		return factory;

	}
}
