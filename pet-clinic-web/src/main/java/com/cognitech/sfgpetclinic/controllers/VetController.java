/*
 * Created by User on 16/02/2019
 */

package com.cognitech.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController
{
    @RequestMapping({"/vets/", "/vets/index", "/vets/index.html"})
    public String listVets()
    {
        return "vets/index";
    }
}
