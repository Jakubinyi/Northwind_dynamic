package servlet;

import dao.DatabaseNorthwind;
import org.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jakubinyi on 2017.05.25..
 */
@WebServlet("/query")
public class QueryServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("text");

        DatabaseNorthwind databaseNorthwind = new DatabaseNorthwind();

        JSONArray jsonArray = databaseNorthwind.executeQuery(query);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(jsonArray);
    }
}
