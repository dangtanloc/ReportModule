package com.report.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.report.logic.Report;
import com.report.model.Factory;

/**
 * Servlet implementation class Reportservlet
 */
public class Reportservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Reportservlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	public String createReportFile(String reportType) throws IOException {

		// create test data
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("reportName", "helloworld");
		data.put("name", "Đặng Tấn Lộc");
		data.put("cmnd", "123456789");
		data.put("sex", "nam");
		data.put("passport", "123456789");
		data.put("addressOne", "Hà nội");
		data.put("addresstwo", "Hồ Chí Minh");
		data.put("list_nguoiphuthuoc", Factory.createBeanCollection());

		String path = Report.createreport(data, true, reportType);

		return path;
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) {

		// demo how to generate a report
		// Set response content type
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		// Actual logic goes here.

		try {
			ServletOutputStream out = response.getOutputStream();
			try {
				String reportType = request.getParameter("reportType");

				out.println("<h1>" + "printpdf" + createReportFile(reportType)
						+ "</h1>");

			} finally {
				out.close();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
