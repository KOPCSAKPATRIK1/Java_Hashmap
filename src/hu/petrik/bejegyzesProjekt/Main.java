package hu.petrik.bejegyzesProjekt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main
{

    private static Map<String, List<Eredmeny>> sportagEredmenyek = new HashMap<>();
    public static void main(String[] args)
    {
        String fajlNev = "eredmenyek.txt";
        try
        {
            beolvas(fajlNev);
        } catch (FileNotFoundException e)
        {
            System.out.printf("Nem talalhato a %s  fajl", fajlNev);
        }
        kiir();
    }

    private static void beolvas(String fajlNev) throws FileNotFoundException
    {
        Scanner file = new Scanner(new File(fajlNev));
        while (file.hasNext())
        {
            String[] sor = file.nextLine().split(" ");
            String sportag = sor[0];
            String reszIdo = sor[1];
            String nev = sor[2] + " " + sor[3];
            sportagEredmenyek.putIfAbsent(sportag, new ArrayList<>());
            Eredmeny eredmeny = new Eredmeny(reszIdo, nev);
            sportagEredmenyek.get(sportag).add(eredmeny);
        }
    }

    private static void kiir()
    {
        for (Map.Entry<String, List<Eredmeny>> entry: sportagEredmenyek.entrySet())
        {
            String sportag = entry.getKey();
            List<Eredmeny> eredmenyek = entry.getValue();
            System.out.println(sportag);
            for (Eredmeny eredmeny: eredmenyek)
            {
                System.out.println("\t" + eredmeny);
            }
        }
    }
}
