package experis.ticket;

public class TicketMain {
    public static void main(String[] args) {

        //qualche test per debug

        Ticket ticket1 = new Ticket(30, 75);
        System.out.println(ticket1.calculatePrice());

        Ticket ticket2 = new Ticket(16, 89);
        System.out.println(ticket2.calculatePrice());

        Ticket ticket3 = new Ticket(70, 100);
        System.out.println(ticket3.calculatePrice());
    }
}
