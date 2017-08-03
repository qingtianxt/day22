package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * �ļ��ϴ�
 */
public class Demo1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String username = request.getParameter("username");
		String f = request.getParameter("f");
		System.out.println(username);
		System.out.println(f);*/
		
		//���������ļ��򹤳�
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		//���������ϴ�����
		ServletFileUpload upload = new ServletFileUpload(factory);
		//��������
		try {
			List<FileItem> list = upload.parseRequest(request);
			//����list
			
			for (FileItem fi : list) {
				//�ж�����ͨ�ϴ���������ļ��ϴ����
				if(fi.isFormField()){
					//��ͨ�ϴ����
					//��ȡname����
					String name = fi.getFieldName();
				
					
					//��ȡֵ
					String string = fi.getString("utf-8");
					
					System.out.println(name+"::"+string);
				}
				else{
					//�ļ��ϴ�
					//��ȡname����
					String fieldName = fi.getFieldName();//fieldname��ȡ����name������ֵ
					
					//��ȡ�ļ���
					String name = fi.getName();//name���Ի�ȡ�����ļ���
					
					//��ȡ�ļ�����
					InputStream is = fi.getInputStream();
					
					System.out.println(fieldName+"::"+name+"::"+is);
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
