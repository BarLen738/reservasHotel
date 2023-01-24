package jdbc.controller;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import jdb.factory.ConnectionFactory;
import jdbc.dao.ReservaDAO;
import jdbc.modelo.Reserva;

// INTERMEDIARIO QUE CONECTA RESERVADAO CON LA VIEW (DIVIDE LAS RESPONSABILIDADES)
// MIGRACIONES MÁS FÁCILES AL USAR ESTA CLASE INTERMEDIARIA
public class ReservasController {
	
//	ATRIBUTOS
	
 private ReservaDAO reservaDAO;
 
 
// MÉTODOS
  
// ABRIR CONEXIÓN CON BASE DE DATOS
 public ReservasController() {
		Connection connection = new ConnectionFactory().recuperarConexion();
		this.reservaDAO = new ReservaDAO(connection);
	}
 
// LLAMADA A MÉTODO GUARDAR RESERVA --> DAO
	public void guardar(Reserva reserva) {
		this.reservaDAO.guardar(reserva);
	}
		
//	LLAMADA A MÉTODO BUSCAR RESERVA --> DAO
	public List<Reserva> buscar() {
		return this.reservaDAO.buscar();
	}
	
//	LLAMADA A MÉTODO BUSCARID --> DAO
	public List<Reserva> buscarId(String id) {
		return this.reservaDAO.buscarId(id);
	}
	
//	LLAMADA A MÉTODO ACTUALIZAR RESERVA --> DAO
	public void actualizar(Date fechaE, Date fechaS, String valor, String formaPago, Integer id) {
		this.reservaDAO.Actualizar(fechaE, fechaS, valor, formaPago, id);
	}
	
//	LLAMADA A MÉTODO ELIMINAR RESERVA --> DAO
	public void Eliminar(Integer id) {
		this.reservaDAO.Eliminar(id);
	}
}
