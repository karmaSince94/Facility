import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nuvizz.facility.controller.FacilityController;
import com.nuvizz.facility.dto.UserDTO;
import com.nuvizz.facility.service.user.UserLoginServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/context.xml")
public class TestCaseLogic 
{
	@Autowired
	UserLoginServiceImpl ser;
	
	private static final Logger logger = LoggerFactory.getLogger(FacilityController.class);
	
	
	//UserLoginServiceImpl ser = new UserLoginServiceImpl();
	
	//FacilityController fc = new FacilityController();
	
	/*@Test
	public void testUserObject()
	{
		UserDTO userDto = new UserDTO();
		userDto.setU_name("Rajeeb");
		userDto.setU_password("fdsas");
		UserDTO userDto1 = ser.userLoginService(userDto);
		assertEquals(1, ser.hello());
	}*/
	
	@Test
	public void authenticate()
	{
		
		UserDTO dto = new UserDTO();
		dto.setU_name("vinay");
		dto.setU_password("kumar");
		
		logger.info("Inside Login()...");
		UserDTO userDto = ser.userLoginService(dto);
		System.out.println("****************" + userDto.getU_password() + "******************");
		
	}
	
	
	
}