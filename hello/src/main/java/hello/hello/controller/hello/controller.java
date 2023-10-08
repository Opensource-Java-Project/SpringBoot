package hello.hello.controller.hello;

import hello.hello.HelloApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class controller {
  @GetMapping("hello")
  public String hello(Model model) {
    model.addAttribute("data", "spring!!"); // -> 키는 "data" 값은 "spring!!"
    return "hello"; //resources 안에 있는 templates에서 return " " -> 따옴표에 있는 이름을 가진 파일을 찾는다.
  }

  @GetMapping("hello-mvc")
  public String helloMvc(@RequestParam("name") String name, Model model) {
    model.addAttribute("name", name);
    return "hello-template";
  }
  @GetMapping("hello-string")
  @ResponseBody
  public String helloString(@RequestParam("name")String name){
    return "hello"+name; //"hello spring"
  }

  @GetMapping("hello-api")
  @ResponseBody
  public Hello helloApi(@RequestParam("name") String name){
      Hello hello = new Hello();
      hello.setName(name);
      return hello;
  }

  static class Hello{
    private String name;
    public String getName(){
      return name;
    }
    public void setName(String name){
      this.name = name;
    }
  }
}
