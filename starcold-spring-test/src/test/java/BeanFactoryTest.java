import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public class BeanFactoryTest {
	@Test
	public void createBeanTest()
	{
		DefaultListableBeanFactory factory =new DefaultListableBeanFactory();
		UserServiceImpl bean = factory.createBean(UserServiceImpl.class);
		System.out.println(bean);
	}
}
