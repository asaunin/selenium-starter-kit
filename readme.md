# Selenium WebDriver starter kit
This repository contains [Selenium](http://seleniumhq.org/) starter kit for fast selenium development.
Code is mainly based on the flowing projects:
- [IDE selenium plugin](https://github.com/perfect-test/selenium_idea_plugin) by Sidelnikov Mikhail
- [Wikia App](https://github.com/Wikia/selenium-tests) automation tests
 
It's quite simpler than Wikia, and more flexible than IDE plugin default version 

## Dependencies

1. Make sure you have [Java](http://www.java.com/) installed on your system, if not follow the vendor instructions for installing them on your operating system.
2. Enable [LOMBOK](https://projectlombok.org/) plugin on your IDE, follow the vendor instructions for installing LOMBOK for your IDE.
  * For eclipse follow [this instruction](https://projectlombok.org/download.html)
  * For IntelliJ Idea:
    * Windows: click Settings -> Plugins -> Browse repositories for "lombok" -> Install. Restart IntelliJ.
    * OSX: click IntelliJ IDEA -> Preferences -> Plugins -> Browse repositories for "lombok" -> Install. Restart Intellij.

3. Go to "Annotation Processors"
    * Windows: click Settings -> Build, Execution, Deployment -> Annotation Processors. Set "Enable annotation processing".
    * OSX: click Intellij IDEA -> Preferences -> Build, Execution, Deployment -> Annotation Processors. Set "Enable annotation processing".

## Features

- Design pattern oriented architecture
- Embedded drivers (you don't need to download and setup environment variables)
- Ability to easily add appropriate browsers and set up their preferences
- Browser type setup in property file, injection with annotation
- YouTube simple test example based on Junit / TestNG runners