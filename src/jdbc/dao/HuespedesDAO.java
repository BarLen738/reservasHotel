package jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jdbc.modelo.Huespedes;

// REGLAS DE NEGOCIO + CRUD
public class HuespedesDAO {
	
//	ATRIBUTOS
	
	private Connection connection;
	
	
//	MÉTODOS
//	CONECTAR A BASE DE DATOS
	public HuespedesDAO(Connection connection) {
		this.connection = connection;
	}

//	GUARDAR HUÉSPEDES / TRY + CATCH SQLEXCEPTION
	public void guardar(Huespedes huesped) {

		try {
//			CREAR EL STRING A ENVIAR A SQL (COINCIDIR EXACTAMENTE LOS NOMBRES DE LOS CAMPOS)
			String sql = "INSERT INTO huespedes (nombre, apellido, fecha_nacimiento, nacionalidad, telefono, idReserva) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";
//			
			try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//				ASIGNAR DATOS EN CAMPOS
//				pstm.setInt(1, huesped.getId());
				pstm.setString(1, huesped.getNombre());
				pstm.setString(2, huesped.getApellido());
				pstm.setDate(3, huesped.getFechaNacimiento());
				pstm.setString(4, huesped.getNacionalidad());
				pstm.setString(5, huesped.getTelefono());
				pstm.setInt(6, huesped.getIdReserva());
//				EJECUTAR DECLARACIÓN
				pstm.execute();

//				ACOMODAR DATOS EN TABLA
				try (ResultSet rst = pstm.getGeneratedKeys()) {
					while (rst.next()) {
						huesped.setId(rst.getInt(1));
					}
				}
			}
//			CATCH SQLEXCEPTION
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

//	CREAR LISTA DE HUÉSPEDES
	public List<Huespedes> listarHuespedes() {
//		DECLARAR LISTA
		List<Huespedes> huespedes = new ArrayList<Huespedes>();

		try {
//			CREAR EL STRING SQL (COINCIDIR EXACTAMENTE LOS NOMBRES DE LOS CAMPOS)
			String sql = "SELECT id, nombre, apellido, fecha_nacimiento, nacionalidad, telefono, idReserva FROM huespedes";

//			PREPARAR DECLARACIÓN 
			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
//				EJECUTAR DECLARACIÓN
				pstm.execute();

				transformarResultSetEnHuesped(huespedes, pstm);
			}
			return huespedes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Huespedes> buscarId(String id) {
		List<Huespedes> huespedes = new ArrayList<Huespedes>();
		try {

			String sql = "SELECT id, nombre, apellido, fecha_nacimiento, nacionalidad, telefono, idReserva FROM huespedes WHERE idReserva = ?";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.setString(1, id);
				pstm.execute();

//				LLAMADA AL MÉTODO --> DAO
				transformarResultSetEnHuesped(huespedes, pstm);
			}

//			MOSTRAR
			return huespedes;
//			CATCH SQLEXCEPTION
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

//	ACTUALIZAR REGISTRO DE HUÉSPEDES
	public void Actualizar(String nombre, String apellido, Date fechaN, String nacionalidad, String telefono,
			Integer idReserva, Integer id) {
//		ARMAR DECLARACIÓN SQL
		try (PreparedStatement stm = connection.prepareStatement(
				"UPDATE huespedes SET nombre = ?, apellido = ?, fecha_nacimiento = ?, nacionalidad = ?, telefono = ?, idReserva = ? "
				+ "WHERE id = ?")) {
//			ASIGNAR DATOS EN CAMPOS
			stm.setString(1, nombre);
			stm.setString(2, apellido);
			stm.setDate(3, fechaN);
			stm.setString(4, nacionalidad);
			stm.setString(5, telefono);
			stm.setInt(6, idReserva);
			stm.setInt(7, id);
//			EJECUTAR
			stm.execute();
//			CATCH SQL EXCEPTION
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
//	ELIMINAR HUÉSPED
	public void Eliminar(Integer id) {
//		PREPARAR SQL 
		try (PreparedStatement stm = connection.prepareStatement("DELETE FROM huespedes "
				+ "WHERE id = ?")) {
//			MATCH ID
			stm.setInt(1, id);
//			EJECUTAR
			stm.execute();
//			CATCH SQLEXCEPTION
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
//	TERMINAR DE LISTAR HUÉSPEDES Y CONECTAR CON RESERVA - THROWS SQL EXCEPTION
	private void transformarResultSetEnHuesped(List<Huespedes> reservas, PreparedStatement pstm) throws SQLException {
//		ASIGNAR DATOS EN CAMPOS
		try (ResultSet rst = pstm.getResultSet()) {
			while (rst.next()) {
				Huespedes huespedes = new Huespedes(
						rst.getInt(1), 
						rst.getString(2), 
						rst.getString(3), 
						rst.getDate(4),
						rst.getString(5), 
						rst.getString(6), 
						rst.getInt(7));
//				MATCH RESERVAS - HUÉSPEDES
				reservas.add(huespedes);
			}
		}
	}

}
