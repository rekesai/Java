import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/index")
public class indexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        // 判断用户是否登录
        HttpSession session = req.getSession(false);
        if(session == null){
            // 当前未登录
//            resp.setStatus(403);
//            resp.getWriter().write("<h3>当前尚未登录！</h3>");
            // 当前未登录，自动跳转到login.html
            resp.sendRedirect("login.html");
            return;
        }
        // 2.已经登陆过了，把之前登陆成功后在 Session 中存的数据取出来展示到页面上
        String userName = (String)session.getAttribute("userName");
        String school = (String)session.getAttribute("school");
        Long time = (Long)session.getAttribute("time");
        // 访问index.html的时候，需要针对这个 访问次数visitCount 进行累加
        Integer visitCount = (Integer)session.getAttribute("visitCount");
        visitCount += 1;
        session.setAttribute("visitCount", visitCount);
        // 3.在页面上显示
        String html = String.format("<div>欢迎您！ %s</div>", userName);
        html += String.format("<div>学校：%s</div>", school);
        html += String.format("<div>上次登录时间： %d</div>", time);
        html += String.format("<div>访问次数： %d</div>", visitCount);
        resp.getWriter().write(html);
    }
}