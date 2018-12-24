package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Result;
import com.baizhi.service.AdminService;
import com.baizhi.util.ValidateImageCodeUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

@Controller
@RequestMapping("/admin")
public class AdminController {

    //对应 该类生成日志文件对象
    private static final Logger log = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;
    @Autowired
    private Jedis Jedis;

    @RequestMapping("/adminLogin")
    @ResponseBody
    public Result adminLogin(Admin admin, boolean rememberMe) {
        Result result = new Result();
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.login(new UsernamePasswordToken(admin.getUsername(), admin.getPassword(), rememberMe));
            result.setSuccess(true);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("账号或密码错误!");
        }
        return result;
    }

    /*@RequestMapping("/adminLogin")
    @ResponseBody
    public Result adminLogin(Admin admin, String code,HttpServletRequest request) {
        Result result = new Result();
        Admin adminLogin = adminService.adminLogin(admin);
        //登陆成功进入emplist页面，登陆失败返回登陆页面
        if (adminLogin != null) {
            result.setSuccess(true);
            result.setMessage("登陆成功!");
            log.info("测试 admin:{}",adminLogin);
            request.getSession().setAttribute("admin",adminLogin);
            Jedis.set(adminLogin.getId(),adminLogin.getName());
        } else {
            result.setSuccess(false);
            result.setMessage("账号或密码错误!");
        }
        return result;
    }*/

    @RequestMapping("/registAdmin")
    public String registAdmin(Admin admin, HttpSession session, String code) {
        Result result = new Result();
        String validateCode = (String) session.getAttribute("validateCode");
        try {
            if (validateCode.equals(code)) {
                adminService.addAdmin(admin);
                result.setSuccess(true);
                result.setMessage(null);
                return "redirect:/views/login.jsp";
            } else {
                result.setSuccess(false);
                result.setMessage("注册失败!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("注册失败!");
        }
        return "redirect:/views/regist.jsp";
    }

    // 验证码
    @RequestMapping("/code")
    public void code(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 获取验证码随机数
        String securityCode = ValidateImageCodeUtils.getSecurityCode();
        // 将securityCode存入session作用域
        request.getSession().setAttribute("validateCode", securityCode);
        // 创建验证码图片，参数为securityCode
        BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
        // 将验证码图片通过输出流响应到客户端，先获取response，再获取输出流
        ServletOutputStream out = response.getOutputStream();
        // 调用神奇方法
        /**
         * 第一个参数： 验证码图片对象 第二个参数： 图片的格式 第三个参数： 输出字节流
         */
        ImageIO.write(image, "png", out);

    }

    @RequestMapping("/logout")
    public String adminLogout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/views/login.jsp";
    }
}
