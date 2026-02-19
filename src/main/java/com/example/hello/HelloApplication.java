package com.example.hello;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContext;
import com.example.hello.config.AppConfig;
import com.example.hello.service.OrderService;

// @SpringBootApplication
public class HelloApplication {

	// public static void main(String[] args) {
	// 	SpringApplication.run(HelloApplication.class, args);
	// }
	public static void main(String[] args) {
		// Create Spring container (ApplicationContext)
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

				 // Get bean from Spring (NOT new)
        OrderService orderService = context.getBean(OrderService.class);
		
		 orderService.placeOrder(100);
	}

}
