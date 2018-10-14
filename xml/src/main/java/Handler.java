import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class Handler extends DefaultHandler {

    public final static String NAME = "name";
    public final static String CASH = "cash";
    public final static String ADDRESS = "address";
    public final static String PERSON = "person";

    private List<Person> persons = null;
    private Person person = null;

    private boolean bName;
    private boolean bCash;
    private boolean bAddress;

    public Handler() {
        super();
    }

    public List<Person> getPersons() {
        return persons;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        switch (qName) {
            case PERSON:
                person = new Person();
                if (persons == null) {
                    persons = new ArrayList<>();
                }
                break;
            case CASH:
                bCash = true;
                break;
            case ADDRESS:
                bAddress = true;
                break;
            case NAME:
                bName = true;
                break;
        }


    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals(PERSON)) {
            persons.add(person);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(bAddress){
            person.setAddress(new String(ch, start, length));
            bAddress = false;
        }
        if(bCash) {
            person.setCash(Integer.parseInt(new String(ch, start, length)));
            bCash = false;
        }
        if(bName) {
            bName = false;
            person.setName(new String(ch, start, length));
        }
    }
}
