package jdbc.controller;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import jdb.factory.ConnectionFactory;
import jdbc.dao.HuespedesDAO;
import jdbc.modelo.Huespedes;

//INTERMEDIARIO QUE CONECTA RESERVADAO CON LA VIEW (DIVIDE LAS RESPONSABILIDADES)

public class HuespedesController {
	
//	ATRIBUTOS
	 private HuespedesDAO huespedDAO;
	 
	 
//	 MÉTODOS
	 
//	 ESTABLECER CONEXIÓN, ABRIRLA Y RECIBIRLA 
	 public HuespedesController() {
			Connection connection = new ConnectionFactory().recuperarConexion();
			this.huespedDAO = new HuespedesDAO(connection);
		}
	 
//	 	LLAMADA A MÉTODO GUARDAR RESERVA --> DAO
		public void guardar(Huespedes huespedes) {
			this.huespedDAO.guardar(huespedes);
		}
		
//		LLAMADA A MÉTODO CREAR LISTA DE HUÉSPEDES --> DAO
		public List<Huespedes> listarHuespedes() {
			return this.huespedDAO.listarHuespedes();
		}
		
//		LLAMADA A MÉTODO CREAR LISTA DE HUÉSPEDES --> DAO
		public List<Huespedes> listarHuespedesId(String id) {
			return this.huespedDAO.buscarId(id);
		}
		
//		LLAMADA A MÉTODO ACTUALIZAR HUÉSPED --> DAO		
		public void actualizar(String nombre, String apellido, Date fechaN, String nacionalidad, String telefono, Integer idReserva, Integer id) {
			this.huespedDAO.Actualizar(nombre, apellido, fechaN, nacionalidad, telefono, idReserva, id);
		}
		
//		LLAMADA A MÉTODO ELIMINAR HUÉSPED --> DAO
		public void Eliminar(Integer id) {
			this.huespedDAO.Eliminar(id);
		}
}
