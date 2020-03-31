import java.util.ArrayList;

public class Find {
    public static Guest findByName(ArrayList<Guest> a,String s){
        int i;
        for(i=0;i<a.size();i++)
            if((a.get(i).getLastName()+" "+a.get(i).getFirstName()).equals(s))
                return a.get(i);
        return new Guest("","","","");
    }
    public static Guest findByEmail(ArrayList<Guest> a,String s){
        int i;
        for(i=0;i<a.size();i++)
            if(a.get(i).getEmail().equals(s))
                return a.get(i);
        return new Guest("","","","");
    }
    public static Guest findByPhoneNumber(ArrayList<Guest> a,String s){
        int i;
        for(i=0;i<a.size();i++)
            if(a.get(i).getPhoneNumber().equals(s))
                return a.get(i);
        return new Guest("","","","");
    }
}
