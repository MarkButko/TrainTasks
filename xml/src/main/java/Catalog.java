import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="catalog")
public class Catalog {

    private Notebook notebook;

    public Catalog() {

    }

    public Catalog(Notebook notebook) {
        this.notebook = notebook;
    }

    @XmlElement(name="notebook")
    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }
}
