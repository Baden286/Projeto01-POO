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
            
            out.println("<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css' integrity='sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO' crossorigin='anonymous'>");
            out.println("<script src='https://code.jquery.com/jquery-3.3.1.slim.min.js' integrity='sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo' crossorigin='anonymous'></script>");
            out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js' integrity='sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49' crossorigin='anonymous'></script>");
            out.println("<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js' integrity='sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy' crossorigin='anonymous'></script>");
        

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
            out.println("<br>");
            out.println("<h3>");         
            out.println("Juros Compostos");
            out.println("</h3>");
            
            out.println("</center>");
            
            out.println("<center>");
          
            out.println("<form>");
            
            
            out.println("<Table style='width: 50%' border='3'>");
                                
            out.println("<tr>");
            out.println("<td colspan='3'>");
            out.println("<label class='px-2' >Capital (R$):</label>");
            out.println("</td>");
            out.println("<td colspan='2'>");
            out.println("<input class='w-100' type='number' step='0.01' name='c' maxlength='20' placeholder='ex:2500,25'"+c+"'/>");
            out.println("</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td colspan='3'>");
            out.println("<label class='px-2'>Taxa de Juros (%):</label>");
            out.println("</td>");
            out.println("<td colspan='2'>");
            out.println("<input class='w-100' type='number' step='0.01' name='t' maxlength='20' placeholder='ex:15,5'"+t+"'/>");
            out.println("</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td colspan='3'>");
            out.println("<label class='px-2'>Número de Períodos (Meses):</label>");
            out.println("</td>");
            out.println("<td colspan='2'>");
            out.println("<input class='w-100' type='number' name='n' maxlength='20' placeholder='ex:12'"+n+"'/>");
            out.println("</td>");
            out.println("</tr>");           
            
            out.println("<tr>");
            out.println("<td colspan='5' align=center>");
            out.println("<p><input class='btn btn-success font-weight-bold mr-5 mt-3' type='submit' value='Calcular'/><input class='btn btn-success font-weight-bold mt-3' type='button' value='Voltar' onclick=\"location.href='index.html'\"/>");
            out.println("</td>");
            out.println("</tr>");
            
                
            
            float auxc=0, auxjm=0, cf=0;
            cf = c;
            auxc = c;
            
                out.println("<tr style='background-color: #cc9'>");
                out.println("<td align=center><b>MÊS</td>");
                out.println("<td align=center><b>APORTE</td>");
                out.println("<td align=center><b>JUROS MENSAL</td>");
                out.println("<td align=center><b>JUROS TOTAL</td>");
                out.println("<td align=center><b>ACUMULADO</td>");
                out.println("</tr>");
            
            
            for(int i=1; i<=n; i++){
                Float m = (c * (1 + (t / 100)));    
               
                out.println("<td align=center>"+ i +"</td>");
                out.println("<td align=right>"+ cm.format(auxc) +"</td>");
                out.println("<td align=right>"+ cm.format(m-auxc - (auxjm))+"</td>");
                out.println("<td align=right>"+ cm.format(m-auxc) +"</td>");
                out.println("<td align=right>"+ cm.format(m) +"</td>");
                c = m;
                auxjm = m-auxc;
                out.println("</tr>");
            }
           
            
            out.println("</tr>");
            
            out.println("</Table>");
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
