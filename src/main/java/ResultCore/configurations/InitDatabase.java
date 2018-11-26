package ResultCore.configurations;

import ResultCore.entities.Result;
import ResultCore.repositories.ResultRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class InitDatabase {

    @Bean
    CommandLineRunner seedDatabase(ResultRepository resultRepository){
        return args -> {
            log.info("Database initialisation with : " + resultRepository.save(new Result(1)));
            log.info("Database initialisation with : " + resultRepository.save(new Result(2)));
        };
    }
}
