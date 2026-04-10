

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String city = request.getParameter("city");
		
		Model model = new Model();
		model.setUsername(name);
		model.setEmail(email);
		model.setPassword(password);
		model.setCity(city);
		
		int row = model.register();
		HttpSession session = request.getSession();
		session.setAttribute("name",name);
		if (row==0) {
			response.sendRedirect("/RegistrationAppMVC/failure.jsp");
		} else {
			response.sendRedirect("/RegistrationAppMVC/success.jsp");
		}
		
		
		
	}

}
