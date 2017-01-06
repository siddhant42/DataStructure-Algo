package SQL;

import java.sql.*;

public class DBwork {

	public static void main(String[] args) {
		try {
			String app = "<parameter name=\"FilterGroupDeep\" class=\"java.lang.Boolean\" value=\"true\"/><parameter name=\"FilterRev\" class=\"java.lang.Long\" value=\"1\"/>";
			String concatResult = app.concat("<parameter name=\"EntityID\" class=\"java.lang.Short\" value=\"1100\"/>");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			/*Connection conn = DriverManager.getConnection(
					"jdbc:sqlserver://EBSI-OPT980-047:1433;databaseName=ERIKS_HPM_MAIN", "sid", "sid123");*/
			Connection conn = DriverManager.getConnection(
					"jdbc:sqlserver://PIM8PRDDB\\PIM8PRDDB:60996;databaseName=ERIKS_HPM_MAIN", "sqlpim8", "T3adC0m!2015nH87");
			if (!conn.isClosed())
				System.out.println("connected " + conn);
			Statement stmtbkp = conn.createStatement();
			String querybkp = "select * into AssortmentNew_bkp from AssortmentNew";
			stmtbkp.executeUpdate(querybkp);
			stmtbkp.close();
			Statement statement = conn.createStatement();
			String queryString = "select ID,Name,XML from [AssortmentNew] where XML like '%PPM4_RepArt_GetByCatID%' and XML like '%FilterClassSystemID%' order by Name";
			ResultSet rs = statement.executeQuery(queryString);
			while (rs.next()) {
				String id = rs.getString(1);
				String xml = rs.getString(3);
				// String xml="<stored-procedure>PPM4_RepArt_GetByCatID</stored-procedure><parameter name=\"EntityID\" class=\"java.lang.Short\" value=\"1100\"/><parameter name=\"FilterClassSystemID\" class=\"java.lang.Long\" value=\"11011\"/><parameter name=\"CatalogID\" class=\"java.lang.Long\" value=\"1\"/><parameter name=\"FilterClassGroupID\" class=\"java.lang.Long\" value=\"337178\"/><stored-procedure>PPM4_RepArt_GetByCatID</stored-procedure><parameter name=\"EntityID\" class=\"java.lang.Short\" value=\"1100\"/><parameter name=\"FilterClassSystemID\" class=\"java.lang.Long\" value=\"11011\"/><parameter name=\"CatalogID\" class=\"java.lang.Long\" value=\"1\"/><parameter name=\"FilterClassGroupID\" class=\"java.lang.Long\" value=\"337178\"/>";
				xml = xml.replaceAll("FilterClassSystemID", "FilterStructureID");
				xml = xml.replaceAll("FilterClassGroupID", "FilterGroupID");

				int ii = 0;
				String str1 = "";
				while ((ii = xml.indexOf("<parameter name=\"FilterStructureID\" class=\"java.lang.Long\" value=",
						ii)) != -1) {
					// System.out.println(ii);
					str1 = xml.substring(0, ii);
					str1 = str1.concat(app);
					str1 = str1.concat(xml.substring(ii, xml.length()));
					xml = str1;

					ii += concatResult.length();
				}
				//System.out.println("str  :: " + str1);
				Statement stmt = conn.createStatement();
			    String insertquery = "update [AssortmentNew] set XML='" + str1 + "' where ID=" + id;
			    System.out.println(insertquery);
			    System.out.println(stmt.executeUpdate(insertquery));
			    conn.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
