set projectLocation=C:\Users\180138\.jenkins\workspace\demo\practicedata
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\change.xml
pause