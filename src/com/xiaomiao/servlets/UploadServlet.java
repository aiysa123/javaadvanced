package com.xiaomiao.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet(name="upload",urlPatterns = {"/uploadFile"})
@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=GBK");

        PrintWriter out = resp.getWriter();
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        out.println("普通的name参数为：" + name + "<br/>");
        //获取文件上传域
        Part part = req.getPart("file");
        //获取上传文件的文件类型
        out.println("上传文件类型为：" + part.getContentType() + "<br/>");
        //获取上传文件的大小
        out.println("上传文件的大小为：" + part.getSize() + "<br/>");
        //获取该文件上传域中的Header Name
        Collection<String> headerNames = part.getHeaderNames();
        //遍历上传文件域的Header Name,Value
        for (String headerName : headerNames){
            out.println("headerName-->" + part.getHeader(headerName) + "<br/>");
        }
        //获取包含原始文件名的字符串
        String fileNameInfo = part.getHeader("content-disposition");
        //提取上传文件的原始文件名
        String filename = fileNameInfo.substring(fileNameInfo.lastIndexOf("filename=\"") + 10,fileNameInfo.length() - 1);
        part.write(getServletContext().getRealPath("/uploadFiles") + "/" + filename);
    }
}
