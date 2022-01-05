/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas.IT.ConverterSuhu_SatuDuaEnam;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Febriyanti Azahra
 */
@Controller
public class Controller_Suhu {
    private int SuhuKelvin(int SuhuCelcius){
        int SuhuKelvin = (int) (SuhuCelcius + 273.15);
        return SuhuKelvin;
    }
    
    private int SuhuReamur(int SuhuCelcius){
        int SuhuReamur = SuhuCelcius * 4/5;
        return SuhuReamur;
    }
    
    private int SuhuFahrenheit(int SuhuCelcius){
        int SuhuFahrenheit = (SuhuCelcius * 9/5) + 32;
        return SuhuFahrenheit;
    }
    
    @RequestMapping("/suhu")
    //@ResponseBody
    public String getHasil (HttpServletRequest Data, Model Temperature){
        
        String getNamaSuhu = Data.getParameter("nmSuhu");
        int getSuhuCelcius = Integer.parseInt(Data.getParameter("SuhuCelcius"));
        
        int SuhuKelvin = SuhuKelvin(getSuhuCelcius);
        int SuhuReamur = SuhuReamur(getSuhuCelcius);
        int SuhuFahrenheit = SuhuFahrenheit(getSuhuCelcius);
        
        Temperature.addAttribute("SuhuCelcius", getSuhuCelcius);
        Temperature.addAttribute("SuhuKelvin", SuhuKelvin);
        Temperature.addAttribute("SuhuReamur", SuhuReamur);
        Temperature.addAttribute("SuhuFahrenheit", SuhuFahrenheit);
        
        return "view";
    }
}