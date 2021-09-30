package co.com.bancolombia.config;

import co.com.bancolombia.model.sede.gateways.SedeRepository;
import co.com.bancolombia.usecase.sede.SedeUseCase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "co.com.bancolombia.usecase",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+UseCase$")
        },
        useDefaultFilters = false)
public class UseCasesConfig {
        public SedeUseCase sedeUseCase(SedeRepository sedeRepository){
                return new SedeUseCase(sedeRepository);
        }
}
