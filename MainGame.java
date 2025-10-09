import java.util.Scanner;
import java.util.ArrayList;//this is stupid
public class MainGame{
  public static void main(String[] args){
    /*IMPORTANT:
    You may notice me using certain code that has not yet been taught in class.
    (Specifically: while loops, try/catch, arrays, array lists)
    I do not remember if I am allowed to do that.
    I AM doing it because I REALLY like text-based games and wanted to go all out here.
    Using only what was taught in class would be tedious for a project like this.
    Any code that wasn't taught yet I had looked up on my own and learned how to use.
    I did not use AI to write code. If prompted, I am capable of explaining what every piece of code here does and why it is used.
    */
    Scanner scan = new Scanner(System.in);
    String input;
    //Intro
    boolean seenIntroOne = false;
    boolean seenIntroTwo = false;
    ArrayList<String> inventory = new ArrayList<String>();//Why are lists a separate class. Why is the syntax for them so complicated. I just wanna make an inventory.
    ArrayList<String> keys = new ArrayList<String>();
    System.out.println("You wake up in an unfamiliar shack. You don’t remember much of the past few days - got drunk with a few friends and decided to wander into the woods to get some fresh air away from the campfire. You suppose someone found you and brought you here. You feel something restricting your wrist.\n");
    System.out.println("[Type in the number of the option given to you to choose it. To see available options again, type \"actions\". If you're not asked for input, press enter to see the next section.]\n");
    //System.out.println("CHEATS:\nexit: conclude current section\nmoretime: add time during section 2\npoints: set \"survival points\" during sections 2 & 3");
    System.out.println("1. Look around\n2. Examine yourself\n");
    System.out.print("Input:");
    input = scan.nextLine().toLowerCase();
    //SECTION 1
    //had to look up how while loops work :/
    while(true){//loops while conditions are met or until theres a break. Im using a break.
      if(input.equals("1")){//option 1
          System.out.println("\nThe shack is well lit with the still burning fireplace. The windows show only a blizzard. On the bedside table you see some food, as well as a fork and a knife. How nice of them.\n");
          seenIntroOne=true;
        if(seenIntroTwo==true){//option 1 after option 2, end INTRO
          System.out.println("The knife seems somewhat sharp. The same can’t be said about whoever left you here. You take the knife and start cutting the rope...\n");
          scan.nextLine();//break in text so that it doesn't appear all at once. Otherwise it would be overwhelming and annoying.
          break;
        }
      }
      else if(input.equals("2")){//option 2
        System.out.println("You seemed to be tied with a rope to the leg of the bed you're laying on. Not the best first impression of whoever found you. You think you should probably try to avoid an in-person meeting with them.\n");
        seenIntroTwo=true;
        if(seenIntroOne==true){//option 2 after option 1
          System.out.println("Wait, wasn’t there a knife nearby? You wonder if it could cut the rope.\n");
        }
      }
      else if(input.equals("actions")||input.equals("action")||input.equals("help")){//available actions
        System.out.println("Available actions:\n1. Look around\n2. Examine yourself\n");
      }
      else if(input.equals("exit")){//move onto the next section
        System.out.println("SECTION EXITED");
        break;
      }
      else{//any other inputs
      System.out.println("Not an option.\n");
      }
      System.out.print("Input:");
      input = scan.nextLine().toLowerCase();//apparently you can do this. neat.
    }
    System.out.println("After some time you manage to free yourself. The wind is howling outside. The blizzard seems to have worsened since you got here. Even if you get out of the house, you would need some supplies to simply not die of the cold, not to mention even finding your way. You think you can \"borrow\" some stuff from this property before their owner comes back, whenever that is...\n");
    scan.nextLine();
    
    
    System.out.println("SECTION 2: THE HOUSE\n");
    int time = (int)(Math.random()*31)+10;//random amount of time 30-40 minutes.
    boolean reachedExit = false;
    int survivalPoints = 0;//increased by getting items, decreased by injuries, determines the chance of surviving at the end.
    String actions = "\nAvailable actions:\n\"Look\" - [5 min] find a few items in the current room, can be repeated.\n\"Move\" - Choose a room to move to. \n\"Trap\" - [10 min] Place a trap in the current room. Traps slow down anyone who is unaware of them. If you have items you can use to make traps, making one can take less time\n\"Inventory\" - Check to see what your inventory contains.\n\"Keys\" - Check what keys you have.";
    //decided to use a variable up here because I'll be changing it up depending on the rooms and sections.
    String room = "bedroom";
    int bedroomCheck = 0;//how many times a room has been checked
    int officeCheck = 0;
    int trophyCheck = 0;
    int kitchenCheck = 0;
    boolean officeUnlocked = false;//locked doors
    boolean trophyUnlocked = false;
    boolean entranceUnlocked = false;
    boolean officeSeen = false;//descriptions of rooms seen
    boolean corridorSeen = false;
    boolean kitchenSeen = false;
    boolean entranceSeen = false;
    boolean trophySeen = false;
    int bedroomTrap=0;//traps
    int officeTrap=0;
    int corridorTrap=0;
    int kitchenTrap=0;
    int trophyTrap=0;
    int entranceTrap=0;
    boolean makingTrap=false;
    
    System.out.println("Now that you're not tied to the bed, you can gather your surrounding better. There are two doors leading out of the room. One of them is labeled \"Office\". It seems to be locked. The other is unlabeled and unlocked.\n");
    inventory.add("food");
    inventory.add("Small knife");
    System.out.println("(Tutorial: You have a certain amount of time before the host returns. You do not know how much that is. You can spend this time [min] to do certain actions. To see what you can do, type \"actions\")");
      while(time>0){//loops until time runs out ;)
        System.out.print("Input: ");
        input = scan.nextLine().toLowerCase();
        if(input.equals("look")){//Too many if statements because items depend on rooms.
          if(room.equals("bedroom")){//bedroom items
            if(bedroomCheck==0){
              System.out.println("You have found an entrance key, lighter, and some firewood. You cannot get firewood yet, because you need rope to tie it so that you can carry it.");
              System.out.println("If you have rope and want to take the firewood, look for an available action in this room.");
              System.out.println("Other than that, you think you found everything here.\n");
              keys.add("entrance key");
              inventory.add("lighter");
              bedroomCheck++;
              time -=5;
              survivalPoints+=1;
            }
            else {
              System.out.println("Nothing to look for here. (No time used up)\n");
            }
          }
          else if(room.equals("office")){//office items
            if(officeCheck==0){
              System.out.println("You have found a trophy room key, a fishing rod and bait. You feel like you have missed some things... Maybe you should have a look again sometime?\n");
              keys.add("trophy room key");
              inventory.add("fishing rod");
              inventory.add("bait");
              officeCheck++;
              time -=5;
              survivalPoints+=2;
            }
            else if(officeCheck==1){
              System.out.println("You have found a few blank pieces of paper, a map of the surrounding area, and a firearm locker key. You think you found everything here.\n");
              inventory.add("paper");
              inventory.add("map of the surroundings");
              keys.add("firearm locker key");
              officeCheck++;
              time -=5;
              survivalPoints+=3;
            }
            else {
              System.out.println("Nothing to look for here. (No time used up)\n");
            }
          }
          else if(room.equals("trophy")){//trophy room items
            if(trophyCheck==0){
              System.out.println("You have found a firearm locker, but you're goint to need to use a key in your actions to unlock it...");
              System.out.println("You have also found a taxidermied fox! Sure, not a very surprising find in this room, but something about it seems very... entrancing...");
              System.out.println("After staring at it for a straight minute, you break out of it. Whatever this thing actually is, you think you can use it for a trap or distraction.\n");
              inventory.add("taxidermied fox?");
              trophyCheck++;
              time -=6;
            }
            else {
              System.out.println("Nothing to look for here. (No time used up)\n");
            }
          }
          else if(room.equals("kitchen")){//kitchen items
            if(kitchenCheck==0){
              System.out.println("You have found an office key, and a sharp knife. You feel like you have missed some things... Maybe you should have a look again sometime?\n");
              inventory.add("sharp knife");
              keys.add("office key");
              kitchenCheck++;
              time -=5;
              survivalPoints+=2;
            }
            else if(kitchenCheck==1){
              System.out.print("You have found some bottled water and raw meat. ");
              if(!inventory.contains("firewood")){
                System.out.println("The meat will be useless if you dont have any firewood to cook it on though. You think you found everything here.\n");
              }
              else{
              System.out.println("You think you could cook it with the firewood you found./n");
              survivalPoints+=2;
              }
              inventory.add("bottled water");
              inventory.add("raw meat");
              kitchenCheck++;
              time -=5;
              survivalPoints+=1;
            }
            else {
              System.out.println("Nothing to look for here. (No time used up)\n");
            }
          }
          else {
            System.out.println("Nothing to look for here. (No time used up)\n");
          }
        }
        else if(input.equals("actions")||input.equals("action")||input.equals("help")){
          System.out.println(actions);//Available actions for different rooms
          if (room.equals("bedroom")){//bedroom actions
            if(inventory.contains("sharp knife")){
              System.out.println("\"Rope\" - [1min] Cut off some of the rope. Now that you have a sharper knife, you can do it quicker.");
            }
            else {
              System.out.println("\"Rope\" - [5min] Cut off some of the rope. Useful, but will take a while to cut with such a small knife.");
            }
            if(bedroomCheck==1){
              System.out.println("\"Firewood\" - [3min] get the firewood. Rope is needed to tie it together if you want to carry it.");
            }
            if(keys.contains("office key")){
              System.out.println("\"Unlock\" - [0min] Unlock the office and make it available to move to.");
            }
          }//no office or kitchen actions :(
          else if(room.equals("corridor")&&keys.contains("trophy room key")){
            System.out.println("\"Unlock\" - [0min] Unlock the trophy room and make it available to move to.");
          }
          else if(room.equals("trophy")&&keys.contains("firearm locker key")&&trophyCheck==1){//trophy room actions
              System.out.println("\"Unlock\" - [0min] Unlock the firearm locker and take what's inside.");
          }
          else if(room.equals("entrance")&&keys.contains("entrance key")){
            System.out.println("\"Unlock\" - [0min] Unlock the entrance door and make the outside available to move to.");
          }
        }
        else if(input.equals("move")){//Available movement
          System.out.println("\nChoose a room to move to:");
          System.out.println("Stay");
          if(room.equals("bedroom")){//bedroom move
            System.out.println("Corridor");
            if(officeUnlocked==true){
              System.out.println("Office");
            }
          }
          else if(room.equals("office")){//office move
            System.out.println("Bedroom");
          }
          else if(room.equals("corridor")){//corridor move
            System.out.println("Bedroom\nEntrance room\nKitchen");
            if(trophyUnlocked==true){
              System.out.println("Trophy room");
            }
          }
          else if(room.equals("entrance")){//entrance room move
            System.out.println("Corridor");
            if(entranceUnlocked==true){
              System.out.println("Outside");
            }
          }
          else if(room.equals("kitchen")||room.equals("trophy")){//kitchen and trophy room move
            System.out.println("Corridor");
          }
          else{//error handler
            System.out.println("You're not in a known room");
          }
          System.out.print("\nInput: ");
          input = scan.nextLine().toLowerCase();//Actual movement
          if(input.equals("stay")){
            System.out.println("You stayed in the same room.\n");
          }
          else if(input.equals("bedroom")){//move to bedroom
            if(room.equals("bedroom")||room.equals("corridor")||room.equals("office")){
              System.out.println("You moved to the bedroom.\n");
              room = "bedroom";
            }
            else{
              System.out.println("Can't access it right now.\n");
            }
          }
          else if(input.equals("corridor")){//move to corridor
            if(room.equals("corridor")||room.equals("bedroom")||room.equals("trophy")||room.equals("kitchen")||room.equals("entrance")){
              System.out.println("You moved to the corridor.\n");
              if(corridorSeen==false){
                System.out.println("The corridor is dark but not too long. Surprisingly empty too. Unless there are any secret compartments here, you doubt you could find anything worthwhile. There are four doors, all labeled. What is this person's deal with labeling rooms?\n");
                corridorSeen=true;
              }
              room = "corridor";
            }
            else{
              System.out.println("Can't access it right now.\n");
            }
          }
          else if(input.equals("office")){//move to office
            if((officeUnlocked==true)&&(room.equals("office")||room.equals("bedroom"))){
              System.out.println("You moved to the office.\n");
              if(officeSeen==false){
                System.out.println("When you enter the room, the first things you notice are the strong smell of dust and mountains of papers scattered about. Many of them seem to be personal documents of various different people... There is also a variety of equipment for hunting and fishing. No guns though, sadly. There are no doors except for the one you entered through.\n");
                officeSeen=true;
              }
              room = "office";
            }
            else{
              System.out.println("Can't access it right now.\n");
            }
          }
          else if(input.equals("trophy room")||input.equals("trophy")){//move to trophy room
            if((trophyUnlocked==true)&&(room.equals("trophy")||room.equals("corridor"))){
              System.out.println("You moved to the trophy room.\n");
              if(trophySeen==false){
                System.out.println("Mounted animal heads. So many of them. You don't think there is an inch of a wall that doesn't have one or some other kind of hunting trophy. A few cabinets are placed haphazardly around the room, as well as pedestals with full-body taxidermied animals. Even the chandelier is made of deer antlers. You can't tell if the host absolutely loves or hates animals, but they seem to feel very strongly about it.\n");
                trophySeen=true;
              }
              room = "trophy";
            }
            else{
              System.out.println("Can't access it right now.\n");
            }
          }
          else if(input.equals("kitchen")){//move to kitchen
            if(room.equals("kitchen")||room.equals("corridor")){
              System.out.println("You moved to the kitchen.\n");
              if(kitchenSeen==false){
                System.out.println("A normal kitchen - fridge, counters, a sink, some cabinets. There is a strong smell of raw meat, so you doubt you will find anything else here.\n");
                kitchenSeen=true;
              }
              room = "kitchen";
            }
            else{
              System.out.println("Can't access it right now.\n");
            }
          }
          else if(input.equals("entrance")||input.equals("entrance room")){//move to entrance room
            if(room.equals("entrance")||room.equals("corridor")){
              System.out.println("You moved to the entrance room.\n");
              if(entranceSeen==false){
                System.out.println("It is quite barren, but not the the same extent the corridor is. There are a few chairs, a table, and a chandelier at least. You notice that the only window in the room has a circular pattern of cracks on it, almost like a spiderweb. It seems it has been shot at once, and has turned out bullet proof. You think it is safe to assume that all of the other windows are reinforced too, meaning that the only exit is the door here.");
                System.out.println("You try the handle of the front door. It's locked. Sadly, it seems your captor actually does have some sense in them. You push a chair up against it. Just in case.\n");
                entranceSeen=true;
              }
              room = "entrance";
            }
            else{
              System.out.println("Can't access it right now.\n");
            }
          }
          else if(input.equals("outside")||input.equals("out")){
            System.out.println("You got out of the house.\n");
            reachedExit=true;
            break;
          }
          else{//other inputs
            System.out.println("Not an available room\n");
          }
        }
        else if(input.equals("inventory")){//check inventory
          System.out.println(inventory);
        }
        else if(input.equals("keys")||input.equals("key")){//check keys
          System.out.println(keys);
        }
        else if(input.equals("unlock")){//unlock action
          if(room.equals("bedroom")&&keys.contains("office key")){//office unlock
            System.out.println("Office unlocked\n");
            officeUnlocked=true;
          }
          else if(room.equals("corridor")&&keys.contains("trophy room key")){//trophy room unlock
            System.out.println("Trophy room unlocked\n");
            trophyUnlocked=true;
          }
          else if(room.equals("trophy")&&keys.contains("firearm locker key")){//firearm locker unlock
            System.out.println("Firearm locker unlocked\n Inside is a loaded rifle. You pick up the rifle. You feel safer.");
            inventory.add("loaded rifle"); 
          }
          else if(room.equals("entrance")&&keys.contains("entrance key")){
            System.out.println("Entrance door unlocked");
            entranceUnlocked=true;
          }
          else System.out.println("Nothing to unlock.");
        }
        else if(input.equals("trap")||input.equals("traps")){//traps
          System.out.println("Setting a trap takes 10 minutes. If you have items that can be used for a trap, however, it will take only 3 minutes, at the cost of the item.\n");
          System.out.println("Items available for trap making: ");
          if(inventory.contains("rope")) System.out.println("Rope");
          if(inventory.contains("taxidermied fox?")) System.out.println("taxidermied fox?");
          if(inventory.contains("sharp knife")) System.out.println("sharp knife");
          if(inventory.contains("fishing rod")) System.out.println("fishing rod");
          if(inventory.contains("bottled water")) System.out.println("bottled water");
          if(!(inventory.contains("rope")||inventory.contains("taxidermied fox?")||inventory.contains("sharp knife")||inventory.contains("fishing rod")||inventory.contains("bottled water"))){
            System.out.println("No items found");
          }
          System.out.print("If you'd like to use any of these items, type a name here. Otherwise, type none. \nInput: ");
          makingTrap=true;
          input = scan.nextLine().toLowerCase();
          if (input.equals("rope")&&inventory.contains("rope")){//rope trap
            inventory.remove(inventory.indexOf("rope"));
            System.out.println("You have used the rope for a trap.");
            time-=3;
          }
          else if ((input.equals("taxidermied fox")||input.equals("fox"))&&inventory.contains("taxidermied fox?")){
            inventory.remove(inventory.indexOf("taxidermied fox?"));
            System.out.println("You have used the taxidermied fox for a trap.");
            time-=3;
          }
          else if (input.equals("sharp knife")&&inventory.contains("sharp knife")){
            inventory.remove(inventory.indexOf("sharp knife"));
            System.out.println("You have used the sharp knife for a trap.");
            time-=3;
          }
          else if (input.equals("fishing rod")&&inventory.contains("fishing rod")){
            inventory.remove(inventory.indexOf("fishing rod"));
            System.out.println("You have used the fishing rod for a trap.");
            time-=3;
          }
          else if ((input.equals("bottled water")||input.equals("water"))&&inventory.contains("bottled water")){
            inventory.remove(inventory.indexOf("bottled water"));
            System.out.println("You have used the bottled water for a trap.");
            time-=3;
          }
          else if(input.equals("none")){
            System.out.println("You have set a trap.");
            time-=10;
          }
          else{
            System.out.println("Not a valid option.");
            makingTrap=false;
          }
          if (makingTrap=true){
            if(room.equals("bedroom")) bedroomTrap++;
            if(room.equals("corridor")) corridorTrap++;
            if(room.equals("office")) officeTrap++;
            if(room.equals("trophy")) trophyTrap++;
            if(room.equals("kitchen")) kitchenTrap++;
            if(room.equals("entrance")) entranceTrap++;
            makingTrap=false;
          }
        }
        else if(input.equals("rope")){
          if(inventory.contains("sharp knife")){
            System.out.println("You cut the rope with the sharp knife.");
            inventory.add("rope");
            time-=1;
          } 
          else{
            System.out.println("You cut the rope with the small knife.");
            inventory.add("rope");
            time-=5;
          }
        }
        else if((input.equals("firewood")||input.equals("fire wood"))&&(room=="bedroom")&&(inventory.contains("rope"))){
          System.out.println("You tied the firewood together with the rope. Now you can carry it.");
          inventory.add("firewood");
        }
        else if(input.equals("exit")){//move onto the next section
          System.out.println("SECTION EXITED");
          break;
        }
        else if(input.equals("moretime")){//sets time to 360 for debug purposes
          time = 360;
          System.out.println("Time set to 360. Don't forget to call the host ;)\n");
        }
        else if(input.equals("points")){//sets points for debug purposes
          try{//woah didnt know this existed, had to look it up. Useful!
          //checks if there are exceptions in the code. This is so cool
            System.out.print("Set survival points:");
            survivalPoints = scan.nextInt();//in case input is not an int
            scan.nextLine();//WHY DOES SCANNING AN INT MAKE NEXT SCANNER INPUT AN EMPTY STRING???
            //THIS IS SO STUPID?!?
          } catch (Exception e){}//executes this instead of an exception
          //idk why, but it somehow prints out "Input: Not an option" when it catches an error, but at least it kinda fits?
        }
        else{
          System.out.println("Not an option.\n");
        }
      }
    scan.nextLine();
    
        //SECTION 3
    if(reachedExit==false){
      System.out.println("Right as you finished doing this, you hear someone try to open the entrance door, the chair you set up blocking their way. It seems you are out of time. You need to get out of here. Although… maybe you are able to put up a fight with the host?");
      System.out.println("SECTION 3: THE HOST\n");
      System.out.println("(Tutorial: You start before the host. On your turn, you can use two available actions, including moving to a different room (the actions have changed. To see the new actions, type \"actions\".) Either reach the entrance room and try your chances at surviving outside with what you have, or fight the host. If you manage to defeat them, you are guaranteed to survive the wilderness.");
      System.out.println("If the host notices you being in the same room as them, they will injure you. Injuries lower your chances of traversing the wilderness alive, but you get one more action immediately after receiving one. Talk about adrenaline!)\n");
    }
    //hosts path
    String[] hostPath = {"entrance","corridor","bedroom","office","bedroom","corridor","kitchen","corridor","trophy","corridor"};
    actions = "\nAvailable actions:\n\"Move\" - Choose a room to move to. \n\"Inventory\" - Check to see what your inventory contains.\n\"Keys\" - Check what keys you have.\n\"Attack\" - Attack the host with a weapon. If you manage to kill the host, you gain a 100% chance of surviving the wilderness.";
    actions = actions.concat("\n\"Hide\" - Hide from the host. At first they won't notice you, but every time they return to a room, there's a greater chance you will be found.\n\"Wait\" - Skip one action.");
    //too many actions lol
    int playerActions=2;
    String hostRoom = "none";
    int turn = 0;
    int injuries=0;
    boolean hiding=false;
    boolean repeat=false;
    int hostStall=0;
    int hostHealth=10;
    boolean rifleUsed=false;
    boolean sharpKnifeEquipped=false;
    boolean smallKnifeEquipped=false;
    if(reachedExit==false){
      while(true){
        while(playerActions>0){
          System.out.print("Input: ");
          input = scan.nextLine().toLowerCase();
          if(input.equals("actions")||input.equals("action")||input.equals("help")){
            System.out.println(actions);
          }
          else if(input.equals("move")){//Available movement. Yeah I just copy pasted it from section 2. Im not creating a sepparate file for this.
            System.out.println("\nChoose a room to move to:");
            System.out.println("Stay");
            if(room.equals("bedroom")){//bedroom move
              System.out.println("Corridor");
              if(officeUnlocked==true){
                System.out.println("Office");
              }
            }
            else if(room.equals("office")){//office move
              System.out.println("Bedroom");
            }
            else if(room.equals("corridor")){//corridor move
              System.out.println("Bedroom\nEntrance room\nKitchen");
              if(trophyUnlocked==true){
                System.out.println("Trophy room");
              }
            }
            else if(room.equals("entrance")){//entrance room move
              System.out.println("Corridor");
              if(entranceUnlocked==true){
                System.out.println("Outside");
              }
            }
            else if(room.equals("kitchen")||room.equals("trophy")){//kitchen and trophy room move
              System.out.println("Corridor");
            }
            else{//error handler
              System.out.println("You're not in a known room");
            }
            System.out.print("\nInput: ");
            input = scan.nextLine().toLowerCase();//Actual movement
            if(input.equals("stay")){
              System.out.println("You stayed in the same room. No actions taken.\n");
            }
            else{
              hiding=false;
              if(input.equals("bedroom")){//move to bedroom
                if(room.equals("corridor")||room.equals("office")){
                  System.out.println("You moved to the bedroom.\n");
                  room = "bedroom";
                  playerActions-=1;
                }
                else{
                  System.out.println("Can't access it right now.\n");
                }
              }
              else if(input.equals("corridor")){//move to corridor
                if(room.equals("bedroom")||room.equals("trophy")||room.equals("kitchen")||room.equals("entrance")){
                  System.out.println("You moved to the corridor.\n");
                  if(corridorSeen==false){
                    System.out.println("The corridor is dark but not too long. Surprisingly empty too. Unless there are any secret compartments here, you doubt you could find anything worthwhile. There are four doors, all labeled. What is this person's deal with labeling rooms?\n");
                    corridorSeen=true;
                  }
                  room = "corridor";
                  playerActions-=1;
                }
                else{
                  System.out.println("Can't access it right now.\n");
                }
              }
              else if(input.equals("office")){//move to office
                if((officeUnlocked==true)&&(room.equals("bedroom"))){
                  System.out.println("You moved to the office.\n");
                  if(officeSeen==false){
                    System.out.println("When you enter the room, the first things you notice are the strong smell of dust and mountains of papers scattered about. Many of them seem to be personal documents of various different people... There is also a variety of equipment for hunting and fishing. No guns though, sadly. There are no doors except for the one you entered through.\n");
                    officeSeen=true;
                  }
                  room = "office";
                  playerActions-=1;
                }
                else{
                  System.out.println("Can't access it right now.\n");
                }
              }
              else if(input.equals("trophy room")||input.equals("trophy")){//move to trophy room
                if((trophyUnlocked==true)&&(room.equals("corridor"))){
                  System.out.println("You moved to the trophy room.\n");
                  if(trophySeen==false){
                    System.out.println("Mounted animal heads. So many of them. You don't think there is an inch of a wall that doesn't have one or some other kind of hunting trophy. A few cabinets are placed haphazardly around the room, as well as pedestals with full-body taxidermied animals. Even the chandelier is made of deer antlers. You can't tell if the host absolutely loves or hates animals, but they seem to feel very strongly about it.\n");
                    trophySeen=true;
                  }
                  room = "trophy";
                  playerActions-=1;
                }
                else{
                  System.out.println("Can't access it right now.\n");
                }
              }
              else if(input.equals("kitchen")){//move to kitchen
                if(room.equals("corridor")){
                  System.out.println("You moved to the kitchen.\n");
                  if(kitchenSeen==false){
                    System.out.println("A normal kitchen - fridge, counters, a sink, some cabinets. There is a strong smell of raw meat, so you doubt you will find anything else here.\n");
                    kitchenSeen=true;
                  }
                  room = "kitchen";
                  playerActions-=1;
                }
                else{
                  System.out.println("Can't access it right now.\n");
                }
              }
              else if(input.equals("entrance")||input.equals("entrance room")){//move to entrance room
                if(room.equals("corridor")){
                  System.out.println("You moved to the entrance room.\n");
                  if(entranceSeen==false){
                    System.out.println("It is quite barren, but not the the same extent the corridor is. There are a few chairs, a table, and a chandelier at least. You notice that the only window in the room has a circular pattern of cracks on it, almost like a spiderweb. It seems it has been shot at once, and has turned out bullet proof. You think it is safe to assume that all of the other windows are reinforced too, meaning that the only exit is the door here.");
                    System.out.println("You try the handle of the front door. It's locked. Sadly, it seems your captor actually does have some sense in them. You push a chair up against it. Just in case.\n");
                    entranceSeen=true;
                  }
                  room = "entrance";
                  playerActions-=1;
                }
                else{
                  System.out.println("Can't access it right now.\n");
                }
              }
              else if(input.equals("outside")||input.equals("out")){
                System.out.println("You get out of the house.\n");
                reachedExit=true;
                break;
              }
              else{//other inputs
                System.out.println("Not an available room\n");
              }
              if(room.equals(hostRoom)){
                System.out.println("As you open the door you see a tall figure searching around the room.");
                break;
              }
            }
          }
          else if(input.equals("hide")){
            if(!room.equals("corridor")){
              System.out.println("You are now hiding.");
              hiding=true;
              playerActions-=1;
            }
            else System.out.println("Nowhere to hide here.(no actions taken)");
          }
          else if(input.equals("attack")){
            if(room.equals(hostRoom)){
              if(rifleUsed==false&&inventory.contains("loaded rifle")){//has rifle
                System.out.println("\nYou take out the rifle. You didn't notice it before, but it is a single shot rifle. You can only shoot once.\nNevertheless you point it at the host and pull the trigger. In such a small range, you were practically guaranteed to hit.");
                System.out.println("The host is greatly wounded. They are also stalled for one turn.");
                hostHealth-=7;
                rifleUsed=true;
                playerActions-=1;
              }
              else if(inventory.contains("sharp knife")){//has sharp knife
                if (sharpKnifeEquipped==false){
                  System.out.println("\nYou pull out the sharp knife. It feels nice in your hand. You can't be sure you will hit the host but the chances are good.");
                  sharpKnifeEquipped=true;
                }
                System.out.print("You use the knife and ");
                if((int)(Math.random()*101)>=50){//50%chance
                  System.out.print("manage to hit the host!");
                  hostHealth-=3;
                  if(hostHealth>0){
                    System.out.println("\nThey are wounded and stalled for one turn.");
                    hostStall+=1;
                    playerActions-=1;
                  }
                  else{
                    System.out.println("They stop moving.");
                    break;
                  }
                }
                else{
                  System.out.println("miss!");
                  playerActions-=1;
                }
              }
              else{//has small knife
                if (smallKnifeEquipped==false){
                    System.out.println("\nYou pull out the small knife. It feels awkward in your hand. You can't be sure you will hit the host.");
                    sharpKnifeEquipped=true;
                }
                System.out.print("You use the knife and ");
                if((int)(Math.random()*101)>=75){//25%chance
                  System.out.print("manage to hit the host!");
                  hostHealth-=2;
                  if(hostHealth>0){
                    System.out.println("\nThey are wounded and stalled for one turn.");
                    hostStall+=1;
                    playerActions-=1;
                  }
                  else{
                    System.out.println("They stop moving.");
                    break;
                  }
                }
                 else{
                  System.out.println("miss!");
                  playerActions-=1;
                }
              }
            }
            else System.out.println("\nNo one to attack.(no actions taken)");
          }
          else if(input.equals("wait")){
            System.out.println("You waited.");
            playerActions-=1;
          }
          else if(input.equals("exit")){//move onto the next section
            System.out.println("SECTION EXITED");
            break;
          }
          else if(input.equals("points")){//sets points for debug purposes
            try{
              System.out.print("Set survival points:");
              survivalPoints = scan.nextInt();//also works for sorting out very large numbers :)
              scan.nextLine();
            } catch (Exception e){}
          }
          else{
            System.out.println("Not an option.\n");
          }
        }
        if(reachedExit==true) break;
        if(hostHealth>0){
          System.out.println("End of your turn... The host is acting.");
          playerActions=2;
          if(hostRoom.equals("bedroom")&&(!(bedroomTrap==0))){//Bedroom traps
            System.out.println("The host set off a trap!");
            hostStall++;
            bedroomTrap-=1;
          }
          else if(hostRoom.equals("office")&&(!(officeTrap==0))){//office traps
            System.out.println("The host set off a trap!");
            hostStall++;
            officeTrap-=1;
          }
          else if(hostRoom.equals("corridor")&&(!(corridorTrap==0))){//corridor traps
            System.out.println("The host set off a trap!");
            hostStall++;
            corridorTrap-=1;
          }
          else if(hostRoom.equals("trophy")&&(!(trophyTrap==0))){//trophy room traps
            System.out.println("The host set off a trap!");
            hostStall++;
            trophyTrap-=1;
          }
          else if(hostRoom.equals("kitchen")&&(!(kitchenTrap==0))){//kitchen traps
            System.out.println("The host set off a trap!");
            hostStall++;
            kitchenTrap-=1;
          }
          else if(hostRoom.equals("entrance")&&(!(entranceTrap==0))){//entrance room traps
            System.out.println("The host set off a trap!");
            hostStall++;
            entranceTrap-=1;
          }
          if(hostStall==0){//host not stall
            if(room.equals(hostRoom)&&hiding==true){//if same room and hiding
              if(repeat==false) System.out.println("You manage to avoid the host. Their eyes don't fall on your hiding spot.");
              else{
                if((int)(Math.random()*50)>65){//fail hiding
                  System.out.println("Your hiding spot fails");
                  hiding=false;
                }
                else System.out.println("You manage to avoid the host. Their eyes don't fall on your hiding spot.");
              }
            }
            if(room.equals(hostRoom)&&hiding==false){//same room not hiding
              System.out.println("You are noticed and the figure quickly moves toward you and attacks you! You feel a burst of pain and adrenaline.(You gain an aditional action for 1 turn)");
              playerActions+=1;
              injuries+=1;
              if(injuries>5)break;
            }
            else{
              hostRoom = hostPath[turn];//host movement only if in different room
              turn++;
              if(turn==10){
                turn=0;
                repeat=true;
              }
            }
          }
          else{//host stall
            System.out.println("The host is stalled. They will not act right now.");
            hostStall-=1;
          }
        }
        else{
          survivalPoints=69;
          System.out.println("You did it. The host is dead now... You gather everything that can be useful in their house and leave as soon as you can.");
          break;
        }
      }
    }
    if(injuries>5){
      System.out.println("\nEverything hurts... You've been hit too many times. Your vision darkens...");
      System.out.println("(You lost... Better luck next time!)");
    }
    else{
      System.out.println("You feel the crunch of snow beneath your feet. You start running. Each step takes you further away from the house, and into the unknown.");
      //SECTION 4
      boolean success = false;
      survivalPoints-=injuries;
      //algorithm for calculating success chance
      //Generates a random number 0-100, compares to survival points times 10.
      //Survival points act as a chance here. Ex: 4 points = 40% chance.
      //If 10 or more points, automatic success.
      if((int)(Math.random()*101)<=(survivalPoints*10)){
          success = true;
      }
      if (success == true){
        System.out.println("After some time, you take a break. The resources you gathered keeping you alive. For the next few days, you continue moving through the forest, and finally find a small populated town. You are safe now.\n");
        System.out.println("(Congradulations! You won!)");
      }
      else{
        System.out.print("After a day or so of walking, you realize you do not enough supplies for the next few days");
        if(injuries>0) System.out.println(", and your injuries don't help either.");
        System.out.println(". You hope that maybe you'll find help sooner than you run out of them, but as the days go by and the resources dwindle there is nothing but trees and snow in sight. You do not have the energy to keep going.");
        System.out.println("(You lost... Better luck next time!)");
      }
    }
  }
}