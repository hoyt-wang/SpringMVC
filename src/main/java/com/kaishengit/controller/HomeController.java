package com.kaishengit.controller;

import com.kaishengit.entity.User;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by hoyt on 2017/11/2.
 */

@Controller
public class HomeController {

    //@GetMapping("/home")
    @RequestMapping("/home")
    public String home() {
        System.out.println("Hello,SpringMVC");
        return "home";
    }

    @RequestMapping("/message")
    public String hello(Model model) {
        model.addAttribute("message" ,"测试");
        return "home";
    }

    @RequestMapping(value = "/blog/{id:\\d+}", method = RequestMethod.GET)
    public String get(@PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("id-->" + id);
        return "home";
    }

    @GetMapping("/blog")
    public String blog(Integer id, @RequestParam(name = "tag") Integer tagId,
                       Model model) {

        System.out.println("id: " + id + ",tagId: " + tagId);
        model.addAttribute("id",id);
        model.addAttribute("tagId",tagId);
        return "home";
    }

      @GetMapping("/movie/{id:\\d+}")
      public String movie(@PathVariable Integer id) {
          System.out.println("movieId-->" + id);
          return "home";
      }

      @GetMapping("/class/{className}/user/{userId:\\d+}")
      public String getUser(@PathVariable String className,@PathVariable Integer userId) {
          System.out.println("className:" + className + ",userId: " + userId );
          return "home";
      }
      @GetMapping("/register")
        public String register() {
          return "register";
      }

      @PostMapping("/register")
        public String register(User user, String email, MultipartFile picture, RedirectAttributes redirectAttributes) {
          System.out.println("username:" + user.getUserName()+ ",email:" + email);
          if(!picture.isEmpty()) {
              System.out.println("文件名称：" + picture.getOriginalFilename());

              try {
                  IOUtils.copy(picture.getInputStream(),
                          new FileOutputStream("d:/upload/" + picture.getOriginalFilename()));
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
          redirectAttributes.addFlashAttribute("message","提交中...");
          return "redirect:/register";
      }

}
