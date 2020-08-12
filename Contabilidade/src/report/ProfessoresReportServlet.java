package report;

import java.sql.Connection;
import java.util.HashMap;

import javax.servlet.annotation.WebServlet;

import factory.JDBCFactory;


@WebServlet("/professoresReport")
public class ProfessoresReportServlet extends ReportServlet {

	private static final long serialVersionUID = 1498447842163614442L;

	@Override
	public String getArquivoJasper() {
		return "Professores.jasper";
	}

	@Override
	public HashMap<String, Class<?>> getParametros() {
		return null;
//		HashMap<String, Class<?>> param = new HashMap<String, Class<?>>();
//		param.put("NOME_CIDADE", String.class);
//		return param;
	}

	@Override
	public Connection getConnection() {
		return JDBCFactory.getConnection();
	}

}