package com.example.webserver1.guessgame;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/guess")
public class GuessServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(true);
        GuessGame game = (GuessGame) session.getAttribute("game");

        if (game == null) {
            game = new GuessGame();
            session.setAttribute("game", game);
        }

        int guess = Integer.parseInt(req.getParameter("guessString"));
        String reply = game.makeGuess(guess);

        resp.setContentType("text/html");
        resp.getWriter().println("<html><body>");
        for (String s : game.getReplies()) {
            resp.getWriter().println(s + "<br/>");
        }
        resp.getWriter().println("Svar: " + reply +
              form +  "</body></html>");
    }
    String form = """
            <form action="/guess" method="post">
              <input type="text" name="guessString" size="8"/>
              <input type="submit" value="Guess!"/>
            </form>
            """;
}
