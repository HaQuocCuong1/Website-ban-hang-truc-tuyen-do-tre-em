/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.controller.web;

import com.shopbandotreem.entity.KhachHang;
import com.shopbandotreem.services.KhachHangService;
import com.shopbandotreem.user.CrmUser;
import java.security.Principal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Dell_Latitude_7480
 */
@Controller
public class TaiKhoanController {

    @Autowired
    private KhachHangService khachhangservice;

    @Autowired
    private UserDetailsManager userDetailsManager;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private Logger logger = Logger.getLogger(getClass().getName());

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

//    ????ng k?? t??i kho???n
    @GetMapping("/taikhoan/showFormdangkytaikhoan")
    public String showFormregister(Model theModel) {

        CrmUser crmUser = new CrmUser();
        theModel.addAttribute("crmUser", crmUser);
        return "giaodiendangkytaikhoan";
    }

    @PostMapping("/taikhoan/dangkytaikhoan")
    public String processRegistrationForm(
            HttpServletRequest request,
            @ModelAttribute("crmUser") @Valid CrmUser theCrmUser,
            BindingResult theBindingResult,
            @RequestParam("ho") String ho,
            @RequestParam("ten") String ten,
            @RequestParam("email") String email,
            @RequestParam("diachi") String diachi,
            @RequestParam("sdt") String sdt,
            @RequestParam("password") String password,
            @RequestParam("ngaysinh1") String ngaysinh,
            Model theModel) {

        String userName = theCrmUser.getUserName();

        logger.info("Processing registration form for: " + userName);

        if (theBindingResult.hasErrors()) {

            theModel.addAttribute("crmUser", new CrmUser());
            theModel.addAttribute("registrationError", "T??n t??i kho???n/password kh??ng ???????c ????? tr???ng.");

            logger.warning("User name/password can not be empty.");

            return "giaodiendangkytaikhoan";
        }

        //Kiem tra regex form
        String usernamerequest = theCrmUser.getUserName();
        String hoquest = request.getParameter("ho");
        String tenrequest = request.getParameter("ten");
        String emailrequest = request.getParameter("email");
        String diachirequest = request.getParameter("diachi");
        String sdtrequest = request.getParameter("sdt");
        String ngaysinhrequest = request.getParameter("ngaysinh1");
        String passwordrequest = request.getParameter("password");
        String passwordxacnhanrequest = request.getParameter("cpassword");
        if (hoquest.equals("") || tenrequest.equals("") || emailrequest.equals("") || sdtrequest.equals("") || ngaysinhrequest.equals("")) {
            theModel.addAttribute("registrationError", "!! B???n ph???i nh???p ?????y ????? th??ng tin, kh??ng ???????c ????? tr???ng");
            return "giaodiendangkytaikhoan";
        } else if (usernamerequest.matches(".*[A-Za-z].*[a-z0-9_-]{5,12}$") == false) {
            theModel.addAttribute("registrationError", "!! UserName ch??? d??i t??? 5-12 k?? t???, kh??ng c?? d???u, v?? kho???n tr???ng");
            return "giaodiendangkytaikhoan";
        } else if (hoquest.matches("^[a-zA-Z]+") == false) {
            theModel.addAttribute("registrationError", "!! H??? kh??ng ch???a ch??? s???");
            return "giaodiendangkytaikhoan";
        } else if (tenrequest.matches("^[a-zA-Z]+") == false) {
            theModel.addAttribute("registrationError", "!! T??n kh??ng ch???a ch??? s???");
            return "giaodiendangkytaikhoan";
        } else if (emailrequest.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$") == false) {
            theModel.addAttribute("registrationError", "!! ?????nh d???ng email sai");
            return "giaodiendangkytaikhoan";
        } else if (sdtrequest.matches("^[0-9]+") == false) {
            theModel.addAttribute("registrationError", "!! S??? ??i???n tho???i kh??ng ch???a k?? t???");
            return "giaodiendangkytaikhoan";
        } else if (passwordrequest.equals(passwordxacnhanrequest) == false) {
            theModel.addAttribute("registrationError", "!! X??c nh???n m???t kh???u kh??ng ????ng");
            return "giaodiendangkytaikhoan";
        }

        // check the database if user already exists
        boolean userExists = doesUserExist(userName);

        if (userExists) {
            theModel.addAttribute("crmUser", new CrmUser());
            theModel.addAttribute("registrationError", "!! T??i kho???n n??y ???? ???????c s??? d???ng");

            logger.warning("User name already exists.");

            return "giaodiendangkytaikhoan";
        }

        //
        // whew ... we passed all of the validation checks!
        // let's get down to business!!!
        //
        // encrypt the password
        String encodedPassword = passwordEncoder.encode(theCrmUser.getPassword());

        // prepend the encoding algorithm id
        encodedPassword = "{bcrypt}" + encodedPassword;

        // give user default role of "employee"
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_EMPLOYEE");

//         create user object (from Spring Security framework)
        User tempUser = new User(userName, encodedPassword, authorities);

        // save user in the database
        userDetailsManager.createUser(tempUser);

        KhachHang khachhang = new KhachHang(userName, ho, ten, sdt, email, ngaysinh, Date.valueOf(ngaysinh), diachi);
        khachhangservice.savekhachhang(khachhang);

        logger.info("Successfully created user: " + userName);

        return "registration-confirmation";
    }

    private boolean doesUserExist(String userName) {

        logger.info("Checking if user exists: " + userName);

        // check the database if the user already exists
        boolean exists = userDetailsManager.userExists(userName);

        logger.info("User: " + userName + ", exists: " + exists);

        return exists;
    }

    //????ng nh???p
    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {

        return "giaodiendangnhap";
    }

//    @GetMapping("/")
//    public String showHomePage(HttpServletRequest request) {
//        List<GrantedAuthority> currentUser = (List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
//
//        for (int i = 0; i < currentUser.size(); i++) {
//            if (currentUser.get(i).getAuthority().equals("ROLE_ADMIN")) {
//                return "redirect:/admin/listkhachhang";
//            } else {
//                return "trangchu";
//            }
//        }
//        return "redirect:/trangchu";
//    }

    @GetMapping("/admin")
    public String showAdmin() {
        return "redirect:/admin/listkhachhang";
    }

    // add request mapping for /access-denied
    @GetMapping("/access-denied")
    public String showAccessDenied() {

        return "access-denied";

    }

    //S???a th??ng tin t??i kho???n, khach hang
    @GetMapping("/taikhoan/suathongtintaikhoan")
    public String suathongtintaikhoan(Model theModel) {
        String makh = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getName());
        KhachHang thekhachhang = khachhangservice.getKhachHang(makh);

        theModel.addAttribute("khachhang", thekhachhang);
        return "giaodiensuathongtintaikhoan";
    }

    @PostMapping("/taikhoan/savesuathongtinkhachhang")
    public String suathongtinkhachhang(
            HttpServletRequest request,
            RedirectAttributes redirectAttributes,
            @RequestParam("ho") String ho,
            @RequestParam("ten") String ten,
            @RequestParam("ngaysinh") String ngaysinh,
            @RequestParam("gioitinh") String gioitinh,
            @RequestParam("email") String email,
            @RequestParam("diachi") String diachi,
            @RequestParam("sdt") String sdt, Model theModel) {

        //Kiem tra regex form
        String hoquest = request.getParameter("ho");
        String tenrequest = request.getParameter("ten");
        String emailrequest = request.getParameter("email");
        String sdtrequest = request.getParameter("sdt");
        String ngaysinhrequest = request.getParameter("ngaysinh");
        if (hoquest.equals("") || tenrequest.equals("") || emailrequest.equals("") || sdtrequest.equals("") || ngaysinhrequest.equals("")) {
            redirectAttributes.addFlashAttribute("registrationError", "!! B???n kh??ng ???????c ????? tr???ng th??ng tin");
            return "redirect:/taikhoan/suathongtintaikhoan";
        } else if (hoquest.matches("^[a-zA-Z]+") == false) {
            redirectAttributes.addFlashAttribute("registrationError", "!! H??? kh??ng ch???a ch??? s??? v?? d???u c??ch");
            return "redirect:/taikhoan/suathongtintaikhoan";
        } else if (tenrequest.matches("^[a-zA-Z]+") == false) {
            redirectAttributes.addFlashAttribute("registrationError", "!! T??n kh??ng ch???a ch??? s??? v?? d???u c??ch");
            return "redirect:/taikhoan/suathongtintaikhoan";
        } else if (emailrequest.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$") == false) {
            redirectAttributes.addFlashAttribute("registrationError", "!! ?????nh d???ng email sai");
            return "redirect:/taikhoan/suathongtintaikhoan";
        } else if (sdtrequest.matches("^[0-9]+") == false) {
            redirectAttributes.addFlashAttribute("registrationError", "!! S??? ??i???n tho???i kh??ng ch???a k?? t???");
            return "redirect:/taikhoan/suathongtintaikhoan";
        }

        String makh = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getName());

        KhachHang khachhang = new KhachHang(makh, ho, ten, sdt, email, gioitinh, Date.valueOf(ngaysinh), diachi);
        khachhangservice.savekhachhang(khachhang);
        KhachHang thekhachhang = khachhangservice.getKhachHang(makh);
        theModel.addAttribute("khachhang", thekhachhang);
        String thongbao = "!!B???n v???a c???p nh???t th??nh c??ng th??ng tin c?? nh??n";
        theModel.addAttribute("thongbao", thongbao);
        return "giaodiensuathongtintaikhoan";

    }

    //?????i m???t kh???u khachhang
    @PostMapping("/taikhoan/savesuapassword")
    public String suapassword(
            RedirectAttributes redirectAttributes,
            @ModelAttribute("crmUser") CrmUser theCrmUser,
            HttpServletRequest request,
            @RequestParam("passwordmoi") String passwordmoi,
            @RequestParam("passwordxacnhan") String passwordxacnhan,
            Model theModel) {

        String encodedPassword = passwordEncoder.encode(passwordmoi);
        // prepend the encoding algorithm id
        encodedPassword = "{bcrypt}" + encodedPassword;

        String passwordmoirequest = request.getParameter("passwordmoi");

        String passwordxacnhanrequest = request.getParameter("passwordxacnhan");

        if (passwordmoirequest.equals(passwordxacnhanrequest) == false) {
            String registrationError = "!!  B???n ???? nh???p 2 password kh??ng gi???ng nhau";
            redirectAttributes.addFlashAttribute("registrationError", registrationError);
            return "redirect:/taikhoan/suathongtintaikhoan";
        }

        userDetailsManager.changePassword("", encodedPassword);

        String makh = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getName());
        KhachHang thekhachhang = khachhangservice.getKhachHang(makh);
        theModel.addAttribute("khachhang", thekhachhang);
        String thongbao = " B???n v???a thay ?????i th??nh c??ng password";
        theModel.addAttribute("thongbao", thongbao);

        return "giaodiensuathongtintaikhoan";

    }
    
       //?????i m???t kh???u admin
    @PostMapping("/taikhoan/savesuapasswordadmmin")
    public String suapasswordadmin(
            RedirectAttributes redirectAttributes,
            @ModelAttribute("crmUser") CrmUser theCrmUser,
            HttpServletRequest request,
            @RequestParam("passwordmoi") String passwordmoi,
            @RequestParam("passwordxacnhan") String passwordxacnhan,
            Model theModel) {

        String encodedPassword = passwordEncoder.encode(passwordmoi);
        // prepend the encoding algorithm id
        encodedPassword = "{bcrypt}" + encodedPassword;

        String passwordmoirequest = request.getParameter("passwordmoi");

        String passwordxacnhanrequest = request.getParameter("passwordxacnhan");

        if (passwordmoirequest.equals(passwordxacnhanrequest) == false) {
            String registrationError = "!!  B???n ???? nh???p 2 password kh??ng gi???ng nhau";
            redirectAttributes.addFlashAttribute("registrationError", registrationError);
            return "redirect:/admin/listkhachhang";
        }

        userDetailsManager.changePassword("", encodedPassword);

        String makh = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getName());
        KhachHang thekhachhang = khachhangservice.getKhachHang(makh);
        theModel.addAttribute("khachhang", thekhachhang);
        String thongbao = " B???n v???a thay ?????i th??nh c??ng password";
        theModel.addAttribute("thongbao", thongbao);
        redirectAttributes.addFlashAttribute("thongbao", thongbao);
        return "redirect:/admin/listkhachhang";

    }
}
