/*
 * Created by User on 17/02/2019
 */

package com.cognitech.sfgpetclinic.bootstrap;

import com.cognitech.sfgpetclinic.model.Owner;
import com.cognitech.sfgpetclinic.model.Pet;
import com.cognitech.sfgpetclinic.model.PetType;
import com.cognitech.sfgpetclinic.model.Speciality;
import com.cognitech.sfgpetclinic.model.Vet;
import com.cognitech.sfgpetclinic.model.Visit;
import com.cognitech.sfgpetclinic.services.OwnerService;
import com.cognitech.sfgpetclinic.services.PetTypeService;
import com.cognitech.sfgpetclinic.services.SpecialityService;
import com.cognitech.sfgpetclinic.services.VetService;
import com.cognitech.sfgpetclinic.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner
{
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    @Autowired          //--- Not needed for Spring 5
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService,
                      VisitService visitService)
    {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception
    {
        int count = this.petTypeService.findAll().size();
        if (count == 0)
        {
            loadData();
        }
    }

    private void loadData()
    {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = this.petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = this.petTypeService.save(cat);

        System.out.println("Pet Types loaded........");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = this.specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = this.specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = this.specialityService.save(dentistry);

        System.out.println("Specialities loaded........");

        Owner owner1 = new Owner();
        owner1.setFirstName("Amit");
        owner1.setLastName("Sule");
        owner1.setAddress("Regency Lodge");
        owner1.setCity("London");
        owner1.setPhone("2323-3434-3434");

        Pet pet1 = new Pet();
        pet1.setPetType(savedDogPetType);
        pet1.setBirthDate(LocalDate.now());
        pet1.setName("Toto");
        pet1.setOwner(owner1);
        owner1.getPets().add(pet1);

        this.ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Joe");
        owner2.setLastName("Bloggs");
        owner2.setAddress("53 Some Street");
        owner2.setCity("Miami");
        owner2.setPhone("333-777-43443");

        Pet pet2 = new Pet();
        pet2.setPetType(savedCatPetType);
        pet2.setBirthDate(LocalDate.now());
        pet2.setName("Just Cat");
        pet2.setOwner(owner2);
        owner2.getPets().add(pet2);

        this.ownerService.save(owner2);

        System.out.println("Owners loaded........");

        Visit catVisit = new Visit();
        catVisit.setPet(pet2);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");
        this.visitService.save(catVisit);

        System.out.println("Visits loaded........");

        Vet vet1 = new Vet();
        vet1.setFirstName("John");
        vet1.setLastName("Smith");
        vet1.getSpecialities().add(savedRadiology);
        this.vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sam");
        vet2.setLastName("Axe");
        vet2.getSpecialities().add(savedSurgery);
        this.vetService.save(vet2);

        System.out.println("Vets loaded...........");
    }
}
