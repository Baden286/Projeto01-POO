package br.com.fatecpg;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class juroSimples extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            
            
            out.println("<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css' integrity='sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO' crossorigin='anonymous'>");
            out.println("<script src='https://code.jquery.com/jquery-3.3.1.slim.min.js' integrity='sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo' crossorigin='anonymous'></script>");
            out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js' integrity='sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49' crossorigin='anonymous'></script>");
            out.println("<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js' integrity='sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy' crossorigin='anonymous'></script>");
        

            
            
            out.println("<title>Servlet Simples</title>"); 
            
            out.println("</head>");
            out.println("<body class='container'>");
            
            out.println("<center>");
            out.println("<br>");
            out.println("<h3>Juros Simples</h3>");
            out.println("<br><hr>");
         
             out.println("<table border='1'>");

             out.println("<form>");
                      out.println("<tr>");
             out.println("<td>Digite o Capital</td> "+"<td><input type='text' size='60' name='c' placeholder='capital aplicado'></td>"); 
                      out.println("</tr>");
                     
                      out.println("<tr>");
             out.println("<td>Digite a taxa %</td> "+"<td><input type='text' size='60' name='i' placeholder='(ex. Para 2% digite 0.2)'></td>"); 
                      out.println("</tr>");
                      
                      out.println("<tr>");
             out.println("<td>Digite as Parcelas</td> "+"<td><input type='text' size='60' name='t' placeholder='Quantidade de meses'></td>");
                      out.println("</tr>");
                      
                      out.println("<tr>");
             out.println("<td><input type='submit' value='Enviar'></td>"); 
                      out.println("<tr>");

             out.println("</form>");
             out.println("</table>");

            out.println("<br><hr>");
          
             double c = Double.parseDouble(request.getParameter("c"));
             double i = Double.parseDouble(request.getParameter("i"));
             double t = Double.parseDouble(request.getParameter("t"));
             double m,j; 
             
             j=c*i*t;
             m=j+c;

             DecimalFormat deci = new DecimalFormat("0.00");

            out.println("<h2 style='text-align:center'>"+"0 valor total de juros é: "+ deci.format(j)+"</h2>");
            out.println("<h2 style='text-align:center'>"+"0 valor do Montante é: "+ deci.format(m)+"</h2>");
            out.println("<form action='index.html'>");
            out.println("<input type='submit' value='Voltar' style='text-align:center'>");
            out.println("</form>");
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}