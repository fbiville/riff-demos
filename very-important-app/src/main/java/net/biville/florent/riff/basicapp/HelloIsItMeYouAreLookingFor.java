package net.biville.florent.riff.basicapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloIsItMeYouAreLookingFor {

    private final String podName;

    public HelloIsItMeYouAreLookingFor(@Value("${env.pod.name}")
                                       String podName) {
        this.podName = podName;
    }

    @GetMapping("/hello")
    public String sayWhat(@RequestParam("who")
                          String who) {
        return String.format(
                "Hello from %s, %s!",
                podName, who);
    }
}
