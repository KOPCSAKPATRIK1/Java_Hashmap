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
            kiir();
            System.out.println();
            System.out.printf("az olimpian %d versenyzo vett resz\n", getVerseníyzokSzama());
        } catch (FileNotFoundException e)
        {
            System.out.printf("Nem talalhato a %s  fajl", fajlNev);
        }
        kiir();
    }

    private static int getVerseníyzokSzama()
    {
        List<String> versenyzok = new ArrayList<>();
        for (Map.Entry<String, List<Eredmeny>> entry: sportagEredmenyek.entrySet())
        {
           List<Eredmeny> eredmenyek = entry.getValue();
           for (Eredmeny e: eredmenyek)
           {
               if (!versenyzok.contains(e.getNev()))
               {
                   versenyzok.add(e.getNev());
               }
           }
        }

        return versenyzok.size();
    }

    private static int getSportagakSzama()
    {
        return  sportagEredmenyek.keySet().size();
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
