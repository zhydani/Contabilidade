package report;

import java.sql.Connection;
import java.util.HashMap;

import javax.servlet.annotation.WebServlet;

import factory.JDBCFactory;


@WebServlet("/alunosCidadeReport")
public class AlunosCidadeReportServlet extends ReportServlet {

	private static final long serialVersionUID = 1498447842163614442L;

	@Override
	public String getArquivoJasper() {
		return "Alunos_Cidade.jasper";
	}

	@Override
	public HashMap<String, Class<?>> getParametros() {
		HashMap<String, Class<?>> param = new HashMap<String, Class<?>>();
		param.put("ID_CIDADE", Integer.class);
		return param;
	}

	@Override
	public Connection getConnection() {
		return JDBCFactory.getConnection();
	}

}