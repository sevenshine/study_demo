import javaconfig.pojo.Name;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * web项目，启动spring之后，web容器会维持进程持续运行,spring也就可以一直出于启动状态
 * 普通的java应用，在启动spring之后，随着java进程的停止，spring也会停止
 */
public class StudySpringMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //对象在Spring中进行管理，直接从context中取出来
        //获取对象，然后强转成Hello类对象
        Name name = (Name)context.getBean("Name");
        //第二种方式获取bean，转成User类
        Name name1 = context.getBean("Name",Name.class);

        System.out.println(name);
        System.out.println(name1);

    }
}
