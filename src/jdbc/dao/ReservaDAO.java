package jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jdbc.modelo.Reserva;

//REGLAS DE NEGOCIO + CRUD
public class ReservaDAO {
	
//	ATRIBUTOS
	
	private Connection connection;
	
	
//	MÉTODOS
	
//	ACCESAR A LA BASE DE DATOS 
	public ReservaDAO(Connection connection) {
		this.connection = connection;
	}
	
//	GUARDAR RESERVA
	public void guardar(Reserva reserva) {
		try {
//			PREPARAR SENTENCIA SQL. USAR EXACTAMENTE LOS MISMOS NOMBRES QUE LA BASE DE DATOS
			String sql = "INSERT INTO reservas (fecha_entrada, fecha_salida, valor, forma_pago) "
					+ "VALUES (?, ?, ?, ?)";

//			ENVIAR DATOS Y ARMAR LA DECLARACIÓN
			try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

//				ASIGNAR LOS DATOS EN LOS CAMPOS QUE CORRESPONDEN
				pstm.setDate(1, reserva.getfechaE());
				pstm.setDate(2, reserva.getfechaS());
				pstm.setString(3, reserva.getvalor());
				pstm.setString(4, reserva.getformaPago());
//				EJECUTAR DECLARACIÓN
				pstm.executeUpdate();

//				MOSTRAR LOS DATOS EN UNA TABLA
				try (ResultSet rst = pstm.getGeneratedKeys()) {
					while (rst.next()) {
						reserva.setId(rst.getInt(1));
					}
				}
			}
//			USAR SQLEXCEPTION PORQUE NOS DEVUELVE EL ERROR GENERADO EN FORMA ESPECÍFICA
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
//	BUSCAR RESERVA
	public List<Reserva> buscar() {
//		DECLARAR LISTA
		List<Reserva> reservas = new ArrayList<Reserva>();
		
		try {
//			DECLARAR SENTENCIA SQL
			String sql = "SELECT id, fecha_entrada, fecha_salida, valor, forma_pago "
					+ "FROM reservas";
//			CONECTAR
			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
//				EJECUTAR
				pstm.execute();
//				LLAMADA AL MÉTODO --> DAO
				transformarResultSetEnReserva(reservas, pstm);
			}
//			MOSTRAR
			return reservas;
//			CATCH SQLEXCEPTION
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
//	BUSCAR ID DE RESERVA
	public List<Reserva> buscarId(String id) {
//		DECLARAR LISTA
		List<Reserva> reservas = new ArrayList<Reserva>();
		try {
//			DECLARAR SENTENCIA SQL
			String sql = "SELECT id, fecha_entrada, fecha_salida, valor, formaPago "
					+ "FROM reservas "
					+ "WHERE id = ?";
//			CONECTAR
			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
//				ASIGNAR
				pstm.setString(1, id);
//				EJECUTAR
				pstm.execute();
//				LLAMADA A MÉTODO --> DAO
				transformarResultSetEnReserva(reservas, pstm);
			}
//			MOSTRAR
			return reservas;
//			CATCH SQLEXCEPTION
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
//	ELIMINAR RESERVA
	public void Eliminar(Integer id) {
//		PREPARAR SENTENCIA SQL
		try (PreparedStatement stm = connection.prepareStatement("DELETE "
				+ "FROM reservas "
				+ "WHERE id = ?")) {
//			ASIGNAR
			stm.setInt(1, id);
//			EJECUTAR
			stm.execute();
//			CATCH SQLEXCEPTION
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
//	ACTUALIZAR RESERVA
	public void Actualizar(Date fechaE, Date fechaS, String valor, String formaPago, Integer id) {
//		PREPARAR SENTENCIA SQL
		try (PreparedStatement stm = connection
				.prepareStatement("UPDATE reservas "
						+ "SET fecha_entrada = ?, fecha_salida = ?, valor = ?, forma_pago = ? "
						+ "WHERE id = ?")) {
//			ASIGNAR DATOS
			stm.setDate(1, fechaE);
			stm.setDate(2, fechaS);
			stm.setString(3, valor);
			stm.setString(4, formaPago);
			stm.setInt(5, id);
//			EJECUTAR
			stm.execute();
//			CATCH SQLEXCEPTION
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
			
//	TERMINAR DE MOSTRAR ASIGNACIÓN EN TABLAS - THROWS SQLEXCEPTION
	private void transformarResultSetEnReserva(List<Reserva> reservas, PreparedStatement pstm) throws SQLException {
//		MOSTRAR EN TABLA LA RESERVA
		try (ResultSet rst = pstm.getResultSet()) {
			while (rst.next()) {
				Reserva produto = new Reserva(
						rst.getInt(1), 
						rst.getDate(2), 
						rst.getDate(3), 
						rst.getString(4), 
						rst.getString(5));
//				AÑADIR PRODUCTO
				reservas.add(produto);
			}
		}
	}
}
