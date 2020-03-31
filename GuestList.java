import java.util.ArrayList;
import java.util.Scanner;

public class GuestList {
    private static int noAvailable;
    private static ArrayList<Guest> guestList;
    private static ArrayList<Guest> waitingList;


    public GuestList(ArrayList<Guest> guestList, ArrayList<Guest> waitingList,int noAvailable){
        this.guestList=guestList;
        this.waitingList=waitingList;
        GuestList.noAvailable=noAvailable;
    }

    public boolean isEnrolled(Guest g, ArrayList<Guest> arrayList, String criteriu){
        boolean cond;
        switch (criteriu){
            case "Name":cond=Contains.containsName(g,arrayList);
                break;
            case "Email":cond=Contains.containsEmail(g,arrayList);
                break;
            case "PhoneNumber":cond=Contains.containsPhoneNumber(g,arrayList);
                break;
            default:cond=false;
        }
        return cond;
    }

    public Guest findElementBy(ArrayList<Guest> a,String criteriu, String s){
        Guest guest;
        switch (criteriu){
            case "Name":guest=Find.findByName(a,s);
                break;
            case "Email":guest=Find.findByEmail(a,s);
                break;
            case "PhoneNumber":guest=Find.findByPhoneNumber(a,s);
                break;
            default:guest=new Guest();
                break;
        }
        return guest;
    }
    public int add(Guest g){
        Scanner sc=new Scanner(System.in);

        if(isEnrolled(g,guestList,"Nume")==true || isEnrolled(g,guestList,"Email")==true || isEnrolled(g,guestList,"PhoneNumber")==true){
            System.out.println("Esti deja inscris la eveniment!");
            return -1;
        }
        else if(guestList.size()>=noAvailable){
                waitingList.add(g);
                System.out.println("Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine "+waitingList.size()+". Te vom notifica daca un loc devine disponibil.");

                return waitingList.size();
            }
        guestList.add(g);
        System.out.println("Felicitari!Locul tau la eveniment este confirmat.Te asteptam!");
        return 0;
    }


    public boolean remove(Guest g,String criteriu){


        if(isEnrolled(g,guestList,criteriu)==false)
        {
            if(isEnrolled(g,waitingList,criteriu)==true){
                waitingList.remove(g);
                return true;
            }
            else {
                System.out.println("Persoana cautata nu este inregistrata in sistem");
                return false;
            }
        }
        else{
            guestList.remove(g);
            if(waitingList.size()!=0){
                guestList.add(waitingList.get(0));
                waitingList.remove(waitingList.get(0));
            }
            return true;
        }

    }

    public void updateProfile(Guest g,String criteriu,String newString){
        if(isEnrolled(g,guestList,criteriu)==true)
        {
            int i=guestList.indexOf(g);
            switch (criteriu){
                case "Name":
                    int x=0;
                    while(newString.charAt(x)!=' ' && x<newString.length())
                        x++;
                    String nume=newString.substring(0,x);
                    guestList.get(i).setLastName(nume);
                    nume=newString.substring(x+1,newString.length());
                    guestList.get(i).setFirstName(nume);
                    break;
                case "Email":guestList.get(i).setEmail(newString);;
                    break;
                case "PhoneNumber":guestList.get(i).setPhoneNumber(newString);
                    break;
                default:System.out.println("Nu exista acest criteriu");
            }
        }
    }

    public static void printare(ArrayList<Guest> a){
        for(int i=0;i<a.size();i++)
            System.out.println(i+1+"."+a.get(i).toString());
    }

    public static boolean findStringInList(String string){
        ArrayList<Guest> rezultat,listaCompleta;
        boolean cond;
        listaCompleta=new ArrayList<>(guestList);
        listaCompleta.addAll(waitingList);
        rezultat=FindSubString.containsStringInName(listaCompleta,string);
        if (rezultat.size()!=0) {
            System.out.println("Name:");
            printare(rezultat);
            cond=true;
        }
        rezultat.clear();
        rezultat=FindSubString.containsStringInEmail(listaCompleta,string);
        if (rezultat.size()!=0) {
            System.out.println("Email:");
            printare(rezultat);
            cond=true;
        }
        rezultat.clear();
        rezultat=FindSubString.containsStringInPhoneNumber(listaCompleta,string);
        if (rezultat.size()!=0){
            System.out.println("PhoneNumber:");
            printare(rezultat);
            cond=true;
        }
        cond=false;
        return cond;
    }



    public ArrayList<Guest> getGuestList() {
        return guestList;
    }

    public ArrayList<Guest> getWaitingList(){
        return waitingList;
    }

    public int getNoAvailable(){
        if(guestList.size()==noAvailable)
            return 0;
        return noAvailable-guestList.size();
    }

    public int getParticipants(){
        return guestList.size();
    }

    public int getNoWaiting(){
        return waitingList.size();
    }

    public int getTotal(){
        return guestList.size()+waitingList.size();
    }

}
