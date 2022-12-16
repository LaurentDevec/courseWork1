import java.time.LocalDate;
import java.time.LocalTime;

public class Client implements FitnessTraining {
    // здесь будет содержаться ФИО, дата рождения клиента фитнеса
    public String name;
    public String surname;
    public LocalDate dateOfBirth;
    private LocalDate registrationStart;
    private LocalDate registrationEnd;
    private LocalTime validFrom;
    private LocalTime validTo;
    private ZoneSport[] zoneSport;

    public Client(String name, String surname, LocalDate dateOfBirth, LocalDate registrationEnd, LocalTime validFrom, LocalTime validTo) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.registrationStart = LocalDate.now();
        this.registrationEnd = registrationEnd;
        this.validFrom = validFrom;
        this.validTo = validTo;

    }

    public String getFullName() {
        return name + " " + surname + " " + dateOfBirth;
    }

    public String getName() {
        return name;
    }
    

    public String getSurname() {
        return surname;
    }

   

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean addFitnessZone(ZoneSport zoneSportName) {
        if (zoneSportName == null) return false;
        for (int i = 0; i < zoneSport.length; i++) {
            if (zoneSport[i] == null) {
                zoneSport[i] = zoneSportName;
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return "Абонемент № " +
                " Имя: " + name +
                " Фамилия: " + surname +
                " Дата рождения: " + dateOfBirth +
                " Действует с " + registrationStart +
                " по " + registrationEnd;
    }

    @Override
    public String startTraining(Fitness fitness, ZoneSport zoneSport) {
        return null;
    }

    @Override
    public void stopTraining(Fitness fitness, ZoneSport zoneSport) {
        if (fitness == null) throw new IllegalArgumentException("Ошшибка!");
        if (zoneSport == null) throw new IllegalArgumentException("Ошибка!");
        if (!fitness.zoneExist(zoneSport)) return;
        zoneSport.stopUsing(this);
    }

}

