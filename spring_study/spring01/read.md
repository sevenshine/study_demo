##Spring流程
1、声明为组件
2、测试中读取容器上下文
3、通过容器获取对应的Bean

##Spring01
MyTest01
主要内容：IOC，DI的实现，Bean获取和测试


##Aop
碰到问题：切面注解声明后不生效，Bean都能获取到

需要加入注解，用来支持Aop
@EnableAspectJAutoProxy //开启注解AOP的支持

或者xml加入配置
<!-- 开启对 @Aspect 的支持--> <aop:aspectj-autoproxy/>