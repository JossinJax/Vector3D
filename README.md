This is the start of the documentation for Project 4:

Team Members:

Jeffrey Simons 
Josselyn Munoz
Noah Peters

Monopoly.java has multiple other classes required to run: 
Player.java, 
BoardSpot.java, 
GUI.java, 
and Reminder.java

To run via command line, navigate to the program's folder and compile, using javac \*.java, then run using java Monopoly.
A GUI should open, asking how many people are playing. Input a number between 1 and 8. If you enter less than 8, it will then ask for a number of AI players. If you only have 1 human player, you will be required to add at least 1 AI. You will only be allowed to have a maximum of 8 players, human or AI. Turn orders will then be assigned to each player. Afterwards, each player will be allowed to select their token. Then gameplay begins. 
If you are in jail at the start of a turn, you will be asked if you'd like to pay the fine or roll for doubles, to a maximum of 3 attempts before being forced to pay the fine. If you succeed in either of these, you will be allowed to continue as normal. If not, your turn will be skipped. Then, if your turn was not skipped, you will be allowed to add houses or hotels to any of your owned properties. Then, you will be allowed to sell properties to other players if you wish. 
Then, you will move. If you land on a property owned by the bank, you will be allowed to purchase it. If it is owned by another player, you will need to pay them rent. The same occurs if you land on a utility or railroad, with the prices varying for both. 
If you land on a tax spot, you will be forced to pay an amount of money depending on which spot you landed on. If you land on Income Tax, you will be able to choose whether you pay 10% of assets or $200. 
If you land on "Go to Jail," you will be sent to jail and your turn will end.
If, during your movement, you pass the Go tile, you will get $200. If you roll doubles, you will be able to take another turn. If you roll 3 doubles in a row on one turn, you will be sent to jail for speeding. 
The game will end when only one player remains or if the time runs out. If the time runs out, the player with the most money in total assets wins.
