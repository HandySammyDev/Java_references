package prob1;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;

//“This homework represents my own work. I understand that I may receive help,
// but I did not copy any portion of this assignment from anywhere.
// I understand that a violation of this will result in a Report of Academic Dishonesty.
// —Samuel Perez-Hernandez”

public class MartianManager {

    protected ArrayList<Martian> martians = new ArrayList<>();
    protected ArrayList<Teleporter> teleporters = new ArrayList<>();

    public MartianManager(){}

    public void absorbColony(ArrayList<Martian> colony){
        martians.addAll(colony);
        for(Martian m : colony){
            if(m instanceof Teleporter){
                teleporters.add((Teleporter) m);
            }
        }
    }

    public boolean addMartian(Martian m){
        int pos = martians.indexOf(m);
        if(pos>=0){
            return false;
        }
        else{
            martians.add(m);
        }

        if(m instanceof Teleporter){
            teleporters.add((Teleporter) m);
        }
        return true;
    }

    private double averagePower(){
        double sum = 0.0;
        for(Martian m : martians){
            sum += m.power();
        }
        return sum / martians.size();
    }

    public ArrayList<Martian> battle(ArrayList<Martian> invaders){
        ArrayList<Martian> defeatedMartians = new ArrayList<>();

        for(int i=0; i<invaders.size(); i++){
            for(int j=0; j<martians.size(); j++){
                Martian m = martians.get(j);

                if(m.power() < invaders.get(i).power()){
                    defeatedMartians.add(m);
                    martians.remove(j);

                    if (m instanceof Teleporter) {
                        teleporters.remove(m);
                    }

                    break;
                }
            }
        }
        return defeatedMartians;
    }

    public ArrayList<Martian> captureInvaders(ArrayList<Martian> invaders){

        ArrayList<Martian> capturedInvaders = new ArrayList<>();
        for(Martian i : invaders){
            if(i.power() < averagePower()){
                martians.add(i);
                if(i instanceof Teleporter){
                    teleporters.add((Teleporter) i);
                }
                capturedInvaders.add(i);
            }
        }
        return capturedInvaders;
    }

    public boolean contains(int id){
        return martians.contains(new RedMartian(id, 0));
    }

    public Martian getMartianAt(int i){
        if(i<0 || i >= martians.size()){
            return null;
        }
        return martians.get(i);
    }

    public Martian getMartianClosetTo(int id){
        int[] closest = new int[martians.size()];

        for (int i=0; i<martians.size(); i++) {
            closest[i] = Math.abs(martians.get(i).getId() - id);
        }

        int smallest = 0;

        for(int i=0; i<martians.size()-1; i++){
            if(closest[i]<closest[smallest]){
                smallest = i;
            }
        }
        if(martians.get(smallest).getId()==id){
            return null;
        }
        else{
            return martians.get(smallest);
        }
    }

    public Martian getMartianClosetTo(Martian martian){
        return getMartianClosetTo(martian.getId());
    }

    public Martian getMartianWithId(int id){
        for(Martian m : martians){
            if(m.getId() == id){
                return m;
            }
        }
        return null;
    }

    public int getNumMartians(){
        return martians.size();
    }

    public int getNumTeleporters(){
        return teleporters.size();
    }

    public ArrayList<Martian> getSortedMartians(){
        ArrayList<Martian> sorted = martians;

        for(int i=0; i<martians.size()-1; i++){
            for(int j=0; j<martians.size()-i-1; j++){
                if(martians.get(j).getId() > martians.get(j + 1).getId()){
                    Martian temp = martians.get(j);
                    sorted.set(j, martians.get(j + 1));
                    sorted.set(j + 1, temp);
                }
            }
        }
        return sorted;
    }

    public Teleporter getTeleporterAt(int i){
        if(i<0 || i>=teleporters.size()){
            return null;
        }
        else{
            return teleporters.get(i);
        }
    }

    public String groupSpeak(){
        String s = "";
        for(Martian m : martians){
            s += m.speak() + "\n";
        }
        return s;
    }

    public String groupTeleport(String dest){
        String s = "";
        for(Teleporter t : teleporters){
            s += t.teleport(dest) + "\n";
        }
        return s;
    }

    public void obliterateTeleporters(){
        ArrayList<Martian> list = new ArrayList<>();
        for (Martian m : martians){
            if(m instanceof Teleporter){
                list.add(m);
            }
        }
        teleporters.clear();
        martians.removeAll(list);
    }

    public Martian removeMartianAt(int loc){
        if(loc<0 || loc>=martians.size()){
            return null;
        }
        Martian martian = martians.get(loc);
        martians.remove(loc);

        int index = -1;
        for(int i=0; i<teleporters.size(); i++){
            if(martian.equals(teleporters.get(i))){
                index = i;
            }
        }
        if(!(index==-1)){
            teleporters.remove(index);
        }

        return martian;
    }

    public Martian removeMartianWithId(int id){
        Martian martian = getMartianWithId(id);
        if(martian != null){
            martians.remove(martian);
        }
        if(martian instanceof Teleporter){
            teleporters.remove(martian);
        }
        return martian;
    }

    @Override
    public String toString(){
        String s = "Martians:\n";
        for(Martian m : martians){
            if(m instanceof RedMartian){
                s += String.format("\tRed Martian - id=%d vol=%d, ten=%d\n",
                        m.getId(), m.getVolume(), ((RedMartian) m).getTenacity());
            }
        }
        for(Martian m : martians){
            if(m instanceof GreenMartian){
                s += String.format("\tGreen Martian - id=%d vol=%d\n",
                        m.getId(), m.getVolume());
            }
        }
        s += "\nTeleporters:\n";
        for(Teleporter t : teleporters){
            Martian m = (Martian)t;
            s += String.format("\tGreen Martian - id=%d vol=%d\n",
                    m.getId(), m.getVolume());
        }

        return s;
    }
}