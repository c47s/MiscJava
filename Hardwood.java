import java.util.Scanner;
import java.util.Random;
/**
 * This RPG is very strange.
 * 
 * @TODO: Add more places to get gold
 * @TODO: Expand world
 * @TODO: Make main coliseum enterance
 * 
 * 
 * @author Nathaniel Waterman
 * @version 10^97569283761
 */
public class Hardwood
{
	static Scanner input = new Scanner(System.in);
	static Random generator = new Random();
	
	
	
	//Utility variables
	static String action, location;
	static boolean run;
	static boolean yesNo;
	static int random;
	
	
	
	//Area variables
	static boolean beenToMossyClearing = false;
	
	static boolean beenToVineWoods = false;
	
	static boolean beenToOvergrownPathClearingSide = false;
	static boolean beenToOvergrownPathCenter = false;
	static boolean beenToOvergrownPathHouseSide = false;
	
	static boolean beenToRusticHouseOutside = false;
	static boolean beenToRusticHouse = false;
	static int houseChestGold = generator.nextInt(10) + 11;
	static int houseBedGold = generator.nextInt(10) + 11;
	static int houseLemonJuiceBottles = generator.nextInt(4) + 1;
	static int houseHealingCreamJars = generator.nextInt(4) + 1;
	static boolean burlyManAlive = true;
	static boolean burlyManAfraid = false;
	
	static boolean beenToGlowingCave = false;
	
	static boolean beenToSlimyTunnel = false;
	static boolean beenToSlimyCave = false;
	
	static boolean beenToColiseumBackHall = false;
	static boolean beenToColiseumLStaircase = false;
	static boolean beenToColiseumRStaircase = false;
	static boolean beenToColiseumStaffHall = false;
	static boolean beenToColiseumMachineRoom = false;
	static boolean beenToColiseumAdminRoom = false;
	static boolean beenToColiseumGloryBox = false;
	static boolean beenToColiseumPit = false;
	static boolean beenToColiseumMainEntrance = false;
	static boolean beenToColiseumMainStaircase = false;
	static boolean beenToColiseumMainHall = false;
	static boolean beenToColiseumStaffStaircase = false;
	static boolean beenToColiseumAdmission = false;
	static boolean beenToColiseumStands = false;
	static boolean coliseumChampion = false;
	
	static boolean beenToShopOutside = false;
	static boolean beenToShop = false;
	static boolean shopHasSword = true;
	static int shopLemonJuiceBottles = generator.nextInt(35) + 16;
	static int shopHealingCreamJars = generator.nextInt(35) + 16;
	
	
	
	//Player variables
	static String name;
	static int health = 10;
	static int gold = generator.nextInt(50) + 51;
	
	//Inventory variables
	static boolean hasSword = false;
	static int lemonJuiceBottles = 0;
	static int healingCreamJars = 0;
	
	
	
	//Utility methods
	public static String getInput(String prompt) {
		run = true;
		while (run) {
			System.out.println(prompt);
			System.out.print(location + " > ");
			action = input.next();
			if (action.toLowerCase().equals("health")) {
				println("You have " + health + " out of 10 health");
				
				if (health < 10 && healingCreamJars > 0) {
					if (getYesNo("Use a jar of healing cream?\nYou have " + healingCreamJars + " jars of healing cream.")) {
						health += generator.nextInt(3) + 1;
						healingCreamJars --;
					}
				}
				run = true;
			} else if (action.toLowerCase().toLowerCase().equals("gold")) {
				println("You have " + gold + " gold coins.");
				run = true;
			} else if (action.toLowerCase().toLowerCase().equals("inventory")) {
				print("You have");
				
				run = !(
					hasSword || lemonJuiceBottles > 0 || healingCreamJars > 0
				);
					
				if (run) {
					println(" nothing.");
				} else {
					println(":");
				}
				
				if (hasSword) {
					println("- a sword");
				}
				
				if (lemonJuiceBottles > 0) {
					println("- " + lemonJuiceBottles + " bottles of lemon juice");
				}
				
				if (healingCreamJars > 0) {
					println("- " + healingCreamJars + " jars of healing cream");
				}
				run = true;
			} else {
				run = false;
			}
		}
		return action;
	}
	
	public static boolean getYesNo(String prompt) {
		run = true;
		while (run) {
			action = getInput(prompt + " - yes/no");
			
			if (action.toLowerCase().charAt(0) == 'y') {
				yesNo = true;
				run = false;
			} else if (action.toLowerCase().charAt(0) == 'n') {
				yesNo = false;
				run = false;
			} else {
				run = true;
			}
		}
		
		return yesNo;
	}
	
	public static void println(String message) {
		System.out.println(message);
	}
	
	public static void print(String message) {
		System.out.print(message);
	}
	
	public static boolean initLocation(String name) {
		location = name;
		System.out.print("\n\n");
		
		if (health <= 0) {
			println("You died.");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(e);
			}
			System.exit(0);
		}
		
		return true;
	}
	
	
	
	//Area methods
	public static void mossyClearing() {
		initLocation("Mossy Clearing");
		
		if (!beenToMossyClearing) {
			action = getInput("You find yourself lying in a mossy clearing.\nThere are trees all around.\nWhat will you call yourself?");
		} else {
			println("You are in a mossy clearing surrounded by trees.");
		}
		
		beenToMossyClearing = true;
		
		println("There is an overgrown path to your left,\nand vine-filled woods on all sides.");
		
		run = true;
		while (run) {
			action = getInput("'Woods' or 'path'?");
			
			if (action.toLowerCase().toLowerCase().equals("woods")) {
				println("You walk into the woods.");
				vineWoods();
				run = false;
			} else if (action.toLowerCase().toLowerCase().equals("path")) {
				println("You go to the path.");
				overgrownPathClearingSide();
				run = false;
			} else {
				if (action.toLowerCase().toLowerCase().equals("health")) {
					println("You have " + health + " out of 10 health");
					
					if (health < 10 && healingCreamJars > 0) {
						if (getYesNo("Use a jar of healing cream?\nYou have " + healingCreamJars + " jars of healing cream.")) {
							health += generator.nextInt(3) + 1;
							healingCreamJars --;
						}
					}
				} else if (action.toLowerCase().toLowerCase().equals("gold")) {
					println("You have " + gold + " gold coins.");
				} else if (action.toLowerCase().toLowerCase().equals("inventory")) {
					print("You have");
					
					run = hasSword || lemonJuiceBottles > 0 || healingCreamJars > 0;
					run = !run;
					
					if (run) {
						println(" nothing.");
					} else {
						println(":");
					}
					
					if (hasSword) {
						println("- a sword");
					}
					
					if (lemonJuiceBottles > 0) {
						println("- " + lemonJuiceBottles + " bottles of lemon juice");
					}
					
					if (healingCreamJars > 0) {
						println("- " + healingCreamJars + " jars of healing cream");
					}
				}
				run = true;
			}
		}
		println("Mossy Clearing");
	}
	
	public static void vineWoods() {
		beenToVineWoods = initLocation("Vine Woods");
		
		println("You are in some woods that are filled wih vines.");
		
		run = true;
		while (run) {
			print("You search around and find ");
			
			random = generator.nextInt(7);
			switch (random) {
				case 0:
					println("a mossy clearing.");
					
					if (getYesNo("Go there?")) {
						println("You go to the mossy clearing.");
						mossyClearing();
						run = false;
					} else {
						run = true;
					}
					
					break;
				
				case 1:
					println("a rustic house.\nThe vines around it are cut back.");
					
					if (getYesNo("Go to the house?")) {
						println("You go to the house.");
						rusticHouseOutside();
						run = false;
					} else {
						run = true;
					}
					
					break;
				
				case 2:
					println("a rocky crevice in the ground.");
					
					if (getYesNo("Go in the crevice?")) {
						println("You go into the rocky crevice.");
						glowingCave();
						run = false;
					} else {
						run = true;
					}
					
					break;
				
				case 3:
					println("an overgrown path.");
					
					if (getYesNo("Go to it?")) {
						println("You go onto the path.");
						overgrownPathCenter();
						run = false;
					} else {
						run = true;
					}
					
					break;
				
				case 4:
					println("a shack with SHOP painted on it.");
					
					if (getYesNo("Go to it?")) {
						println("You go to the shop.");
						shopOutside();
						run = false;
					} else {
						run = true;
					}
					
					break;
				
				case 5:
					println("a strange floating orb of stone\ncovered with glowing blue runes.");
					
					if (getYesNo("Go to it?")) {
						println("You walk over to the stone orb.\nWhen you get near the orb, you have an overwhelming desire to grab it.\nYou reach out, and as your finger touches its surface, reality melts away.\nYou suddenly find that you can feel nothing and hear nothing.\nAll you percieve is words, and you find you can create numbers with your mind.\n\n");
						int num, guess, attempt;
						int[] guesses = new int[100];
						boolean run = true;
						char answer;
						
						while (run) {
							num = generator.nextInt(50)+1;
							guess = 0;
							attempt = 0;
							
							println("***********************");
							println("* Guess That Integer! *");
							println("***********************\n");
							println("In this game, you must");
							println("guess an integer which");
							println("is some number from 1 to 50.");
							println("After your guess, you will");
							println("recieve \"Too high.\" or");
							println("\"Too low.\" This will be");
							println("a lie about 20% of the time.\n");
							
							while (guess != num) {
								guess = 0;
								
								while (guess < 1 || guess > 50) {
									println("Enter your guess - Attempt " + (attempt + 1));
									print(">");
									guess = input.nextInt();
								}
								
								guesses[attempt] = guess;
								
								attempt ++;
								
								int unreliability = generator.nextInt(5);
								
								if (guess != num) {
									if (unreliability > 4) {
										if (guess < num) {
											println("Too high.");
										} else if (guess > num) {
											println("Too low.");
										}
									} else {
										if (guess < num) {
											println("Too low.");
										} else if (guess > num) {
											println("Too high.");
										}
									}
								}
							}
							
							println("Correct! You guessed the integer in " + attempt + " tries!");
							
							println("\nGuess playback:");
							
							for (int i = 0; i < attempt; i ++) {
								try {
									Thread.sleep(2000);
								} catch (Exception e) {
									System.out.println(e);
								}
								println("Attempt " + (i + 1) + ": " + guesses[i]);
							}
							
							println("\nPlay another game?");
							print(">");
							answer = input.next().charAt(0);
							
							if (answer == 'y') {
								run = true;
							} else if (answer == 'n') {
								run = false;
							} else {
								run = false;
								println("Invalid Input");
							}
						}
						run = false;
					} else {
						run = true;
					}
					
					break;
					
				case 6:
					println("a majestic entrance to a staircase in the center of a huge clearing.");
					
					if (getYesNo("Go to the clearing?")) {
						println("You go to the clearing.");
						coliseumMainEntrance();
						run = false;
					} else {
						run = true;
					}
					
					break;
			}
		}
		println("Vine Woods");
	}
	
	public static void overgrownPathClearingSide() {
		beenToOvergrownPathClearingSide = initLocation("Overgrown Path - Clearing Side");
		
		println("You are on an overgrown path in the woods.\nThe path connects to a mossy clearing.\nThere is a bend in the path,\nand you can't see what lies around it.\nThere are bushes on either side of the bend.");
		
		run = true;
		while (run) {
			action = getInput("Walk on the 'path', go into the 'woods', or go into the 'clearing'?");
			
			if (action.toLowerCase().equals("clearing")) {
				println("You go into the clearing.");
				mossyClearing();
				run = false;
			} else if (action.toLowerCase().equals("path")) {
				println("You walk along the path.");
				overgrownPathCenter();
				run = false;
			} else if (action.toLowerCase().equals("woods")) {
				println("You go into the woods.");
				vineWoods();
				run = false;
			} else {
				run = true;
			}
		}
		println("Overgrown Path - Clearing Side");
	}
	
	public static void overgrownPathCenter() {
		beenToOvergrownPathCenter = initLocation("Overgrown Path - Center");
		
		println("You are on an overgrown path in the woods.\nThere are two bends in the path,\non either side of you.\nOne has some bushes around it,\nthe other has brambles.");
		
		run = true;
		while (run) {
			action = getInput("Go around the 'bushes' bend, the 'brambles' bend, or go into the 'woods'?");
			
			if (action.toLowerCase().equals("bushes")) {
				println("You walk around the bend.");
				overgrownPathClearingSide();
				run = false;
			} else if (action.toLowerCase().equals("brambles")) {
				println("You walk around the bend.");
				overgrownPathHouseSide();
				run = false;
			} else if (action.toLowerCase().equals("woods")) {
				println("You go into the woods.");
				vineWoods();
				run = false;
			} else {
				run = true;
			}
		}
		println("Overgrown Path - Center");
	}
	
	public static void overgrownPathHouseSide() {
		beenToOvergrownPathHouseSide = initLocation("Overgrown Path - House Side");
		
		println("You are on an overgrown path in the woods.\nThere are vines on the trees.\nThe path connects to a rustic house with the vines cut back around it.\nThere is a bend in the path,\nand you can't see what lies around it.\nThere are brambles on either side of the bend.");
		
		run = true;
		while (run) {
			action = getInput("Walk on the 'path', go into the 'woods', or go to the 'house'?");
			
			if (action.toLowerCase().equals("house")) {
				println("You go to the house.");
				rusticHouseOutside();
				run = false;
			} else if (action.toLowerCase().equals("path")) {
				println("You walk along the path.");
				overgrownPathCenter();
				run = false;
			} else if (action.toLowerCase().equals("woods")) {
				println("You go into the woods.");
				vineWoods();
				run = false;
			} else {
				run = true;
			}
		}
		println("Overgrown Path - House Side");
	}
	
	public static void rusticHouseOutside() {
		beenToRusticHouseOutside = initLocation("Rustic House - Outside");
		
		println("You are in a grassy area around a rustic house.");
		
		if (burlyManAlive) {
			println("It looks like somebody is home,\nthere is movement inside.");
		}
		
		run = true;
		while (run) {
			action = getInput("Walk on the 'path', go into the 'woods', or go into the 'house'?");
			
			if (action.toLowerCase().equals("house")) {
				println("You go into the house.");
				rusticHouse();
				run = false;
			} else if (action.toLowerCase().equals("path")) {
				println("You walk along the path.");
				overgrownPathHouseSide();
				run = false;
			} else if (action.toLowerCase().equals("woods")) {
				println("You go into the woods.");
				vineWoods();
				run = false;
			} else {
				run = true;
			}
		}
		println("Rustic House - Outside");
	}
	
	public static void rusticHouse() {
		initLocation("Rustic House");
		
		println("You are in a one-room house.\nIt has some chairs, a table, workbench and two beds.\nAll of the furniture is wooden.");
		
		if (burlyManAlive) {
			if (burlyManAfraid) {
				println("A burly man sits meekly in a chair when you enter.");
			} else {
				println("A burly man jumps up from a chair as you enter.");
			}
		} else {
			println("A burly man lies on the floor, dead.");
		}
		
		run = true;
		while (run) {
			if (burlyManAlive && !burlyManAfraid) {
				action = getInput("'Run', 'talk', or 'fight'?");
				
				if (action.toLowerCase().equals("run")) {
					println("You manage to get out of the door.\nThe man shouts curses at you.");
					beenToRusticHouse = true;
					rusticHouseOutside();
					run = false;
				} else if (action.toLowerCase().equals("talk") && !beenToRusticHouse) {
					println("The man walks up.");
					println("Burly Man - \"What are you doing in my house?\"");
					
					run = true;
					while (run) {
						action = getInput("Be 'polite' - \"Just exploring, sorry.\"\nBe 'rude' - \"Well, why don't you guard your house a bit better?\"");
						
						if (action.toLowerCase().equals("polite")) {
							println(name + " - \"Just exploring, sorry.\"\nBurly Man - \"Alright, leave and don't bother me again.\"");
							if (getYesNo("Leave the house?")) {
								println("You leave the house.");
								beenToRusticHouse = true;
								rusticHouseOutside();
								run = false;
							} else {
								if (hasSword) {
									println("The man is helpless against your sword.");
									
									if (getYesNo("Kill the man?")) {
										println("You kill the burly man.");
										burlyManAlive = false;
									} else {
										println("The burly man thanks you for sparing him,\nand promises to stay out of your way.");
										burlyManAfraid = true;
									}
									rusticHouse();
								} else {
									println("You are no match for the man.\nHe punches your head, and you fall unconcious.\n\nYou slowly wake up.");
									beenToRusticHouse = true;
									health --;
									vineWoods();
								}
							}
							run = false;
						} else if (action.toLowerCase().equals("rude")) {
							println(name + " - \"Well, why don't you guard your house a bit better?\"\nBurly Man - \"I guard it like this!\"");
							if (hasSword) {
								println("The man is helpless against your sword.");
								
								if (getYesNo("Kill the man?")) {
									println("You kill the burly man.");
									burlyManAlive = false;
								} else {
									println("The burly man thanks you for sparing him,\nand promises to stay out of your way.");
									burlyManAfraid = true;
								}
								rusticHouse();
							} else {
								println("You are no match for the man.\nHe punches your head, and you fall unconcious.\n\nYou slowly wake up.");
								beenToRusticHouse = true;
								health --;
								vineWoods();
							}
							run = false;
						} else {
							run = true;
						}
					}
					run = false;
				} else if (action.toLowerCase().equals("fight")) {
					if (hasSword) {
						println("The man is helpless against your sword.");
						
						if (getYesNo("Kill the man?")) {
							println("You kill the burly man.");
							burlyManAlive = false;
						} else {
							println("The burly man thanks you for sparing him,\nand promises to stay out of your way.");
							burlyManAfraid = true;
						}
						rusticHouse();
					} else {
						println("You are no match for the man.\nHe punches your head, and you fall unconcious.\n\nYou slowly wake up.");
						beenToRusticHouse = true;
						health --;
						vineWoods();
					}
					run = true;
				} else {
					run = true;
				}
			} else {
				println("In the room, you see a wooden chest, some shelves, and a bed.");
				
				run = true;
				while (run) {
					action = getInput("Go to the 'chest', 'shelves', 'bed', or 'leave'?");
					
					if (action.toLowerCase().equals("chest")) {
						println("You find " + houseChestGold + " gold coins in the chest.");
						gold += houseChestGold;
						houseChestGold = 0;
						run = true;
					} else if (action.toLowerCase().equals("shelves")) {
						print("You find");
						
						run = houseLemonJuiceBottles > 0 || houseHealingCreamJars > 0;
						run = !run;
						
						if (run) {
							println(" nothing.");
						} else {
							println(":");
						}
						
						if (houseLemonJuiceBottles > 0) {
							println("- " + houseLemonJuiceBottles + " bottles of lemon juice");
							lemonJuiceBottles += houseLemonJuiceBottles;
							houseLemonJuiceBottles = 0;
						}
						
						if (houseHealingCreamJars > 0) {
							println("- " + houseHealingCreamJars + " jars of healing cream");
							healingCreamJars += houseHealingCreamJars;
							houseHealingCreamJars = 0;
						}
						run = true;
					} else if (action.toLowerCase().equals("bed")) {
						println("You find " + houseBedGold + " gold coins under the bed.");
						gold += houseBedGold;
						houseBedGold = 0;
						run = true;
					} else if (action.toLowerCase().equals("leave")) {
						println("You leave the house.");
						rusticHouseOutside();
						run = false;
					} else {
						run = true;
					}
				}
				run = false;
			}
		}
		println("Rustic House");
	}
	
	public static void glowingCave() {
		beenToGlowingCave = initLocation("Glowing Cave");
		
		println("You are in a cave filled with glowing moss.\nThere is a slimy tunnel and an ornately carved hallway going deeper down.\nThere is also a crack in the wall, opening to the woods.");
		
		run = true;
		while (run) {
			action = getInput("Go 'tunnel', 'hallway', or 'crack'?");
			
			if (action.toLowerCase().equals("tunnel")) {
				println("You go into the tunnel.");
				slimyTunnel();
				run = false;
			} else if (action.toLowerCase().equals("hallway")) {
				println("You go into the hallway.");
				coliseumBackHall();
				run = false;
			} else if (action.toLowerCase().equals("crack")) {
				println("You go through the crack.");
				vineWoods();
				run = false;
			} else {
				run = true;
			}
		}
		println("Glowing Cave");
	}
	
	public static void slimyTunnel() {
		beenToSlimyTunnel = initLocation("Slimy Tunnel");
		
		println("You are in a slimy tunnel.\nYou are careful not to slip on the undulating slime.\nIt opens into a slimy cave on one end,\nand a cave filled with glowing moss on the other.");
		
		run = true;
		while (run) {
			action = getInput("Go 'slimy' or 'glowing'?");
			
			if (action.toLowerCase().equals("slimy")) {
				println("You go into the slimy cave.");
				slimyCave();
				run = false;
			} else if (action.toLowerCase().equals("glowing")) {
				println("You go into the glowing cave.");
				glowingCave();
				run = false;
			} else {
				run = true;
			}
		}
		println("Slimy Tunnel");
	}
	
	public static void slimyCave() {
		beenToSlimyCave = initLocation("Slimy Cave");
		
		println("You are in a slimy cave.\nThe slime is slowly undulating towards you,\nand is suddenly very sticky.");
		
		if (lemonJuiceBottles > 0) {
			println("You dump a bottle of lemon juice on yourself.\nThe slime moves away very quickly.\nThe stuff really works!\nYou run into the slimy tunnel.");
			lemonJuiceBottles --;
			slimyTunnel();
		} else {
			println("The slime slowly envelops you.\nYou fade into unconciousness.");
		}
		println("Slimy Cave");
	}
	
	public static void coliseumBackHall() {
		beenToColiseumBackHall = initLocation("Coliseum - Back Hall");
		
		println("You are in a carved hallway.\nRed torches cast a soft light on the walls.\nYou can see a large, circular coliseum through a window carved out of\nthe rock at the end of the hall.\nThere are staircases to the left and right of the window,\ngoing up and down in that order.\nAn armored guard stands by each staircase.\nThe hallway also opens to a glowing cave on the end opposite the window.");
		
		run = true;
		while (run) {
			action = getInput("Go 'left' staircase, 'right' staircase, or into the 'cave'?");
			
			if (action.toLowerCase().equals("left")) {
				if (coliseumChampion) {
					println("You go up the left staircase.");
					coliseumLStaircase();
				} else {
					println("As you walk towards the staircase, a guard silently steps in front of you.");
					coliseumBackHall();
				}
				run = false;
			} else if (action.toLowerCase().equals("right")) {
				if (coliseumChampion) {
					println("You go down the right staircase.");
					coliseumRStaircase();
				} else {
					println("As you walk towards the staircase, a guard steps in front of you.\nThey explain that this goes to the coliseum pit,\nand if you do not have excellent fighting gear and skills,\ngoing there means your death.\nThe guard also tells you that if you do survive,\nyou will become a coliseum champion.");
					if (getYesNo("Go to the staircase?")) {
						coliseumRStaircase();
					} else {
						coliseumBackHall();
					}
				}
				run = false;
			} else if (action.toLowerCase().equals("cave")) {
				println("You go into the cave.");
				glowingCave();
				run = false;
			} else {
				run = true;
			}
		}
		println("Coliseum - Back Hall");
	}
	
	public static void coliseumLStaircase() {
		beenToColiseumLStaircase = initLocation("Coliseum - Back Staircase");
		
		println("You are on a staircase carved from rock.\nThere is a hallway at the top of the stairs and at the bottom.");
		
		run = true;
		while (run) {
			action = getInput("Go 'up' or 'down'?");
			
			if (action.toLowerCase().equals("up")) {
				println("You go up the staircase.");
				coliseumStaffHall();
				run = false;
			} else if (action.toLowerCase().equals("down")) {
				println("You go down the staircase.");
				coliseumBackHall();
				run = false;
			} else {
				run = true;
			}
		}
		println("Coliseum - Back Staircase");
	}
	
	public static void coliseumRStaircase() {
		beenToColiseumRStaircase = initLocation("Coliseum - Back Staircase");
		
		println("You are on a staircase.\nAt the top, there is a hallway carved from stone.\nThe bottom leads to a grimy arena pit, with fearsome creatures behind gates of iron bars.\nThe gates look to be mechanically operated.\nA guard mutters about silly adventurers coming to die in the pit.");
		
		run = true;
		while (run) {
			action = getInput("Go 'up' or 'down'?");
			
			if (action.toLowerCase().equals("up")) {
				println("You go up the staircase.");
				coliseumBackHall();
				run = false;
			} else if (action.toLowerCase().equals("down")) {
				println("You go down the staircase.");
				coliseumPit();
				run = false;
			} else {
				run = true;
			}
		}
		println("Coliseum - Back Staircase");
	}
	
	public static void coliseumStaffHall() {
		beenToColiseumStaffHall = initLocation("Coliseum - Staff Hallway");
		
		print("You are in a hallway carved from stone.\nIt is bustling with coliseum staff.\nThe hallway connects to a staircase going down,\na room with mechanical grindings and clunkings eminating from it,\na room filled with papers and pompous administrators,\na staricase leading into another very large hallway,\nand a private coliseum viewing box guarded by two soldiers.");
		
		run = true;
		while (run) {
			action = getInput("Go on the 'staircase', into the 'machine' room,\n into the 'administration' room, towards the stairs connecting to the large 'hallway',\n or into the private viewing 'box'?");
			
			if (action.toLowerCase().equals("staircase")) {
				println("You go to the staircase.");
				coliseumLStaircase();
				run = false;
			} else if (action.toLowerCase().equals("machine")) {
				println("You go into the machine room.");
				coliseumMachineRoom();
				run = false;
			} else if (action.toLowerCase().equals("administration")) {
				println("You go into the administration room.");
				coliseumAdminRoom();
				run = false;
			} else if (action.toLowerCase().equals("hallway")) {
				println("You go onto the staircase connecting to the large hallway.");
				coliseumStaffStaircase();
				run = false;
			} else if (action.toLowerCase().equals("box")) {
				println("You go into the private viewing box.");
				coliseumGloryBox();
				run = false;
			} else {
				run = true;
			}
		}
		println("Coliseum - Staff Hallway");
	}
	
	public static void coliseumMachineRoom() {
		println("You are in a room full of machinery.\nThere are workers controlling the machines and a supervisor controlling the workers.");
		
		beenToColiseumMachineRoom = initLocation("Coliseum - Machine Room");
		
		run = true;
		while (run) {
			action = getInput("Talk to the 'supervisor', the 'workers', or leave?");
			
			if (action.toLowerCase().equals("supervisor")) {
				println("The supervisor tells you that these machines run the doors, gates,\nand even automatically feed the monsters.\n");
				run = true;
			} else if (action.toLowerCase().equals("workers")) {
				println("The workers show you the interesting and intricate mechanisms.\nThey seem proud of their great knowledge.\n");
				run = true;
			} else if (action.toLowerCase().equals("leave")) {
				println("You leave the machine room.");
				coliseumStaffHall();
				run = false;
			} else {
				run = true;
			}
		}
		println("Coliseum - Machine Room");
	}
	
	public static void coliseumAdminRoom() {
		println("You are in a room filled with desks, paperwork, and busy people.");
		
		beenToColiseumAdminRoom = initLocation("Coliseum - Administration Room");
		
		run = true;
		while (run) {
			action = getInput("'Talk' with an administrator or 'leave'?");
			
			if (action.toLowerCase().equals("talk")) {
				println("The administrator tells you about how much money the coliseum makes.\nEvery time he mentions money, he almost drools.\n");
				run = true;
			} else if (action.toLowerCase().equals("leave")) {
				println("You leave the administration room.");
				coliseumStaffHall();
				run = false;
			} else {
				run = true;
			}
		}
		println("Coliseum - Administration Room");
	}
	
	public static void coliseumGloryBox() {
		println("You enter into a lavish private viewing box.\nThere is a large window to the coliseum on one wall\nand a door to the staff hallway on the other.\nAround you are legendary adventurers.\nOne of them affectionately strokes a shapeshifting cat.");
		
		beenToColiseumGloryBox = initLocation("Coliseum - Glory Box");
		
		run = true;
		while (run) {
			action = getInput("What will you do? Watch the 'cat', look out of the 'window',\n'talk' with the adventurers, or go into the staff 'hallway'?");
			if (action.toLowerCase().equals("cat")) {
				println("You watch the magical cat.\n");
				random = generator.nextInt(20);
				switch (random) {
					case 0:
					println("The cat turns into a fuzzy purring sphere and rolls around.");
					break;
					case 1:
					println("It grows gecko feet and starts walking on the ceiling.");
					break;
					case 2:
					println("The cat sprouts wings and flies through the window and around the coliseum.");
					break;
					case 3:
					println("It shapeshifts into a chair and tries to be very still.");
					break;
					case 4:
					println("The cat rolls around on the floor, purring.");
					break;
					case 5:
					println("It rubs against your legs.");
					break;
					case 6:
					println("The cat rubs against someone's legs.");
					break;
					case 7:
					println("It jumps out the window, to the shock of the crowd, then turns into a catbird and flies back.");
					break;
					case 8:
					println("The cat jumps on your lap");
					break;
					case 9:
					println("It jumps on your head and licks your face");
					break;
					case 10:
					println("The cat turns into a miniature version of you and mocks you when you speak.");
					break;
					case 11:
					println("It pounces on a mouse as a frog, then lands on it as a snake.");
					break;
					case 12:
					println("The cat turns into a coin-coughing cormorant. You gain 1 gold.");
					gold ++;
					break;
					case 13:
					println("It turns into a coin-consuming cobra. You lose 1 gold.");
					gold --;
					break;
					case 14:
					println("The cat turns into a dog and goes around licking everything.");
					break;
					case 15:
					println("It grows tentacles around its mouth and catches a rat.");
					break;
					case 16:
					println("The cat dissapears, a flea lands on your lap, then it reappears where the flea was.");
					break;
					case 17:
					println("It jumps onto the cieling and turns into a chandelier.");
					break;
					case 18:
					println("The cat licks your boots.");
					break;
					case 19:
					println("It scarfs down some dropped food.");
					break;
					case 20:
					println("The cat licks someone's boots.");
					break;
				}
				run = true;
			} else if (action.toLowerCase().equals("window")) {
				println("You peer down at the coliseum below.\n");
				random = generator.nextInt(11);
				switch (random) {
					case 0:
					println("A bear gets stabbed through the heart, and the crowd goes wild!");
					break;
					case 1:
					println("There is a very boring swordfight going on.");
					break;
					case 2:
					println("An adventurer is fighting hundreds of centipedes using lemon juice.");
					break;
					case 3:
					println("Two furry spheres are doing what looks like sumo wrestling.");
					break;
					case 4:
					println("Someone steps into the pit, looking confused.\nSome guards escort them out. The crowd chuckles.");
					break;
					case 5:
					println("Two teams of combatatants are fighting to get an inflated pig stomach to the enemy's side of the pit.");
					break;
					case 6:
					println("There is a barrel in the pit that is shooting out colorful expolosions, to the awe of all watching.");
					break;
					case 7:
					println("Someone is trying to fight by holding their sword out and spinning.");
					break;
					case 8:
					println("Some furry spheres seem to be multipkying and rapidly growing out of control.\nLuckily someone in the crowd casts a spell and they turn into sand.");
					break;
					case 9:
					println("A fight has broken out among the crowd.");
					break;
					case 10:
					println("Some rich person in the crowd is tossing expensive chocolate truffles to whoever will catch them.");
					break;
					case 11:
					println("Some ghosts are having an epic battle.");
					break;
					case 12:
					println("A tall blue box labeled POLICE BOX is noisily disappearing, to the confusion of the crowd.");
					break;
					case 13:
					println("A mage is showcasing a long-distance communication device. Nobody is paying attention.");
					break;
					case 14:
					println("Two knights are jousting with sharpened stale baguettes.");
					break;
					case 15:
					println("The coliseum pit fills with water and some small boats are placed in it.");
					break;
					case 16:
					println("Members of the crowd are jumping into a brawl at the center of the arena.");
					break;
					case 17:
					println("Two cats are standing on their hind legs and punching each other with their paws.");
					break;
					case 18:
					println("Some clockwork automatons are brawling, the arena is littered with gears.");
					break;
					case 19:
					println("The announcer calls for the next contestant.");
					try {
						Thread.sleep(1000);
					} catch (Exception e) {}
					println("But nobody came.");
					try {
						Thread.sleep(200);
					} catch (Exception e) {}
					break;
					case 20:
					println("While you watch, someone slips their hand into your purse.");
					try {
						Thread.sleep(1000);
					} catch (Exception e) {}
					println("They seem to have added some gold?");
					gold += 10;
					try {
						Thread.sleep(200);
					} catch (Exception e) {}
					break;
				}
				run = true;
			} else if (action.toLowerCase().equals("talk")) {
				println("You strike up a conversation with a fellow adventurer.\n");
				random = generator.nextInt(1);
				switch (random) {
					case 0:
					println("But nobody came."); //TODO: Add more sights, sounds, and smells
					break;
					case 1:
					println("");
					break;
					case 2:
					println("");
					break;
					case 3:
					println("");
					break;
					case 4:
					println("");
					break;
					case 5:
					println("");
					break;
					case 6:
					println("");
					break;
					case 7:
					println("");
					break;
					case 8:
					println("");
					break;
					case 9:
					println("");
					break;
					case 10:
					println("");
					break;
					case 11:
					println("");
					break;
					case 12:
					println("");
					break;
					case 13:
					println("");
					break;
					case 14:
					println("");
					break;
					case 15:
					println("");
					break;
					case 16:
					println("");
					break;
					case 17:
					println("");
					break;
					case 18:
					println("");
					break;
					case 19:
					println("");
					break;
					case 20:
					println("");
					break;
				}
				run = true;
			} else if (action.toLowerCase().equals("hallway")) {
				println("You go into the staff hallway.");
				coliseumStaffHall();
				run = false;
			} else {
				run = true;
			}
		}
		println("Coliseum - Glory Box");
	}

	public static void coliseumPit() {
		println("You enter the pit, noticing chunks of cracked bone strewn about,\npresumably from the last fight. A portcullis slams down behind you.\nThe monster gates are slowly opening.\nSomeone shouts \"There is an unplanned adventurer in the pit!\nLet's have a round of applause for this brave soul!\"");
		
		beenToColiseumPit = initLocation("Coliseum - Pit");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {}
		if (hasSword) {
			println("Luckily, you have a sword. You pull it out.");
			
			random = generator.nextInt(15)+1;
			health -= random;
			int potns = 0;
			
			while (health < 1 && healingCreamJars > 0) {
				health += generator.nextInt(3) + 1;
				healingCreamJars --;
				potns ++;
				println("You are seriously wounded, you quickly apply some healing cream.");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {}
			}
			
			if (health > 1) {
				println("* * * * * * * * * * * *");
				println("* YOU ARE VICTORIOUS! *");
				println("* * * * * * * * * * * *\n");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {}
				println("You managed to slay each of the monsters, taking " + random + " damage ");
				if (potns > 1) {
					print("and using " + potns + " healing poitions ");
				}
				print("in the process.\nThis has left you with " + health + " health.\nYou are carried away by some guards.");
			} else {
				println("Though you fought well, you simply could not heal all of the damage you took.\nTo the dismay of the crowd watching in the seats above,\nyou died.");
			}
		} else {
			println("The guard was right about silly adventurers.\nYou are torn apart before the indifferent eyes of the coliseum audience.");
			health = 0;
		}
		coliseumGloryBox();
		
		println("Coliseum - Pit");
	}
	
	public static void coliseumMainEntrance() {
		println("You are in a large clearing in the woods.\nIn the center is an ornate roofed entrance to a giant staircase,\npacked with people making their way in and out.\nThe people are traveling to and from this clearing on a multitude of narrow paths through the trees.\nAbove the majestic doors, in the wide triangular area below the arching roof, the words\n\nTHE COLISEUM\n\nare carved.");
		
		beenToColiseumMainEntrance = initLocation("Coliseum - Main Entrance");
		
		run = true;
		while (run) {
			action = getInput("Go down the 'staircase' or into the 'woods'?");
			
			if (action.toLowerCase().equals("staircase")) {
				println("You go down the staircase.");
				coliseumMainStaircase();
				run = false;
			} else if (action.toLowerCase().equals("woods")) {
				println("You go into the woods.");
				vineWoods();
				run = false;
			} else {
				run = true;
			}
		}
		println("Coliseum - Main Entrance");
	}
	
	public static void coliseumMainStaircase() {
		println("You are on a large staircase, filled with people.\nAt the top is a huge doorway, opening to some vine-filled woods.\nAt the bottom is an even larger hall, filled with people.");
		
		beenToColiseumMainStaircase = initLocation("Coliseum - Main Staircase");
		
		run = true;
		while (run) {
			action = getInput("Go 'up' to the woods or 'down' to the hall?");
			
			if (action.toLowerCase().equals("up")) {
				println("You go up the staircase.");
				coliseumMainEntrance();
				run = false;
			} else if (action.toLowerCase().equals("down")) {
				println("You go down the staircase.");
				coliseumMainHall();
				run = false;
			} else {
				run = true;
			}
		}
		println("Coliseum - Main Staircase");
	}
	
	public static void coliseumMainHall() {
		println("You are in a massive hall filled with people.\nEach is going to their own destination, but most are going towards a large door labeled \"COLISEUM ADMISSION\".\nSome very official looking people are entering and exiting a staff staircase.\nPeople are also streaming in and out through a large entrance staircase.");
		
		beenToColiseumMainHall = initLocation("Coliseum - Main Hall");
		
		run = true;
		while (run) {
			action = getInput("Go to the 'admission' booths, 'staff' staircase, or 'main' staircase?");
			
			if (action.toLowerCase().equals("admission")) {
				println("You go through the large door labeled \"COLISEUM ADMISSION\".");
				coliseumAdmission();
				run = false;
			} else if (action.toLowerCase().equals("staff")) {
				if (coliseumChampion) {
					println("A guard steps aside and you go onto the staircase.");
					coliseumStaffStaircase();
					run = false;
				} else {
					println("You are blocked by a guard.\nYou quickly realize that you are not a member of the staff.\n");
					run = true;
				}
			} else if (action.toLowerCase().equals("main")) {
				println("You go onto the huge main staircase.");
				coliseumMainStaircase();
				run = false;
			} else {
				run = true;
			}
		}
		println("Coliseum - Main Hall");
	}
	
	public static void coliseumStaffStaircase() {
		println("You are on a staircase with a hallway at the top and a huge hall at the bottom.");
		
		beenToColiseumStaffStaircase = initLocation("Coliseum - Staff Staircase");
		
		run = true;
		while (run) {
			action = getInput("Go 'up' to the staff hallway or 'down' to the main hall?");
			
			if (action.toLowerCase().equals("up")) {
				println("You go up the staircase.");
				coliseumStaffHall();
				run = false;
			} else if (action.toLowerCase().equals("down")) {
				println("You go down the staircase.");
				coliseumMainHall();
				run = false;
			} else {
				run = true;
			}
		}
		println("Coliseum - Staff Staircase");
	}
	
	public static void coliseumAdmission() {
		println("You are in a room filled with people in lines and a row of desks.\nBehind each desk is a ticket golem,\ncreated for the specific purpose of selling and verifying tickets.\nTickets are 5 gold coins each. You have " + gold + " gold coins.");
		
		beenToColiseumAdmission = initLocation("Coliseum - Admission");
		
		run = true;
		while (run) {
			action = getInput("'Buy' a ticket and enter the coliseum or go into the main 'hall'?");
			
			if (action.toLowerCase().equals("hall")) {
				println("You go into the massive main hall.");
				coliseumMainHall();
				run = false;
			} else if (action.toLowerCase().equals("buy")) {
				if (gold >= 5) {
					println("You purchase a ticket and join the crowd going into the stands.");
					coliseumStands();
					run = false;
				} else {
					println("You don't have enough gold to buy a ticket.\n");
					run = true;
				}
			} else {
				run = true;
			}
		}
		println("Coliseum - Admission");
	}
	
	public static void coliseumStands() {
		println("You are in the stands of a massive arena.");
		
		beenToColiseumStands = initLocation("Coliseum - Stands");
		
		run = true;
		while (run) {
			action = getInput("'Watch' the events in the coliseum or 'leave'?");
			
			if (action.toLowerCase().equals("watch")) {
				println("You look around and see something happening.\n");
				random = generator.nextInt(11);
				switch (random) {
				case 0:
					println("A bear gets stabbed through the heart, and the crowd goes wild!");
					break;
					case 1:
					println("There is a very boring swordfight going on.");
					break;
					case 2:
					println("An adventurer is fighting hundreds of centipedes using lemon juice.");
					break;
					case 3:
					println("Two furry spheres are doing what looks like sumo wrestling.");
					break;
					case 4:
					println("Someone steps into the pit, looking confused.\nSome guards escort them out. The crowd chuckles.");
					break;
					case 5:
					println("Two teams of combatatants are fighting to get an inflated pig stomach to the enemy's side of the pit.");
					break;
					case 6:
					println("There is a barrel in the pit that is shooting out colorful expolosions, to the awe of all watching.");
					break;
					case 7:
					println("Someone is trying to fight by holding their sword out and spinning.");
					break;
					case 8:
					println("Some furry spheres seem to be multipkying and rapidly growing out of control.\nLuckily someone in the crowd casts a spell and they turn into sand.");
					break;
					case 9:
					println("A fight has broken out among the crowd.");
					break;
					case 10:
					println("Some rich person in the crowd is tossing expensive chocolate truffles to whoever will catch them.");
					break;
					case 11:
					println("Some ghosts are having an epic battle.");
					break;
					case 12:
					println("A tall blue box labeled POLICE BOX is noisily disappearing, to the confusion of the crowd.");
					break;
					case 13:
					println("A mage is showcasing a long-distance communication device. Nobody is paying attention.");
					break;
					case 14:
					println("Two knights are jousting with sharpened stale baguettes.");
					break;
					case 15:
					println("The coliseum pit fills with water and some small boats are placed in it.");
					break;
					case 16:
					println("Members of the crowd are jumping into a brawl at the center of the arena.");
					break;
					case 17:
					println("Two cats are standing on their hind legs and punching each other with their paws.");
					break;
					case 18:
					println("Some clockwork automatons are brawling, the arena is littered with gears.");
					break;
					case 19:
					println("The announcer calls for the next contestant.");
					try {
						Thread.sleep(1000);
					} catch (Exception e) {}
					println("But nobody came.");
					try {
						Thread.sleep(200);
					} catch (Exception e) {}
					break;
					case 20:
					println("While you watch, someone slips their hand into your purse.");
					try {
						Thread.sleep(1000);
					} catch (Exception e) {}
					println("They seem to have added some gold?");
					gold += 10;
					try {
						Thread.sleep(200);
					} catch (Exception e) {}
					break;
				}
				run = true;
			} else if (action.toLowerCase().equals("leave")) {
				println("You leave the stands and go into the main hall.");
				coliseumMainHall();
				run = false;
			} else {
				run = true;
			}
		}
		println("Coliseum - Stands");
	}
	
	public static void shopOutside() {
		println("You are outside of a shack with SHOP painted on the outside.\nThere are vine-filled woods all around.");
		
		if (!beenToShopOutside) {
			println("It looks like somebody is in the shop,\nthere is movement inside.");
		}
		
		beenToShopOutside = initLocation("Shop - Outside");
		
		run = true;
		while (run) {
			action = getInput("Go into the woods or go into the shop?");
			
			if (action.toLowerCase().equals("shop")) {
				println("You go into the shop.");
				shop();
				run = false;
			} else if (action.toLowerCase().equals("woods")) {
				println("You go into the woods.");
				vineWoods();
				run = false;
			} else {
				run = true;
			}
		}
		println("Shop - Outside");
	}
	
	public static void shop() {
		beenToShop = initLocation("Shop");
		
		random = generator.nextInt(20);
		
		if (random == 0) {
			shopLemonJuiceBottles += generator.nextInt(5);
			shopHealingCreamJars += generator.nextInt(5);
		}
		
		do {
			print("You are in a meager shop.\nThe shelves contain");
			
			run = shopHasSword || shopLemonJuiceBottles > 0 || shopHealingCreamJars > 0;
			run = !run;
			
			if (run) {
				println(" nothing.");
			} else {
				println(":");
			}
			
			if (shopHasSword) {
				println("- a sword - 50 gold");
			}
			
			if (shopLemonJuiceBottles > 0) {
				println("- " + shopLemonJuiceBottles + " bottles of lemon juice - 20 gold each");
			}
			
			if (shopHealingCreamJars > 0) {
				println("- " + shopHealingCreamJars + " jars of healing cream - 20 gold each");
			}
			
			println("\n");
			
			if (shopHasSword) {
				println("The shopkeeper tells you that if you buy this sword,\nhe will also give you lessons on how to wield it.");
				
				if (getYesNo("Buy the sword?")) {
					if (gold >= 50) {
						println("You buy the sword.");
						
						shopHasSword = false;
						hasSword = true;
						gold -= 50;
					} else {
						println("You do not have enough gold.\nA sword costs 50 gold. You have " + gold + " gold.");
					}
				}
			}
			
			if (shopLemonJuiceBottles > 0) {
				println("The label on the bottle claims that the lemon juice deters\nall sorts of jellies, slimes, and puddings.");
				
				if (getYesNo("Buy a bottle of lemon juice?")) {
					if (gold >= 20) {
						println("You buy a bottle of lemon juice.");
						
						shopLemonJuiceBottles --;
						lemonJuiceBottles ++;
						gold -= 20;
					} else {
						println("You do not have enough gold.\nA bottle of lemon juice costs 20 gold. You have " + gold + " gold.");
					}
				}
			}
			
			if (shopHealingCreamJars > 0) {
				println("The healing cream jar label assures you that the healing cream\nwill restore at least one health point.");
				
				if (getYesNo("Buy a jar of healing cream?")) {
					if (gold >= 20) {
						println("You buy a jar of healing cream.");
						
						shopHealingCreamJars --;
						healingCreamJars ++;
						gold -= 20;
					} else {
						println("You do not have enough gold.\nA jar of healing cream costs 20 gold. You have " + gold + " gold.");
					}
				}
			}
		} while (getYesNo("Shop More?"));
		shopOutside();
		println("Shop");
	}
	
	
	
	//Main method
	public static void main(String[] args) {
		for (int i = 0; i < args.length; i += 2) {
			switch (args[i]) {
				case "health":
					health = Integer.parseInt(args[i+1]);
				break;
				case "gold":
					gold = Integer.parseInt(args[i+1]);
				break;
				case "hasSword":
					hasSword = Boolean.parseBoolean(args[i+1]);
				break;
				case "healingCreamJars":
					healingCreamJars = Integer.parseInt(args[i+1]);
				break;
				case "lemonJuiceBottles":
					lemonJuiceBottles = Integer.parseInt(args[i+1]);
				break;
				case "coliseumChampion":
					coliseumChampion = Boolean.parseBoolean(args[i+1]);
				break;
			}
		}
		println("* * * * * * *");
		println("* Hardwood. *");
		println("* * * * * * *\n");
		println("TIPS:\nKeywords will be surrounded by 'apostropies'.\nType \"health\" to check your health\nType \"gold\" to check how much gold you have.\nType \"inventory\" to check your inventory.\nWhen answering a yes/no prompt, any word starting with 'y' is considered\nto mean 'yes'and any word starting with 'n' is considered to be 'no'.\nEnjoy your game!\n\n");
		
		mossyClearing();
		
		println("\n* * * * * * * *\n*  Game  Over . *\n* * * * * * * *\n\n");
	}
}