package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auxiliar.envio;

/**
 * Servlet implementation class EnviarEmail
 */
public class EnviarEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnviarEmail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String assunto = (String) request.getParameter("assunto");
		String corpo = (String) request.getParameter("corpo");
		String listaEmail = (String) request.getParameter("listaEmail");
		String quant = (String) request.getParameter("quant");
		String data = (String) request.getParameter("data");
		Integer a = new Integer(quant);
		String emailLogin = (String) request.getParameter("emailLogin");
		String senha = (String) request.getParameter("senha");
		String remetente = (String) request.getParameter("remetente");
		envio teste = new envio();
		

		teste.listaDeEnvio(listaEmail, assunto, corpo,a, emailLogin, senha, remetente);
		
		
		
		System.out.print(listaEmail + "\n" + corpo + "\n" + assunto);
		
		//String email[] = listaEmail.split(", |,");
		
	}

}
