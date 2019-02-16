/*
 * Created by User on 16/02/2019
 */

package com.cognitech.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController
{
    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listVets()
    {
        return "owners/index";
    }
}
