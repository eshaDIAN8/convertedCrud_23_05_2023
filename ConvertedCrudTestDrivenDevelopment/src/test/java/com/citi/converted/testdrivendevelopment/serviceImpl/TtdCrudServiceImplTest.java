package com.citi.converted.testdrivendevelopment.serviceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.citi.converted.testdrivendevelopment.Repository.TtdCrudRepository;
import com.citi.converted.testdrivendevelopment.controller.TtdCrudController;
import com.citi.converted.testdrivendevelopment.entity.Convert;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@RunWith(MockitoJUnitRunner.class)
@DataJpaTest
public class TtdCrudServiceImplTest {

	@InjectMocks
	private TtdCrudServiceImpl serviceImpl;

	// @Autowired
	@Mock
	private TtdCrudRepository repo;

	// @Autowired
	@Mock
	private Convert convert;

	@Test
	public void testImpl() {

		String convertedUnit = "km-meter";
		when(repo.findByName(convertedUnit)).thenReturn(convert);
		when(serviceImpl.findByKey(convertedUnit)).thenReturn(String.class);
		assertThat(serviceImpl.findByKey(convertedUnit)).isEqualTo("*1000");

	}

}
