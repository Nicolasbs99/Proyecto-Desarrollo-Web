package co.edu.javeriana.Proyecto.Model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;


@Component
public class DataBaseInit implements ApplicationRunner{

    @Autowired
    DecoracionRepo decoItemRepo;

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    MonstruoRepo monsterRepo;

    @Autowired
    JugadorRepo playerRepo;

    @Autowired
    HabRepo roomRepo;

    /// se ejecuta una sola vez al inicio de la aplicacion.
    @Override
    public void run(ApplicationArguments args) throws Exception {
        
        loadDecoItems();
        loadItems();
        loadMonsters();
        
        loadRooms();
        loadPlayers();
        
    }
    
    void loadDecoItems(){

        List<Decoracion> itemList = new ArrayList<>();

        itemList.add(new Decoracion("Crate"));
        itemList.add(new Decoracion("Cave Entrance"));
        itemList.add(new Decoracion("Prison Door"));
        itemList.add(new Decoracion("Door"));
        itemList.add(new Decoracion("Large door"));
        itemList.add(new Decoracion("Crate"));
        itemList.add(new Decoracion("Giant crystal"));
        itemList.add(new Decoracion("Vine"));
        itemList.add(new Decoracion("Door"));
        itemList.add(new Decoracion("Stairs"));

        decoItemRepo.saveAll(itemList);
    }

    void loadItems() {
        
		List<Item> itemList = new ArrayList<>();

        itemList.add(new Item("Dwarf remains","2022-09-24",2,3,"The body of a Dwarf savaged by Goblins.", "https://oldschool.runescape.wiki/w/Dwarf_remains"));
        itemList.add(new Item("Toolkit","2021-09-4",2,33,"The body of a Dwarf savaged by Goblins.", "https://oldschool.runescape.wiki/w/Dwarf_remains"));
        itemList.add(new Item("Cannonball","2021-2-24",23,31,"The body of a Dwarf savaged by Goblins.", "https://oldschool.runescape.wiki/w/Dwarf_remains"));
        itemList.add(new Item("Nulodion's notes","2021-09-24",4,32,"The body of a Dwarf savaged by Goblins.", "https://oldschool.runescape.wiki/w/Dwarf_remains"));
        itemList.add(new Item("Ammo mould","2021-09-2",6,35,"The body of a Dwarf savaged by Goblins.", "https://oldschool.runescape.wiki/w/Dwarf_remains"));
        itemList.add(new Item("Instruction manual","2021-09-24",2,32,"The body of a Dwarf savaged by Goblins.", "https://oldschool.runescape.wiki/w/Dwarf_remains"));
        itemList.add(new Item( "Cannon barrels","2020-09-24",2,3,"The body of a Dwarf savaged by Goblins.", "https://oldschool.runescape.wiki/w/Dwarf_remains"));
        
        itemRepo.saveAll(itemList);
        
	}

    void loadMonsters(){
  
		List<Monstruo> monsterList = new ArrayList<>();
        ArrayList<String> catego = new ArrayList<>();
        catego.add("Cat A");
        catego.add("Cat B");
        catego.add("Cat C");
        monsterList.add(new Monstruo("Aberrant spectre","2021-09-02",1,20,2,90,catego,"A very smelly ghost.","https://oldschool.runescape.wiki/w/Aberrant_spectre"));
        monsterList.add(new Monstruo("Nechryael","2021-09-02",1,20,2,90,catego,"A very smelly ghost.","https://oldschool.runescape.wiki/w/Aberrant_spectre"));
        monsterList.add(new Monstruo( "Death spawn","2021-09-02",1,20,2,90,catego,"A very smelly ghost.","https://oldschool.runescape.wiki/w/Aberrant_spectre"));
        monsterList.add(new Monstruo( "An evil death spawn.","2021-09-02",1,20,2,90,catego,"A very smelly ghost.","https://oldschool.runescape.wiki/w/Aberrant_spectre"));
        monsterList.add(new Monstruo("Zombie","2021-09-02",1,20,2,90,catego,"A very smelly ghost.","https://oldschool.runescape.wiki/w/Aberrant_spectre"));
        monsterList.add(new Monstruo("Summoned Zombie","2021-09-02",1,20,2,90,catego,"A very smelly ghost.","https://oldschool.runescape.wiki/w/Aberrant_spectre"));
        monsterList.add(new Monstruo("Ghost","2021-09-02",1,20,2,90,catego,"A very smelly ghost.","https://oldschool.runescape.wiki/w/Aberrant_spectre"));
        monsterList.add(new Monstruo("The living dead","2021-09-02",1,20,2,90,catego,"A very smelly ghost.","https://oldschool.runescape.wiki/w/Aberrant_spectre"));
        monsterList.add(new Monstruo("Rock Crab","2021-09-02",1,20,2,90,catego,"A very smelly ghost.","https://oldschool.runescape.wiki/w/Aberrant_spectre"));
        monsterList.add(new Monstruo("Molanisk","2021-09-02",1,20,2,90,catego,"A very smelly ghost.","https://oldschool.runescape.wiki/w/Aberrant_spectre"));
        monsterList.add(new Monstruo( "Skeleton Mage","2021-09-02",1,20,2,90,catego,"A very smelly ghost.","https://oldschool.runescape.wiki/w/Aberrant_spectre"));
        
        monsterRepo.saveAll(monsterList);

    }

    void loadPlayers(){

        Jugador pA = new Jugador();
        pA.setName("Alice");
        pA.setAttack_level(30);
        pA.setSize(30);
        
        Jugador pB = new Jugador();
        pB.setName("Bob");
        pB.setAttack_level(20);
        pB.setSize(20);

        pA.getCategory().add("Categoria Uno");
        pA.getCategory().add("Categoria Dos");

        pB.getCategory().add("Categoria Uno");
        pB.getCategory().add("Categoria Dos");

        Item iA = itemRepo.findById(12l).orElseThrow();
        Item iB = itemRepo.findById(14l).orElseThrow();
        
        playerRepo.save(pA);
        playerRepo.save(pB);

        pA.getBackpack().add(iA);
        pA.getBackpack().add(iB);

        pB.getBackpack().add(iA);
        pB.getBackpack().add(iB);

        //pA.setLocation(roomRepo.findById(137l).orElseThrow());
        //pB.setLocation(roomRepo.findById(137l).orElseThrow());

        playerRepo.save(pA);
        playerRepo.save(pB);
        
    }

    void loadRooms(){

        Habitacion rA = new Habitacion();
        
        rA.setName("ROOM_1");

        roomRepo.save(rA);
        Item iA = itemRepo.findById(45l).orElseThrow();
        Decoracion diA = decoItemRepo.findById(2l).orElseThrow();
        Decoracion diB = decoItemRepo.findById(3l).orElseThrow();
        Monstruo mA = monsterRepo.findById(130l).orElseThrow();
        rA.getItems().add(iA);
        rA.getDecorativeItems().add(diA);
        rA.getDecorativeItems().add(diB);
        rA.setMonster(mA);
        roomRepo.save(rA);
        Habitacion rB = new Habitacion();
        rB.setName("ROOM_2");
        roomRepo.save(rB);
        Item iB = itemRepo.findById(46l).orElseThrow();
        Decoracion diC = decoItemRepo.findById(7l).orElseThrow();
        Decoracion diD = decoItemRepo.findById(5l).orElseThrow();
        Monstruo mB = monsterRepo.findById(131l).orElseThrow();
        rB.getItems().add(iB);
        rB.getDecorativeItems().add(diC);
        rB.getDecorativeItems().add(diD);
        rB.setMonster(mB);
        rB.getExits().add(rA);
        roomRepo.save(rB);

    }

}
