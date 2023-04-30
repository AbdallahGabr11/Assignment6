public class Arxml implements Comparable<Arxml>{
    private String container;
    private String longName;
    private String shortName;

    public Arxml(String container, String longName, String shortName) {
        this.container = container;
        this.longName = longName;
        this.shortName = shortName;
    }
    public Arxml(){
        this("","","");
    }

    public String getContainer() {
        return container;
    }

    public String getLongName() {
        return longName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public String toString() {
        return 
" <CONTAINER UUID=\""+container+"\">\n" +
" <SHORT-NAME>"+shortName+"</SHORT-NAME>\n" +
" <LONG-NAME>"+longName+"</LONG-NAME>\n" +
" </CONTAINER>\n" ;
    }

    @Override
    public int compareTo(Arxml o) {
        int x=this.shortName.compareToIgnoreCase(o.getShortName());
        if(x>0)
            return 1;
        else if(x<0)
            return -1;
        else
            return 0;
        
    }
    
}
