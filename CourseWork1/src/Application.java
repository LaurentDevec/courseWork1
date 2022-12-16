
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

    public class Application {
        public static void main(String[] args) {
            Fitness myFitness = new Fitness("Наш Фитнес", 3, 100);
            ZoneSport myZone1 = new ZoneSport("Бассейн");
            ZoneSport myZone2 = new ZoneSport("Тренажерный зал");
            ZoneSport myZone3 = new ZoneSport("Групповые занятия");
            Client client1 = new Client("Иван", "Сидоров", LocalDate.parse("19984-08-22"), LocalDate.parse("2021-12-12"), LocalTime.parse("08:00:00"),  LocalTime.parse("22:00:00"));
            client1.addFitnessZone(myZone1);
            client1.addFitnessZone(myZone2);
            Client client2 = new Client("Петр", "Петров", LocalDate.parse("2001-01-01"), LocalDate.parse("2021-11-11"), LocalTime.parse("08:00:00"),  LocalTime.parse("16:00:00"));
            client2.addFitnessZone(myZone3);
            Client client3 = new Client("Michael", "Jackson", LocalDate.parse("1885-16-10"), LocalDate.parse("2021-10-10"), LocalTime.parse("00:00:00"),  LocalTime.parse("23:59:59"));


            System.out.println("Здравствуйте " + client1);
            System.out.println("Здравствуйте " + client2);
            System.out.println("Здравствуйте " + client3);

            Scanner in = new Scanner(System.in);
            while (true) {
                System.out.println("1 - Начать работу фитнеса");
                System.out.println("2 - Добавить новый абонемент");
                System.out.println("3 - Начать занятие по абонементу");
                System.out.println("4 - Закончить занятие по абонементу");
                System.out.println("5 - Вывести информацию о текущих посетителях");
                System.out.println("8 - Вывести информацию о зарегистрированных посетителях");
                System.out.println("9 - Завершить работу фитнеса");
                System.out.println("0 - выход");
                int userChoice = Integer.parseInt(in.nextLine());
                if (userChoice == 0) break;
                switch (userChoice) {
                    case 1:
                        myFitness.openFitness();
                        break;

                    case 2:
                        // добавление нового абонемент
                        System.out.println("Введите имя:");
                        String newClientName = in.nextLine().strip();
                        System.out.println("Введите фамилию:");
                        String newClientSurname = in.nextLine().strip();
                        System.out.println("Введите Год рождения ГГГГ-ММ-ДД:");
                        String newClientBirthDate = in.nextLine().strip();
                        System.out.println("Введите дату окончания ГГГГ-ММ-ДД:");
                        String newClientEndDate = in.nextLine().strip();
                        System.out.println("Введите время начала занятий ЧЧ:ММ:СС:");
                        String newClientStartTime = in.nextLine().strip();
                        System.out.println("Введите время окончания занятий ЧЧ:ММ:СС:");
                        String newClientEndTime = in.nextLine().strip();

                        Client clientNew = new Client(newClientName, newClientSurname, LocalDate.parse(newClientBirthDate),
                                LocalDate.parse(newClientEndDate), LocalTime.parse(newClientStartTime), LocalTime.parse(newClientEndTime));
                        for (int j = 0; j < myFitness.getZoneSports().length; j++) {
                            System.out.println("Выберите " + j + " зону:");
                            for (int i = 0; i < myFitness.getZoneSports().length; i++) {
                                if (myFitness.getZoneSports()[i] != null) System.out.println(i + " " + myFitness.getZoneSports()[i].getZoneSportName());
                            }
                            int myZoneNum = Integer.parseInt(in.nextLine());
                            clientNew.addFitnessZone(myFitness.getZoneSports()[myZoneNum]);
                        }
                        myFitness.addClient(clientNew);
                        break;

                    case 3:
                        //начало спорт занятия
                        for (int i = 0; i < myFitness.getClients().length; i++) {
                            if (myFitness.getClients()[i] != null) System.out.println(i + " " + myFitness.getClients()[i].getName() + " " + myFitness.getClients()[i].getSurname());
                        }
                        System.out.println("Выберите абонемент: ");
                        int mySubs = Integer.parseInt(in.nextLine());
                        for (int i = 0; i < myFitness.getZoneSports().length; i++) {
                            if (myFitness.getZoneSports() != null) System.out.println(i + " " + myFitness.getZoneSports()[i].getZoneSportName());
                        }
                        System.out.println("Выберите зону: ");
                        int myZone = Integer.parseInt(in.nextLine());
                        System.out.println(myFitness.getClients()[mySubs].startTraining(myFitness, myFitness.getZoneSports()[myZone]));
                        break;

                    case 4:
                        //Закончить занятие по абонементу
                        for (int i = 0; i < myFitness.getClients().length; i++) {
                            if (myFitness.getClients()[i] != null) System.out.println(i + " " + myFitness.getClients()[i].getName() + " " + myFitness.getClients()[i].getSurname());
                        }
                        System.out.println("Выберите абонемент: ");
                        int mySubsEnd = Integer.parseInt(in.nextLine());
                        for (int i = 0; i < myFitness.getZoneSports().length; i++) {
                            if (myFitness.getZoneSports() != null) System.out.println(i + " " + myFitness.getZoneSports()[i].getZoneSportName());
                        }
                        System.out.println("Выберите зону: ");
                        int myZoneEnd = Integer.parseInt(in.nextLine());
                        myFitness.getClients()[mySubsEnd].stopTraining(myFitness, myFitness.getZoneSports()[myZoneEnd]);
                        break;

                    case 5:
                        //Информация о посетитешлях
                        for (ZoneSport zoneSport : myFitness.getZoneSports()) {
                            for (Client client : zoneSport.getClients()) {
                                if(client != null) System.out.println(myFitness.getFitnessName() + " " + zoneSport.getZoneSportName() + " " + client.toString());
                            }
                        }
                        break;

                    case 8:
                        //Информация о зарегистрированных посетитешлях
                        for (Client client : myFitness.getClients()) {
                            if(client != null) System.out.println(client.toString());
                        }
                        break;

                    case 9:
                        //З конец работы
                        myFitness.closeFitness();
                        break;


            }
        }
    }
}
