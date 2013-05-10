// Ejemplo de Servlet que procesa un formulario.
public class FormulariotServlet extends HttpServlet {
	protected void processRequest(HttpServletRequest request,
	HttpServletResponse response)
	throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String edad = request.getParameter("edad");
		String[] hobbies = request.getParameterValues("hobbies");
		String[] request.getParameterValues("hobbies");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet que procesa un formulario basico</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>" + "Hola " + nombre + " " + apellidos+ "</h1>");
			out.println("Tu Franja de edad es " + edad + " y tus hobbies son:");
			out.println("<ul>");
			for (String hobby : hobbies) {
				out.println("<li>" + hobby + "</li>");
			}
			out.println("</ul>");
			out.println("Este formulario ha sido invocado con los siguientes parametros:<br/>");
			out.println(request.getQueryString());
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close();
		}
	}
}
