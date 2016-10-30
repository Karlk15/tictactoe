#Design Report

##Tic Tac Toe

##Introduction
The Tic-tac-toe game is an ancient game that first appeared in the time of the Roman Empire. Since then it has spread around the world and today it is hard to find someone 
who has never heard of it. <br />
The game is simple. Two players, X and O, take turns marking the spaces in a 3x3 grid. The player who succeeds in placing three of their marks in a horizontal, vertical or
diagonal row wins the game. The following example game is won by the player X.
<br />
![Tic-tac-toe example](/docs/mdfiles/X_wins.jpg)

The purpose with this assignment is to set up technical infrastructure that supports agile development. We will use the Test Driven Development (TDD) that can be described as 
a technique where you must first write a test that fails before you write new functional code. It is a process that relies on the repetition of a very short development cycle.
When a new functionality is finished sucessfully we will commit the code and then refactor it if neccessary.

##Initial design

###Class Diagram
We made a simple class diagram that displays the inital class design and will therefore most likely change something over the time during development. Still, it gives the reader 
a good insight into how the system will work. Below is our class diagram.
<br />
![Class diagram](/docs/mdfiles/ClassDiagram.jpg)

###Overview
 * The game is written in Java.
 * The source control is hosted in Github.
 * For organizing workflow we will use Trello.
 * The code will be written mainly in IntelliJ IDEA and Sublime Text 2. 
 * Before each push, we will use Gradle to build and test the new functionality on our own computers.
 * Travis will be used to test the code each time we push the new functionality to GitHub. 

###Programming rules
It is necessary to follow a few rules when the code is written, mainly to make the code more readable and understandable. On our first day we came up with a few rules to follow
throughout the development. We talked about what rules we usually follow when programming and why we follow those rules. When in doubt, we looked for inspiration on Google and
found the standards for each programming language and adjusted them to us.
Following are the rules we decided to use and a few examples.

####Classes
 * Every class name is made by nouns or nounphrases 
 * They should follow the PascalCasing rule, where every word is capitalized 

```
public class PlayerService(){
...
}
```

####Functions
 * Every function name should be made by a descriptive name but not too long
 * They should follow the camelCasing, where the first letter is in lowercase but next words are in uppercase <br />

```
public void printMainMenu(){
...
}
```

####Variables
 * Every variable name should be made by nouns or nounphrases
 * They should also follow the camelCasing rule, if necessary <br />

```
    int playerCount = 10;
```

####Brackets
 * The brackets are supposed to be opened at the end of the class/function
 * The brackets are supposed to be closed below the class/function in a new line

####Comments
 * If your not sure whether something needs explanation, it is best explain what is going on with a comment
 * Classes and functions should be commented above them by double slash or //
 * Variables should be commented at the end of their declaration by double slash or //
 * If comment needs more than one line, use the example below: <br />

```
/**
 * The main function for a one player game.
 * Plays through one human turn and automates one computer turn
 * also let's the human player choose his name
 */
public void OnePlayerGame(){
...
}
```
