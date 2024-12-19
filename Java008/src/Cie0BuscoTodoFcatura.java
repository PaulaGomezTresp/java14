import java.util.ArrayList;

public class Cie0BuscoTodoFcatura {

	public static void main(String[] args) {
		
		FacturaRepository repo=new FacturaRepository();
		ArrayList<Factura> lista= repo.buscarTodos();
		for (Factura f1:lista) {
			System.out.print(f1.getNumero()+".- ");
			System.out.print(f1.getConcepto()+" : ");
			System.out.println(f1.getImporte()+"€");
		}
	}

}
