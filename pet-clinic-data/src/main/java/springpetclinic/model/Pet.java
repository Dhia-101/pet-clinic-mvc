package springpetclinic.model;

import java.time.LocalDate;

public class Pet {
    private petType type;
    private Owner owner;
    private LocalDate birthdate;

    public petType getType() {
        return type;
    }

    public void setType(petType type) {
        this.type = type;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
