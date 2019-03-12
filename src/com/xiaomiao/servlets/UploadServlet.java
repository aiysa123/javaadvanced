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
        out.println("��ͨ��name����Ϊ��" + name + "<br/>");
        //��ȡ�ļ��ϴ���
        Part part = req.getPart("file");
        //��ȡ�ϴ��ļ����ļ�����
        out.println("�ϴ��ļ�����Ϊ��" + part.getContentType() + "<br/>");
        //��ȡ�ϴ��ļ��Ĵ�С
        out.println("�ϴ��ļ��Ĵ�СΪ��" + part.getSize() + "<br/>");
        //��ȡ���ļ��ϴ����е�Header Name
        Collection<String> headerNames = part.getHeaderNames();
        //�����ϴ��ļ����Header Name,Value
        for (String headerName : headerNames){
            out.println("headerName-->" + part.getHeader(headerName) + "<br/>");
        }
        //��ȡ����ԭʼ�ļ������ַ���
        String fileNameInfo = part.getHeader("content-disposition");
        //��ȡ�ϴ��ļ���ԭʼ�ļ���
        String filename = fileNameInfo.substring(fileNameInfo.lastIndexOf("filename=\"") + 10,fileNameInfo.length() - 1);
        part.write(getServletContext().getRealPath("/uploadFiles") + "/" + filename);
    }
}
