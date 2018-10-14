import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbCatalogMapper {

    private static JAXBContext context;

    static {
        try {
            context = JAXBContext.newInstance(Catalog.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public Catalog unmarshal(String path) throws JAXBException {
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Catalog) unmarshaller.unmarshal(new File(path));
    }

    public void marshal(String path, Catalog catalog) throws JAXBException {
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(catalog, new File(path));
    }
}
