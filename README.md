## Notes:
Follow the instructions below to start the application and call the service. All that is required is Java version 1.8.0_144.
It should be noted that the terminal commands should ideally be exectuted in a linux environment, as the curl command will not execute correctly using a windows bash emulator such as git bash
However the application will start fine on a windows and linux enviroment using the commands below, and can the service can still be called via browser as an alternative.


**Instructions to run program:**
1. Unzip project and enter the WebsiteComparison folder
2. To start the application open a terminal and run: java -jar target/WebsiteComparison-0.0.1-SNAPSHOT.jar 
3. Open a new terminal and run the commands below to call the REST service and examine the output
4. You can also call the service by opening a web broswer and naviagating to the links below



**Three websites to test:**
http://www.bbc.co.uk/news/uk-england-london-43033511
https://en.wikipedia.org/wiki/Java
https://en.wikipedia.org/wiki/Computer_programming

**Commands to compare sites via a terminal:**
curl -X GET 'http://localhost:8080/compare?url1=http://www.bbc.co.uk/news/uk-england-london-43033511/&url2=https://en.wikipedia.org/wiki/Java'
curl -X GET 'http://localhost:8080/compare?url1=http://www.bbc.co.uk/news/uk-england-london-43033511/&url2=https://en.wikipedia.org/wiki/Computer_programming'
curl -X GET 'http://localhost:8080/compare?url1=https://en.wikipedia.org/wiki/Java&url2=https://en.wikipedia.org/wiki/Computer_programming'

**To compare via a browser, go to the following urls:**
http://localhost:8080/compare?url1=http://www.bbc.co.uk/news/uk-england-london-43033511/&url2=https://en.wikipedia.org/wiki/Java
http://localhost:8080/compare?url1=http://www.bbc.co.uk/news/uk-england-london-43033511/&url2=https://en.wikipedia.org/wiki/Computer_programming
http://localhost:8080/compare?url1=https://en.wikipedia.org/wiki/Java&url2=https://en.wikipedia.org/wiki/Computer_programming


**Their respective outputs will be:**
The JaccardIndex is 0.05
The JaccardIndex is 0.06
The JaccardIndex is 0.15