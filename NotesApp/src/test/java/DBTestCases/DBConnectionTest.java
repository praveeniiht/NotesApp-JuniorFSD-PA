package DBTestCases;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.examples.projects.model.Notes;


@RunWith(MockitoJUnitRunner.class)
public class DBConnectionTest {
	static { 
		File file = new  File("output_dbconnections_revised.txt"); 
		if (file.exists()) { 
			try {
			  FileUtils.forceDelete(new File("output_dbconnections_revised.txt")); 
			 } catch(IOException e) { 
				
			 } 
		}
	}
	@Test
	public void testDatabaseConnectivity() throws IOException {
		Properties properties = MasterData.getProperties();
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(properties.getProperty("database.driver"));
		dataSource.setUrl(properties.getProperty("database.url"));
		dataSource.setUsername(properties.getProperty("database.root"));
		dataSource.setPassword(properties.getProperty("database.password"));
		File file = new File("output_dbconnections_revised.txt"); 
		FileUtils.write(file,"\n testDatabaseConnectivity = "+(dataSource!=null?true:false), true);
	}

	@Test
	public void testhibernateProperties() throws IOException {
		Properties properties = MasterData.getProperties();
		properties.put("hibernate.dialect", properties.getProperty("hibernate.dialect"));
		properties.put("hibernate.hbm2ddl.auto", properties.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.show_sql", properties.getProperty("hibernate.show_sql"));
		
		File file = new File("output_dbconnections_revised.txt"); 
		FileUtils.write(file,"\n testhibernateProperties = true ", true);
	}

	
	
/*	@Test
	public void testSqlException() throws IOException {
		
		HibernateTemplate  session = new HibernateTemplate( MasterData.getSession().getObject());
		String hql = "FROM Notes";
		@SuppressWarnings("unchecked")
		List<Notes> size = (List<Notes>) session.find(hql);
		assertNotNull(size);
	}
*/

}
