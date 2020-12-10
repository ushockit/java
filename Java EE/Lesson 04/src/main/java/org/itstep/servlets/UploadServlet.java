package org.itstep.servlets;

import org.apache.log4j.Logger;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    static final Logger logger = Logger.getLogger(UploadServlet.class);
    final String VIEWS = "/WEB-INF/views/";
    final String UPLOADS = "/uploads";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher(VIEWS + "/upload.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {



        ServletContext ctx = req.getServletContext();
        //получение полного пути к папке с файлами
        String uploadPath = ctx.getRealPath(UPLOADS);

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        Part part = req.getPart("image");
        String s = part.getSubmittedFileName();
        String contentDisposition = part.getHeader("content-disposition");

        Pattern pattern = Pattern.compile("filename=\\\"(?<filename>.+)?\\\"");
        Matcher matcher = pattern.matcher(contentDisposition);
        matcher.find();
        String filename = matcher.group()
                .replace("\"", " ")
                .split("=")[1]
                .trim();

        filename = filename.substring(filename.lastIndexOf("\\") + 1);

        //Сохранение
        Path savePath = Paths.get(uploadPath, filename);
        Files.copy(part.getInputStream(), savePath);

        resp.sendRedirect("/upload");
    }
}
