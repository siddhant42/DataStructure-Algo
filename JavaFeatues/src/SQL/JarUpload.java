package SQL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class JarUpload {

	public static void main(String[] args) {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
			String url = "http://localhost:8085/nexus/content/repositories/releases";
			String jarpath = "G:/ProjectDetails/Eriks/SDK/PIM_8.0_SDK/targets/8.0.03.00/plugins/";
			String repositoryID = "internal";
			String mvn = "mvn deploy:deploy-file -DgroupId=groupName -DartifactId=jarName"
					+ " -Dversion=versionVal -DgeneratePom=true -Dpackaging=jar -DrepositoryId=" + repositoryID
					+ " -Durl=" + url + " -Dfile=" + jarpath + "jarName_versionVal.jar";
			DocumentBuilder db = dbf.newDocumentBuilder();
			// Map map=new HashMap<String,String>();
			List success = new ArrayList<String>();
			List fail = new ArrayList<String>();
			Document dom = db.parse("H:/work/JavaFeatues/src/SQL/artifacts.xml");
			Element docEle = dom.getDocumentElement();
			NodeList nl = docEle.getElementsByTagName("artifact");
			if (nl != null && nl.getLength() > 0) {
				for (int i = 0; i < nl.getLength(); i++) { // nl.getLength()

					String command = mvn;
					Element el = (Element) nl.item(i);
					String groupName = el.getAttribute("classifier");
					String versionVal = el.getAttribute("version");
					String jarName = el.getAttribute("id");
					command = command.replaceAll("groupName", groupName);
					command = command.replaceAll("versionVal", versionVal);
					command = command.replaceAll("jarName", jarName);
					System.out.println("********command**********" + command);
					// try {
					Process p = Runtime.getRuntime().exec("cmd /c " + command);

					// p.waitFor();
					StringBuilder strb = new StringBuilder();
					BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
					String line = reader.readLine();
					while (line != null) {
						strb.append(line);
						line = reader.readLine();
					}
					System.out.println(strb);
					if (strb.indexOf("BUILD FAILURE") == -1)
						success.add(jarName);
					else
						fail.add(jarName);
					//
					// map.put(jarName, groupName+","+versionVal);
				}
			}
			System.out.println(" \n\nSuccessfully Jar uplaod :: " + success);
			System.out.println(" Fail to uplaod jar :: " + fail);

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (SAXException se) {
			se.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
