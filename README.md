Developer Guide

1.	General
This is a module which can create reports file with 3 extnesions (docx,pdf, xls). Module base on jasper report. The module include 2 main class. They are ModuleConfig class and Report class
2.	ModuleConfig class
The class will be load config info from a file. The file config is put at resource folder. We will put path of folder with contain .jrxml file.
 Src/main/resource/report.propeties
3.	Report class
The class will create a report. It include a main method.
Createreport(HashMap<String,Object> data,boolean isCompiled,String reportType)
-	Data : a map contain param and data for filling report. The map must have follow rules:
o	Must contain a key with name is “reportName” – value of the key will be use for named report files, jrxml, jasper.
o	If the map contains lists data, keys for the lists must begin with “list_”
-	IsComplied : check whether compiled jrxml to jasper or not
-	 reportType : specify type of report which you want (pdf,docx,xls)
4.	Design Report
When you design a report, all parameter name of the report must be same key name of the Map which is passed to createreport().
5.	Test App
Development Environment : java, maven,tomcat7
The web app just have a index page. The page include a textfile and a button.
You type reportType which you want and click button. It will be generate a report and return path of the report file.
 
 

