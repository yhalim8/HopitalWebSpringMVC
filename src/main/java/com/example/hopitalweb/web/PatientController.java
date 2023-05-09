package com.example.hopitalweb.web;

import com.example.hopitalweb.entities.Patient;
import com.example.hopitalweb.repository.PatientRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@AllArgsConstructor
@Controller

public class PatientController {
    private PatientRepository patientRepository;
    @GetMapping("/index")
    public String index(Model model,@RequestParam(value = "page",defaultValue = "0") int page,
                                    @RequestParam(value = "size",defaultValue = "4") int size,
                                    @RequestParam(value = "keyword",defaultValue = "") String kw
                        ){
        Page<Patient> pagePatient = patientRepository.findByNomContains(kw,PageRequest.of(page,size));
        model.addAttribute("listPatients",pagePatient.getContent());
        model.addAttribute("pages",new int[pagePatient.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",kw);
        return "patients";
    }
    @GetMapping("/delete")
    public String delete(Long id,String keyword,int page){
        patientRepository.deleteById(id);
        return "redirect:/index?page"+page+"&keyword="+keyword;
    }
    @GetMapping("/")
    public String home(){

        return "redirect:/index";
    }
    @ResponseBody
    @GetMapping("/patients")
    public List<Patient> patientList(){
        return patientRepository.findAll();
    }
    @GetMapping("/formPatient")
    public String formPatient(Model model){
            model.addAttribute("patient",new Patient());
        return "formPatient";
    }
    @PostMapping("/save")
    public String save(Model model, @Valid Patient patient, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "formPatient";
        }
        patientRepository.save(patient);
        return "redirect:/index";
    }
    @GetMapping("/editPatient")
    public String editPatient(Model model ,@RequestParam("id") Long id){
        Patient patient =patientRepository.findById(id).get();
        model.addAttribute("patient",patient);
        return "editPatient";
    }

}
