import java.util.ArrayList;
public class FindSubString {

    public static ArrayList<Guest> containsStringInName(ArrayList<Guest> listaCompleta,String string){
        try{
        string=string.toLowerCase();
        } catch(NullPointerException e){
            System.out.println("Sirul de caractere dat ca parametrii este invalid");
            return null;
        }
        int i;
        ArrayList<Guest> rezultat=new ArrayList<>();
        for(i=0;i<listaCompleta.size();i++){
            String element=listaCompleta.get(i).getLastName();
            element=element.concat(" ");
            element=element.concat(listaCompleta.get(i).getFirstName());
            element=element.toLowerCase();
            if(element.contains(string)) {
                rezultat.add(listaCompleta.get(i));
            }
        }

        return rezultat;
    }

    public static ArrayList<Guest> containsStringInEmail(ArrayList<Guest> listaCompleta,String string){
        string=string.toLowerCase();
        ArrayList<Guest> rezultat=new ArrayList<>();
        for(int i=0;i<listaCompleta.size();i++){
            String element=listaCompleta.get(i).getEmail();
            element=element.toLowerCase();
            if(element.contains(string)) {
                rezultat.add(listaCompleta.get(i));
            }
        }
        return rezultat;
    }
    public static ArrayList<Guest> containsStringInPhoneNumber(ArrayList<Guest> listaCompleta,String string){
        ArrayList<Guest> rezultat=new ArrayList<>();
        for(int i=0;i<listaCompleta.size();i++){
            if(listaCompleta.get(i).getPhoneNumber().contains(string)) {
                rezultat.add(listaCompleta.get(i));
            }
        }
        return rezultat;
    }
}
