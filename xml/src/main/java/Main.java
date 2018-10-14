import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public final static String XML_FILE_NAME = "catalog.xml";
    public final static String TXT_FILE_NAME = "catalog.txt";
    private final static File TXT_FILE = new File(TXT_FILE_NAME);


    public static void main(String[] args) {

        Catalog catalog = setUp();

        JaxbCatalogMapper mapper = new JaxbCatalogMapper();
        try {
            mapper.marshal(XML_FILE_NAME, catalog);
        } catch (JAXBException e) {
            System.out.println("marshal exception");
            e.printStackTrace();
        }

        //JAXB
        try {
            mapper.unmarshal(XML_FILE_NAME);
        } catch (JAXBException e) {
            System.out.println("unmarshal exception");
            e.printStackTrace();
        }
        System.out.println("JAXB out");
        print(catalog.getNotebook().getPersons());

        //SAX
        SaxPersonParser saxParser = new SaxPersonParser();
        try {
            List<Person> persons = saxParser.parse(XML_FILE_NAME);
            System.out.println("SAX out");
            print(persons);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void print(List<Person> list) {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(TXT_FILE, true))) {
            list.stream()
                    .filter(p -> p.getCash() > 10_000)
                    .map(p -> p.toString())
                    .forEach((p) -> {
                        System.out.println(p);
                        writer.append(p + "\n");
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Catalog  setUp() {
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
        return new Catalog(notebook);
    }

}
