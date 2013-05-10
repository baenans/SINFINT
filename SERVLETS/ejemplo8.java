@WebServlet(name="AutenticacionServlet", urlPatterns={"/AutenticacionServlet"})
public class AutenticacionServlet extends HttpServlet {
	private String passwordAdministrador; ...
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
	String usuario = request.getParameter("usuario");
	String password = request.getParameter("password");
	String elemento = request.getParameter("elemento");
	ServletContext contexto = request.getServletContext();
	If (usuario!= null && usuario.equals("administrador") && password.equals(passwordAdministrador)){
		request.setAttribute("autenticado", true); request.setAttribute("elemento");
		RequestDispatcher anhadirServlet = contexto.getNamedDispatcher("AnhadiArticuloServlet");
		anhadirServlet.forward(request, response);
	} else {
		RequestDispatcher paginaError =contexto.getRequestDispatcher("/tema7/error.html");
		paginaError.forward(request, response);
	}
	@Override
	public void init(ServletConfig config) {
		String ficheroUsuarios = config.getInitParameter("ficheroUsuarios");
		ServletContext contexto = config.getServletContext();
		InputStream is = contexto.getResourceAsStream(ficheroUsuarios);
		Properties ficheroPropiedades = new Properties ();
		try {
			ficheroPropiedades.load(is);
			passwordAdministrador = ficheroPropiedades.getProperty("administradorPassword");
		} catch (Exception ex){
			Logger.getLogger(AutenticacionServlet.class.getName()).log( Level.SEVERE, "No se pudo cargar el fichero con los password", ex);
		}
	}
}
