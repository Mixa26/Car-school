package Module;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Database {
    private static Database instance;

    private final List<Akcija> akcije = new ArrayList<>();
    private final List<Akcija> pohadjaci = new ArrayList<>();

    static
    {
        instance = new Database();
    }

    private Database()
    {
        loadActions();
        removeDuplicatesInList();
    }

    public static Database getInstance()
    {
        return instance;
    }

    private void loadActions()
    {
        try
        {
            File file = new File("skola.txt");
            Scanner scanner = new Scanner(file);

            String datum;
            TipAkcije tipAkcije;

            while(scanner.hasNextLine())
            {
                String[] args = scanner.nextLine().split(",");
                String[] prvi = args[0].split("-");
                String[] datumSplit = args[1].split("-");

                datum = datumSplit[2] + "." + datumSplit[1] + "." + datumSplit[0];
                if (prvi[0].equals("ČAS VOŽNJE"))
                {
                    tipAkcije = TipAkcije.CAS_VOZNJE;
                }
                else if (prvi[0].equals("ČAS TEORIJE"))
                {
                    tipAkcije = TipAkcije.CAS_TEORIJE;
                }
                else
                {
                    tipAkcije = TipAkcije.valueOf(prvi[0]);
                }

                if (prvi.length <= 1)
                {
                    akcije.add(new Akcija(args[3], args[2], datum, tipAkcije));
                }
                else
                {
                    akcije.add(new Akcija(args[3], args[2], datum, Double.parseDouble(prvi[1]), tipAkcije));
                }

                boolean ima = false;
                for (Akcija polaznik1 : pohadjaci)
                {
                    if (args[3].equals(polaznik1.getIme()) && (args[2].equals(polaznik1.getPrezime())))
                    {
                        ima = true;
                        break;
                    }
                }
                if (!ima)
                {
                    if (prvi.length <= 1)
                    {
                        pohadjaci.add(new Akcija(args[3], args[2], datum, null, tipAkcije));
                    }
                    else
                    {
                        pohadjaci.add(new Akcija(args[3], args[2], datum, Double.parseDouble(prvi[1]), tipAkcije));
                    }
                }
            }
            scanner.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        Collections.sort(pohadjaci);
    }

    void removeDuplicatesInList()
    {
        Iterator<Akcija> iterator = pohadjaci.iterator();
        Iterator<Akcija> iteratorSledeci = pohadjaci.iterator();

        while (iterator.hasNext())
        {
            iteratorSledeci = iterator;
            while(iteratorSledeci.hasNext())
            {
                if (iterator.equals(iteratorSledeci.next()))
                {
                    iteratorSledeci.remove();
                }
            }

        }
    }

    public List<Akcija> getAkcije() {
        return akcije;
    }

    public List<Akcija> getPohadjaci() {
        return pohadjaci;
    }
}
