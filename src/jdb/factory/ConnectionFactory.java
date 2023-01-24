// ADMINISTRADOR DE CONEXIONES
package jdb.factory;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

//FÁBRICA DE CONEXIONES
public class ConnectionFactory {

//	ATRIBUTOS
	public DataSource dataSource;

	
// MÉTODOS
	
//	ESTABLECER CONEXIÓN
	public ConnectionFactory() {
//		ABRIR POOL
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
//		PARÁMETROS PARA ESTABLECER LA CONEXIÓN
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/hotelbonsai?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("20230501");

//		RECIBIR LA CONEXIÓN
		this.dataSource = comboPooledDataSource;
	}

//	INTERFAZ CONNECTION - JAVA.SQL
//	TRY RETURN ABRIR LA CONEXIÓN / CATCH THROW SQLEXCEPTION
	public Connection recuperarConexion() {
		try {
			return this.dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
