package aula10;

import java.util.HashMap;
import java.util.Map;

public class Main{
    public static Map<String, String> agenda = new HashMap<>();

    public static void main(String[] args) {
        agenda.put("Ana", "19999999999");
        agenda.put("Bruno", "888888888");

        for(String nome : agenda.keySet()){
            System.out.println(nome + " -> " + agenda.get(nome));
        }

        for(Map.Entry<String, String> e : agenda.entrySet()){
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }
}
