package jdb.factory;
import java.sql.Connection;
import java.sql.SQLException;

//TESTEO DE CONEXIONES
public class TesteConexion {

//	MÉTODO MAIN - THROWS SQLEXCEPTION
	public static void main(String[] args) throws SQLException {

//		ESTABLECER CONEXIÓN
		ConnectionFactory connectionFactory = new ConnectionFactory();
//		ABRIR CONEXIÓN
		Connection connection = connectionFactory.recuperarConexion();
//		CERRAR CONEXIÓN
		System.out.println("Cerrando conexion!!");
		connection.close();
	}

}
