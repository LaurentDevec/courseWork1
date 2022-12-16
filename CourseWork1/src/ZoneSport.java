import java.util.Objects;

public class ZoneSport {
    private String zoneSportName;
    private Client[] clients;

    public ZoneSport(String fitnessZoneName) {
        this.zoneSportName = fitnessZoneName;
        this.clients = new Client[20];
    }

    public String getZoneSportName() {
        return zoneSportName;
    }

    public Client[] getClients() {
        return clients;
    }

    public boolean clientExist(Client client) {
        if (client == null) throw new IllegalArgumentException("Ошибка");
        for (Client isClient : clients) {
            if(client.equals(isClient)) return true;
        }
        return false;
    }

    public boolean addClient(Client client) {
        if (client == null) throw new IllegalArgumentException("Ошибка");
        if(clientExist(client)) return false;
        for (int i = 0; i < clients.length; i++) {
            if(clients[i] == null) {
                clients[i] = client;
                return true;
            }
        }
        return false;
    }

    public boolean stopUsing(Client client) {
        if (client == null) throw new IllegalArgumentException("Ошибка");
        for (int i = 0; i < clients.length; i++) {
            if(client.equals(clients[i])) {
                clients[i] = null;
                return true;
            }
        }
        return false;
    }

    public void stopZone() {
        for (int i = 0; i < clients.length; i++) {
            clients[i] = null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ZoneSport)) return false;
        ZoneSport that = (ZoneSport) o;
        return Objects.equals(zoneSportName, that.zoneSportName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zoneSportName);
    }

    @Override
    public String toString() {
        return zoneSportName;
    }
}
