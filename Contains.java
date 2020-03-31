import java.util.ArrayList;

public class Contains {
    public static boolean containsName(Guest g, ArrayList<Guest> arrayList){
        int i;
        ArrayList<Guest> a=arrayList;
        for(i=0;i<a.size();i++)
            if(a.get(i).getLastName().equals(g.getLastName()) && a.get(i).getFirstName().equals(g.getFirstName()))
                return true;
        return false;
    }
    public static boolean containsEmail(Guest g, ArrayList<Guest> arrayList){
        int i;
        ArrayList<Guest> a=arrayList;
        for(i=0;i<a.size();i++)
            if(a.get(i).getEmail().equals(g.getEmail()))
                return true;
        return false;
    }
    public static boolean containsPhoneNumber(Guest g, ArrayList<Guest> arrayList){
        int i;
        ArrayList<Guest> a=arrayList;
        for(i=0;i<a.size();i++)
            if(a.get(i).getPhoneNumber().equals(g.getPhoneNumber()))
                return true;
        return false;
    }
}
