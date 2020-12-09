# ServerPlugins
A simple repo with all of my minecraft Spigot Plugins, that are not private at least

## General Sever Pack
Just a simple pack with `/home`, `/gettime`, and `/sharelocation`

## Sky Cube
An entire game mode in it of itself, skycube is a game where players start out in a 3x3x3 area in the sky
- The top layer is logs
- The middle layer is grass
- The bottom layer is infinatly regenerating stone

The rest is in the book given to new players or by using `/helpme`
### config.yml
The config for this is very simple
- `messageJoin_first`: This is for when a new player joins
- `messageJoin_default`: This is for when a non new player joins
- `messageTutorial_start`: The message that is sent to new players
- `spawn_spread`: The max distance away from 0, 0 a new player can spawn
- `unbreakable_file`: The filename [without .txt] of the file that stores which blocks are unbreakable
- `spawn_file`: The filename [without .json] of the json file that stores the players spawns
- `startBook_author`: The author of the starting book
- `startBook_title`: The title of the starting book
- `startBook_pages`: The filename [without .txt] of the file that contains the text for the starting book
- `registerMinHeight`: Boolean to register a min height (if the player goes below this they die) this may take up a lot of server processing power if it is big.
- `minHeight`: The min height for the players to be at, only needed if `registerMinHeight` is true

Here is my default config.yml
```
messageJoin_first: '&a<player> &7has joined the server for the first time!'
messageJoin_default: '&e<player> &7 has joined the server.'

messageTutorial_start: '&oWelcome to your island, this is where you will live for a long time so get comfy, feel free to head over to other playsers islands, everything here is fair game! Do not forget to read your book!'

spawn_spread: 500

unbreakable_file: 'unbreakable'
spawn_file: 'spawn'

startBook_author: 'Asra_31'
startBook_title: 'Introduction to Sky Cube!'
startBook_pages: 'book'

registerMinHeight: true
minHeight: 4
```

### The starting book pages
Enter is a newline, and to seperate pages you use ~, recommended book pages text:
```
&khi&r &lWelcome to Sky Cube&r &khi&r
This is your island and your home for a long, long time.
Your starting island is composed of 3 layers
- The lop layer is logs
- The middle layer is grass
- And the bottom layer is infinitely regenerating cobblestone
~&khi&r &lStarting off&r &khi&r
To start off I recommend breaking the top layer into logs and converting it to planks
Make sure you keep some planks and turn them into bonemeal for later by putting it in a crafting table
Then get your grass, if some of it turned to dirt, that's ok!
~&khi&r &lStarting off Continued&r &khi&r
You can convert it back by putting it into a crafting table
After that, create a wood than a stone pickaxe and start mining the stone at the bottom, now you have started off!
~&khi&r &lTransmutation&r &khi&r
After a while, if you arrange 5 cobblestones in a + formation in your crafting table you will get 1 coal
If you do the same with coal then you get iron and so on
Here is the list of the elements in order:
- Coal
- Iron
~&khi&r &lTransmutation Continued&r &khi&r
- Gold
- Redstone
- Lapis
- Diamond
- Emerald (No Transmutation)
Continued on next page
~&khi&r &lTransmutation Continued&r &khi&r
To get these materials faster you may want to get transmutation on your items, which changes cobblestone to the material
This is done by surrounding the corresponding pickaxe with the material, here is the list of the pickaxes
~&khi&r &lTransmutation Continued&r &khi&r
- Coal: Stone Pickaxe
- Iron: Iron Pickaxe
- Gold: Iron Pickaxe
- Redstone: Iron Pickaxe
- Lapis: Iron Pickaxe
- Diamond: Diamond Pickaxe
Remember to keep a regular pickaxe just in case!
~&khi&r &lFarming&r &khi&r
To start off farming you will need to turn some of your planks into bonemeal
After you have done that you will be able to take your grass blocks and use the bonemeal on it to get flowers and seeds
~&khi&r &lFarming Continued&r &khi&r
Once you have two seeds you can create a sapling out of them by putting them in a stick formation
After that, you can plant the sapling and bonemeal it to get a tree
~&khi&r &lFarming Continued&r &khi&r
After you chop down the tree make sure to get some leaves so you can make more grass
To make grass you need gravel (Which you can make from stone) and a leaf
~&khi&r &lFarming Continued&r &khi&r
After that, you will need some water which you can craft by making the regular bucket, but adding a lapis block in the middle
You are also able to put saplings and seeds in the crafting table to get different things, it's a cycle!
```