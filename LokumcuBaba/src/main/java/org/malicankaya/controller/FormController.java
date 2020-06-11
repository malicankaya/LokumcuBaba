package org.malicankaya.controller;

import org.malicankaya.dao.FormDAO;
import org.malicankaya.dao.FormDAOImplementation;
import org.malicankaya.model.FormModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class FormController
{
    // formdao'in yakalanmasını sağladık, bu sayede configde verdiğimiz datasource ile birlikte (configdeki FormDAO metodu sayesinde) kullanabileceğiz
    @Autowired
    FormDAO formDAO;

    @RequestMapping("/submitForm")
    public ModelAndView Form(HttpServletRequest req, HttpServletResponse res)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("result");
        FormModel formModel = new FormModel();
        formModel.setAdSoyad(req.getParameter("formName"));
        formModel.setTcKimlik (req.getParameter("formTCNo"));
        formModel.setAdres (req.getParameter("formAdress"));
        formModel.setTelefon (req.getParameter("formPhone"));
        formModel.setEmail (req.getParameter("formEmail"));
        formModel.setDogumTarihi(java.sql.Date.valueOf(req.getParameter("formBirthdate")));
        if(req.getParameter("formS1").equals("Yes"))
        {
            formModel.setS1(true);
        }else
            {
                formModel.setS1(false);
            }
        formModel.setS2(req.getParameter("formS2"));
        formModel.setS3(req.getParameter("formS3"));
        formModel.setS4(req.getParameter("formS4"));
        formModel.setS5(req.getParameter("formS5"));

        formDAO.save(formModel);

        mv.addObject("result",formModel);
        return mv;
    }
}
