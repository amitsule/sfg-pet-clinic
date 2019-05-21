package guru.springframework.sfgpetclinic.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest
{
    public static final String LAST_NAME = "Smith";
    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    Owner returnOwner;

    @BeforeEach
    void setUp()
    {
        this.returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName()
    {
        when(this.ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        Owner smith = this.ownerSDJpaService.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME, smith.getLastName());

        verify(this.ownerRepository).findByLastName(any());
    }

    @Test
    void findAllByLastNameLike()
    {
    }

    @Test
    void findAll()
    {
        Set<Owner> returnOwnerSet = new HashSet<>();
        returnOwnerSet.add(Owner.builder().id(1L).build());
        returnOwnerSet.add(Owner.builder().id(2L).build());

        when(this.ownerRepository.findAll()).thenReturn(returnOwnerSet);
        Set<Owner> owners = this.ownerSDJpaService.findAll();
        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById()
    {
        when(this.ownerRepository.findById(anyLong())).thenReturn(Optional.of(this.returnOwner));
        Owner owner = this.ownerSDJpaService.findById(1L);
        assertNotNull(owner);
        assertEquals(1L, (long) owner.getId());
    }

    @Test
    void findByIdNotFound()
    {
        when(this.ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner = this.ownerSDJpaService.findById(1L);
        assertNull(owner);
    }

    @Test
    void save()
    {
        Owner ownerToSave = Owner.builder().id(1L).build();
        when(this.ownerRepository.save(any())).thenReturn(ownerToSave);
        Owner owner = this.ownerSDJpaService.save(ownerToSave);
        assertNotNull(owner);
        verify(this.ownerRepository).save(any());
    }

    @Test
    void delete()
    {
        this.ownerSDJpaService.delete(this.returnOwner);
        verify(this.ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById()
    {
        this.ownerSDJpaService.deleteById(1L);
        verify(this.ownerRepository).deleteById(any());
    }
}