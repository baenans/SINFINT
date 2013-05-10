@WebServlet(name = "SessionServlet", urlPatterns = {"/SessionServlet"}) 
public class SessionServlet extends HttpServlet { 
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException { 
		String nuevoAtributo = request.getParameter("parametro"); 
		String valor = request.getParameter("valor"); 
		String action = request.getParameter("accion"); 
		request.getParameter("accion"); 
		response.setContentType("text/html;charset=UTF-8"); 
		PrintWriter out = response.getWriter(); 
		response.getWriter(); 
		try { 
			out.println("<html>"); 
			out.println("<head>"); 
			out.println("<title>Servlet que muestra el contenido de la sesion</title>"); 
			out.println("</head>"); 
			out.println("<body>"); 
			out.println("<h1>El contenido de tu sesion es:</h1>"); 
			HttpSession s request.getSession(); 
			if (action.equals("invalidar")) { 
				s.invalidate(); 
				out.println("<h1>Sesion invalidada:</h1>"); 
			} else { 
				s.setAttribute(nuevoAtributo, valor); 
				out.println("<ul>"); 
				Enumeration<String> nombresDeAtributos = s.getAttributeNames(); 
				while (nombresDeAtributos.hasMoreElements()) { 
					String atributo = nombresDeAtributos.nextElement(); 
					out.println("<li><b>" + atributo + ": </b>" + s.getAttribute(atributo) + "</li>"); 
				} 
				out.println("</ul>"); 
				out.println("</ul>"); 
			} 
			out.println("<ahref=/contexto/tema6/FormularioSesion.html>"+ "Volver a la página anterior</a><br/>"); 
			out.println(request.getQueryString()); 
			out.println(request.getQueryString()); 
			out.println("</body>"); 
			out.println("</html>"); 
		} finally { 
			out.close(); 
		}
	}
}
