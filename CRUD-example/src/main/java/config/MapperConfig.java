package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Configuration
public class MapperConfig {
	
	@Bean
	public MapperFactory BeanClassMapper() {
		final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
		return mapperFactory;
	}

}

