import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public final static String XML_FILE_NAME = "catalog.xml";
    public final static String TXT_FILE_NAME = "catalog.txt";

    public static void main(String[] args) {

        Catalog catalog = new Catalog();
        setUp(catalog);

        try {
            marshal(catalog);
        } catch (JAXBException e) {
            System.out.println("marshal exception");
            e.printStackTrace();
        }

        //JAXB
        try {
            unmarshal(catalog);
        } catch (JAXBException e) {
            System.out.println("unmarshal exception");
            e.printStackTrace();
        }

        System.out.println("JAXB out");
        print(catalog.getNotebook().getPersons());

        //SAX
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            Handler handler = new Handler();
            saxParser.parse(XML_FILE_NAME, handler);
            System.out.println("SAX out");
            print(handler.getPersons());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void print(List<Person> list) {
        try (PrintWriter writer = new PrintWriter(new File(TXT_FILE_NAME))) {
            list.stream()
                    .filter( p -> p.getCash() > 10_000)
                    .map(p -> p.toString())
                    .forEach((p) -> {
                        System.out.println(p);
                        writer.write(p + "\n");
                    });
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    public static void unmarshal(Catalog catalog) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(Catalog.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        catalog = (Catalog) unmarshaller.unmarshal(new File(XML_FILE_NAME));

    }

    public static void marshal(Catalog catalog) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Catalog.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(catalog, new File(XML_FILE_NAME));
    }

    public static void setUp(Catalog catalog) {
        Notebook notebook = new Notebook();
        List<Person> persons = new ArrayList<Person>(3);

        Person person = new Person();
        person.setAddress("addr");
        person.setName("First");
        person.setCash(1000000);
        person.setEducation("sa");

        persons.add(person);

        person = new Person();
        person.setAddress("addr2");
        person.setName("Second");
        person.setCash(1000);
        person.setEducation("sa");

        persons.add(person);

        person = new Person();
        person.setAddress("addr3");
        person.setName("Third");
        person.setCash(9999999);
        person.setEducation("sa");

        persons.add(person);

        notebook.setPersons(persons);
        catalog.setNotebook(notebook);
    }

}
