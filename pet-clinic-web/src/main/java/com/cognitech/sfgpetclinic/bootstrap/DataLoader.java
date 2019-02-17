/*
 * Created by User on 17/02/2019
 */

package com.cognitech.sfgpetclinic.bootstrap;

import com.cognitech.sfgpetclinic.model.Owner;
import com.cognitech.sfgpetclinic.model.Vet;
import com.cognitech.sfgpetclinic.services.OwnerService;
import com.cognitech.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner
{
    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired          //--- Not needed for Spring 5
    public DataLoader(OwnerService ownerService, VetService vetService)
    {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception
    {
        Owner owner1 = new Owner();
        owner1.setFirstName("Amit");
        owner1.setLastName("Sule");
        this.ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Joe");
        owner2.setLastName("Bloggs");
        this.ownerService.save(owner2);


        System.out.println("Owners loaded........");

        Vet vet1 = new Vet();
        vet1.setFirstName("John");
        vet1.setLastName("Smith");
        this.vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sam");
        vet2.setLastName("Axe");
        this.vetService.save(vet2);

        System.out.println("Vets loaded...........");
    }
}
