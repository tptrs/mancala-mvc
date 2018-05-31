

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import nl.sogyo.mancalamaven.Mancala;
import nl.sogyo.mancalamaven.domain.Bowl;
        
public class SomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Mancala mancala = new Mancala(4);
        HttpSession session = req.getSession();
        session.setAttribute("mancala", mancala);
        for(int i = 0; i < 14; i++){
            session.setAttribute("Field" + (i + 1), mancala.getBowls().get(i));
        }
        
        session.setAttribute("Player1", mancala.getBowls().get(0).getOwner());
        
        RequestDispatcher rd = req.getRequestDispatcher("pagina.jsp");
        rd.forward(req, resp);
    }
    
}