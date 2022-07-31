package serenitylabs.tutorials.vetclinic.features;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import serenitylabs.tutorials.vetclinic.features.tasks.CheckIn;
import serenitylabs.tutorials.vetclinic.features.tasks.CheckOut;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenCheckingInToThePetHotel {

    @Test
    public void petra_books_her_pet_cat_into_the_hotel() {

        // GIVEN

        Actor petra = Actor.named("Petra the pet owner");
        Pet ginger = Pet.cat().named("Ginger");
        PetHotel petHotel = PetHotel.called("Pet Hotel California");

        // WHEN
        petra.attemptsTo(
                CheckIn.aPet(ginger).into(petHotel)
        );

        // THEN
        assertThat(petHotel.getPets(), hasItem(ginger));

    }

    @Test
    public void petra_checks_her_cat_out_of_the_hotel() {

        // GIVEN

        Actor petra = Actor.named("Petra the pet owner");
        Pet ginger = Pet.cat().named("Ginger");
        PetHotel petHotel = PetHotel.called("Pet Hotel California");

        petra.wasAbleTo(CheckIn.aPet(ginger).into(petHotel));

        // WHEN
        petra.attemptsTo(
                CheckOut.aPet(ginger).from(petHotel)
        );

        // THEN
        assertThat(petHotel.getPets(), not(hasItem(ginger)));

    }
}
