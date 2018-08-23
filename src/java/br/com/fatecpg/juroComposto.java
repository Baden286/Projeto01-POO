/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author acer
 */
public class juroComposto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet juroComposto</title>");            
            out.println("</head>");
            out.println("<body>");            
           
               float c = 0;
                try{ c = Float.parseFloat(request.getParameter("c"));
                }catch(Exception ex){}
                               
               float t = 0;
                try{ t = Float.parseFloat(request.getParameter("t"));
                }catch(Exception ex){}
               
               DecimalFormat cj = new DecimalFormat("#.00"); 
               DecimalFormat cm = new DecimalFormat("#.00");
               
               int n = 0;
                try{ n = Integer.parseInt(request.getParameter("n"));
                }catch(Exception ex){}
                           
            out.println("<center>");
           
            out.println("<h1>");         
            out.println("Juros Compostos");
            out.println("</h1>");
            
            out.println("</center>");
            
            out.println("<fieldset>");
            out.println("<legend>Juros Compostos</legend>");
            out.println("<form>");
            
            out.println("<p>");
            
            out.println("<Table>");
                                
            out.println("<tr>");
            out.println("<td align=right>");
            out.println("<label>Capital (R$):</label>");
            out.println("</td>");
            out.println("<td>");
            out.println("<input type='number' step='0.01' name='c' maxlength='20' placeholder='ex:2500,25'"+c+"'/>");
            out.println("</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td align=right>");
            out.println("<label>Taxa de Juros (%):</label>");
            out.println("</td>");
            out.println("<td>");
            out.println("<input type='number' step='0.01' name='t' maxlength='20' placeholder='ex:15,5'"+t+"'/>");
            
            out.println("</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td align=right>");
            out.println("<label>Número de Períodos (Meses):</label>");
            out.println("</td>");
            out.println("<td>");
            out.println("<input type='number' name='n' maxlength='20' placeholder='ex:12'"+n+"'/>");
            out.println("</td>");
            out.println("</tr>");
            
            
            
            out.println("<tr>");
            out.println("<td colspan='3' align=center>");
            out.println("<p><input type='submit' value='Calcular'/>");
            
            
            out.println("</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            
            
            float cf = 0;
            cf = c;
            
            for(int i=1; i<=n; i++){
                Float m = (c * (1 + (t / 100)));    
                out.println("<tr>");
                out.println("<td><b>Saldo da Parcela "+ i +" do Montante (R$): "+ cm.format(m) +"</td>");
                c = m;
                out.println("</tr>");
            }
          
            
            out.println("<td><b><br>Juros Composto Total do Período (R$): "+ cj.format(c - cf) +"</td>");
            
            out.println("</tr>");
            
            out.println("</Table>");
            out.println("</form>");
            out.println("</fieldset>");         
                        
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
