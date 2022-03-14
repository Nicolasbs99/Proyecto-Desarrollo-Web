package co.edu.javeriana.Proyecto;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Inicio")
public class PaginaInicio extends HttpServlet{

    @Override
    protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
        System.out.println("hola");
        ServletOutputStream o = arg1.getOutputStream();
        o.println("Juego Desarrollo Web");
    }
    
}
