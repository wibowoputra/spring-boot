package com.example.hello;

// import static org.mockito.Mockito.when;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

// import org.junit.jupiter.api.Test;
// import org.mockito.Mock;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
// import org.springframework.test.context.bean.override.mockito.MockitoBean;
// import org.springframework.test.web.servlet.MockMvc;



import com.example.hello.controller.CalculatorController;
import com.example.hello.service.CalculatorService;

// @WebMvcTest(controllers = CalculatorController.class)
public class CalculatorControllerTest {
    // @Autowired
    // MockMvc mockMvc;

    // @MockitoBean
    CalculatorService calculatorService = new CalculatorService();

    // @Test
    public void testAdd() throws Exception {
        // when(calculatorService.add(2, 3)).thenReturn(5);


        // mockMvc.perform(get("/api/calculator/add")
        //         .param("a", "2")
        //         .param("b", "3"))
        //         .andExpect(status().isOk())
                // .andExpect(content().string("5"));
    }

}
