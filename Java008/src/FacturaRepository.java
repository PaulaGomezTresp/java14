import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FacturaRepository {

	static final String DB_URL = "jdbc:mysql://localhost:3306/cie1";
	static final String USER = "root";
	static final String PASS = "";
	static final String QUERY = "SELECT * from Facturas";

	public void insertar(Factura f) {
		try {
			Connection conexion = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement sentencia = conexion.createStatement();
			sentencia.executeUpdate("insert into facturas values ('" + f.getNumero() + "','" + f.getConcepto() + "','"
					+ f.getImporte() + "')");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Factura f) {
		try {
			Connection conexion = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement sentencia = conexion.createStatement();
			sentencia.executeUpdate("delete from facturas where numero = '" + f.getNumero() + "'");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Factura> buscarTodos() {

		ArrayList<Factura> lista = new ArrayList<Factura>();
		ResultSet rs=null;
		Connection conexion=null;
		Statement sentencia=null;
		try {
			conexion = DriverManager.getConnection(DB_URL, USER, PASS);
			sentencia = conexion.createStatement();
			rs = sentencia.executeQuery("select * from Facturas");
			while (rs.next()) {
				Factura f1 = new Factura(rs.getInt("numero"), rs.getString("concepto"), rs.getDouble("importe"));
				lista.add(f1);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}finally {
			if (rs!=null) {
				try {
					rs.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			if (conexion!=null) {
				try {
					conexion.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			if (sentencia!=null) {
				try {
					sentencia.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
			}
			}
		}
		return lista;
	}
}
