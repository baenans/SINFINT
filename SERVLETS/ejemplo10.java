@WebServlet(name = "JDBCServlet", urlPatterns = {"/JDBCServlet"})
public class JDBCServlet extends HttpServlet {
	private Statement statment = null;
	private Connection conexion = null;
	@Override
	public void init(ServletConfig config) {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			conexion = DriverManager.getConnection("jdbc:derby://localhost:1527/HOLAJDBC", "administrador","administrador");
			statment = conexion.createStatement();
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(JDBCServlet.class.getName()).log(Level.SEVERE, "No se pudo cargar el driver de la base de datos", ex);
		} catch (SQLException ex) {
			Logger.getLogger(JDBCServlet.class.getName()).log(Level.SEVERE, "No se pudo obtener la conexión a la base de datos", ex);
		}
	}
	void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no@Override protectedmbre = request.getParameter("nombre"); int edad;
		try {
			edad = Integer.parseInt(request.getParameter("edad"));
		} catch (NumberFormatException e) {
			edad = -1;
		}
		ServletContext contexto = request.getServletContext();
		String query = null;
		try {
			query = "insert into\"PERSONAS\" values('"+ nombre + "'," + edad + ")";
			synchronized(statment) {
				statment.executeUpdate(query);
			}
		} catch (SQLException ex) {
			gestionarErrorEnConsultaSQL(ex, request, response);
		}
		RequestDispatcher paginaAltas = contexto.getRequestDispatcher("/tema10/crearpersona.html");
		paginaAltas.forward(request, response);
	}
	private void gestionarErrorEnConsultaSQL(SQLException ex, HttpServletRequest request, HttpServletResponse response) throws OException, ServletException {
		ServletContext contexto = request.getServletContext();
		Logger.getLogger(JDBCServlet.class.getName()).log(Level.SEVERE, "No se pudo ejecutar la consulta contra la base de datos", ex);
		RequestDispatcher paginaError = contexto.getRequestDispatcher("/tema3/error.html");
		paginaError.forward(request, response);
	}
	@Override 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		response.setContentType("text/html;charset=UTF-8"); 
		PrintWriter out = response.getWriter(); 
		try { 
			out.println("<html>"); 
			out.println("<head>"); 
			out.println("<title>Servlet Listar Personas</title>"); 
			out.println("</head>"); 
			out.println("<body>"); 
			out.println("<h1>Lista de las personas:</h1>"); 
			out.println("<ul>"); 
			String query = null; 
			query = "select *" + "from \"PERSONAS\""; 
			ResultSet resultSet = null; 
			try { 
				synchronized(statment){ resultSet = statment.executeQuery(query); } 
			}
			while (resultSet.next()) { 
				out.println("<li>" + resultSet.getString("NOMBRE") + " edad: " + resultSet.getInt("EDAD") + "</li>"); 
			} 
		} catch (SQLException ex) { 
			gestionarErrorEnConsultaSQL(ex, request, response); 
		} finally { 
			if (resultSet != null) { 
				try { resultSet.close(); 
				} catch (SQLException ex) { 
					Logger.getLogger(JDBCServlet.class.getName()).log(Level.SEVERE, "No se pudo cerrar el Resulset", ex); 
				} 
			} 
		} 
		out.println("</ul>"); 
		out.println("</body>"); 
		out.println("</html>"); 
		} finally { 
		out.close(); 
		} 
	} 
	@Override 
	public void destroy (){ 
		try { 
			statment.close(); 
		} catch (SQLException ex) { 
			Logger.getLogger(JDBCServlet.class.getName()).log(Level.SEVERE, 
			"No se pudo cerrar el objeto Statement", ex); 
		} finally { 
			try { 
				conexion.close(); 
			} catch (SQLException ex) { 
				Logger.getLogger(JDBCServlet.class.getName()). 
				log(Level.SEVERE, "No se pudo cerrar el objeto Conexion", ex); 
			} 
		} 
	} 
}
