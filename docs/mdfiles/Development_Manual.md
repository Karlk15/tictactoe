Development Manual
==================
## Purpose:
- To help new team members get acquainted to the project's development enviroment.
- Which tools to install and how to use them.

## Which tools need to be pre-installed
- [Java JDK-8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) needs to be installed for compilation of java code.
- Make sure that [Java Runtime Envioroment(JRE)](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html) is also installed on your computer to be able to run .jar files.
- [Pandoc](http://kevin.deldycke.com/2012/01/how-to-generate-pdf-markdown/) needs to be installed as well.
- [Intellij 2.4.](https://www.jetbrains.com/idea/?fromMenu) is used as the main idea of the project. It is recomended that you install Intellij for code editing and easy running of the app but is not necessary for building and testing the code which [Gradle](https://gradle.org/) handles automatically.
- A [Github](https://github.com/) account is required for the source control purposes.
#### Note for Windows users:
- To be able to run JRE from anywhere in your computer you need to first add [Java enviroment variables.](http://stackoverflow.com/questions/1672281/environment-variables-for-java-installation).
- We higly recommend that install and use [Git Bash](https://git-scm.com/downloads) for building, testing, running and all git related uses.

## Getting Started
- Firstly clone the repository to you local drive by running the the following command on your terminal/git bash ``` https://github.com/valdimar94/tictactoe.git ```
- After you have been added as a collaborator to the projects repository you need to accept the invitation in your notifications window.
- **Before every** push to master you need to run the following scripts from the projects root directory: ==bin/build_and_test== and ==bin/deploy==. If all gradle task builds are succefull you may push to the master.
- [Travis CI](https://travis-ci.org/valdimar94/tictactoe/builds) is used as for continuous integration.
- To the run the executable file located in *TicTacToe/tictactoe.jar*, use the following command from your terminal/git bash: ```java -jar tictactoe.jar ```.
