package net.biville.florent.riff.basicapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
@TestPropertySource(properties = {"env.pod.name=test-pod"})
public class HelloIsItMeYouAreLookingForTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void is_polite() throws Exception {
        String resultingContent =
                "Hello from test-pod, Pivotal Paris Day!";
        mockMvc.perform(
                get("/hello").param(
                        "who",
                        "Pivotal Paris Day"))
                .andExpect(status().isOk())
                .andExpect(content()
                        .string(resultingContent));
    }
}