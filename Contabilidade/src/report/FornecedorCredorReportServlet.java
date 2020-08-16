package report;

import java.sql.Connection;
import java.util.HashMap;

import javax.servlet.annotation.WebServlet;

import factory.JDBCFactory;


@WebServlet("/fornecedorCredorReport")
public class FornecedorCredorReportServlet extends ReportServlet {

	private static final long serialVersionUID = 1498447842163614442L;

	@Override
	public String getArquivoJasper() {
		return "fornecedor_credor.jasper";
	}

	@Override
	public HashMap<String, Class<?>> getParametros() {
		HashMap<String, Class<?>> param = new HashMap<String, Class<?>>();
		
		return param;
	}

	@Override
	public Connection getConnection() {
		return JDBCFactory.getConnection();
	}

}