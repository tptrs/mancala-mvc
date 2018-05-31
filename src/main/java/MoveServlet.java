

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import nl.sogyo.mancalamaven.Mancala;
import nl.sogyo.mancalamaven.domain.Bowl;
        
public class MoveServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int clickedBowl = Integer.parseInt(req.getParameter("bowl"));
        HttpSession session = req.getSession();
        Mancala mancala = (Mancala) session.getAttribute("mancala");
        Bowl activeBowl = (Bowl) mancala.getBowls().get(clickedBowl-1);
        activeBowl.emptyAndPassStones();
        
        RequestDispatcher rd;
        
        if(mancala.gameOver()){
            rd = req.getRequestDispatcher("endGame.jsp");
        }else{
            rd = req.getRequestDispatcher("pagina.jsp");
        }
        
        rd.forward(req, resp);
    }
    
}