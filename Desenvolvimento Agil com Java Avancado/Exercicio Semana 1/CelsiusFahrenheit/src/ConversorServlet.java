

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/ConversorServlet")
public class ConversorServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		String value = request.getParameter("value");
		
		if(type.equals("CelsiusToFahrenheit")){
			Double valorCelsius = Double.parseDouble(value);
			Double valorFahrenheit = 1.8*valorCelsius+32;
			response.getWriter()
			.append(value)
			.append(" graus Celsius equivale a ")
			.append(String.format("%.0f", valorFahrenheit))
			.append(" Fahrenheit!");
		} else if(type.equals("FahrenheitToCelsius")){
			Double valorFahrenheit = Double.parseDouble(value);
			Double valorCelsius = (valorFahrenheit-32)/1.8;
			response.getWriter()
			.append(value)
			.append(" Fahrenheit equivale a ")
			.append(String.format("%.0f", valorCelsius))
			.append(" graus Celsius!");
		}
		
		
		
	}

}
