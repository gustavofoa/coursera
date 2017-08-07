import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/traduzir")
public class TradutorController extends HttpServlet {

	private static final long serialVersionUID = 2661638371842942558L;
	
	private Tradutor tradutor;
	
	@Override
	public void init() throws ServletException {
		tradutor = new Tradutor();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String palavra = request.getParameter("palavra");
		String palavraTraduzida = tradutor.traduzir(palavra);
		
		request.setAttribute("palavra", palavra);
		request.setAttribute("palavraTraduzida", palavraTraduzida);
		
		request.getRequestDispatcher("tradutor-view.jsp").forward(request, response);
	}

}
