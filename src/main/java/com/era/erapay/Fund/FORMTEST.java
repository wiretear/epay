package com.era.erapay.Fund;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Controller
public class FORMTEST {
    @RequestMapping(value= "/erapay/clearform")
    public String formclertest(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "formtest";
    }
    @RequestMapping(value= "/erapay/exclearform")
    public String formclerteswt(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "formtest";
    }

}
