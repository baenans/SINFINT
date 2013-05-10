// Ejemplo de código de un Servlet que genera una respuesta al usuario donde se muestran todas las cabeceras 
// de la petición http que ha recibido y el primero de sus valores.
@WebServlet(name="CabecerasServlet", urlPatterns={"/cabeceras"})
public class CabecerasServlet extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet CabecerasServlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Cabeceras: </h1>");
			out.println("<ul>");
			Enumeration<String> nombresDeCabeceras = Enumeration<String> request.getHeaderNames();
			while (nombresDeCabeceras.hasMoreElements()) {
				String cabecera = nombresDeCabeceras.nextElement();
				out.println("<li><b>" + cabecera + ": </b>" + request.getHeader(cabecera) + "</li>");
			}
			out.println("</ul>");
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close();
		}
		@Override
		protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
			processRequest(request, response);
		}
		@Override
		protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
			processRequest(request, response);
		}
	}
}
