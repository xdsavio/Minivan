package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletCancelar
 */
@WebServlet("/ServletCancelar")
public class ServletCancelar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletCancelar() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				response.getWriter().append("Served at: ").append(request.getContextPath());
				
				Comprar comprar = new Comprar();
		       
				CancelarDAO cancelardao = new CancelarDAO();
				
				comprar.setNome(request.getParameter("nome"));
				comprar.setIdade(request.getParameter("idade"));
				comprar.setCodido(request.getParameter("codigo")); 
				
				try {
					
					cancelardao.delete(comprar);
					cancelardao.disconnect();
					
				} catch (SQLException e) {
					
					System.out.println("Vá andando");
				}
				
				response.sendRedirect("boleto.html");
	}
	
	}


