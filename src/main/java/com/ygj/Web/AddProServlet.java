package com.ygj.Web;

import com.ygj.Dao.ProDao;
import com.ygj.Model.Product;
import com.ygj.Model.Type;
import com.ygj.Service.ProService;
import com.ygj.Service.Service;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

/**
 * @Author 微风
 * @Version 1.0.1
 * @StartTime Start
 * @EndTime End
 */
@WebServlet(name = "AddProServlet",urlPatterns = "/addpro")
public class AddProServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        Service ss=new Service();
            Product product=new Product();
            if (ServletFileUpload.isMultipartContent(req))//判断数据是否为多段数据(只有多段数据，才是文件上传)
            {
                FileItemFactory fileItemFactory = new DiskFileItemFactory();
                //创建用于解析上传数据的工具类ServletFileUpload类
                ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
                try {
                    List<FileItem> list = servletFileUpload.parseRequest(req);//解析上传的数据得到每一个表单项FileItem
                    //循环判断，每一个表单是普通类型还是上传文件
                    for (FileItem fi : list) {
                        if (fi.isFormField()) {
                            System.out.println("普通类型---" + fi.getFieldName() + "---" + "参数值" + fi.getString("UTF-8"));
                            if(fi.getFieldName().equals("name")){
                                product.setName(fi.getString("UTF-8"));
                            }
                            if(fi.getFieldName().equals("price")){
                                product.setPrice(Double.valueOf(fi.getString("UTF-8")));
                            }
                            if(fi.getFieldName().equals("num")){
                                product.setNum(Integer.parseInt(fi.getString("UTF-8")));
                            }
                            if(fi.getFieldName().equals("desc")){
                                product.setDesc(fi.getString("UTF-8"));
                            }
                            if(fi.getFieldName().equals("skills"))
                            {
                                int skillvalue = Integer.parseInt(fi.getString("UTF-8"));
                                Type type = ss.getTypeName(skillvalue);
                                product.setType(type);
                                System.out.println("Type的id为:"+type.getTypeId());
                            }
                        }
                        else{//不是普通类型
                            System.out.println("图片的名称:"+fi.getName());
                            product.setImg(fi.getName());
                            System.out.println("文件上传---" + fi.getFieldName() + "---" + fi.getName());
                            fi.write(new File("F:\\java\\YGJTest\\web\\image\\"+fi.getName()));
                            //product.setImg("F:\\java\\YGJTest\\target\\classes\\image"+fi.getName());
                            //fi.write(new File("F:\\java\\YGJTest\\web\\image\\"+fi.getName()));
                        }
                    }
                }
                catch (FileUploadException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            ProService ps=new ProService();
            int i = ps.insetPro(product);
            if(i!=0){
                req.getRequestDispatcher("AddProSussce.jsp").forward(req,resp);
            }
            else{
                req.getRequestDispatcher("AddProfail.jsp").forward(req,resp);
            }
//        }
    }
}
