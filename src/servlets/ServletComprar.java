package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletComprar")
public class ServletComprar extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletComprar() {
        super();
   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Comprar comprar = new Comprar();
		comprar.Codigo();
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
			
        ComprarDAO comprardao = new ComprarDao();
		
		comprar.setNome(request.getParameter("nome"));
		comprar.setIdade(request.getParameter("idade"));
         
		comprar.compararIdade();
		
        try {
			
			comprardao.insert(comprar);
			comprardao.disconnect();
			
		} catch (SQLException e) {
			
			System.out.println("Vá andando");
		}
		
		response.sendRedirect("Solado.html");

	}

	

}
