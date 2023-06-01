package com.bigcorp.crm.open;

import java.util.Properties;

import org.apache.openejb.jee.WebApp;
import org.apache.openejb.jee.jpa.unit.PersistenceUnit;
import org.apache.openejb.testing.Application;
import org.apache.openejb.testing.Classes;
import org.apache.openejb.testing.Configuration;

@Application
public class TestWebApp {
	@org.apache.openejb.testing.Module
	public PersistenceUnit persistence() {
		PersistenceUnit unit = new PersistenceUnit("PersisterPU");
		unit.setJtaDataSource("crmTestDatabase");
		unit.setNonJtaDataSource("crmTestDatabaseUnmanaged");
		unit.setProperty("javax.persistence.schema-generation.database.action", "drop-and-create");
		unit.setProperty("openjpa.jdbc.SynchronizeMappings", "buildSchema(ForeignKeys=true)");
		unit.setProperty("openjpa.Log", "DefaultLevel=WARN,Runtime=INFO,Tool=INFO,SQL=TRACE");

		return unit;
	}

	@org.apache.openejb.testing.Module
	@Classes(cdi = true, value = { 
			
			})
	public WebApp app() {
		return new WebApp();
	}

	@Configuration
	public Properties configInMemory() throws Exception {
		Properties p = new Properties();
		p.put("crmTestDatabase", "new://Resource?type=DataSource");
		p.put("crmTestDatabase.JdbcDriver", "org.hsqldb.jdbcDriver");
		p.put("crmTestDatabase.JdbcUrl", "jdbc:h2:mem:testdb");
		p.put("crmTestDatabase.UserName", "test");
		p.put("crmTestDatabase.password", "test");
		return p;
	}

	public Properties configLocalDataBase() throws Exception {
		Properties p = new Properties();
		p.put("crmTestDatabase", "new://Resource?type=DataSource");
		p.put("crmTestDatabase.JdbcDriver", "org.apache.derby.client.ClientAutoloadedDriver");
		p.put("crmTestDatabase.JdbcUrl", "jdbc:derby://localhost:1527/test-junit;create=true");
		p.put("crmTestDatabase.UserName", "test");
		p.put("crmTestDatabase.password", "test");
		return p;
	}
}
