package com.petclinic.petclinic.controllers;

import com.petclinic.petclinic.models.Pet;
import com.petclinic.petclinic.models.Visit;
import com.petclinic.petclinic.services.PetService;
import com.petclinic.petclinic.services.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
public class VisitController {
    private static final String VIEWS_PETS_CREATE_OR_UPDATE_VISIT_FORM = "pets/createOrUpdateVisit";

    private final VisitService visitService;
    private final PetService petService;

    public VisitController(VisitService visitService, PetService petService) {
        this.visitService = visitService;
        this.petService = petService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @ModelAttribute("visit")
    public Visit loadPetWithVisit(@PathVariable Long petId, Model model) {
        Pet pet = petService.findById(petId);
        model.addAttribute("pet", pet);
        Visit visit = new Visit();
        pet.addVisit(visit);
        return visit;
    }

    @GetMapping("/owners/*/pets/{petId}/visits/new")
    public String initNewVisitForm() {
        return VIEWS_PETS_CREATE_OR_UPDATE_VISIT_FORM;
    }

    @PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
    public String processNewVisitForm(@Valid Visit visit, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_PETS_CREATE_OR_UPDATE_VISIT_FORM;
        } else {
            if (visit.getDate() == null) {
                visit.setDate(LocalDate.now());
            }
            visitService.save(visit);
            return "redirect:/owners/{ownerId}/detail";
        }
    }
}
