package model;

import java.util.Date;

public class InhibitionLog {
    private Date checkInDate;
    private Date checkOutDate;
    private Species animalSpecies;
    private String animalName;

    public InhibitionLog(final Date checkInDate,
                         final Date checkOutDate,
                         final Species animalSpecies,
                         final String animalName) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.animalSpecies = animalSpecies;
        this.animalName = animalName;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public Species getAnimalSpecies() {
        return animalSpecies;
    }

    public String getAnimalName() {
        return animalName;
    }

    @Override
    public String toString() {
        return "\nInhibitionLog{" +
                "checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", animalSpecies=" + animalSpecies +
                ", animalName='" + animalName + '\'' +
                '}';
    }
}
