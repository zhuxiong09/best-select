package com.zx.store.aspect;

import com.zx.store.bean.AspectInfo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;


@Component
@Aspect
@Slf4j
public class AspectForService {

    @Autowired
    private AspectService aspectService;

    @Autowired
    RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法

    //定义拦截规则第一个*表示方法返回值任意
    //com.zx.store.service.*.*的意思是：这个包里面任意类里面的任意方法，
    //(..)表示参数任意，
    @Pointcut("execution(* com.zx.store.service.*.*(..))")
    public void pc() {
    }

//    //前置通知
//    @Before(value = "pc()")
//    public void before(JoinPoint jp) {
//        final Logger logger = LoggerFactory.getLogger(AspectService.class);
//
//        //name就是拿到的Service中的方法名
//        String name = jp.getSignature().getName();
//
//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();//这个RequestContextHolder是Springmvc提供来获得请求的东西
//        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
//
//        // 记录下请求内容
//        logger.info("################URL : " + request.getRequestURL().toString());
//        logger.info("################HTTP_METHOD : " + request.getMethod());
//        logger.info("################IP : " + request.getRemoteAddr());
//        logger.info("################THE ARGS OF THE SERVICE : " + Arrays.toString(jp.getArgs()));
//
//        //下面这个getSignature().getDeclaringTypeName()是获取包+类名的   然后后面的jp.getSignature.getName()获取了方法名
//        logger.info("################CLASS_METHOD : " + jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName());
//        //logger.info("################TARGET: " + jp.getTarget());//返回的是需要加强的目标类的对象
//        //logger.info("################THIS: " + jp.getThis());//返回的是经过加强后的代理类的对象
//
//        System.out.println("前置通知;方法名:" + name);
//        // 方法一
//        // url, method, args, result, time, startTime, endTime
//        // Log log = new Log(url, method, args, result, time, startTime, endTime)
//        // save(Log)
//
//        // 方法二
//        // SpringBoot如何整合RabbitMQ
//        // save--->Producer: log  ---> MQ
//        // 消费日志队列里的日志消息
//        // Customer: log----> logDao.save(log)
//        // 优化： 创建一个队列，当队列里的值达到10条后再保存到数据库logDao.saveAll(logs)
//    }

    //环绕通知
    @Around(value = "pc()")
    public Object arount(ProceedingJoinPoint pjp) throws Throwable {

        //这个RequestContextHolder是Springmvc提供来获得请求的东西
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

        // 记录下请求内容
        String url=request.getRequestURL().toString();
        log.info("请求地址URL : " + url);

        //获取目标类名称
        String clazzName = pjp.getTarget().getClass().getName();
        log.info("获取目标类名称:  "+clazzName);

        //获取目标类方法名称
        String methodName = pjp.getSignature().getName();
        log.info("获取目标类方法名称:  "+methodName);

        //获取,记录请求参数
        Object[] args = pjp.getArgs();
        log.info("记录请求参数params: "+ args);
        JSONArray jsonArgs0 = JSONArray.fromObject(args);
        String jsonArgs = jsonArgs0.toString();
        System.out.println("JSON数据类args:"+ jsonArgs);

        //开始调用时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");//设置日期格式
//        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        String nowTime = df.format(new Date());
        Date startDate = df.parse( nowTime );
        long startTime = System.currentTimeMillis();
        log.info("startTime: {}", startTime);

        Object result = pjp.proceed();

        //调用完成时间
        String nowTime1 = df.format(new Date());
        Date endDate = df.parse( nowTime1 );

        // 计时并调用目标函数
        Long time = System.currentTimeMillis() - startTime;
        //设置消耗总时间
        log.info("consumeTime: "+ time);

        System.out.println("..........result:"+ result);
        JSONArray jsonResult0 = JSONArray.fromObject(result);
        String jsonResult = jsonResult0.toString();
        System.out.println("..........JSONresult:"+ jsonResult);

        AspectInfo aspectInfo = new AspectInfo(startDate,endDate,time,jsonArgs,url,clazzName,methodName,jsonResult);

        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting", aspectInfo);

//        //将信息插入数据库
//        aspectService.insertAspectInfo(aspectInfo);

        return result;
    }


//    //后置通知
//    @After(value = "pc()")
//    public void after(JoinPoint jp) {
//        //name就是拿到的Service中的方法名
//        String name = jp.getSignature().getName();
//        System.out.println("后置通知;方法名:" + name);
//    }
}
