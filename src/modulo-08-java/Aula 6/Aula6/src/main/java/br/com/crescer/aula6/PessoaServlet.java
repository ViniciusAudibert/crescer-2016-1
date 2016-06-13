package br.com.crescer.aula6;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vinicius.audibert
 */
@WebServlet(name = "pessoa", urlPatterns = {"/pessoa"})
public class PessoaServlet extends HttpServlet {

    String html = "";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(resp, req);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           process(response,request);
    }
        private void process (HttpServletResponse response, HttpServletRequest request) throws IOException{
            response.setContentType("text/html");
            try(final PrintWriter out = response.getWriter();){
                out.append(request.getParameter("pessoa.nome"));
                out.append(request.getParameter("pessoa.idade"));
                out.append(request.getParameter("pessoa.sexo"));
            }
        }

}
