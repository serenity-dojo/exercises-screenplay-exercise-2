package serenitylabs.tutorials.vetclinic.features.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.annotations.Step;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

public class CheckOut  implements Performable {
    private Pet pet;
    private PetHotel petHotel;

    public CheckOut(){}

    public CheckOut(Pet pet, PetHotel petHotel) {
        this.pet = pet;
        this.petHotel = petHotel;
    }

    @Step("{0} checks #pet out of #petHotel")
    @Override
    public <T extends Actor> void performAs(T actor) {
        petHotel.checkOut(pet);
    }

    public static CheckOutBuilder aPet(Pet pet) {
        return new CheckOutBuilder(pet);
    }

    public static class CheckOutBuilder {
        private final Pet pet;

        public CheckOutBuilder(Pet pet) {
            this.pet = pet;
        }

        public Performable from(PetHotel petHotel) {
            return new CheckOut(pet, petHotel);
        }
    }
}
