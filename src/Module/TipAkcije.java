package Module;

public enum TipAkcije {
    POLAGANJE,
    CAS_VOZNJE,
    CAS_TEORIJE,
    UPLATA;

    @Override
    public String toString() {
        if (this.equals(TipAkcije.CAS_TEORIJE))
        {
            return "ČAS TEORIJE";
        }
        else if (this.equals(TipAkcije.CAS_VOZNJE))
        {
            return "ČAS VOŽNJE";
        }
        else
        {
            return super.toString();
        }
    }
}
