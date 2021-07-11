import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
    private String username = "zxc";
    private String password = "zxc";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("test/html; charset=utf-8");
        // 1.从请求中读取到用户名和密码
        //   浏览器是通过form提交的，用户名密码就会按照键值对的方式，通过body传输，username=zhangsan&password=123
        //   通过 getParameter 方法获取到用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(username == null || "".equals(username) || password == null || "".equals(password)){
            // 参数缺失了，认为登陆失败
            resp.setStatus(403);
            resp.getWriter().write("<h3>登陆失败！用户名或者密码为空！</h3>");
            return;
        }
        // 2.验证用户名和密码是否正确
        //  对于一般的网站，这里的匹配过程需要根据用户名，在数据库中查找相应的密码
        //  一方面查找用户名在数据库中是否存在，一方面检测查找到的用户名与密码是否匹配
        if(!username.equals(this.username) || !password.equals(this.password)){
            //登陆失败
            resp.setStatus(403);
            resp.getWriter().write("<h3>登陆失败！用户名或密码错误！</h3>");
        }
        // 3.服务器需要创建一个 “会话” 来保存当前的用户登录的状态
        HttpSession session = req.getSession(true);
        session.setAttribute("username", username);
        session.setAttribute("school", "西安工业大学");
        session.setAttribute("time", System.currentTimeMillis());
        session.setAttribute("visitCount", 0);
        // 4.登录成功，自动跳转到index.html
        resp.setStatus(200);
        resp.getWriter().write("<h3>登录成功！</h3>");
        resp.sendRedirect("index.html");
        //登录成功，等待3s再跳转
        //resp.setStatus(200);
        //String html = String.format("<h3>登陆成功! 3s 之后跳转到主页</h3>");
        //html += "<script> setTimeout(function() { location.assign(\"index.html\"); }, 3000); </script>";
        //resp.getWriter().write(html);

    }
}
