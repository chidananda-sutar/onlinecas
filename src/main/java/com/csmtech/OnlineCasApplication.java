package com.csmtech;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(exclude = (SecurityAutoConfiguration.class))
@EnableAsync
public class OnlineCasApplication implements CommandLineRunner {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(OnlineCasApplication.class, args);
		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
		// String schemaName = "csm_online_exam";
		insertion(jdbcTemplate, "role", "rolename", "Admin");
		insertion(jdbcTemplate, "role", "rolename", "Proctor");
		insertion(jdbcTemplate, "questiontype", "question_type_name", "Subjective");
		insertion(jdbcTemplate, "questiontype", "question_type_name", "Objective");
		into(jdbcTemplate, "Admin");
	}

	private static void into(JdbcTemplate jdbcTemplate, String data) {
		int update = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM users WHERE username = 'Admin';",
				Integer.class);
		if (update == 0) {
			jdbcTemplate.update(
					"INSERT INTO `users` (`email`, `gender`, `isdelete`, `name`, `password`, `status`, `user_address`, `username`, `roleid`) VALUES ('admin@gmail.com', 'N/A', 'NO', 'Admin', 'admin@123', '0', 'Ocac tower BBSR', 'Admin', '1');");
		}
	}

	private static void insertion(JdbcTemplate jdbcTemplate, String tbleName, String colName, String data) {
		String sql = "SELECT COUNT(*) FROM " + tbleName + " WHERE " + colName + "= '" + data + "'";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);

		if (count == 0) {
			String insertQuery = "INSERT INTO " + tbleName + " (" + colName + ") VALUES ('" + data + "');";
			jdbcTemplate.update(insertQuery);
		}
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

	}

}
