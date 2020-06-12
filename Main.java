import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static String criteriuSwitch(String criteriu){
        switch (criteriu){
            case "1":criteriu="Nume";
                System.out.println("Introduceti numele si prenumele:");
                break;
            case "2":criteriu="Email";
                System.out.println("Introduceti email-ul:");
                break;
            case "3":criteriu="PhoneNumber";
                System.out.println("Introduceti numarul de telefon:");
                break;
            default:System.out.println("Nu exista acest criteriu");
                break;
        }
        return criteriu;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<Guest> guestList,waitingList;
        guestList=new ArrayList<>();
        waitingList=new ArrayList<>();
        String comanda,afisare,afisare2="Introduceti lista in care se realizeaza cautarea-GuestList sau WaitingList:";
        String criteriu, lista,newString,s,text="Alege modul de autentificare, tastand:\n\"1\" - Nume si prenume\n" +
                "\"2\" - Email\n" +
                "\"3\" - Numar de telefon (format \"0733386463\")";
        afisare="help         - Afiseaza aceasta lista de comenzi\n" +
                "add          - Adauga o noua persoana (inscriere)\n" +
                "check        - Verifica daca o persoana este inscrisa la eveniment\n" +
                "remove       - Sterge o persoana existenta din lista\n" +
                "update       - Actualizeaza detaliile unei persoane\n" +
                "guests       - Lista de persoane care participa la eveniment\n" +
                "waitlist     - Persoanele din lista de asteptare\n" +
                "available    - Numarul de locuri libere\n" +
                "guests_no    - Numarul de persoane care participa la eveniment\n" +
                "waitlist_no  - Numarul de persoane din lista de asteptare\n" +
                "subscribe_no - Numarul total de persoane inscrise\n" +
                "search       - Cauta toti invitatii conform sirului de caractere introdus\n" +
                "quit         - Inchide aplicatia";
        System.out.println("Bun venit! Introduceti numarul de locuri diponibile:");
        GuestList g=new GuestList(guestList,waitingList,sc.nextInt());
        Guest guest;
        comanda="help";
        System.out.println(afisare);
        guest=new Guest("","","","");
        while (!comanda.equals("quit")){
            System.out.println("Introduceti o comanda:");
            comanda=sc.nextLine();
            switch (comanda){
                case "help":System.out.println(afisare);
                    break;
                case "add":
                    System.out.println("Introduceti datele utilizatorului:\nNume:");
                    String nume,prenume,email,telefon;
                    try{
                    nume=sc.nextLine();
                    System.out.println("Prenume:");
                    prenume=sc.nextLine();
                    System.out.println("Email:");
                    email=sc.nextLine();
                    System.out.println("PhoneNumber:");
                    telefon=sc.nextLine();}
                    catch(InputMismatchException e){
                        System.out.println("Datele introduse nu sunt valide. Utilizatorul nu va fi adaugat...");
                        break;
                    }
                    guest=new Guest(nume,prenume,email,telefon);
                    g.add(guest);
                    break;
                case "check":
                    System.out.println(text);
                    criteriu=sc.nextLine();
                    System.out.println(afisare2);
                    lista=sc.nextLine();
                    criteriu=criteriuSwitch(criteriu);
                    s=sc.nextLine();
                    if(lista.equals("GuestList")){
                        guest=g.findElementBy(g.getGuestList(),criteriu,s);
                        System.out.println("Invitatul este pe lista de participanti?"+guest.getFirstName()==""?false:true);
                    }
                    else if(lista.equals("WaitingList")){
                        guest=g.findElementBy(g.getWaitingList(),criteriu,s);
                        System.out.println("Invitatul este pe lista de asteptare?"+guest.getFirstName()==""?false:true);
                    }
                        else System.out.println("Nu exista o astfel de lista");
                    break;
                case "remove":
                    System.out.println(text);
                    criteriu=sc.nextLine();
                    guest=new Guest();
                    criteriu=criteriuSwitch(criteriu);
                    s=sc.nextLine();
                    guest=g.findElementBy(guestList,criteriu,s);
                    if(guest.getFirstName()!="")
                        System.out.println(g.remove(guest,criteriu));
                    break;
                case "update":
                    System.out.println(text);
                    criteriu=sc.nextLine();
                    guest=new Guest();
                    criteriu=criteriuSwitch(criteriu);
                    s=sc.nextLine();
                    System.out.println("Introduceti noua valoare a campului:");
                    newString=sc.nextLine();
                    System.out.println(afisare2);
                    lista=sc.nextLine();
                    ArrayList<Guest> a=lista.equals("GuestList")? g.getGuestList():g.getWaitingList();
                    guest=g.findElementBy(a,criteriu,s);
                    if(guest.getFirstName()!="")
                        g.updateProfile(guest,criteriu,newString);
                    else System.out.println("Invitatul nu se gaseste printre cei inscrisi");
                    break;
                case "guests":
                    if(g.getParticipants()==0)
                        System.out.println("Nu exista niciun participant");
                    else{ ArrayList<Guest> newG=g.getGuestList();
                          GuestList.printare(newG);}
                    break;
                case "waitlist":
                    if(g.getNoWaiting()==0)
                        System.out.println("Nu exista nicio persoana in lista de asteptare.");
                    else{ ArrayList<Guest> newW=g.getWaitingList();
                        GuestList.printare(newW);}
                    break;
                case "available":System.out.println(g.getNoAvailable());
                    break;
                case "guests_no":System.out.println(g.getParticipants());
                    break;
                case "waitlist_no":System.out.println(g.getNoWaiting());
                    break;
                case "subscribe_no":System.out.println(g.getTotal());
                    break;
                case "search":
                    System.out.println("Introduceti string-ul cautat:");
                    String string=sc.nextLine();
                    GuestList.findStringInList(string);
                    break;
                case "quit":System.out.println("Ai ales sa iesi din aplicatie");
                    break;
            }
        }
        sc.close();
    }
}
