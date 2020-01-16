[TOC]

###### Targe类型
1.TYPE 对象/接口/枚举
2.FIELD 成员变量
3.METHOD 成员方法
4.PARAMETER 方法参数
5.ANNOTATION_TYPE 注解的注解

###### Retention类型
1.SOURCE 针对编写阶段 @Overide注解
2.CLASS  针对编译阶段 动态生成代码 
2.RUNTIME 针对JVM运行阶段,可以结合反射使用(比较常用)

##### AOP注解与使用

1. @Aspect：声明切面，标记类   
2. @Pointcut(切点表达式)：定义切点，标记方法
3. @Before(切点表达式)：前置通知，切点之前执行
4. @Around(切点表达式)：环绕通知，切点前后执行
5. @After(切点表达式)：后置通知，切点之后执行
6. @AfterReturning(切点表达式)：返回通知，切点方法返回结果之后执行
7. @AfterThrowing(切点表达式)：异常通知，切点抛出异常时执行