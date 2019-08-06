package com.francisco.castanieda.fluxtest.mapper;

import com.francisco.castanieda.fluxtest.model.User;
import com.francisco.castanieda.fluxtest.rest.dto.UserDTO;
import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements OrikaMapperFactoryConfigurer {

	@Override
	public void configure(MapperFactory orikaMapperFactory) {
		orikaMapperFactory.classMap(User.class, UserDTO.class)
				.field("id","id")
				.field("username","username")
				.field("password","password")
				.byDefault()
				.register();
	}
}
