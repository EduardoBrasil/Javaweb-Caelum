package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import javax.xml.ws.http.HTTPException;


@WebServlet("/contador")
public class ContadorServlet extends HttpServlet{

	private int contador = 0;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		log("Iniciando servlet");
	}
	
	public void destroy() {
		super.destroy();
		log("Destruindo a servlet");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	contador++;
	
	PrintWriter out = response.getWriter();
	
	 out.println("<html>");
     out.println("<body>");
     out.println("Contador agora é: " + contador);
     out.println("</body>");
     out.println("</html>");
	}
}
