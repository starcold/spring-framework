import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.util.Assert;

public class BeanFactoryTest {
	@Test
	public void createBeanTest() {
		//Bean创建
		DefaultListableBeanFactory factory =new DefaultListableBeanFactory();
		UserServiceImpl bean = factory.createBean(UserServiceImpl.class);

		System.out.println(bean);
	}

	@Test
	public void beanStore() {
		DefaultListableBeanFactory factory =new DefaultListableBeanFactory();
		//Bean存储
		factory.registerSingleton("s1", new UserServiceImpl());
		factory.getBean("s1");
	}


	/*
	*依赖关系注入
	*/
	@Test
	public void dependcesTest() {
		try{
			DefaultListableBeanFactory factory =new DefaultListableBeanFactory();
			factory.registerSingleton("dao1",new UserDaoImpl());
			//自动获取UserServiceImpl的依赖关系
			UserServiceImpl bean = (UserServiceImpl) factory.createBean(UserServiceImpl.class, AbstractBeanDefinition.AUTOWIRE_BY_TYPE, true);
			System.out.println(bean);
		}
		catch ( BeansException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getBeanTest() {
		DefaultListableBeanFactory factory =new DefaultListableBeanFactory();
		//创建Xml的加载器
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		//加载spring.xml配置文件
		reader.loadBeanDefinitions("spring.xml");
		UserServiceImpl bean = factory.getBean(UserServiceImpl.class);
		Assert.notNull(bean, "bean 不能为空");
		Assert.notNull(bean.getUserDao(), "UserDao 不能为空");
	}
}
