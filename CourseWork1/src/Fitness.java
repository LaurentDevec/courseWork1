public class Fitness {
    final private String fitnessName;
    private ZoneSport[] zoneSports;
    private Client[] clients;
    private Boolean isOpen;

    public Fitness(String fitnessName, int fitnessZoneCount, int clientsCount) {
        this.fitnessName = fitnessName;
        if (fitnessZoneCount < 1) throw new IllegalArgumentException("Неверное значение ");
        this.zoneSports = new ZoneSport[fitnessZoneCount];
        if (clientsCount < 1) throw new IllegalArgumentException("Неверное значение");
        this.clients = new Client[clientsCount];
        this.isOpen = false;
    }

    public String getFitnessName() {
        return fitnessName;
    }

    public ZoneSport[] getZoneSports() {
        return zoneSports;
    }

    public Client[] getClients() {
        return clients;
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public boolean zoneExist(ZoneSport zoneSport) {
        if (zoneSport == null) throw new IllegalArgumentException("Неверное значение fitnessZone");
        for (ZoneSport zone : zoneSports) {
            if(zoneSport.equals(zone)) return true;
        }
        return false;
    }

    public boolean addZone(ZoneSport zoneSport){
        if (zoneSport == null) throw new IllegalArgumentException("Неверное значение fitnessZone");
        for (int i = 0; i < zoneSports.length; i++) {
            if (zoneSports[i] == null) {
                zoneSports[i] = zoneSport;
                return true;
            }
        }
        return false;
    }
    public boolean addClient(Client client) {
        if (client == null) throw new IllegalArgumentException("Ошибка!");
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] == null) {
                clients[i] = client;
                return true;
            }
        }
        return false;
    }

    public void openFitness() {
        this.isOpen = true;
    }

    public void closeFitness() {
        for (int i = 0; i < zoneSports.length; i++) {
            zoneSports[i].stopZone();
        }
        this.isOpen = false;
    }


}
