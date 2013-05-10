@WebServlet(name = "AnhadiArticuloServlet", urlPatterns = {"/AnhadiArticuloServlet"})
public class AnhadiArticuloServlet extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		ServletContext contexto = request.getServletContext();
		Boolean autenticado = (Boolean)
		request.getAttribute("autenticado");
		if (!autenticado) {
			RequestDispatcher paginaError = contexto.getRequestDispatcher("/tema7/error.html");
			paginaError.forward(request, response);
		} else {
			List<String> lista = (List<String>)
			contexto.getAttribute("lista");
			if (lista == null) {
				lista = new LinkedList<String>();
				contexto.setAttribute("lista", lista);
			}
			lista.add((String) request.getAttribute("elemento"));
			RequestDispatcher listarArticulosServlet =
			contexto.getNamedDispatcher("ListarArticulosServlet");
			listarArticulosServlet.forward(request, response);
		}
	}
}
