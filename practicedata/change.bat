set projectLocation=C:\Users\180138\eclipse-workspace\practicedata
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\change.xml
pause