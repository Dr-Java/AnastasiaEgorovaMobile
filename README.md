In order to run tests you have to:

1. clone this project to your local machine and open it in your IDE
* be sure to change deviceName parameter value to appropriate in nativeTNG.xml and webTNG.xml files.
2. attach physical or virtual device
3. run Appium with created sets of desired capabilities
4. use terminal to run tests
* web scenario: mvn clean test -P web
* native scenario: mvn clean test -P native 
* *or do it manually: Maven>Profiles>Lifecycle>test
