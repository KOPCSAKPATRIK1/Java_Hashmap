package hu.petrik.bejegyzesProjekt;

public class Eredmeny implements  Comparable<Eredmeny>
{
    private String reszido;
    private String nev;

    public Eredmeny(String reszido, String nev)
    {
        this.reszido = reszido;
        this.nev = nev;
    }

    public String getReszido()
    {
        return reszido;
    }

    public String getNev()
    {
        return nev;
    }


    @Override
    public int compareTo(Eredmeny other)
    {
        String[] thisReszidok = this.reszido.split(":");
        String[] otherReszidok = other.reszido.split(":");
        Integer thisPerc = Integer.parseInt(thisReszidok[0]);
        Integer thisMasodperc = Integer.parseInt(thisReszidok[1]);
        Integer otherPerc = Integer.parseInt(otherReszidok[0]);
        Integer otherMasodperc = Integer.parseInt(otherReszidok[1]);

        if (thisPerc.compareTo(otherPerc) == 0)
        {
            return  thisMasodperc.compareTo(otherMasodperc);
        }

        return thisPerc.compareTo(otherPerc);
    }

    @Override
    public String toString()
    {
        return String.format("%s %s", this.nev, this.reszido);
    }
}
