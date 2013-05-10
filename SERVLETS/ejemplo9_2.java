@WebServlet(name="ListarArticulosServlet", urlPatterns={"/ListarArticulosServlet"})
public class ListarArticulosServlet extends HttpServlet {
	protected void processRequest(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		ServletContext contexto = request.getServletContext();
		List<String> lista = (List<String>)
		contexto.getAttribute("lista");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet ListarArticulosServlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Lista:</h1>");
			out.println("<ul>");
			if (lista != null) {
				for (String articulo : lista) {
					out.println("<li>" + articulo + "</li>");
				}
			}
			out.println("</ul>");
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close();
		}
	}
}
