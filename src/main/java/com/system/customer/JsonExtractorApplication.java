package com.system.customer;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mark Anthony Ortiz - ortizmark905@gmail.com
 */
@SpringBootApplication
public class JsonExtractorApplication {

	private static final Logger logger = LogManager.getLogger(JsonExtractorApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(JsonExtractorApplication.class, args);
	}

	@Bean
	public CommandLineRunner testExtractFieldFromJson() {
		return (args) -> {
			String userDirectory = Paths.get("")
					.toAbsolutePath()
					.toString();
			logger.info("current user dir: " + userDirectory);
			String json = new String(Files.readAllBytes(Paths.get(userDirectory, "input/lead.json")));
			logger.info("payload: " + json);
			Object document = Configuration.defaultConfiguration().jsonProvider().parse(json);

			List<String> returns = JsonPath.read(document,
					"$.fields[?(@.label == 'Primary InLife contact')].values[0].value.title");
			logger.info("returns: " + returns.stream().collect(Collectors.joining(", ")));
		};
	}

}
