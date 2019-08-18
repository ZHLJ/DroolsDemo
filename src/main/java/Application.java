import com.zlj.drools.domain.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String [] args){
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession ks =  kieContainer.newKieSession("drools-basic");

        List<Person> persons = generatePersons();
//        KieSession ks = getSession();
        for (Person person: persons) {
            System.out.println(person.getName() + "的年龄：" + person.getAge());
            ks.insert(person);
        }
        int count = ks.fireAllRules();
        System.out.println("共执行了" + count + "规则。");
        for (Person person : persons) {
            System.out.println(person.getName() + "的年龄：" + person.getAge());
        }
    }

    public static List<Person> generatePersons(){
        List<Person> persons = new ArrayList<Person>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Person lee = new Person();
            lee.setName("lee");
            lee.setAge(21);
            lee.setBirthday(sdf.parse("1997-12-13"));
            lee.setBirthplace("安徽 合肥");
            persons.add(lee);

            Person wang = new Person();
            wang.setName("wang");
            wang.setAge(28);
            wang.setBirthday(sdf.parse("1991-4-13"));
            wang.setBirthplace("广东 湛江");
            persons.add(wang);

            Person shi = new Person();
            shi.setName("shi");
            shi.setAge(26);
            shi.setBirthday(sdf.parse("1995-4-13"));
            shi.setBirthplace("广东 广州");
            persons.add(shi);
            
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        return persons;
    }

    public static KieSession getSession(){
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        return kieContainer.newKieSession("drools-basic");
    }


}
