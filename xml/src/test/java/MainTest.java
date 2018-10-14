import static org.junit.Assert.*;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainTest {

    private static Catalog catalog = Main.setUp();

    private final static String XML_FILE_NAME = "catalogTest.xml";
    private final static String TXT_FILE_NAME = "catalogTest.txt";

    @Test
    public void JaxbMarshalTest() throws JAXBException {
        JaxbCatalogMapper mapper = new JaxbCatalogMapper();
        mapper.marshal(XML_FILE_NAME, catalog);

        assertTrue(new File(XML_FILE_NAME).exists());
    }

    @Test
    public void JaxbUnmarshalTest() throws JAXBException {
        JaxbCatalogMapper mapper = new JaxbCatalogMapper();
        Catalog jaxbCatalog = mapper.unmarshal(XML_FILE_NAME);

        assertEquals(jaxbCatalog.getNotebook().getPersons().size(),3);
    }

    @Test
    public void SaxUnmarshalTest() throws ParserConfigurationException, SAXException, IOException {
        SaxPersonParser saxParser = new SaxPersonParser();
        List<Person> persons = saxParser.parse(XML_FILE_NAME);

        assertEquals(persons.size(), 3);
    }

}
