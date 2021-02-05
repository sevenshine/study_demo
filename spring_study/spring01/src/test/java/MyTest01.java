import aop.pojo.Landlord;
import javaconfig.TestEn.TeUser;
import javaconfig.config.TestConfig;
import javaconfig.pojo.Name;
import javaconfig.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest01 {

    @Test
    public void test(){
        /**
         * 方式一：xml配置
         * 获取spring上下文对象,xml装配bean，然后获取bean
         * 快捷键：Cpx
         */
//        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //对象在Spring中进行管理，直接从context中取出来
        //获取对象，然后强转成Hello类对象
        Name name = (Name)context.getBean("Name");
        //第二种方式获取bean，转成User类
        Name name1 = context.getBean("Name",Name.class);

        System.out.println(name);
        System.out.println(name1);
    }

    @Test
    public void test1(){
        /**
         * 方式二：java config 方式，全部通过注解获取
         * 通过上下文获取容器，参数为包名
         */
        ApplicationContext context = new AnnotationConfigApplicationContext("javaconfig");
        //通过容器上下文获取bean
        //@Bean将类对象加载为bean对象，id默认为驼峰形式的名字
        TestConfig testConfig = (TestConfig) context.getBean("testConfig");
        User user2 = (User) context.getBean("user2");
        Name name1 = (Name) context.getBean("name1");
        //测试@Autowired
        TeUser tUser = (TeUser) context.getBean("teUser");

        tUser.test3();
        System.out.println(user2.getName());
        System.out.println(name1.getName());
        System.out.println(testConfig.getUser().getName());
    }

    @Test
    public void test2(){
        /**
         * 方式三：xml方式，自动装配
         * xml+注解自动获取
         */
        ApplicationContext context = new AnnotationConfigApplicationContext("applicationContext01.xml");
        User user = (User) context.getBean("user");
        System.out.println(user.getName());
    }

    @Test
    public void test3(){
        ApplicationContext context = new AnnotationConfigApplicationContext("aop");
        Landlord landlord=(Landlord)context.getBean("landlord");
//        Broker broker=(Broker)context.getBean("broker");
        landlord.service();
//        broker.before();
    }

    public static void main(String[] args) {
        System.out.println("Testing");
    }
}
