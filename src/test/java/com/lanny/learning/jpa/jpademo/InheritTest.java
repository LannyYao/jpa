package com.lanny.learning.jpa.jpademo;

import com.lanny.learning.jpa.entity.inherit.joined.Animal;
import com.lanny.learning.jpa.entity.inherit.joined.Bird;
import com.lanny.learning.jpa.entity.inherit.joined.Dog;
import com.lanny.learning.jpa.entity.inherit.single_table.Document;
import com.lanny.learning.jpa.entity.inherit.single_table.Folder;
import com.lanny.learning.jpa.entity.inherit.single_table.WindowFile;
import com.lanny.learning.jpa.entity.inherit.table_per_class.Bus;
import com.lanny.learning.jpa.entity.inherit.table_per_class.Car;
import com.lanny.learning.jpa.entity.inherit.table_per_class.Vehicle;
import com.lanny.learning.jpa.repository.AnimalRepository;
import com.lanny.learning.jpa.repository.BirdRepository;
import com.lanny.learning.jpa.repository.BusRepository;
import com.lanny.learning.jpa.repository.CarRepository;
import com.lanny.learning.jpa.repository.DocumentRepository;
import com.lanny.learning.jpa.repository.DogRepository;
import com.lanny.learning.jpa.repository.FolderRepository;
import com.lanny.learning.jpa.repository.VehicleRepository;
import com.lanny.learning.jpa.repository.WindowFileRepository;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Lanny Yao
 * @date 7/8/2018 3:41 PM
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class InheritTest {

    @Autowired
    private WindowFileRepository windowFileRepository;

    @Autowired
    private FolderRepository folderRepository;

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private BirdRepository birdRepository;

    @Autowired
    private DogRepository dogRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private BusRepository busRepository;

    @Test
    public void init() {
        // init table
    }

    @Test
    public void testSingleTableStrategy() {

        WindowFile windowFile = new WindowFile();
        windowFile.setDate(new Date());
        windowFile.setName("window file");
        windowFile.setType("file");

        Folder folder = new Folder();
        folder.setDate(new Date());
        folder.setName("folder");
        folder.setType("folder");
        folder.setFileCount(1);

        Document document = new Document();
        document.setDate(new Date());
        document.setName("document");
        document.setType("document");
        document.setSize(1024);

        windowFileRepository.save(windowFile);
        folderRepository.save(folder);
        documentRepository.save(document);

        windowFileRepository.findAll().forEach(System.out::println);
    }

    @Test
    public void testJoinedStrategy() {

        Animal animal = new Animal();
        animal.setColor("color");
        animal.setName("animal");

        Bird bird = new Bird();
        bird.setColor("red");
        bird.setName("bird");
        bird.setSpeed(314);

        Dog dog = new Dog();
        dog.setLegs(4);
        dog.setColor("yellow");
        dog.setName("dog");

        animalRepository.save(animal);
        birdRepository.save(bird);
        dogRepository.save(dog);

        List<Animal> animals = animalRepository.findAll(); // ?
        System.out.println("animal: ");
        animals.forEach(System.out::println);

        List<Bird> birds = birdRepository.findAll();
        System.out.println("bird: ");
        birds.forEach(System.out::println);

        List<Dog> dogs = dogRepository.findAll();
        System.out.println("dog: ");
        dogs.forEach(System.out::println);
    }

    @Test
    public void testTablePerClassStrategy() {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(1);
        vehicle.setSpeed(123);
        vehicleRepository.save(vehicle);

        Car car = new Car();
        car.setId(2);
        car.setEngine("engine");
        car.setSpeed(789);
        carRepository.save(car);

        Bus bus = new Bus();
        bus.setId(3);
        bus.setCapacity(38);
        bus.setSpeed(555);
        busRepository.save(bus);

        List<Vehicle> vehicles = vehicleRepository.findAll(); // ?
        vehicles.forEach(System.out::println);
    }
}
