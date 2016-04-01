package com.report.logic;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

/**
 * for generate report
 * @author Po Dang
 *
 */
public class Report {

	static final public String PDF_TYPE = "pdf";
	static final public String XLS_TYPE = "xls";
	static final public String DOCX_TYPE = "docx";
	static final public String REPORT_PATH="reportpath";
	static final public String REPORT_NAME="reportName";
	static final public String LIST_PREFIX="list_";
	
	
	static public String createreport(HashMap<String, Object> data,
			boolean isCompile, String reportType) {

		// load config
		Properties appconfig = ModuleConfig.getinstance();
		// get report file name
		String reportName = (String) data.get(REPORT_NAME);
		// create data sources
		Set<String> key_parama = data.keySet();
		for (String key : key_parama) {
			if (key.startsWith(LIST_PREFIX)) {
				JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(
						(Collection<?>) data.get(key));
				data.put(key, ds);
			}
		}

		try {
			if (isCompile) {
				JasperDesign jasperDesign = JRXmlLoader
						.load(appconfig.getProperty(REPORT_PATH)
								+ reportName + ".jrxml");
				JasperReport bill = JasperCompileManager
						.compileReport(jasperDesign);
				JRSaver.saveObject(bill,
						appconfig.getProperty(REPORT_PATH) + reportName
								+ ".jasper");
			}

			data.put("IS_IGNORE_PAGINATION", true);

			JasperReport jasperReport = (JasperReport) JRLoader
					.loadObject(new File(appconfig
							.getProperty(REPORT_PATH)
							+ reportName
							+ ".jasper"));

			JasperPrint jasperPrint = JasperFillManager.fillReport(
					jasperReport, data, new JREmptyDataSource());

			if (Report.PDF_TYPE.equals(reportType)) {
				return writePDF(reportName, appconfig, jasperPrint);
			} else if (Report.DOCX_TYPE.equals(reportType)) {
				return writeDOCX(reportName, appconfig, jasperPrint);
			} else if (Report.XLS_TYPE.equals(reportType)) {
				return writeXLS(reportName, appconfig, jasperPrint);
			}

		} catch (Throwable e) {
			e.printStackTrace();
		}

		return "Don't support the file type";
	}

	static private String writePDF(String reportName, Properties appconfig,
			JasperPrint jasperPrint) {
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			FileOutputStream fos = new FileOutputStream(new File(
					appconfig.getProperty(REPORT_PATH) + reportName
							+ ".pdf"));
			try {
				JRPdfExporter exporter = new JRPdfExporter();
				exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
				exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(
						out));
				exporter.exportReport();
				out.writeTo(fos);
				return appconfig.getProperty(REPORT_PATH) + reportName
						+ ".pdf";
			} catch (JRException e) {
				e.printStackTrace();
			} finally {
				fos.close();
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "failed";
	}

	static private String writeDOCX(String reportName, Properties appconfig,
			JasperPrint jasperPrint) {
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			FileOutputStream fos = new FileOutputStream(new File(
					appconfig.getProperty(REPORT_PATH) + reportName
							+ ".docx"));
			try {
				JRDocxExporter exporter = new JRDocxExporter();
				exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
				exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(
						out));
				exporter.exportReport();
				out.writeTo(fos);
				return appconfig.getProperty(REPORT_PATH) + reportName
						+ ".docx";
			} catch (JRException e) {
				e.printStackTrace();
			} finally {
				fos.close();
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "failed";
	}

	static private String writeXLS(String reportName, Properties appconfig,
			JasperPrint jasperPrint) {
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			FileOutputStream fos = new FileOutputStream(new File(
					appconfig.getProperty(REPORT_PATH) + reportName
							+ ".xls"));
			try {
				JRXlsExporter exporter = new JRXlsExporter();
				exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
				exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(
						out));
				exporter.exportReport();
				out.writeTo(fos);
				return appconfig.getProperty(REPORT_PATH) + reportName
						+ ".xls";
			} catch (JRException e) {
				e.printStackTrace();
			} finally {
				fos.close();
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "failed";
	}

}
