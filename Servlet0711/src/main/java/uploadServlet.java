import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@MultipartConfig
@WebServlet("/upload")
public class uploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.通过req.getPart 能够拿到一个 Part 对象
        //  一个Part对象就对应到一个上传的文件
        //  一个Http请求中可以有多个Part
        //  当前只考虑一个文件
        Part part = req.getPart("image");
        System.out.println(part.getName()); // image, input 的 name
        System.out.println(part.getSubmittedFileName()); // rose.jpg
        System.out.println(part.getSize()); // 图片的长度(字节数)
        System.out.println(part.getContentType()); // 文件的格式.
        // 2. 就可以把 part 里的内容给存储到某个路径中.
        part.write("d:/leesin.jpg");
        // 3. 返回一个响应内容.
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write("<h3>上传图片成功</h3>");
    }
}
